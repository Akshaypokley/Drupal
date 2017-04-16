package Packages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AKSHAY on 16/04/2017.
 */
public class Home {

    WebDriver driver;

    @FindBy(xpath = ".//*[@id='block-bartik-main-menu']/div[2]/ul/li/a")
    WebElement HomeLogo;

    @FindBy(xpath = "")
    WebElement Logout;

    @FindBy(xpath = ".//*[@id='block-bartik-page-title']/div[2]/h1")
    WebElement Username;

    @FindBy(xpath = "")
    WebElement Editoption;

    @FindBy(xpath = "")
    WebElement searchOption;


    public Home(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        if(!HomeLogo.isDisplayed())
            throw  new IllegalStateException("This Not Home Page");

    }

    public WebElement getHomeLogo()
    {
        return HomeLogo;
    }

    public WebElement getUsername()
    {
        return Username;
    }

    public WebElement getEditoption()
    {
        return Editoption;
    }
}