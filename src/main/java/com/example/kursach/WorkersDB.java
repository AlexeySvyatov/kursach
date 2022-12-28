package com.example.kursach;

public class WorkersDB {
    public Integer idWorker;
    private String password;
    private String fullName;
    public String post;
    private String birthDate;
    private String passport;
    private Integer experience;

    public WorkersDB(Integer idWorker, String fullName, String post, String birthDate, String passport, Integer experience){
        this.idWorker = idWorker;
        this.fullName = fullName;
        this.post = post;
        this.birthDate = birthDate;
        this.passport = passport;
        this.experience = experience;
    }

    public WorkersDB(){}

    public Integer getIdWorker(){
        return idWorker;
    }
    public void setIdWorker(){
        this.idWorker = idWorker;
    }

    public String getFullName(){
        return fullName;
    }
    public void setFullName(){
        this.fullName = fullName;
    }

    public String getPost(){
        return post;
    }
    public void setPost(){
        this.post = post;
    }

    public String getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(){
        this.birthDate = birthDate;
    }

    public String getPassport(){
        return passport;
    }
    public void setPassport(){
        this.passport = passport;
    }

    public Integer getExperience(){
        return experience;
    }
    public void setExperience(){
        this.experience = experience;
    }
}