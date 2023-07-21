package tests.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_PageClassKullanimi {

    @Test
    public void test01() throws IOException {

        // amazon sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        // dropdown'dan "Computers" optionunu secin
/*      DDM ile çalışmak için 3 adım vardır:
        1-ddm locate alınır -   AmazonPAge sayfasında yaptık bu adımı.
        2-select objesi oluşturulur
        3-option lardan birisi seçilir
*/


        AmazonPage amazonPage = new AmazonPage();
        Select select = new Select(amazonPage.ddm);// DDM için 2. adım
        //parametre olarak ddm webElementi gerekiyor. ddm AmazonPage'de oldugu içiv oraya amazonPage objesi ile ulaştık ve onu aldik
        select.selectByVisibleText("Computers");//DDM için 3. adım


        // arama motoruna "Asus" yazıp aratın
        amazonPage.aramaKutusu.sendKeys("Asus" + Keys.ENTER);


        // ikinci urunun fotografını cekin
        /*
        1-locate al  -   AmazonPAge sayfasında yaptık bu adımı.
        2-File Class ile, fotoğrafı nereye kayderdeceğemi söyle
         */

        //fotografların isimlerinin unique olmasi icin  LocalDate yapıyoruz
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        File kayit = new File("target/ekranGoruntusu/kayit"+tarih+".jpeg");// SCreenShot için 2. Adım.
        File gecici = amazonPage.ikinciUrun.getScreenshotAs(OutputType.FILE);//Fotografi cektik, gecici adında bir variable'a aldik.
        FileUtils.copyFile(gecici, kayit);//gecici'dekini al, kayit'a yapıştır.

        // ikinci urune tıklayın
        amazonPage.ikinciUrun.click();


        // title'ının "ASUS" icerdigini test edin
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("ASUS"));

        // sayfayı kapatın
        Driver.closeDriver();
    }
}
