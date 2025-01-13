package com.mycompany.ciencias2proyecto.main.view;

import com.mycompany.ciencias2proyecto.main.model.Apartment;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class ApartmentView {
    private final Box box;
    private final Apartment apartment;

    public ApartmentView(Apartment apartment,double x, double y, double z) {
        this.apartment = apartment;
        this.box = createBox(x, y, z);
    }

    private Box createBox(double x, double y, double z) {
        Box box = new Box(99, 99, 99); // Crear un cubo
        box.setTranslateX(x - 100);
        box.setTranslateY(y - 100);
        box.setTranslateZ(z);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE); // Establecer el color del cubo
        box.setMaterial(material);

        return box;
    }

    public Box getBox() {
        return box;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
