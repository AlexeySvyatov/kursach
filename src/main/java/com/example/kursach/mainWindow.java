package com.example.kursach;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class mainWindow {
    private WorkersDB selectedWorker = new WorkersDB();
    private ProductionDB selectedProduct = new ProductionDB();
    private WorkshopDB selectedWshop = new WorkshopDB();
    private StorageDB selectedStorage = new StorageDB();

    private ObservableList<WorkersDB> workers = FXCollections.observableArrayList();
    private ObservableList<ProductionDB> production = FXCollections.observableArrayList();
    private ObservableList<WorkshopDB> workshop = FXCollections.observableArrayList();
    private ObservableList<StorageDB> storage = FXCollections.observableArrayList();

    @FXML private TableView<WorkersDB> workersTable;
    @FXML private TableColumn<WorkersDB, Integer> idClmW;
    @FXML private TableColumn<WorkersDB, String> nameClmW;
    @FXML private TableColumn<WorkersDB, String> postClmW;
    @FXML private TableColumn<WorkersDB, String> birthClmW;
    @FXML private TableColumn<WorkersDB, String> passClmW;
    @FXML private TableColumn<WorkersDB, Integer> expertClmW;

    @FXML private TableView<ProductionDB> productTable;
    @FXML private TableColumn<ProductionDB, Integer> idClmP;
    @FXML private TableColumn<ProductionDB, Integer> idsClmP;
    @FXML private TableColumn<ProductionDB, String> nameClmP;
    @FXML private TableColumn<ProductionDB, String> matClmP;
    @FXML private TableColumn<ProductionDB, String> expClmP;

    @FXML private TableView<WorkshopDB> workshopTable;
    @FXML private TableColumn<WorkshopDB, Integer> idClmWS;
    @FXML private TableColumn<WorkshopDB, Integer> idwClmWS;
    @FXML private TableColumn<WorkshopDB, Integer> idpClmWS;
    @FXML private TableColumn<WorkshopDB, String> descClmWS;

    @FXML private TableView<StorageDB> storageTable;
    @FXML private TableColumn<StorageDB, Integer> idClmS;
    @FXML private TableColumn<StorageDB, String> placeClmS;
    @FXML private TableColumn<StorageDB, String> numClmS;
    @FXML private TableColumn<StorageDB, String> maxClmS;

    @FXML private Button addBtnW;
    @FXML private Button addBtnP;
    @FXML private Button addBtnWS;
    @FXML private Button addBtnS;

    @FXML private Button deleteBtnW;
    @FXML private Button deleteBtnP;
    @FXML private Button deleteBtnWS;
    @FXML private Button deleteBtnS;

    @FXML private Button changeBtnW;
    @FXML private Button changeBtnP;
    @FXML private Button changeBtnWS;
    @FXML private Button changeBtnS;

    @FXML void initialize(){
        try{
            Statement statement = DBHandler.getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Workers");
            while(resultSet.next()){
                if(resultSet.getString("post").equals("Сборщик")){
                    addBtnW.setDisable(true);
                    addBtnP.setDisable(true);
                    addBtnWS.setDisable(true);
                    addBtnS.setDisable(true);
                    deleteBtnW.setDisable(true);
                    deleteBtnP.setDisable(true);
                    deleteBtnWS.setDisable(true);
                    deleteBtnS.setDisable(true);
                    changeBtnW.setDisable(true);
                    changeBtnP.setDisable(true);
                    changeBtnWS.setDisable(true);
                    changeBtnS.setDisable(true);
                }else{
                    addBtnW.setDisable(false);
                    addBtnP.setDisable(false);
                    addBtnWS.setDisable(false);
                    addBtnS.setDisable(false);
                    deleteBtnW.setDisable(false);
                    deleteBtnP.setDisable(false);
                    deleteBtnWS.setDisable(false);
                    deleteBtnS.setDisable(false);
                    changeBtnW.setDisable(false);
                    changeBtnP.setDisable(false);
                    changeBtnWS.setDisable(false);
                    changeBtnS.setDisable(false);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        addBtnW.setOnAction(actionEvent -> {
            addBtnW.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("addWorker.fxml");
        });

        addBtnP.setOnAction(actionEvent -> {
            addBtnP.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("addProduction.fxml");
        });

        addBtnWS.setOnAction(actionEvent -> {
            addBtnWS.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("addWorkshop.fxml");
        });

        addBtnS.setOnAction(actionEvent -> {
            addBtnS.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("addStorage.fxml");
        });

        deleteBtnW.setOnAction(actionEvent -> {
            selectedWorker = workersTable.getSelectionModel().getSelectedItem();
            selectedWorker.getIdWorker();
            DBHandler.deleteRowWorkers(selectedWorker.getIdWorker(), "workers");
            workersTable.getItems().remove(selectedWorker);
        });

        deleteBtnP.setOnAction(actionEvent -> {
            selectedProduct = productTable.getSelectionModel().getSelectedItem();
            selectedProduct.getIdProduction();
            DBHandler.deleteRowProduction(selectedProduct.getIdProduction(), "production");
            productTable.getItems().remove(selectedProduct);
        });

        deleteBtnWS.setOnAction(actionEvent -> {
            selectedWshop = workshopTable.getSelectionModel().getSelectedItem();
            selectedWshop.getIdWorkshop();
            DBHandler.deleteRowWorkshop(selectedWshop.getIdWorkshop(), "workshop");
            workshopTable.getItems().remove(selectedWshop);
        });

        deleteBtnS.setOnAction(actionEvent -> {
            selectedStorage = storageTable.getSelectionModel().getSelectedItem();
            selectedStorage.getIdStorage();
            DBHandler.deleteRowStorage(selectedStorage.getIdStorage(), "storage");
            storageTable.getItems().remove(selectedStorage);
        });

        changeBtnW.setOnAction(actionEvent -> {
            changeBtnW.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("changeWorker.fxml");
            selectedWorker = workersTable.getSelectionModel().getSelectedItem();
            selectedWorker.getIdWorker();
            changeWorker.getIDW(selectedWorker.getIdWorker());
            workersTable.setItems(workers);
        });

        changeBtnP.setOnAction(actionEvent -> {
            changeBtnP.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("changeProduction.fxml");
            selectedProduct = productTable.getSelectionModel().getSelectedItem();
            selectedProduct.getIdProduction();
            changeProduction.getIDP(selectedProduct.getIdProduction());
            productTable.setItems(production);
        });

        changeBtnWS.setOnAction(actionEvent -> {
            changeBtnWS.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("changeWorkshop.fxml");
            selectedWshop = workshopTable.getSelectionModel().getSelectedItem();
            selectedWshop.getIdWorkshop();
            changeWorkshop.getIDWS(selectedWshop.getIdWorkshop());
            workshopTable.setItems(workshop);
        });

        changeBtnS.setOnAction(actionEvent -> {
            changeBtnS.getScene().getWindow().hide();
            HelloApplication.openAnotherWindow("changeStorage.fxml");
            selectedStorage = storageTable.getSelectionModel().getSelectedItem();
            selectedStorage.getIdStorage();
            changeStorage.getIDS(selectedStorage.getIdStorage());
            storageTable.setItems(storage);
        });

        initWorker();
        idClmW.setCellValueFactory(new PropertyValueFactory<>("idWorker"));
        nameClmW.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        postClmW.setCellValueFactory(new PropertyValueFactory<>("post"));
        birthClmW.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        passClmW.setCellValueFactory(new PropertyValueFactory<>("passport"));
        expertClmW.setCellValueFactory(new PropertyValueFactory<>("experience"));
        workersTable.setItems(workers);

        initProduction();
        idClmP.setCellValueFactory(new PropertyValueFactory<>("idProduction"));
        idsClmP.setCellValueFactory(new PropertyValueFactory<>("idStorage"));
        nameClmP.setCellValueFactory(new PropertyValueFactory<>("name"));
        matClmP.setCellValueFactory(new PropertyValueFactory<>("material"));
        expClmP.setCellValueFactory(new PropertyValueFactory<>("expiration"));
        productTable.setItems(production);

        initWorkshop();
        idClmWS.setCellValueFactory(new PropertyValueFactory<>("idWorkshop"));
        idwClmWS.setCellValueFactory(new PropertyValueFactory<>("idWorker"));
        idpClmWS.setCellValueFactory(new PropertyValueFactory<>("idProduction"));
        descClmWS.setCellValueFactory(new PropertyValueFactory<>("description"));
        workshopTable.setItems(workshop);

        initStorage();
        idClmS.setCellValueFactory(new PropertyValueFactory<>("idStorage"));
        placeClmS.setCellValueFactory(new PropertyValueFactory<>("storagePlace"));
        numClmS.setCellValueFactory(new PropertyValueFactory<>("productsNum"));
        maxClmS.setCellValueFactory(new PropertyValueFactory<>("productsMax"));
        storageTable.setItems(storage);
    }

    private void initWorker() {
        try{
            Connection dbConnection = DBHandler.getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT idWorker, fullName, post, birthDate, passport, experience FROM proekt.workers");
            while(resSet.next()){
                workers.add(new WorkersDB(resSet.getInt("idWorker"), resSet.getString("fullName"), resSet.getString("post"), resSet.getString("birthDate"), resSet.getString("passport"), resSet.getInt("experience")));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void initProduction() {
        try{
            Connection dbConnection = DBHandler.getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM proekt.production");
            while(resSet.next()){
                production.add(new ProductionDB(resSet.getInt("idProduction"), resSet.getInt("idStorage"), resSet.getString("name"), resSet.getString("material"), resSet.getString("expiration")));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void initWorkshop() {
        try{
            Connection dbConnection = DBHandler.getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM proekt.workshop");
            while(resSet.next()){
                workshop.add(new WorkshopDB(resSet.getInt("idWorkshop"), resSet.getInt("idWorker"), resSet.getInt("idProduction"), resSet.getString("description")));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private void initStorage() {
        try{
            Connection dbConnection = DBHandler.getDbConnection();
            ResultSet resSet = dbConnection.createStatement().executeQuery("SELECT * FROM proekt.storage");
            while(resSet.next()){
                storage.add(new StorageDB(resSet.getInt("idStorage"), resSet.getString("storagePlace"), resSet.getInt("productsNum"), resSet.getInt("productsMax")));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}