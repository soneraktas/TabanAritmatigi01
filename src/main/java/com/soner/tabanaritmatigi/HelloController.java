package com.soner.tabanaritmatigi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.effect.DropShadow;

public class HelloController {

    @FXML
    private TilePane ledPane;

    @FXML
    private TextField sayiTF;

    public void initialize(){

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();

            if (newText.matches("\\d*")) {
                if (newText.isEmpty()) return change;

                // Sayıyı kontrol et: 127'den büyükse reddet
                if (Integer.parseInt(newText) <= 127) {
                    return change;
                }
            }
            return null;
        };

        sayiTF.setTextFormatter(new TextFormatter<>(filter));

    }//end initialize



    @FXML
    void hesapla(ActionEvent event) {
        // Önce TilePane içini temizleyelim (her hesapla değiştiğinde üst üste binmesin)
        // 1. Önce temizlik: Eski daireleri siliyoruz
        ledPane.getChildren().clear();

        // ASLINDA BURADA KONTROL YAPISINA GEREK KALMADI ARTIK initialize() metodu içinde her şey kontrol ediliyor
        // AMA YİNEDE TextField IN İÇİ BOŞKEN HESAPLA METODUNA BASILIRSA TRY CATCH YİNE GEREKLİ
        String girilenSayi=sayiTF.getText().trim();
        int sayi=0;

        try {
            sayi=Integer.parseInt(girilenSayi);
            System.out.println("girilen sayı başarılı bir şekilde int e dönüştü...:"+sayi+" sayının 2 tabandaki yazımı...:"+Integer.toBinaryString(sayi));

            boolean[] bitler = new boolean[7];

            for (int i = 0; i < 7; i++) {
                // Sayıyı sağa kaydır ve en sağdaki bitin 1 olup olmadığına bak
                bitler[i] = ((sayi >> i) & 1) == 1;
            }//end for

            // Kullanım örneği:
            // bitler[0] -> En düşük değerli bit (LSB) - 2^0
            // bitler[6] -> En yüksek değerli bit (MSB) - 2^6

            for (int b = 0; b < bitler.length; b++) {
                System.out.println(b+" inci led in durumu...:"+bitler[b]);
            }//end for

            // 2. Daireleri Oluşturma Döngüsü
            // İpucu: Bitleri tersten (6'dan 0'a) dönersek, en büyük basamak en solda görünür.
            for (int i = 6; i >= 0; i--) {
                boolean durum = bitler[i];

                // 20 piksel yarıçapında bir daire oluşturuyoruz
                Circle led = new Circle(20);

                if (durum) {
                    // LED yanıyorsa: Parlak Yeşil
                    led.setFill(Color.LIME);

                    // Şıklık katmak için parlama efekti (Glow)
                    DropShadow glow = new DropShadow();
                    glow.setColor(Color.LIME);
                    glow.setRadius(15);
                    glow.setSpread(0.5);
                    led.setEffect(glow);
                } else {
                    // LED sönükse: Koyu Gri
                    led.setFill(Color.DARKSLATEGRAY);
                    led.setEffect(null); // Parlama efektini kaldır
                }//end else

                // LED'in etrafına siyah ince bir çerçeve
                led.setStroke(Color.BLACK);
                led.setStrokeWidth(1.5);

                // Ve bu daireyi TilePane içine ekliyoruz
                ledPane.getChildren().add(led);
            }//end for


        }catch (Exception e){
            System.out.println("hata oluştu girilen sayı int tipine dönüşemedi");
            System.out.println("muhtemelen bir sayı girmeden hesapla butonuna bastınız ....");
            sayiTF.clear();
        }//end catch

    }//end hesapla

}//end class
