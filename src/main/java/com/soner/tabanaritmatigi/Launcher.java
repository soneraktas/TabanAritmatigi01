package com.soner.tabanaritmatigi;

import javafx.application.Application;
import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;


public class Launcher {

    static Context pi4j = null;
    static DigitalOutput morKablo=null;
    static DigitalOutput maviKablo=null;
    static DigitalOutput yesilKablo=null;
    static DigitalOutput sariKablo=null;
    static DigitalOutput turuncuKablo=null;
    static DigitalOutput kirmiziKablo=null;
    static DigitalOutput kahveKablo=null;

    /*
    Java'da ProcessBuilder kullanırken karşılaştığın bu durumun iki temel sebebi var: Tilde (~) karakteri ve komutun parçalanma şekli.
    Terminalde ~ yazdığında bunu senin "home" klasörüne (/home/soner) Linux kabuğu (shell) çevirir. Ancak Java doğrudan işletim sistemiyle konuştuğu için ~ sembolünün ne anlama geldiğini bilmez ve bu yolu bulamaz.
     */

    //@SuppressWarnings("removal") // address() metodundaki deprecated uyarısını susturur
    public static void main(String[] args) {

        /*
        // Pİ DE GPIO PİNLERİNİ BURADA ÇALIŞTIRINCA SANIRIM KONSOL U PİNLER İŞGAL ETTİ VE SES ARTIK ÇIKMIYOR O YÜZDEN SESİ İPTAL EDİYORUZ
        // LAUNCER A YAZDIĞIMIZ SES DOSYASI ÇALMA KOMUTU BÖLÜMÜ
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
        */

        // LAUNCER A YAZDIĞIMIZ LED YAKMA BÖLÜMÜ

        // BCM Pinleri: 26, 19, 13, 6, 22, 27, 17
        int[] LED_PINS = {26, 19, 13, 6, 22, 27, 17};
        System.out.println("V4.0.1 ile 7 LED sistemi başlatılıyor...");

        try {
            pi4j = Pi4J.newAutoContext();


            // Pini yapılandır ve oluştur
            var config1 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[0])
                    .name("LED Pin " + LED_PINS[0])
                    .bcm(LED_PINS[0])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            morKablo = pi4j.create(config1);


            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config2 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[1])
                    .name("LED Pin " + LED_PINS[1])
                    .bcm(LED_PINS[1])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            maviKablo = pi4j.create(config2);


            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config3 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[2])
                    .name("LED Pin " + LED_PINS[2])
                    .bcm(LED_PINS[2])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            yesilKablo = pi4j.create(config3);


            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config4 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[3])
                    .name("LED Pin " + LED_PINS[3])
                    .bcm(LED_PINS[3])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            sariKablo = pi4j.create(config4);


            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config5 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[4])
                    .name("LED Pin " + LED_PINS[4])
                    .bcm(LED_PINS[4])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            turuncuKablo = pi4j.create(config5);


            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config6 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[5])
                    .name("LED Pin " + LED_PINS[5])
                    .bcm(LED_PINS[5])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            kirmiziKablo = pi4j.create(config6);


            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config7 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[6])
                    .name("LED Pin " + LED_PINS[6])
                    .bcm(LED_PINS[6])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            kahveKablo = pi4j.create(config7);


            // ------------------------------------------------------------------------------------------


        }catch (Exception e){
            System.err.println("Bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }//end catch


        // ...............................................................................
        Application.launch(HelloApplication.class, args);
    }//end main
}//end Launcher
