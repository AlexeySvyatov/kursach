package com.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class changeWorker {
    static int idWorker;
    @FXML private Label message;
    @FXML private Button commitBtn;
    @FXML private Button backBtn;
    @FXML private TextField fullName;
    @FXML private TextField post;
    @FXML private DatePicker dateBirth;
    @FXML private TextField passport;
    @FXML private TextField experience;

    public static void getIDW(int workerID){
        idWorker = workerID;
    }

    @FXML void initialize(){
        commitBtn.setOnAction(actionEvent -> {
            LocalDate birthDate = dateBirth.getValue();
            if(!fullName.equals("") & !post.equals("") & !dateBirth.equals("") & !passport.equals("") & !experience.equals("")){
                String query = "UPDATE workers SET fullName = '"+fullName.getText()+"'" + ",post =  '"+post.getText()+"'" + ",birthDate = "+ birthDate
                        + ",passport = "+ passport.getText() + ",experience = "+ Integer.parseInt(experience.getText()) + " WHERE idWorker = "+ idWorker;
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