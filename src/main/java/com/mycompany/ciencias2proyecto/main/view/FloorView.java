package com.mycompany.ciencias2proyecto.main.view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class FloorView {
    private final Window view;

    public FloorView(Window view) {
        this.view = view;
    }

    public void initialize(){
        Box floor = createFloor();
        view.addFloor(floor);
    }

    private Box createFloor() {
        int maxHeight = contarApartamentosVerticalmente();//Hace un recuento de cubos verticales para reconocer dónde ubicar el piso
        Box floor = new Box(40000, 10, 40000); // Crear un piso
        floor.setTranslateX(150);
        floor.setTranslateY(150 + maxHeight * 101);
        floor.setTranslateZ(0);

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.GREENYELLOW); // Establecer el color del piso
        material.setSpecularColor(Color.GREENYELLOW); // Establecer el color especular del piso para que no cambie con la iluminación
        material.setSelfIlluminationMap(null);
        floor.setMaterial(material);

        return floor;
    }

    private int contarApartamentosVerticalmente() {
        int maxHeight = 0;
        for (var node : view.getRoot().getChildren()) {
            if (node instanceof Group) {
                Group group = (Group) node;
                for (var child : group.getChildren()) {
                    if (child instanceof Box) {
                        Box cubo = (Box) child;
                        int height = (int) (cubo.getTranslateY() / 101);
                        if (height > maxHeight) {
                            maxHeight = height;
                        }
                    }
                }
            }
        }
        return maxHeight + 2; // +1 para contar el piso actual
    }
}
