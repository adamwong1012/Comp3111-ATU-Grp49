package com.example.comp3111_project.outputScene;

import com.example.comp3111_project.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;


public class OutputScene extends Scene {

    private final OutputController controller;
    public OutputScene() throws IOException {
        super(new Label("Loading..."));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("team-output.fxml"));
        final AnchorPane startPane = (AnchorPane)fxmlLoader.load();
        this.setRoot(startPane);
        controller = fxmlLoader.getController();
    }

    public final OutputController getController() {
        return controller;
    }

}
