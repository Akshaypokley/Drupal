package Pagesss;

import Packages.Login;
import Resources.initExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.IOException;

import static Resources.OpenBrowser.getUrl;
import static Resources.OpenBrowser.openbrowser;
import static Resources.TakeScreenShot.takeScreenshot;

/**
 * Created by AKSHAY on 15/04/2017.
 */
public class LoginTest {

    WebDriver driver;
    ExtentReports extent ;
    @BeforeMethod
    public void LoadBrowser()
    {

        extent = initExtentReport.init();
        driver =openbrowser("chrome");
        getUrl("url");
    }

    @Test(dataProvider = "ExcelData")
    public void UserInput( String UserName,String UserPassword,String Expected,String Xpath) throws IOException {
        ExtentTest test = extent.startTest("LoginFunction Test", "To Test the functionalty of login button");

        try {
            Login login = new Login(driver);
            test.log(LogStatus.INFO, " initialised driver");
            login.ClickLoginBt();
            test.log(LogStatus.INFO, " Click On LoginFunction Button");

            login.setUserId(UserName);
            test.log(LogStatus.INFO, " set User Name");

            login.setUserPassword(UserPassword);

            test.log(LogStatus.INFO, " set user password");

            login.ClickLoBtn();

            test.log(LogStatus.INFO, " perfrom login button functionalty");

            try {
                String Actual = driver.findElement(By.xpath(Xpath)).getText();
                Assert.assertEquals(Actual,Expected,"Test pass");
                test.log(LogStatus.INFO, " Test Pass");

                test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./LoginFunction/"+takeScreenshot(driver)));

            } catch (Throwable e)

            {
                /*System.out.println(e);*/
                test.log(LogStatus.FAIL, "Element not found : "+e);
                test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./LoginFunction/"+takeScreenshot(driver)));

            }
        }
        catch (AssertionError e)
        {
            System.out.println(e);
            test.log(LogStatus.FAIL, "Element not found : "+e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./LoginFunction/"+takeScreenshot(driver)));

        }
        extent.endTest(test);
        extent.flush();
        driver.close();
    }

    @DataProvider

    public Object[][] ExcelData() throws IOException {

        FileInputStream fis= new FileInputStream("ExcelData/LoginData.xls");
        HSSFWorkbook workbook=new HSSFWorkbook(fis);
        HSSFSheet sheet=workbook.getSheet("LoginData");

        int RowCount=sheet.getPhysicalNumberOfRows();
        String[][] data=new String[RowCount-1][4];
        for(int i=1;i<RowCount;i++)

        {
            HSSFRow row=sheet.getRow(i);

            HSSFCell UserCell=row.getCell(0);
            if(data==null)
                {
                data[i-1][0]="";
                }
            else
                {
                    UserCell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i-1][0]=UserCell.getStringCellValue();
                }

            HSSFCell UserPasswordCell=row.getCell(1);
            if(data==null)
            {
                data[i-1][1]="";
            }

            else
            {
                UserPasswordCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][1]=UserPasswordCell.getStringCellValue();
            }

            HSSFCell ExpetedCell =row.getCell(2);
            if(data==null)
            {
                data[i-1][2]="";
            }
            else
            {
                ExpetedCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][2]=ExpetedCell.getStringCellValue();

            }

            HSSFCell XpatCell =row.getCell(3);
            if(data==null)
            {
                data[i-1][3]="";
            }
            else
            {
                XpatCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=XpatCell.getStringCellValue();

            }

        }
        return data;
    }


  }
