package com.example.comp3111_project.teamScene;

import com.example.comp3111_project.outputScene.OutputController;
import com.example.comp3111_project.outputScene.OutputScene;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TextFieldController   {

    @FXML
    private Text field_title;

    @FXML
    private Button go_button;

    @FXML
    private TextField inputField;

    @FXML
    private Text title;

    private String inputResult;

    @FXML
    private Button exitButton;



    @FXML
    void search(ActionEvent event) throws IOException {
        inputResult = inputField.getCharacters().toString();
        Stage outputStage = new Stage();
        OutputScene outputScene = new OutputScene();
        outputScene.getController().setSearch(inputResult);
        outputStage.setScene(outputScene);
        outputStage.show();
    }

    @FXML
    void exit(ActionEvent event) {
        this.exitButton.fireEvent(event);
    }

    public String getInputResult() {
        return inputResult;
    }


}
