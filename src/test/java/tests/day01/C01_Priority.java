package tests.day01;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Priority extends TestBase {//Bu soruyu TestBase Class'i extends ederek cozelim.

    //=====>> amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    //=====>> bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    //=====>> techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz
    //=====>> once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız

    /*
    TestNG'de @Test'lere priority (oncelik) vermezsek, alfabetik isim sirasina gore calisir.

    Eger isim siralamasinin disinda bir siralama ile calismasini istersek, test methodlarina
    oncelik(priority) tanimlayabiliriz.

      Priority kucukten buyuge gore calisir

    priority (oncelik) degeri verilmeyen @Test methodu default olarak (priority=0) 'dir.
     */


    @Test(priority = -2)
    public void Amazon() {

        //=====>> amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
        driver.get("https://www.amazon.com");

    }


    @Test
    public void bestBuy() {

        //=====>> bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
        driver.get("https://www.bestbuy.com");

    }


    @Test(priority = -5)
    public void techproeducation() {

        //=====>> bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
        driver.get("https://www.techproeducation.com");

    }
}
