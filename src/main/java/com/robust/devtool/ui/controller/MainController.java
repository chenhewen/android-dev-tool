package com.robust.devtool.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

    private Parent apkView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            apkView = FXMLLoader.load(getClass().getResource("/fxml/apk.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button apkBtn;

    @FXML
    private AnchorPane rightAnchor;

    @FXML
    void onApkBtnClicked(ActionEvent event) {
        if (rightAnchor.getChildren().size() > 0) {
            rightAnchor.getChildren().remove(0);
        }
        rightAnchor.getChildren().add(apkView);
    }

}
