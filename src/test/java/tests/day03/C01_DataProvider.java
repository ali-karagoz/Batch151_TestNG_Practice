package tests.day03;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {


    /*
    DataProvider veri sağlayıcısı demektir. Aranacak kelimeleri bir liste gibi dutarak bize veri sağlar
     */

    //=====>> amazon sayfasına gidelim
    //=====>> Nutella, Java, cigdem ve Netherlands icin arama yapalım
    //=====>> sonucların aradıgımız kelime icerdigini test edelim
    //=====>> sayfayı kapatalım

    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArray = {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};
        return arananKelimeArray;
    }


    @Test(dataProvider = "AranacakKelimeler")
    public void test01(String arananKelime) {

        //=====>> amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //=====>> Nutella, Java, cigdem ve Netherlands icin arama yapalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(arananKelime, Keys.ENTER);

        //=====>> sonucların aradıgımız kelime icerdigini test edelim
        String expectedWord = arananKelime;
        String actualWord = amazonPage.sonucYazisi.getText();
        Assert.assertTrue(actualWord.contains(expectedWord));

        //=====>> sayfayı kapatalım
        Driver.closeDriver();
    }
}
