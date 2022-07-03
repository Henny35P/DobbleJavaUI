module com.example.lab4_20960400_villarroelgonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.lab4_20960400_villarroelgonzalez to javafx.fxml;
    exports com.example.lab4_20960400_villarroelgonzalez;
}