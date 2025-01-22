module learn.destroyer {
    requires javafx.controls;
    requires javafx.fxml;


    opens learn.destroyer to javafx.fxml;
    exports learn.destroyer;
}