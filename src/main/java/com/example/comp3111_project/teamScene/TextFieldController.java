package com.example.comp3111_project.teamScene;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    void search(ActionEvent event) {
        inputResult = inputField.getCharacters().toString();
        System.out.println(inputResult);
    }

    @FXML
    void exit(ActionEvent event) {

    }

    public String getInputResult() {
        return inputResult;
    }


}
