package com.example.comp3111_project;

import com.example.comp3111_project.Algorithms.Team;
import com.example.comp3111_project.Algorithms.TeamingProcess;
import com.example.comp3111_project.chartScene.ChartScene;
import com.example.comp3111_project.teamScene.TeamScene;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {


    static File selectedFile;

    private TableView<Statistics> stat_table = new TableView<Statistics>();
    private TableView<Person> person_table = new TableView<Person>();

    private static Team[] team ;

    //    private final ObservableList<Statistics> stat_data = FXCollections.observableArrayList(
//            new Statistics("Total Number of Students", "100"),
//            new Statistics("K1_Energy(Average, Min, Max)", "(59.8, 10, 80)"),
//            new Statistics("K2_Energy(Average, Min, Max)", "(62.3, 40, 85)"), new Statistics("K3_Tick1 = 1", "12"),
//            new Statistics("K3_Tick2 = 1", "3"), new Statistics("My_Preference = 1", "19"));
    private final ObservableList<Statistics> stat_data = FXCollections.observableArrayList();


    private final static ObservableList<Person> person_data = FXCollections.observableArrayList();

    public static final String delimiter = ",";

    //public final String K1_AVG = null;

    public  static void read(String csvFile) {

        System.out.print("\n");
        try {
            File file = new File(csvFile);
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = " ";
            String[] tempArr;
            br.readLine(); // skip the first line
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                String temptemp = "";
                String displayName = "";
                String displayEmail ="";
                for(int i=0;i<tempArr.length;i++)
                {   temptemp = tempArr[1]+tempArr[2];
                    displayName = temptemp.substring(1, temptemp.length() - 1);
                    displayEmail = tempArr[3].substring(1, temptemp.length() - 1);
                }
                person_data.add(new Person(tempArr[0], displayName, displayEmail, tempArr[4], tempArr[5], tempArr[6],
                        tempArr[7], tempArr[8], tempArr[9]));
            }
            var hello = new TeamingProcess(person_data);
            team = hello.getTeamArray();
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static Team[] getTeam(){
        return team;
    }



    @Override
    public void start(Stage stage_stat) {

        stage_stat.setTitle("Multiple Scenes");

        Group group1 = new Group();
        Scene scene1 = new Scene(group1, 300, 250);

        // Fill in the scene1






//        stage_stat.setScene(scene_stat);
//        stage_stat.show();
        //Group group2 = new Group();
//        Button btnExit = new Button();
//        btnExit.setLayoutX(400);
//        btnExit.setLayoutY(10);
//        btnExit.setText("Back");
//        btnExit.setOnAction(e -> {stage_stat.setScene(scene1);stage_stat.show();});
        //group2.getChildren().add(btnExit);

        Scene scene_stat = new Scene(new Group());
        stage_stat.setTitle("ATU system");
        stage_stat.setWidth(400);
        stage_stat.setHeight(500);


        final Label label_stat = new Label("Statistics");
        label_stat.setFont(new Font("Arial", 20));

        stat_table.setEditable(true);

        TableColumn entry_column = new TableColumn("Entry");
        entry_column.setMinWidth(100);
        entry_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("entry"));

        TableColumn value_column = new TableColumn("Value");
        value_column.setMinWidth(200);
        value_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("value"));

        stat_table.setItems(stat_data);
        stat_table.getColumns().addAll(entry_column, value_column);
        stat_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final VBox vbox_stat = new VBox();
        vbox_stat.setSpacing(5);
        vbox_stat.setPadding(new Insets(10, 10, 10, 10));
        vbox_stat.getChildren().addAll(label_stat, stat_table);

        ((Group) scene_stat.getRoot()).getChildren().addAll(vbox_stat);
        //((Group) scene_stat.getRoot()).getChildren().addAll(btnExit);

//        stage_stat.setScene(scene_stat);
//        stage_stat.show();

        Stage stage_person = new Stage();
        Scene scene_person = new Scene(new Group());
        stage_person.setTitle("Table of statistics data");
        stage_person.setWidth(450);
        stage_person.setHeight(500);

        final Label label_person = new Label("Person");
        label_person.setFont(new Font("Arial", 20));

        person_table.setEditable(true);

        TableColumn studentid_column = new TableColumn("Student_ID");
        studentid_column.setMinWidth(100);
        studentid_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("studentid"));

        TableColumn studentname_column = new TableColumn("Student_Name");
        studentname_column.setMinWidth(200);
        studentname_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("studentname"));

        TableColumn studentemail_column = new TableColumn("Student_Email");
        studentemail_column.setMinWidth(200);
        studentemail_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("studentemail"));

        TableColumn k1energy_column = new TableColumn("K1_Energy");
        k1energy_column.setMinWidth(100);
        k1energy_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k1energy"));

        TableColumn k2energy_column = new TableColumn("k2_Energy");
        k2energy_column.setMinWidth(100);
        k2energy_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k2energy"));

        TableColumn k3trick1_column = new TableColumn("K3_Trick1");
        k3trick1_column.setMinWidth(100);
        k3trick1_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k3trick1"));

        TableColumn k3trick2_column = new TableColumn("K3_Trick2");
        k3trick2_column.setMinWidth(100);
        k3trick2_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("k3trick2"));

        TableColumn mypreference_column = new TableColumn("My_Preference");
        mypreference_column.setMinWidth(100);
        mypreference_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("mypreference"));

        TableColumn concerns_column = new TableColumn("Concerns");
        concerns_column.setMinWidth(100);
        concerns_column.setCellValueFactory(new PropertyValueFactory<Statistics, String>("concerns"));

        person_table.setItems(person_data);
        person_table.getColumns().addAll(studentid_column, studentname_column, studentemail_column,k1energy_column, k2energy_column,
                k3trick1_column, k3trick2_column, mypreference_column, concerns_column);
        person_table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        final VBox vbox_person = new VBox();
        vbox_person.setSpacing(5);
        vbox_person.setPadding(new Insets(10, 10, 10, 10));
        vbox_person.getChildren().addAll(label_person, person_table);

        ((Group) scene_person.getRoot()).getChildren().addAll(vbox_person);

//        stage_person.setScene(scene_person);
//        stage_person.show();





        Button btn2 = new Button();
        btn2.setLayoutX(135);
        btn2.setLayoutY(200);
        btn2.setText("view student info");
        Stage person_stage = new Stage();
        person_stage.setScene(scene_person);
        btn2.setOnAction(e ->
                //stage_stat.setScene(scene_person)

                person_stage.show()
        );
        //group1.getChildren().add(btn2);

        Button btn3 = new Button();
        btn3.setLayoutX(135);
        btn3.setLayoutY(240);
        btn3.setText("view general statistics");
        Stage stats_Stage = new Stage();
        btn3.setOnAction(e -> {
            Platform.runLater(()->{
                String numOfStudents = String.valueOf(person_data.size());

                /*
                 * check for the average K1,
                 * minimum and maximum values of K1
                 * using for loop to iterate through the list of students
                 */
                double K1_AVG = 0;
                double K1_MIN = Double.parseDouble(person_data.get(0).k1energy.getValue());
                double K1_MAX = Double.parseDouble(person_data.get(0).k1energy.getValue());
                for(int i=0; i< person_data.size();i++)
                {
                    K1_AVG += Double.parseDouble(person_data.get(i).k1energy.getValue());
                    if(K1_MIN>Double.parseDouble(person_data.get(i).k1energy.getValue()))
                    {
                        K1_MIN = Double.parseDouble(person_data.get(i).k1energy.getValue());
                    }
                    if(K1_MAX<Double.parseDouble(person_data.get(i).k1energy.getValue())){
                        K1_MAX = Double.parseDouble(person_data.get(i).k1energy.getValue());
                    };
                }

                /*
                 * check for the average K2,
                 * minimum and maximum values of K2
                 * using for loop to iterate through the list of students
                 */
                double K2_AVG = 0;
                double K2_MIN = Double.parseDouble(person_data.get(0).k2energy.getValue());
                double K2_MAX = Double.parseDouble(person_data.get(0).k2energy.getValue());
                for(int i=0; i< person_data.size();i++)
                {
                    K2_AVG += Double.parseDouble(person_data.get(i).k2energy.getValue());
                    if(K2_MIN>Double.parseDouble(person_data.get(i).k2energy.getValue()))
                    {
                        K2_MIN = Double.parseDouble(person_data.get(i).k2energy.getValue());
                    }
                    if(K2_MAX<Double.parseDouble(person_data.get(i).k2energy.getValue())){
                        K2_MAX = Double.parseDouble(person_data.get(i).k2energy.getValue());
                    };
                }

                K2_AVG = K2_AVG/person_data.size();

                /*
                 * check for the K3 tick 1 and tick 2
                 * check the "my preference"
                 *
                 * using for loop to iterate through the list of students
                 * by adding the values for each field, for example, if the result of
                 * adding all "my preference" is 2, then two students put 1 in their preference
                 */

                Integer K3_TICK_1 = 0;
                Integer K3_TICK_2 = 0;
                for(int i=0; i< person_data.size();i++)
                {
                    K3_TICK_1 += Integer.parseInt(person_data.get(i).k3trick1.getValue());
                    K3_TICK_2 += Integer.parseInt(person_data.get(i).k3trick2.getValue());
                }

                Integer MY_PREFERENCE = 0;

                for(int i=0; i< person_data.size();i++)
                {

                    MY_PREFERENCE += Integer.parseInt(person_data.get(i).mypreference.getValue());
                }

                stat_data.add(new Statistics("Total Number of Students", numOfStudents));
                stat_data.add(new Statistics("K1_Energy(Average, Min, Max)", "(" + String.valueOf(K1_MIN) + ", " + String.valueOf(K1_AVG) + ", " +String.valueOf(K1_MAX) + ")"));//"(59.8, 10, 80)"
                stat_data.add(new Statistics("K2_Energy(Average, Min, Max)", "(" + String.valueOf(K2_MIN) + ", " + String.valueOf(K2_AVG) + ", " +String.valueOf(K2_MAX) + ")"));
                stat_data.add(new Statistics("K3_Tick1 = 1", K3_TICK_1.toString()));
                stat_data.add(new Statistics("K3_Tick2 = 1", K3_TICK_2.toString()));
                stat_data.add(new Statistics("My_Preference = 1", MY_PREFERENCE.toString()));});
//            new Statistics("K2_Energy(Average, Min, Max)", "(62.3, 40, 85)"), new Statistics("K3_Tick1 = 1", "12"),
//            new Statistics("K3_Tick2 = 1", "3"), new Statistics("My_Preference = 1", "19"));
            stats_Stage.setScene(scene_stat);
            stats_Stage.show();
            //stage_stat.setScene(scene_stat);
        });

        Button btn4 = new Button();
        btn4.setLayoutX(135);
        btn4.setLayoutY(280);
        btn4.setText("Search your own team");
        btn4.setOnAction(e ->
                        //stage_stat.setScene(scene_person)
                {
                    if (person_data.isEmpty()){
                        Alert alertMessage = new Alert(Alert.AlertType.NONE);
                        alertMessage.setAlertType(Alert.AlertType.ERROR);
                        alertMessage.setTitle("Not Found");
                        alertMessage.setContentText("Please drag the csv file into the system.");
                        alertMessage.show();
                    }
                    else {
                        try {
                            Stage stage4= new Stage();
                            stage4.setTitle("ATU System");
                            stage4.setScene(new TeamScene());
                            stage4.show();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );

        Button btn5 = new Button();
        btn5.setLayoutX(135);
        btn5.setLayoutY(320);
        btn5.setText("Search Line Chart");
        btn5.setOnAction(e ->
                        //stage_stat.setScene(scene_person)
                {
                    if (person_data.isEmpty()){
                        Alert alertMessage = new Alert(Alert.AlertType.NONE);
                        alertMessage.setAlertType(Alert.AlertType.ERROR);
                        alertMessage.setTitle("Not Found");
                        alertMessage.setContentText("Please drag the csv file into the system.");
                        alertMessage.show();
                    }
                    else {
                        try {
                            Stage stage5= new Stage();
                            stage5.setTitle("ATU System");
                            ChartScene chartScene = new ChartScene();
                            stage5.setScene(chartScene);
                            stage5.show();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );

        Label mainLabel = new Label("Please Choose your File (.csv)");
        mainLabel.setLayoutX(50);
        mainLabel.setLayoutY(110);
        mainLabel.setFont(new Font("Arial", 18));
        mainLabel.setTextFill(Color.RED);

        Button btn1 = new Button();
        btn1.setLayoutX(100);
        btn1.setLayoutY(138);
        btn1.setText("Choose a file");
        btn1.setOnAction(e -> {
            /* using file chooser to allow users to choose files from file explorer*/
            FileChooser fileChooser = new FileChooser();
            selectedFile = fileChooser.showOpenDialog(null);
            btn1.setText(selectedFile.getName());
            HelloApplication.read(selectedFile.toString());

        });
        Label selectedFileLabel = new Label("File:");
        selectedFileLabel.setLayoutX(50);
        selectedFileLabel.setLayoutY(140);
        selectedFileLabel.setFont(new Font("Arial", 15));

        Label Welcome = new Label("Welcome to ATU!");
        Welcome.setLayoutX(40);
        Welcome.setLayoutY(40);
        Welcome.setFont(new Font("Arial", 40));
        Welcome.setTextFill(Color.ORANGE);

        Label Input = new Label("Statistics:");
        Input.setLayoutX(50);
        Input.setLayoutY(200);
        Input.setFont(new Font("Arial", 15));
        Welcome.setTextFill(Color.ORANGE);

        Label search = new Label("Search:");
        search.setLayoutX(50);
        search.setLayoutY(280);
        search.setFont(new Font("Arial", 15));





        group1.getChildren().add(Welcome);
        group1.getChildren().add(mainLabel);
        group1.getChildren().add(selectedFileLabel);
        group1.getChildren().add(btn1);
        group1.getChildren().add(btn2);
        group1.getChildren().add(btn3);
        group1.getChildren().add(Input);
        group1.getChildren().add(btn4);
        group1.getChildren().add(btn5);
        group1.getChildren().add(search);



        stage_stat.setScene(scene1);
        stage_stat.show();

    }


    public static void main(String[] args) throws Exception {

        launch(args);

    }

    public static class Statistics {

        private final SimpleStringProperty entry;
        private final SimpleStringProperty value;

        public Statistics(String fName, String lName) {
            this.entry = new SimpleStringProperty(fName);
            this.value = new SimpleStringProperty(lName);
        }

        public String getEntry() {
            return entry.get();
        }

        public void setEntry(String val) {
            entry.set(val);
        }

        public String getValue() {
            return value.get();
        }

        public void setValue(String val) {
            value.set(val);
        }

    }

    public static class Person {

        private final SimpleStringProperty studentid;
        private final SimpleStringProperty studentname;

        private final SimpleStringProperty studentemail;
        private final SimpleStringProperty k1energy;
        private final SimpleStringProperty k2energy;
        private final SimpleStringProperty k3trick1;
        private final SimpleStringProperty k3trick2;
        private final SimpleStringProperty mypreference;
        private final SimpleStringProperty concerns;

        public Person(String student_id, String student_name, String student_email, String k1_energy, String k2_energy, String k3_trick1,
                      String k3_trick2, String my_preference, String concerns) {
            this.studentid = new SimpleStringProperty(student_id);
            this.studentname = new SimpleStringProperty(student_name);
            this.studentemail = new SimpleStringProperty(student_email);
            this.k1energy = new SimpleStringProperty(k1_energy);
            this.k2energy = new SimpleStringProperty(k2_energy);
            this.k3trick1 = new SimpleStringProperty(k3_trick1);
            this.k3trick2 = new SimpleStringProperty(k3_trick2);
            this.mypreference = new SimpleStringProperty(my_preference);
            this.concerns = new SimpleStringProperty(concerns);
        }




        public String getStudentid() {
            return studentid.get();
        }

        public void setStudentid(String val) {
            studentid.set(val);
        }

        public String getStudentname() {
            return studentname.get();
        }

        public void setStudentname(String val) {
            studentname.set(val);
        }

        public String getStudentemail() {
            return studentemail.get();
        }

        public void setStudentemail(String val) {
            studentemail.set(val);
        }


        public String getK1energy() {
            return k1energy.get();
        }

        public void setK1energy(String val) {
            k1energy.set(val);
        }

        public String getK2energy() {
            return k2energy.get();
        }

        public void setK2energy(String val) {
            k2energy.set(val);
        }

        public String getK3trick1() {
            return k3trick1.get();
        }

        public void setK3trick1(String val) {
            k3trick1.set(val);
        }

        public String getK3trick2() {
            return k3trick2.get();
        }

        public void setK3trick2(String val) {
            k3trick2.set(val);
        }

        public String getMypreference() {
            return mypreference.get();
        }

        public void setMypreference(String val) {
            mypreference.set(val);
        }

        public String getConcerns() {
            return concerns.get();
        }

        public void setConcerns(String val) {
            concerns.set(val);
        }

    }
    public static ObservableList<Person> getPerson_data() {
        return person_data;
    }
}
