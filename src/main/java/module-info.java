module _implementierung {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;

    opens _implementierung to javafx.fxml;
    exports _implementierung;
}
