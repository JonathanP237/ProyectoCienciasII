package com.mycompany.ciencias2proyecto.main.view;

import com.mycompany.ciencias2proyecto.main.model.Apartment;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetailsView {
    private Stage detailsStage;

    public void initialize(Apartment apartment){
        detailsStage = new Stage();

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

    public Stage getDetailsStage() {
        return detailsStage;
    }

    public void setDetailsStage(Stage detailsStage) {
        this.detailsStage = detailsStage;
    }
}
