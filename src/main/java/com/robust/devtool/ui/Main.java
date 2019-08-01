package com.robust.devtool.ui;

import com.robust.devtool.AppManager;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Main extends Application {

    AppManager appManager = new AppManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("This is Title");

        HBox layout = new HBox();
        VBox left = new VBox(10);
        left.setMinWidth(100);
        left.setPadding(new Insets(10, 10, 10, 10));

        VBox right = new VBox();
        right.setPadding(new Insets(20, 20, 20, 40));

        layout.getChildren().addAll(left, right);
        Button funGetApk = new Button("Get Apk");
        funGetApk.setMinWidth(50);
        left.getChildren().add(funGetApk);
        right.getChildren().add(createGetApkPane());

        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createGetApkPane() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        Label label1 = new Label("get top pkgName from the phone");
        gridPane.add(label1, 0, 0);
        TextField textField1 = new TextField();
        gridPane.add(textField1, 0, 1);
        Button button1 = new Button("Get");
        gridPane.add(button1, 1, 1);
        button1.setOnAction(e -> {
            String pkgName = appManager.getTopPkgName();
            textField1.setText(pkgName);
        });

        Label label2 = new Label("get top apk path");
        gridPane.add(label2, 0, 2);
        TextField textField2 = new TextField();
        gridPane.add(textField2, 0, 3);
        Button button2 = new Button("Get");
        gridPane.add(button2, 1, 3);
        button2.setOnAction(e -> {
            String pkgName = appManager.getTopPkgName();
            textField1.setText(pkgName);

            String topApkPath = appManager.getTopApkPath();
            textField2.setText(topApkPath);
        });

        Label label3 = new Label("select file path to save");
        TextField textField3 = new TextField();
        Button filePathBtn = new Button("save in file...");
        gridPane.add(label3, 0, 4);
        gridPane.add(textField3, 0, 5);
        gridPane.add(filePathBtn, 1, 5);
        filePathBtn.setOnAction(e -> {
            final DirectoryChooser directoryChooser = new DirectoryChooser();
            final File selectedDirectory = directoryChooser.showDialog(new Stage());
            String savePath = "";
            if (selectedDirectory != null) {
                savePath = selectedDirectory.getAbsolutePath();
            }
            textField3.setText(savePath);
        });

        Button button3 = new Button("Download");
        gridPane.add(button3, 0, 6);
        button3.setOnAction(e -> {
            String pkgName = appManager.getTopPkgName();
            textField1.setText(pkgName);

            String topApkPath = appManager.getTopApkPath();
            textField2.setText(topApkPath);

            appManager.pullTopApk(textField3.getText());
        });

        return gridPane;
    }


}
