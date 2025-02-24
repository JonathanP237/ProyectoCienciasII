package com.mycompany.ciencias2proyecto.main.view;

import com.mycompany.ciencias2proyecto.main.model.Apartment;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class DetailsView {
    private Stage detailsStage;

    public void initialize(Apartment apartment){
        detailsStage = new Stage();

        detailsStage = new Stage();
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        Button applyButton = new Button("Aplicar medida");
        DecimalFormat formato = new DecimalFormat("#.###");
        Label idLabel = new Label("ID: " + apartment.getIdApartment());
        Label activityLabel = new Label("Actividad: " + (apartment.getActivity() != null ? apartment.getActivity().getActivityName() : "N/A"));
        String resultado;
        Label tempLabel = new Label("Temperatura: " + (apartment.getTempApt() != null ? resultado = String.format("%.3f", apartment.getTempApt()) : "N/A"));
        Label habitabilityLabel = new Label("Habitabilidad: " + (apartment.getHabitability() != null ? apartment.getHabitability() : "N/A"));
        Label actionLabel = new Label("Medida: " + (apartment.getHabitability() != null ? apartment.getHabitability() : "N/A"));
        detailsStage.setResizable(false);

        idLabel.setTranslateX(20);
        activityLabel.setTranslateX(20);
        tempLabel.setTranslateX(20);
        actionLabel.setTranslateX(20);
        habitabilityLabel.setTranslateX(20);
        idLabel.setTranslateY(30);
        activityLabel.setTranslateY(50);
        tempLabel.setTranslateY(70);
        habitabilityLabel.setTranslateY(90);
        actionLabel.setTranslateY(110);
        applyButton.setTranslateX(100);
        applyButton.setTranslateY(130);

        vbox.getChildren().addAll(idLabel, activityLabel, tempLabel, habitabilityLabel, actionLabel,applyButton);

        Scene scene = new Scene(vbox, 300, 300);
        detailsStage.setScene(scene);
        detailsStage.setTitle("Detalles del apartamento");
        detailsStage.show();
    }

    public Stage getDetailsStage() {
        return detailsStage;
    }

    public void setDetailsStage(Stage detailsStage) {
        this.detailsStage = detailsStage;
    }
}
