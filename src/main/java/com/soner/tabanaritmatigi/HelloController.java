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

            for (int i = 0; i < 7; i++) {
                // i. biti kontrol et (Sağdan sola doğru)
                // (sayi >> i) & 1 ifadesi ilgili bitin 0 mı 1 mi olduğunu verir
                int bit = (sayi >> i) & 1;

                if (bit == 1) {
                    System.out.println("LED " + i + ": YANIYOR");
                    // Burada i. LED'i yakma kodun gelecek
                } else {
                    System.out.println("LED " + i + ": SÖNÜK");
                    // Burada i. LED'i söndürme kodun gelecek
                }//end else
            }//end for

        }catch (Exception e){
            System.out.println("hata oluştu girilen sayı int tipine dönüşemedi");
            sonuc.setText("Hata lütfen tekrar deneyin !");
            sayiTF.clear();
        }//end catch

    }//end hesapla

}//end class
