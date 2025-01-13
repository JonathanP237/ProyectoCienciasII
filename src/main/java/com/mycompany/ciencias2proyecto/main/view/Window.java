/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ciencias2proyecto.main.view;

import com.mycompany.ciencias2proyecto.main.controller.ApartmentController;
import com.mycompany.ciencias2proyecto.main.controller.ViewController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Window extends Application {

    private Group root;
    private Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
    private Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
    private Scale scale = new Scale(1, 1, 1);

    @Override
    public void start(Stage primaryStage) {
        //Grupo que contiene los cubos de los apartamentos
        root = new Group();
        root.getTransforms().addAll(rotateX, rotateY, scale);

        // Crear el botón y posicionarlo en la parte superior derecha
        Button clcHabitabilityBtn = new Button("Calcular Habitabilidad");
        clcHabitabilityBtn.setTranslateX(800);
        clcHabitabilityBtn.setTranslateY(40);
        clcHabitabilityBtn.setPrefWidth(160);
        clcHabitabilityBtn.setPrefHeight(50);
        clcHabitabilityBtn.setStyle("-fx-font-weight: bold;");

        // Crear un grupo que contenga el root y el botón
        Group mainGroup = new Group();
        mainGroup.getChildren().addAll(root, clcHabitabilityBtn);

        Scene scene = new Scene(mainGroup, 1000, 800, true);
        scene.setFill(Color.LIGHTSKYBLUE);
        PerspectiveCamera camera = new PerspectiveCamera(false);
        scene.setCamera(camera);

        primaryStage.setTitle("Apartamentos Interactivos");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false); // Hacer que el tamaño de la ventana no se pueda cambiar
        primaryStage.show();

        // Centrar el grupo en la ventana
        root.setTranslateX(scene.getWidth() / 2);
        root.setTranslateY(scene.getHeight() / 2);

        // Inicializar el controlador después de que la vista esté lista
        ApartmentController controller = new ApartmentController(this);
        controller.initialize();
        ViewController viewController = new ViewController(this);
        viewController.initialize();
        FloorView floorView = new FloorView(this);
        floorView.initialize();
    }

    public void addCubo(Box cubo) {
        root.getChildren().add(cubo);
    }

    public void addPiso(Box piso) {
        root.getChildren().add(piso);
    }

    public void setOnMousePressed(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        root.getScene().setOnMousePressed(value);
    }

    public void setOnMouseDragged(javafx.event.EventHandler<? super javafx.scene.input.MouseEvent> value) {
        root.getScene().setOnMouseDragged(value);
    }

    public void setOnScroll(javafx.event.EventHandler<? super javafx.scene.input.ScrollEvent> value) {
        root.getScene().setOnScroll(value);
    }

    public Rotate getRotateX() {
        return rotateX;
    }

    public Rotate getRotateY() {
        return rotateY;
    }

    public Scale getScale() {
        return scale;
    }

    public Group getRoot() {
        return root;
    }
}
