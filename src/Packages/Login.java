package Packages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AKSHAY on 15/04/2017.
 */
public class Login {
    WebDriver driver;

    @FindBy(xpath = "//div/h1")
    WebElement Logo;

    @FindBy(xpath = ".//*[@id='block-bartik-account-menu']/div/ul/li/a")
    WebElement loginBtn;

    @FindBy(xpath = ".//*[@id='edit-name']")
    WebElement UserId ;

    @FindBy(xpath = ".//*[@id='edit-pass']")
    WebElement UserPassword;

    @FindBy(xpath = ".//*[@id='edit-submit']")
    WebElement LoBtn;

   public Login(WebDriver driver)
    {
        this.driver=driver;

        PageFactory.initElements(driver,this);
        if(!Logo.isDisplayed())
            throw new IllegalStateException("This Not Login Button");
    }

    public WebElement getLogo()
    {
        return Logo;
    }

    public void ClickLoginBt()
    {
      loginBtn.click();
    }

    public void setUserId(String UserName)
    {
        UserId.sendKeys(UserName);
    }

    public void setUserPassword(String Password)
    {
        UserPassword.sendKeys(Password);
    }

    public void ClickLoBtn()
    {
        LoBtn.click();
    }

}
