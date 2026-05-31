module com.soner.tabanaritmatigi {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.pi4j;


    opens com.soner.tabanaritmatigi to javafx.fxml;
    exports com.soner.tabanaritmatigi;
}