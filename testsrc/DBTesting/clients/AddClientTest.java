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
import utilities.Conversion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

public class AddClientTest extends DoLogin {

    @Test(dataProvider = "getData")
    public void addClienttest(String name,String surname,String language,String add1,
                              String add2,String city,String state,String zip,
                              String country,String gender,String birthdate,
                              String phone,String faxNumber,String Mob,String email,
                              String web,String vat,String tax) throws ParseException, ClassNotFoundException, SQLException {


      ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(faxNumber);
        expected.add(Mob);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);

       System.out.println(expected);
        System.out.println(expected.size());



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



       // JDBC - Java Database connectivity

        //1. Loading a driver - mysql
        Class.forName("com.mysql.jdbc.Driver"); // 8 - mysql connector

       // 2. create a connection

        String url  = "jdbc:mysql://localhost:3306/ipbatch9";
        String user = "root";
        String pass = "root";

        Connection con = DriverManager.getConnection(url,user,pass);

       // 3. create a statement

        Statement st = con.createStatement();


        //4. execute the query

        String sql = "select * from ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));


            String countryFromDB = rs.getString("client_country"); // shortCountry
            String convertedCountry = Conversion.convertCountry(countryFromDB);
            actual.add(convertedCountry);



            String genderFromDB = rs.getString("client_gender");
            String convertedGender = Conversion.convertGender(genderFromDB);
            actual.add(convertedGender);


            String dbDate = rs.getString("client_birthdate");
            String convertedDate = Conversion.convertDate(dbDate);
             actual.add(convertedDate);



            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));


        }


        System.out.println(actual);
        System.out.println(actual.size());
        Assert.assertEquals(actual,expected,"test is failed");


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
