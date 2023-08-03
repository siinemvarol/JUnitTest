package com.sinem;

/**
 *  import static -> Assertions icin kullanarak surekli bu sinifi cagirmadan
 *  kullanmamizi saglar.
 */

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Test03_AssertUsing {

    private final static Islemler islem = new Islemler();

    @Test
    void standartAssert(){
        int result = islem.topla(45,99);
        assertEquals(144, result);
        /**
         *  hata durumlarinda aciklama yapmak onemlidir. cunku sizin kodunuzu ya da
         *  test kodlarinizi baskalari okuyacak ya da degistirecektir. bu nedenle
         *  olusan hata hakkinda detayli bilgi vermek onemlidir.
         */
        assertEquals(144, result, "Toplama islemi basarisiz");
        assertTrue(result==144);
        assertTrue(result==144, "Toplama islemi basarisiz.");
    }

    @Test
    void groupAssert(){
        assertAll("Toplu toplama islemi",
                ()-> assertEquals(5, islem.topla(2,3)),
                ()-> assertEquals(10, islem.topla(5,5)),
                ()-> assertEquals(15, islem.topla(10,5))
                );
    }

    @Test
    void exceptionTest(){
        assertThrows(ArithmeticException.class,() -> islem.bolme(10,0));
    }

    @Test
    void exceptionTestMessage(){
        Exception exception = assertThrows(ArithmeticException.class,() -> islem.bolme(10,0));
        assertEquals("Bolen 0 olamaz", exception.getMessage());
    }

    @Test
    void timeoutTest(){
        assertTimeout(Duration.ofMillis(400), () -> {
            Long start = System.currentTimeMillis();
            System.out.println("Islem basladi...");
            // bu bekleme alani, bir kodun calisma suresini simule etmek icin yazilmistir
            Thread.sleep(500);
            System.out.println("Islem bitti...");
            Long end = System.currentTimeMillis();
            System.out.println("Islem suresi: " +(end-start) + " ms");
        });
    }
}
