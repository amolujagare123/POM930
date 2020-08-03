package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;

public class OpenUrl {

    protected static WebDriver driver;

    @BeforeClass
    public void openUrl() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver(Driver.DriverTypes.CHROME);


        driver.manage().window().maximize();

        driver.get(getUrl());
    }



    }
