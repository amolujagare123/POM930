package DBTesting.clients;

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
import java.io.IOException;
import java.text.ParseException;

public class AddClientTest extends DoLogin {

    @Test(dataProvider = "getData")
    public void addClienttest(String name,String surname,String language,String add1,
                              String add2,String city,String state,String zip,
                              String country,String gender,String birthdate,
                              String phone,String faxNumber,String Mob,String email,
                              String web,String vat,String tax) throws ParseException {
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





    }

    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp = new FileInputStream("Data\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Database testing");

        int rowcount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowcount-1][18];

        // data[i][18] --> expected result
        for(int i=0;i<rowcount-1; i++ )
        {
            XSSFRow row = sheet.getRow(i+1);
            for (int j=0;j<18;j++)
            {
                XSSFCell element = row.getCell(j);
                data[i][j] =  element.toString().trim();

            }

        }

        return data;

    }
}
