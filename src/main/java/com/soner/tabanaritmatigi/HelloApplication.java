package com.soner.tabanaritmatigi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static com.soner.tabanaritmatigi.Launcher.pi4j;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Taban Aritmatiği");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }//end start

    @Override
    public void stop() throws Exception {
        // Kaynakları temizle ve kapat
        if (pi4j != null) {
            pi4j.shutdown();
            System.out.println("Pi4J sistemi güvenli bir şekilde kapatıldı.");
        }//end if
    }//end stop
}//end class
