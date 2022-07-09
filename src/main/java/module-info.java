module com.example.lab4_20960400_villarroelgonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens Vista to javafx.fxml;
    exports Vista;
}