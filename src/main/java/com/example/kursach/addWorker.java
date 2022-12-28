package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addWorker {
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField idWorker;
    @FXML private TextField password;
    @FXML private TextField fullName;
    @FXML private TextField post;
    @FXML private DatePicker dateBirth;
    @FXML private TextField passport;
    @FXML private TextField experience;

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            if(!idWorker.equals("") & !fullName.equals("") & !password.equals("") & !post.equals("") & !dateBirth.equals("") & !passport.equals("") & !experience.equals("")){
                DBHandler.addWorker(idWorker.getText(), password.getText(), fullName.getText(), post.getText(), dateBirth, passport.getText(), experience.getText());
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