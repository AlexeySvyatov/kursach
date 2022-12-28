package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class changeWorkshop {
    static int idWorkshop;
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField idWorker;
    @FXML private TextField idProduction;
    @FXML private TextField description;

    public static void getIDWS(int workshopID){
        idWorkshop = workshopID;
    }

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            if(!idWorker.equals("") & !idProduction.equals("") & !description.equals("")){
                String query = "UPDATE workshop SET idWorker = "+ Integer.parseInt(idWorker.getText()) +",idProduction =  "
                        + Integer.parseInt(idProduction.getText()) + ",description = "+ description +" WHERE idWorkshop = "+ idWorkshop;
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