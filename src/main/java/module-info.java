module com.soner.tabanaritmatigi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.soner.tabanaritmatigi to javafx.fxml;
    exports com.soner.tabanaritmatigi;
}