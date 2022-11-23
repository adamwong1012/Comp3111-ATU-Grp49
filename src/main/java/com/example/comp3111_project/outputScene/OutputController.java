package com.example.comp3111_project.outputScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


/**
 * create controller to controller the state of outputScene
 */
public class OutputController implements Initializable  {



    @FXML
    private Text K1;

    @FXML
    private Text K2;

    @FXML
    private Text name1;

    @FXML
    private Text name2;

    @FXML
    private Text name3;

    @FXML
    private Text name4;

    @FXML
    private Text search_id;

    @FXML
    private Text search_name;

    @FXML
    private Text teamNo;


    private String search;

    //private Object[] teamList = new Object[4];

    private int teamId;

    //private String[] nameList = new String[4];

    /**
     * initialize outputScene
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.teamNo.setText("-----");
        this.name4.setText("-----");
        this.name2.setText("-----");
        this.name1.setText("-----");
        this.name3.setText("-----");
        this.K1.setText("-----");
        this.K2.setText("-----");
        this.search_name.setText("-----");
        this.search_id.setText("-----");
    }



    /**
     * update Scene
     */

    public void setScene(List<String> nameList,String teamId,String k1avg,String k2avg,String sName,String sID){
        this.teamNo.setText(teamId);
        this.search_id.setText(sID);
        this.search_name.setText(sName);
        for (int i=0; i<nameList.size(); i++){
            switch (i){
                case 0: name1.setText(nameList.get(0));break;
                case 1: name2.setText(nameList.get(1));break;
                case 2: name3.setText(nameList.get(2));break;
                case 3: name4.setText(nameList.get(3));break;
            }
        }
        this.K1.setText(k1avg);
        this.K2.setText(k2avg);
    }
}
