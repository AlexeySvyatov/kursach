package com.example.kursach;

public class WorkshopDB {
    public Integer idWorkshop;
    private Integer idWorker;
    private Integer idProduction;
    private String description;

    public WorkshopDB(Integer idWorkshop, Integer idWorker, Integer idProduction, String description){
        this.idWorkshop = idWorkshop;
        this.idWorker = idWorker;
        this.idProduction = idProduction;
        this.description = description;
    }

    public WorkshopDB(){}

    public Integer getIdWorkshop(){
        return idWorkshop;
    }
    public void setIdWorkshop(){
        this.idWorkshop = idWorkshop;
    }

    public Integer getIdWorker(){
        return idWorker;
    }
    public void setIdWorker(){
        this.idWorker = idWorker;
    }

    public Integer getIdProduction(){
        return idProduction;
    }
    public void setIdProduction(){
        this.idProduction = idProduction;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(){
        this.description = description;
    }
}