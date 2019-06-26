module CapucinoChat {
    requires javafx.controls;
    requires javafx.fxml;

    opens CapucinoChat to javafx.fxml;
    exports CapucinoChat;
}