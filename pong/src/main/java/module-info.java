module lab01 {
	requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    opens vsb_cs_java.pong to javafx.fxml;
    exports vsb_cs_java.pong;
}