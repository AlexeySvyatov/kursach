package com.example.kursach;

public class ProductionDB {
    public Integer idProduction;
    private Integer idStorage;
    private String name;
    private String material;
    private String expiration;

    public ProductionDB(Integer idProduction, Integer idStorage, String name, String material, String expiration){
        this.idProduction = idProduction;
        this.idStorage = idStorage;
        this.name = name;
        this.material = material;
        this.expiration = expiration;
    }

    public  ProductionDB(){}

    public Integer getIdProduction(){
        return idProduction;
    }
    public void setIdProduction(){
        this.idProduction = idProduction;
    }

    public Integer getIdStorage(){
        return idStorage;
    }
    public void setIdStorage(){
        this.idStorage = idStorage;
    }

    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

    public String getMaterial(){
        return material;
    }
    public void setMaterial(){
        this.material = material;
    }

    public String getExpiration(){
        return expiration;
    }
    public void setExpiration(){
        this.expiration = expiration;
    }
}