package regression.Clients;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import static utilities.Myscreenshots.getScreenshot;

public class AddclientTest extends DoLogin {

    ExtentReports extent;
    ExtentSparkReporter reporter;
    static int count;

    @BeforeClass
    public void initReport()
    {
        count =1;
        reporter = new ExtentSparkReporter("Report\\report.html");

        reporter.config().setDocumentTitle("Invoice plane tests");
        reporter.config().setReportName("POM test results");


        extent  = new ExtentReports();

         extent.attachReporter(reporter);

        extent.setSystemInfo("Project name","Invoice plane");
        extent.setSystemInfo("Developere name","praful");
        extent.setSystemInfo("Testers Name","Amol");

    }




    @Test (dataProvider = "getData")
    public void addClienttest(String name,String surname,String language,String add1,
                              String add2,String city,String state,String zip,
                              String country,String gender,String birthdate,
                              String phone,String faxNumber,String Mob,String email,
                              String web,String vat,String tax, String expected
    ,String xpathActual) throws ParseException, IOException {


        ExtentTest test = extent.createTest("addClientTest00"+count++);

        Menu menu = new Menu(driver);
        menu.clickAddclient();

        test.info("Add client page is opened");

        AddClient addClient = new AddClient(driver);
        addClient.setTxtClientName(name);
        addClient.setTxtSurname(surname);
        test.info("Surname is entered");
        addClient.setLanguage(language);
        addClient.setTxtAdd1(add1);

        test.info("address is entered");

        addClient.setTxtAdd2(add2);
        addClient.setTxtCity(city);
        addClient.setTxtState(state);
        addClient.setTxtZip(zip);
        addClient.setCountry(country);

        test.info("country is entered");

        addClient.setGender(gender);
        addClient.setTxtDOB(birthdate);
        //addClient.setDobUsingJS("11/27/1985");
        addClient.setTxtPhone(phone);
        addClient.setTxtFax(faxNumber);
        addClient.setTxtMobile(Mob);
        addClient.setTxtEmail(email);
        addClient.setWebAddress(web);
        addClient.setTxtVaitId(vat);
        addClient.setTxtTaxesCode(tax);
        addClient.clickBtnSave();

        test.info("submit button is clicked");

        System.out.println("Expected result for cilent:"+name);
        System.out.println(expected);


        String actual ="";
        try {


             actual = driver.findElement(By.xpath(xpathActual)).getText();


        }
        catch (Exception e)
        {

        }

        try {

            Assert.assertEquals(actual, expected, "Invalid msg");
            test.pass("Test is passed & screenshot below");
            test.addScreenCaptureFromPath("./screenshots/"+getScreenshot(driver));
        }
        catch ( AssertionError e)
        {
            test.fail("This test is failed because");
            test.fail(e.getMessage());
            test.fail("screenshot below");
            test.addScreenCaptureFromPath("./screenshots/"+getScreenshot(driver));

        }


    }

    @AfterClass
    public void afterReports()
    {
        extent.flush();
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp = new FileInputStream("Data\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowcount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowcount-1][20];

        // data[i][18] --> expected result
        for(int i=0;i<rowcount-1; i++ )
        {
            XSSFRow row = sheet.getRow(i+1);
            for (int j=0;j<20;j++)
            {
                XSSFCell element = row.getCell(j);
                data[i][j] =  element.toString().trim();

            }

        }

        return data;

    }

}
