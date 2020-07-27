package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class SpiceJet2 {

    @Test
    public void SpiceDateDemo() throws ParseException, InterruptedException {

        //String setDateStr = "25/12/2020";

        String setDateStr1 = "23/11";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

        WebElement txtDatePicker = driver.findElement(By.id("ctl00_mainContent_view_date1"));

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;


        js.executeScript("arguments[0].setAttribute('value','"+setDateStr1+"')",txtDatePicker);
    }
    }
