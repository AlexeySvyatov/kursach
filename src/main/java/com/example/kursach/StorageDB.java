package com.example.kursach;

public class StorageDB {
    public Integer idStorage;
    private String storagePlace;
    private Integer productsNum;
    private Integer productsMax;

    public StorageDB(Integer idStorage, String storagePlace, Integer productsNum, Integer productsMax){
        this.idStorage = idStorage;
        this.storagePlace = storagePlace;
        this.productsNum = productsNum;
        this.productsMax = productsMax;
    }

    public StorageDB(){}

    public Integer getIdStorage(){
        return idStorage;
    }
    public void setIdStorage(){
        this.idStorage = idStorage;
    }

    public String getStoragePlace(){
        return storagePlace;
    }
    public void setStoragePlace(){
        this.storagePlace = storagePlace;
    }

    public Integer getProductsNum(){
        return productsNum;
    }
    public void setProductsNum(){
        this.productsNum = productsNum;
    }

    public Integer getProductsMax(){
        return productsMax;
    }
    public void setProductsMax(){
        this.productsMax = productsMax;
    }
}