/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ciencias2proyecto.main.model;

public class Person {
    private Double personalTemp;
    private String personalTypeClothing;

    public Person(Double personalTemp, String personalTypeClothing) {
        this.personalTemp = personalTemp;
        this.personalTypeClothing = personalTypeClothing;
    }

    public Double getPersonalTemp() {
        return personalTemp;
    }

    public void setPersonalTemp(Double personalTemp) {
        this.personalTemp = personalTemp;
    }

    public String getPersonalTypeClothing() { return personalTypeClothing;}

    public void setPersonalTypeClothing(String personalTypeClothing) { this.personalTypeClothing = personalTypeClothing;}
}
