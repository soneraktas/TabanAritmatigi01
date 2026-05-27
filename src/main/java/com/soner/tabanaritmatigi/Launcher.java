package com.soner.tabanaritmatigi;

import javafx.application.Application;


public class Launcher {
    /*
    Java'da ProcessBuilder kullanırken karşılaştığın bu durumun iki temel sebebi var: Tilde (~) karakteri ve komutun parçalanma şekli.

    Terminalde ~ yazdığında bunu senin "home" klasörüne (/home/soner) Linux kabuğu (shell) çevirir. Ancak Java doğrudan işletim sistemiyle konuştuğu için ~ sembolünün ne anlama geldiğini bilmez ve bu yolu bulamaz.
     */

    public static void main(String[] args) {

        // Dosya yolunu tam olarak belirtiyoruz
        String homeDir = System.getProperty("user.home");
        String sesYolu = homeDir + "/sesler/turkceSes/tabanAritmetigi.mp3";

        ProcessBuilder pb = new ProcessBuilder("mpg123", sesYolu);
        try {
            pb.start();
            // Ses bitene kadar beklemesini istersen (isteğe bağlı):
            // p.waitFor();
        } catch (Exception e) {
            //System.out.println("ses dosyası çalınırken hata oluştu");
            System.out.println("Ses dosyası çalınırken hata oluştu: " + e.getMessage());
        }//end catch

        Application.launch(HelloApplication.class, args);
    }//end main
}//end Launcher
