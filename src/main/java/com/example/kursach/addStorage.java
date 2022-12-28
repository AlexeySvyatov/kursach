package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addStorage {
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField idStorage;
    @FXML private TextField storagePlace;
    @FXML private TextField productsNum;
    @FXML private TextField productsMax;

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            if(!idStorage.equals("") & !storagePlace.equals("") & !productsNum.equals("") & !productsMax.equals("")){
                DBHandler.addStorage(idStorage.getText(), storagePlace.getText(), productsNum.getText(), productsMax.getText());
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