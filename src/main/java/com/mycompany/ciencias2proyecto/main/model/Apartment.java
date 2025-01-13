/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ciencias2proyecto.main.model;

import java.util.List;
import com.mycompany.ciencias2proyecto.main.model.Activity;

/**
 *
 * @author JyL
 */
public class Apartment {
    private String idApartment;
    private Activity activity;
    private Float tempApt;
    private List<Wall> walls;
    private String habitability;

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

    public Float getTempApt() {
        return tempApt;
    }

    public void setTempApt(Float tempApt) {
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
            
    public void calculAptHabitability(){
        
    }    
}
