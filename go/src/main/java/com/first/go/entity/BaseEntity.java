package com.first.go.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
    @Id //co 2 chuc nang "NOT NULL , PRIMARY KEY"
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREAMENT
    private Long id;

    @Column(name = "createdBy") //khai bao col
    private String createdBy;

    @Column(name = "createdDate")
    private Date createdDate;
    
    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "modifiedDate")
    private Date modifiedDate;

    public Long getID(){
        return id;
    }

    public String getCreateBy(){
        return createdBy;
    }

    public void setCreateBy(String createdBy){
        this.createdBy = createdBy;
    }

    public Date getCreateDate(){
        return createdDate;
    }
    
    public void setCreateDate(Date createdDate){
        this.createdDate = createdDate;
    }

    public String getModifiedBy(){
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy){
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate(){
        return modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate){
        this.modifiedDate = modifiedDate;
    }
}
