package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuPage {


    public HerokuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailKutusu;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordKutusu;


    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block']")
    public WebElement logInButonu;


    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement thereWasaProblemElement;


}