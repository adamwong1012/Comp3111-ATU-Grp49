module com.example.comp3111_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp3111_project to javafx.fxml;
    exports com.example.comp3111_project;

    exports com.example.comp3111_project.teamScene;
    opens com.example.comp3111_project.teamScene to javafx.fxml;


    exports com.example.comp3111_project.outputScene;
    opens com.example.comp3111_project.outputScene to javafx.fxml;

    exports com.example.comp3111_project.chartScene;
    opens com.example.comp3111_project.chartScene to javafx.fxml;

}
