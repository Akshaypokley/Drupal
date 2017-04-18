package Resources;

import Packages.Login;
import org.openqa.selenium.WebDriver;

import static Resources.OpenBrowser.getUrl;
import static Resources.OpenBrowser.openbrowser;

/**
 * Created by AKSHAY on 18/04/2017.
 */
public class LoginFunction {

    static WebDriver driver;

    public static WebDriver  LogFunction()
    {
        driver=openbrowser("chrome");
        getUrl("url");

        Login login=new Login(driver);
        login.ClickLoginBt();
        login.setUserId("akshay");
        login.setUserPassword("Akshay85Pokley");
        login.ClickLoBtn();


        return driver;
    }
}
