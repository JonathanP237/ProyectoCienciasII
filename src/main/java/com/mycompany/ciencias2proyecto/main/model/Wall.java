/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ciencias2proyecto.main.model;

public class Wall {
    private Material material;
    private Apartment apt1;
    private Apartment apt2;
    private Double area;
    private Double thickness;
    private Ambient ambient;

    public Wall(Material material, Apartment apt1, Apartment apt2, Double area, Double thickness) {
        this.material = material;
        this.apt1 = apt1;
        this.apt2 = apt2;
        this.area = area;
        this.thickness = thickness;
        this.ambient = null;
    }

    public Wall(Material material, Apartment apt1, Ambient ambient, Double area, Double thickness) {
        this.material = material;
        this.apt1 = apt1;
        this.apt2 = null;
        this.area = area;
        this.thickness = thickness;
        this.ambient = ambient;
    }

    public Apartment getApt1() {
        return apt1;
    }

    public Apartment getApt2() {
        return apt2;
    }

    public Ambient getAmbient() {
        return ambient;
    }

    // Método para calcular la transferencia de calor
    public Double calcularTransferenciaCalor() {
        Double k = material.getThermalConduct();
        Double temperatura1 = apt1.getTempApt();
        Double temperatura2 = 0.0;
        Double deltaT = 0.0;
        if(apt1.getTempApt()==null){
            temperatura2 = ambient.getAmbientTemp();
            deltaT = Math.abs(temperatura1 - temperatura2);
        }else{
            temperatura2 = apt2.getTempApt();
            deltaT = Math.abs(temperatura1 - temperatura2);
        }
        return (k * area * deltaT) / thickness;
    }
}