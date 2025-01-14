package com.mycompany.ciencias2proyecto.main.controller;

import com.mycompany.ciencias2proyecto.main.model.Apartment;
import com.mycompany.ciencias2proyecto.main.view.ApartmentView;
import com.mycompany.ciencias2proyecto.main.view.DetailsView;
import com.mycompany.ciencias2proyecto.main.view.Window;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

public class ApartmentController {

    private Window view;
    private DetailsView detailsView = new DetailsView();

    public ApartmentController(Window view) {
        this.view = view;
    }

    public void initialize() {
        // Crear y agregar apartamentos a la vista
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Apartment apartment = new Apartment();
                apartment.setIdApartment("Apt-" + i + "-" + j);
                ApartmentView apartmentView = new ApartmentView(apartment, i * 101, j * 101, 0);
                Box cubo = apartmentView.getBox();
                addClickHandler(cubo, apartmentView);
                view.addCubo(cubo);
            }
        }
    }

    private void addClickHandler(Box cubo, ApartmentView apartmentView) {
        cubo.setOnMouseEntered(event -> cubo.setCursor(Cursor.HAND));
        cubo.setOnMouseExited(event -> cubo.setCursor(Cursor.DEFAULT));
        cubo.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("Cubo clicado en posición: (" + cubo.getTranslateX() + ", " + cubo.getTranslateY() + ", " + cubo.getTranslateZ() + ")");
            PhongMaterial material = (PhongMaterial) cubo.getMaterial();
            material.setDiffuseColor(Color.GREEN); // Cambiar el color al hacer clic

            showApartmentDetails(apartmentView.getApartment());
        });
    }

    private void showApartmentDetails(Apartment apartment) {
        if (detailsView.getDetailsStage() != null && detailsView.getDetailsStage().isShowing()) {
            return; // Si la ventana ya está abierta, no hacer nada
        }
        detailsView.initialize(apartment);
    }
}