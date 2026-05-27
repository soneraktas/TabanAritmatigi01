package com.soner.tabanaritmatigi;

import javafx.application.Application;


public class Launcher {

    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("espeak", "-v", "tr", "-s", "150", "-g", "10", "mab vildan");
        try {
            pb.start();
        } catch (Exception e) {
            System.out.println("ses dosyası çalınırken hata oluştu");
            //throw new RuntimeException(e);
        }

        Application.launch(HelloApplication.class, args);
    }//end main
}//end Launcher
