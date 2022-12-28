package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.*;

public class HelloController {
    @FXML Button authBtn;
    @FXML TextField login;
    @FXML PasswordField password;
    @FXML Label message;

    @FXML
    void initialize(){
        authBtn.setOnAction(actionEvent -> {
            String loginCheck = login.getText().trim();
            String passwordCheck = password.getText().trim();
            if(!loginCheck.equals("") & !passwordCheck.equals("")){
                try{
                    Statement statement = DBHandler.getDbConnection().createStatement();
                    ResultSet resSet = statement.executeQuery("SELECT * FROM Workers");
                    while(resSet.next()){
                        if(resSet.getString("passport").equals(loginCheck) & resSet.getString("password").equals(passwordCheck)){
                            authBtn.getScene().getWindow().hide();
                            HelloApplication.openAnotherWindow("mainWindow.fxml");
                        }else{
                            message.setText("Проверьте правильность введенных данных");
                            message.setVisible(true);
                        }
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }else{
                message.setText("Пожалуйста, заполните поля ввода");
                message.setVisible(true);
            }
        });
    }
}