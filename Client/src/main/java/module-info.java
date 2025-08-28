module com.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.client.ui.login to javafx.fxml;
    opens com.client.ui.register to javafx.fxml;
    opens com.client.ui.collection to javafx.fxml;
    opens com.client.ui.map to javafx.fxml;
    opens com.client.ui.newDragon to javafx.fxml;
    opens com.client.ui.commands to javafx.fxml;
    exports com.client;
}