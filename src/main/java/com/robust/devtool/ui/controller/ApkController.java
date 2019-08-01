package com.robust.devtool.ui.controller;

import com.robust.devtool.AppManager;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ApkController implements Initializable {


    private AppManager appManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        appManager = new AppManager();
    }

    @FXML
    private TextField pkgNameField;

    @FXML
    private TextField apkPathField;

    @FXML
    private Button filePathBtn;

    @FXML
    private Button pkgNameBtn;

    @FXML
    private Button apkPathBtn;

    @FXML
    private TextField filePathField;

    @FXML
    private Button pullApkBtn;

    @FXML
    private Button clearAllBtn;

    @FXML
    void onPkgNameBtnClicked(ActionEvent event) {
        String pkgName = appManager.getTopPkgName();
        pkgNameField.setText(pkgName);
    }

    @FXML
    void onApkPathBtnClicked(ActionEvent event) {
        String topApkPath = appManager.getTopApkPath();
        apkPathField.setText(topApkPath);
    }

    @FXML
    void onFilePathFieldClicked(ActionEvent event) {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        final File selectedDirectory = directoryChooser.showDialog(new Stage());
        String savePath = "";
        if (selectedDirectory != null) {
            savePath = selectedDirectory.getAbsolutePath();
        }
        filePathField.setText(savePath);
    }

    @FXML
    void onClearAllBtnClicked(ActionEvent event) {
        pkgNameField.clear();
        apkPathField.clear();
        filePathField.clear();
    }

    @FXML
    void onPullApkBtnClicked(ActionEvent event) {
        String filePath = filePathField.getText();
        if (filePath == null) {
            filePath = "";
        }
        appManager.pullTopApk(filePath);
    }

}
