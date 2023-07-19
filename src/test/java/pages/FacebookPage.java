package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {//Locate'ler bu class icinde depolanacak

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
        //bu class'a Driver'i getir, dedik. Cunku locate'ler bu class icinde depolanacak.
    }


    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailKutusu;




    @FindBy(xpath = "//input[@id='pass']")
    public WebElement sifreKutusu;



    @FindBy(xpath = "//button[@name='login']")
    public WebElement girisYapButonu;




    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girdiginSifreYanlisYaziElementi;


}
