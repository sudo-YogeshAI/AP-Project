module com.example.willhero.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.willhero.project to javafx.fxml;
    exports com.example.willhero.project;
}