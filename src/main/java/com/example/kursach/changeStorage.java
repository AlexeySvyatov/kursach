package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class changeStorage {
    static int idStorage;
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField storagePlace;
    @FXML private TextField productsNum;
    @FXML private TextField productsMax;

    public static void getIDS(int storageID){
        idStorage = storageID;
    }

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            if(!storagePlace.equals("") & !productsNum.equals("") & !productsMax.equals("")){
                String query = "UPDATE storage SET storagePlace = '"+ storagePlace.getText()+ "'" +",productsNum =  "
                        + Integer.parseInt(productsNum.getText()) + ",productsMax = "+ Integer.parseInt(productsMax.getText()) +" WHERE idStorage = "+ idStorage;
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