package com.example.comp3111_project.teamScene;
import com.example.comp3111_project.HelloApplication;
import com.example.comp3111_project.outputScene.OutputHelper;
import com.example.comp3111_project.outputScene.OutputScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;



/**
 * create controller to controller the state of textFieldScene
 */
public class TextFieldController   {



    @FXML
    private Text field_title;

    @FXML
    private Button go_button;

    @FXML
    private TextField inputField;

    @FXML
    private Text title;

    private  String inputResult;





    /**
     * @param event user click button, if valid inputField -> create outputScene , otherwise it will call new Alert()
     * @throw IO exception for creating outputScene
     */

    @FXML
    void search(ActionEvent event) throws IOException {

        this.setInputResult(inputField.getCharacters().toString());
        Stage outputStage = new Stage();
        outputStage.setTitle("ATU System");
        OutputHelper outputHelper = new OutputHelper(HelloApplication.getTeam());
        int result = outputHelper.checkForValidInput(inputResult);
        if ( result == -1) {
            Alert alertMessage = new Alert(Alert.AlertType.NONE);
            alertMessage.setAlertType(Alert.AlertType.ERROR);
            alertMessage.setTitle("Invalid Input");
            alertMessage.setContentText("Please provide valid input. [<Family Name> <First Name>]");
            alertMessage.show();
        } else if (result == 0) {
            Alert alertMessage = new Alert(Alert.AlertType.NONE);
            alertMessage.setAlertType(Alert.AlertType.ERROR);
            alertMessage.setTitle("Not Found");
            alertMessage.setContentText("There is no existing record.");
            alertMessage.show();
        } else {
            OutputScene outputScene = new OutputScene();
            outputScene.getController().setScene(outputHelper.getNameList(),outputHelper.getTeamId(),outputHelper.getK1Average(),outputHelper.getK2Average(),outputHelper.getFoundNameResult(),outputHelper.getFoundIDResult());
            outputStage.setScene(outputScene);
            outputStage.show();
        }

    }
    /**
     * return inputResult
     * @return inputFieldResult
     */

    public String getInputResult() {

        return inputResult;
    }
    /**
     * set inputResult
     * @param result update the instance inputResult as result of inputField
     */
    public void setInputResult(String result) {

        inputResult = result;
    }


}
