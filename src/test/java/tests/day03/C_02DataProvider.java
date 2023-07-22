package tests.day03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HerokuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C_02DataProvider {

    //=====>> https://id.heroku.com/login sayfasına gidin
    //=====>> yanlıs email ve yanlıs password giriniz
    //=====>> (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)
    //=====>> login butonuna tıklayınız
    //=====>> "There was a problem with your login." yazisinin gorunur oldugunu test edin
    //=====>> sayfayı kapatınız


    @DataProvider
    public static Object[][] userList() {
        Object[][] info = {{"ali@gmail.com","123456"},{"veli@gmail.com","456789"},{"can@gmail.com","147258"}};
        return info; }

    @DataProvider
    public static Object[][] userList2() {
        Object[][] info = {{ConfigReader.getProperty("emailYanlis1"),ConfigReader.getProperty("passwordYanlis1")},
                {ConfigReader.getProperty("emailYanlis2"),ConfigReader.getProperty("passwordYanlis2")},
                {ConfigReader.getProperty("emailYanlis3"),ConfigReader.getProperty("passwordYanlis2")}};
        return info; }

    @Test(dataProvider = "userList2")
    public void test01(String mail, String password) {

        //=====>> https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuUrl"));


        //=====>> yanlıs email ve yanlıs password giriniz
        //=====>> (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)
        HerokuPage herokuPage = new HerokuPage();
        herokuPage.emailKutusu.sendKeys(mail);
        herokuPage.passwordKutusu.sendKeys(password);//TAB ile de gecebilirdik...


        //=====>> login butonuna tıklayınız
        herokuPage.logInButonu.click();


        //=====>> "There was a problem with your login." yazisinin gorunur oldugunu test edin
        Assert.assertTrue(herokuPage.thereWasaProblemElement.isDisplayed());


        //=====>> sayfayı kapatınız
        Driver.closeDriver();
    }
}
