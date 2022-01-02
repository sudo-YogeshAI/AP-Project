module com.example.willhero.project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.willhero.project to javafx.fxml;
    exports com.example.willhero.project;
    exports com.example.willhero.project.Extra;
    opens com.example.willhero.project.Extra to javafx.fxml;
    exports com.example.willhero.project.Orcs;
    opens com.example.willhero.project.Orcs to javafx.fxml;
    exports com.example.willhero.project.Player;
    opens com.example.willhero.project.Player to javafx.fxml;
}