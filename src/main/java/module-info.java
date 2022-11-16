module com.example.comp3111_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp3111_project to javafx.fxml;
    exports com.example.comp3111_project;
}