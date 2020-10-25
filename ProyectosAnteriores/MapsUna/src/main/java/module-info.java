module cr.ac.una.mapsuna {
    requires javafx.controls;
    requires javafx.fxml;

    opens cr.ac.una.mapsuna to javafx.fxml;
    exports cr.ac.una.mapsuna;
    requires com.jfoenix;
}
