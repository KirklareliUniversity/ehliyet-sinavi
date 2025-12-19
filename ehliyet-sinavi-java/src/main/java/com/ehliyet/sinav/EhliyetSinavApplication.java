package com.ehliyet.sinav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EhliyetSinavApplication {

    public static void main(String[] args) {
        SpringApplication.run(EhliyetSinavApplication.class, args);
        System.out.println("\n" +
                "===============================================\n" +
                "   EHLİYET SINAV SİSTEMİ BAŞLATILDI! \n" +
                "===============================================\n" +
                "   URL: http://localhost:9090\n" +
                "   Admin: admin / admin123\n" +
                "   User:  user  / user123\n" +
                "===============================================\n");
    }
}
