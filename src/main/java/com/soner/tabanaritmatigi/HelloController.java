package com.soner.tabanaritmatigi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.control.TextFormatter;
import java.util.function.UnaryOperator;

public class HelloController {

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
    private Label sonuc;


    @FXML
    void hesapla(ActionEvent event) {
        // ASLINDA BURADA KONTROL YAPISINA GEREK KALMADI ARTIK initialize() metodu içinde her şey kontrol ediliyor
        String girilenSayi=sayiTF.getText().trim();
        int sayi=0;

        System.out.println("textField deki sayı...:"+girilenSayi);
        try {
            sayi=Integer.parseInt(girilenSayi);
            System.out.println("girilen sayı başarılı bir şekilde int e dönüştü...:"+sayi);
            sonuc.setText("girmiş olduğunuz sayı...:"+girilenSayi);

            //int sayi = 42; // Kullanıcının girdiği sayı bunu yapay zeka yazdı

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

        }catch (Exception e){
            System.out.println("hata oluştu girilen sayı int tipine dönüşemedi");
            sonuc.setText("Hata lütfen tekrar deneyin !");
            sayiTF.clear();
        }//end catch

    }//end hesapla

}//end class
