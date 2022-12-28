package com.example.kursach;

import javafx.scene.control.DatePicker;

import java.sql.*;

public class DBHandler {
    static Connection dbConnection;
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localHost:3306/proekt";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "root", "1234");
        return dbConnection;
    }

    public static void addWorker(String idWorker, String password, String fullName, String post, DatePicker dateBirth, String passport, String experience){
        Date birthDate = Date.valueOf(dateBirth.getValue());
        String query = "INSERT INTO workers(idWorker, password, fullName, post, birthDate, passport, experience) VALUES(?,?,?,?,?,?,?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1, Integer.parseInt(idWorker));
            prSt.setString(2, password);
            prSt.setString(3, fullName);
            prSt.setString(4, post);
            prSt.setDate(5, birthDate);
            prSt.setString(6, passport);
            prSt.setString(7, experience);
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void addProduction(String idProduction, String idStorage, String name, String material, DatePicker expir){
        Date expiration = Date.valueOf(expir.getValue());
        String query = "INSERT INTO production(idProduction, idStorage, name, material, expiration) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1, Integer.parseInt(idProduction));
            prSt.setInt(2, Integer.parseInt(idStorage));
            prSt.setString(3, name);
            prSt.setString(4, material);
            prSt.setDate(5, expiration);
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void addWorkshop(String idWorkshop, String idWorker, String idProduction, String description){
        String query = "INSERT INTO workshop(idWorkshop, idWorker, idProduction, description) VALUES(?,?,?,?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1, Integer.parseInt(idWorkshop));
            prSt.setInt(2, Integer.parseInt(idWorker));
            prSt.setInt(3, Integer.parseInt(idProduction));
            prSt.setString(4, description);
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void addStorage(String idStorage, String storagePlace, String productsNum, String productsMax){
        String query = "INSERT INTO storage(idStorage, storagePlace, productsNum, productsMax) VALUES(?,?,?,?)";
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.setInt(1, Integer.parseInt(idStorage));
            prSt.setString(2, storagePlace);
            prSt.setInt(3, Integer.parseInt(productsNum));
            prSt.setInt(4, Integer.parseInt(productsMax));
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void deleteRowWorkers(int idWorker, String workers){
        String query = "DELETE FROM workers WHERE idWorker = " + idWorker;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void deleteRowProduction(int idProduction, String production){
        String query = "DELETE FROM production WHERE idProduction = " + idProduction;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void deleteRowWorkshop(int idWorkshop, String workshop){
        String query = "DELETE FROM workshop WHERE idWorkshop = " + idWorkshop;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static void deleteRowStorage(int idStorage, String storage){
        String query = "DELETE FROM storage WHERE idStorage = " + idStorage;
        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(query);
            prSt.executeUpdate();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
}