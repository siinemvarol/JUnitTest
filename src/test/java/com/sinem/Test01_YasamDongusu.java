package com.sinem;

import org.junit.jupiter.api.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test01_YasamDongusu {

    private Islemler islemler;
    private int[] sayilar;

    /**
     *  Tum testlerden once 1 kez calisan ilk metoddur.
     */
    @BeforeAll
    void initAll(){
        System.out.println("Ilk calisan benim");
    }

    /**
     * kullanilacak her testten once tum degiskenlerin sifirlanmasi ve initialize
     * edilmesini istiyorum. bunun icin tum test metodlarindan once calisacak
     *
     * @BeforeEach metodunu kullaniyorum.
     */
    @BeforeEach
    public void init() {
        System.out.println("Her test methodundan once calisir.");
    }
    @Test
    public void test01() {
        System.out.println("Test01_YasamDongusu.test01()");
    }
    @Test
    @Disabled
    public void test02(){
        System.out.println("Test01_YasamDongusu.test02()");
    }

    /**
     *  Methodlarin islemleri bittikten sonra yapilacak islemleri tamamlamak icin
     *  @AfterEach metodunu kullaniyorum.
     */
    @AfterEach
    public void sonCalisanMethod(){
        System.out.println("Her test metodundan sonra calisir.");
    }

    @AfterAll
    void sonUtucu(){
        System.out.println("Son Utucu");
    }
}
