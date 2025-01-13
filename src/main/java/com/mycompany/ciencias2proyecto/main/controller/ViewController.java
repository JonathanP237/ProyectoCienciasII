package com.mycompany.ciencias2proyecto.main.controller;

import com.mycompany.ciencias2proyecto.main.view.Window;
import javafx.scene.transform.Scale;

public class ViewController {
    private final Window view;
    private static final double ROTATION_SPEED = 0.2;
    private static final double MAX_ANGLE_X = 45;
    private static final double MIN_ANGLE_X = -5;
    private static final double SCALE_DELTA = 1.1;
    private static final double MIN_SCALE = 0.61;
    private static final double MAX_SCALE = 2.5;
    private double anchorX, anchorY;
    private double anchorAngleX = 0;
    private double anchorAngleY = 0;

    public ViewController(Window view) {
        this.view = view;
    }

    public void initialize() {
        // Manejar eventos de arrastre del ratón
        view.setOnMousePressed(event -> {
            anchorX = event.getSceneX();
            anchorY = event.getSceneY();
            anchorAngleX = view.getRotateX().getAngle();
            anchorAngleY = view.getRotateY().getAngle();
        });

        view.setOnMouseDragged(event -> {
            double deltaX = (anchorY - event.getSceneY()) * ROTATION_SPEED;
            double deltaY = (anchorX - event.getSceneX()) * ROTATION_SPEED;

            double newAngleX = anchorAngleX - deltaX;
            double newAngleY = anchorAngleY + deltaY;

            // Limitar los ángulos de rotación
            newAngleX = Math.max(MIN_ANGLE_X, Math.min(MAX_ANGLE_X, newAngleX));

            view.getRotateX().setAngle(newAngleX);
            view.getRotateY().setAngle(newAngleY);
        });

        // Manejar eventos de desplazamiento del ratón para zoom
        view.setOnScroll(event -> {
            double delta = event.getDeltaY();
            Scale scale = view.getScale();
            double newScaleX = scale.getX() * (delta > 0 ? SCALE_DELTA : 1 / SCALE_DELTA);
            double newScaleY = scale.getY() * (delta > 0 ? SCALE_DELTA : 1 / SCALE_DELTA);
            double newScaleZ = scale.getZ() * (delta > 0 ? SCALE_DELTA : 1 / SCALE_DELTA);

            // Limitar la escala
            newScaleX = Math.max(MIN_SCALE, Math.min(MAX_SCALE, newScaleX));
            newScaleY = Math.max(MIN_SCALE, Math.min(MAX_SCALE, newScaleY));
            newScaleZ = Math.max(MIN_SCALE, Math.min(MAX_SCALE, newScaleZ));

            scale.setX(newScaleX);
            scale.setY(newScaleY);
            scale.setZ(newScaleZ);

            System.out.println(scale.getX() + " " + scale.getY() + " " + newScaleZ);
        });
    }
}
