package com.example.comp3111_project.chartScene;

import com.example.comp3111_project.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class ChartScene extends Scene {

    private final ChartController controller;

    public ChartScene() throws IOException {
        super(new Label("Loading..."));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("chart-output.fxml"));
        final StackPane startPane = (StackPane)fxmlLoader.load();
        this.setRoot(startPane);
        controller = fxmlLoader.getController();
    }

    public final ChartController getController() {
        return controller;
    }
}
