package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addProduction {
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField idProduction;
    @FXML private TextField idStorage;
    @FXML private TextField name;
    @FXML private TextField material;
    @FXML private DatePicker expir;

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            if(!idProduction.equals("") & !idStorage.equals("") & !name.equals("") & !material.equals("") & !expir.equals("")){
                DBHandler.addProduction(idProduction.getText(), idStorage.getText(), name.getText(), material.getText(), expir);
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