/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ciencias2proyecto.main.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private String idApartment;
    private Activity activity;
    private Double tempApt;
    private List<Wall> walls;
    private String habitability;

    public Apartment(int i, Activity activity) {
        this.idApartment = Integer.toString(i);
        this.activity = activity;
        this.walls = new ArrayList<>();
    }

    public String getIdApartment() {    
        return idApartment;
    }

    public void setIdApartment(String idApartment) {
        this.idApartment = idApartment;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Double getTempApt() {
        return tempApt;
    }

    public void setTempApt(Double tempApt) {
        this.tempApt = tempApt;
    }
    
    public List<Wall> getWalls(){
        return this.walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }   

    public void setHabitability(String habitability) {
        this.habitability = habitability;
    }

    public String getHabitability() {return this.habitability;}

    public String getColorApartment(){
        if(this.tempApt <= 31.5){
            return "GREEN";
        }else if(this.tempApt <= 32.5){
            return  "ORANGE";
        }else{
            return "RED";
        }
    }

    public void calculAptHabitability(){
        activity.calcTempAport();
        if(this.tempApt==null){
            System.out.println(activity.getTempAport());
            this.tempApt=activity.getTempAport();
            System.out.println("1");
        }else{

            for(Wall w: walls){
                this.tempApt+= w.calcularTransferenciaCalor();
            }
            this.tempApt/=4;
            this.tempApt+=activity.getTempAport();
            System.out.println("2");
        }
    }    
}
