package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Myscreenshots {

    public static String getScreenshot(WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        Date date = new Date();

        System.out.println(date);
        SimpleDateFormat sd = new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
        String dateStr = sd.format(date);
        String fileName = "Image"+dateStr+".png";
        System.out.println(fileName);


        FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\Report\\screenshots\\"+fileName));

        return fileName;
    }

}
