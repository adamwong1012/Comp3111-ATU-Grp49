package com.example.comp3111_project.outputScene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.io.*;
import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;


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
     * set textFieldInputResult
     * @param result inputFieldResult
     */

    public void setSearch(String result) {

        search = result;
        //setScene();
    }

    /**
     * update Scene
     */
	
	/*public static void readFromCSVFile(String filePath, String search)
	{
	    try {
	        FileReader inputfile = new FileReader(filePath);
	        CSVReader reader = new CSVReader(inputfile);
	        String[] rowdata;
	        
	        // header needs not to be searched
	        reader.readNext();
	        // read the csv file to search for matching student_name
	        while ((rowdata = reader.readNext()) != null) {
	        	if (rowdata[2].equals(search)) {
		            for (String datum : rowdata) {
		                System.out.print(datum + "\t");
		            }
		            System.out.println();
		            break;
	        	}
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}*/

    public void setScene(){
    	try {
	        FileReader inputfile = new FileReader(filePath);
	        CSVReader reader = new CSVReader(inputfile);
	        String[] rowdata;
	        
	        // header needs not to be searched
	        reader.readNext();
	        // read the csv file to search for matching student_name
	        while ((rowdata = reader.readNext()) != null) {
	        	if (rowdata[2].equals(search)) {
		            for (String datum : rowdata) {
		                this.teamNo.setText(rowdata[0]);
		                this.name4.setText(search); // search == rowdata[2] ? 
		                this.name1.setText(rowdata[3]);
		                this.name2.setText(rowdata[4]);
		                this.name3.setText(rowdata[5]);
		                this.K1.setText(rowdata[6]);
		                this.K2.setText(rowdata[7]);
		            }
		            break;
	        	}
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
    }
}
