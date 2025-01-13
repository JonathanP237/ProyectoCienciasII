package com.mycompany.ciencias2proyecto.main.controller;

import com.mycompany.ciencias2proyecto.main.model.Apartment;
import com.mycompany.ciencias2proyecto.main.view.ApartmentView;
import com.mycompany.ciencias2proyecto.main.view.Window;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class ApartmentController {

    private Window view;
    private Stage detailsStage;

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
        if (detailsStage != null && detailsStage.isShowing()) {
            return; // Si la ventana ya está abierta, no hacer nada
        }

        detailsStage = new Stage();
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        Label idLabel = new Label("ID: " + apartment.getIdApartment());
        Label activityLabel = new Label("Activity: " + (apartment.getActivity() != null ? apartment.getActivity().toString() : "N/A"));
        Label tempLabel = new Label("Temperature: " + (apartment.getTempApt() != null ? apartment.getTempApt().toString() : "N/A"));
        Label habitabilityLabel = new Label("Habitability: " + (apartment.getHabitability() != null ? apartment.getHabitability() : "N/A"));

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> detailsStage.close());

        vbox.getChildren().addAll(idLabel, activityLabel, tempLabel, habitabilityLabel, closeButton);

        Scene scene = new Scene(vbox, 300, 200);
        detailsStage.setScene(scene);
        detailsStage.setTitle("Apartment Details");
        detailsStage.show();
    }
}