package regression.Clients;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class AddclientTest extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClienttest(String name,String surname,String language,String add1,
                              String add2,String city,String state,String zip,
                              String country,String gender,String birthdate,
                              String phone,String faxNumber,String Mob,String email,
                              String web,String vat,String tax, String expected
    ,String xpathActual) throws ParseException {
        Menu menu = new Menu(driver);
        menu.clickAddclient();

        AddClient addClient = new AddClient(driver);
        addClient.setTxtClientName(name);
        addClient.setTxtSurname(surname);
        addClient.setLanguage(language);
        addClient.setTxtAdd1(add1);
        addClient.setTxtAdd2(add2);
        addClient.setTxtCity(city);
        addClient.setTxtState(state);
        addClient.setTxtZip(zip);
        addClient.setCountry(country);
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


        System.out.println("Expected result for cilent:"+name);
        System.out.println(expected);


        String actual ="";
        try {


            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"Invalid msg");


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
