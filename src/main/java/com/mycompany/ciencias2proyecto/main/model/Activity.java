/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ciencias2proyecto.main.model;

import java.util.Date;
import java.util.List;

public class Activity {
    private String nameActivity;
    private List<Person> integrants;
    private Double tempAport;
    private String workType;
    private Date startDate;
    private Date endDate;

    public String getActivityName() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public List<Person> getIntegrants() {
        return integrants;
    }

    public void setIntegrants(List<Person> integrants) {
        this.integrants = integrants;
    }

    public Double getTempAport() {
        return tempAport;
    }

    public void setTempAport(Double tempAport) {
        this.tempAport = tempAport;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void calcTempAport(){
        tempAport=0.0;
        for(Person p : integrants){
            tempAport += p.getPersonalTemp();
        }
        switch (this.getWorkType().toUpperCase()){
            case "PESADA":
                this.tempAport = (tempAport/integrants.size())*0.95;
                break;
            case  "NORMAL":
                this.tempAport = (tempAport/integrants.size())*0.8;
                break;
            case "LIGERA":
                this.tempAport = (tempAport/integrants.size())*0.7;
                break;
        }
    }
}
