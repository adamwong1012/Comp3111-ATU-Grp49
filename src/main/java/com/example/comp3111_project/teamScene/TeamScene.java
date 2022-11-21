package com.example.comp3111_project.teamScene;

import com.example.comp3111_project.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Objects;

public class TeamScene extends Scene {

    private final TextFieldController controller;
    public TeamScene() throws IOException {
        super(new Label("Loading..."));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("text-field.fxml"));
        final AnchorPane startPane = (AnchorPane)fxmlLoader.load();
        this.setRoot(startPane);
        controller = fxmlLoader.getController();
    }

    public final TextFieldController getController() {
        return controller;
    }

}
