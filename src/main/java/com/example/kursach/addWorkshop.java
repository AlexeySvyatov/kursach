package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addWorkshop {
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField idWorkshop;
    @FXML private TextField idWorker;
    @FXML private TextField idProduction;
    @FXML private TextField description;

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            if(!idWorkshop.equals("") & !idWorker.equals("") & !idProduction.equals("") & !description.equals("")){
                DBHandler.addWorkshop(idWorkshop.getText(), idWorker.getText(), idProduction.getText(), description.getText());
                commitBtn.getScene().getWindow().hide();
                HelloApplication.openAnotherWindow("mainWindow.fxml");
            }else{
                message.setText("Пожалуйста, заполните все поля");
                message.setVisible(true);
            }
        });
        backBtn.setOnAction(actionEvent -> {
            backBtn.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("mainWindow.fxml");
        });
    }
}