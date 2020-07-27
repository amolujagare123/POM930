package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SpiceJet {
    @Test
    public void SpiceDateDemo() throws ParseException {

        String setDateStr = "25/12/2020";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.className("ui-datepicker-trigger")).click();



        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);
        System.out.print("Send Date String :" + setDate);
        String currDateStr = driver.findElement(By.className("ui-datepicker-title")).getText();
        System.out.print("\nCurrent Date String :" + currDateStr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);
        System.out.print("\n Current Date :" + currDate);

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1), new DateTime(setDate).withDayOfMonth(1)).getMonths();
        System.out.print("\n Month Differance :" + monthDiff);
        int setDateDayInt=0;
        if (monthDiff > 0) {
            for (int i = 0; i < monthDiff ; i++) {

                driver.findElement(By.xpath("//span[text()='Next']")).click();
            }
            //convert date to string FDS & PSD

            String setDateDayStr = new SimpleDateFormat("dd").format(setDate);
             setDateDayInt = Integer.parseInt(setDateDayStr);
            System.out.print(setDateDayInt);

           driver.findElement(By.xpath("//a[text()="+ setDateDayInt +"]")).click();
        }
        else
            driver.findElement(By.xpath("//a[text()="+ setDateDayInt +"]")).click();
    }



}
