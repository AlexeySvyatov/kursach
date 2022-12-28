package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class changeProduction {
    static int idProduction;
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField name;
    @FXML private TextField material;
    @FXML private TextField idStorage;
    @FXML private DatePicker expir;

    public static void getIDP(int productionID){
        idProduction = productionID;
    }

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            LocalDate expiration = expir.getValue();
            if(!name.equals("") & !material.equals("") & !expir.equals("")){
                String query = "UPDATE production SET idStorage = "+ Integer.parseInt(idStorage.getText()) +"name = '"+name.getText()+"'" + ",material =  '"+material.getText()+"'"
                        + ",expiration = "+ expiration + " WHERE idProduction = "+ idProduction;
                try{
                    PreparedStatement prSt = DBHandler.getDbConnection().prepareStatement(query);
                    prSt.executeUpdate();
                }catch(SQLException | ClassNotFoundException ex){
                    ex.printStackTrace();
                }
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