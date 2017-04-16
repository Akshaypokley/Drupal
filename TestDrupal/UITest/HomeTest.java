package UITest;

import Packages.Home;
import Packages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Resources.OpenBrowser.openbrowser;
import static Resources.OpenBrowser.getUrl;

/**
 * Created by AKSHAY on 16/04/2017.
 */
public class HomeTest {

    WebDriver driver;

    @BeforeMethod
    public void LoadBrowser() {
        driver = openbrowser("chrome");
        getUrl("url");
    }

    @Test
    public void HomeUITest() {
        try {

            Login login = new Login(driver);
            login.ClickLoginBt();
            login.setUserId("akshay");
            login.setUserPassword("Akshay85Pokley");
            login.ClickLoBtn();

            try {
                String Expetecd = "akshay";
                Home home = new Home(driver);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                String actual = home.getUsername().getText();
                System.out.println(""+actual);


                Assert.assertEquals(actual, Expetecd, "Test Pass");

            } catch (Throwable e) {
                System.out.println(e);
            }
        } catch (AssertionError e) {
            System.out.println(e);
        }

driver.close();
    }
}