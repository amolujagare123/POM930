package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver myDriver;

    public enum DriverTypes {
        INTERNETEXPLORER,FIREFOX,CHROME
    }

    public static WebDriver getDriver(DriverTypes d)
    {

        if(myDriver==null)
        {
            switch(d)
            {
                case INTERNETEXPLORER:
                    WebDriverManager.iedriver().setup();
                    myDriver = new InternetExplorerDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    myDriver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    myDriver = new FirefoxDriver();
                    break;

            }

            myDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            myDriver.manage().window().maximize();

        }


        return myDriver;
    }


}
