package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

     static  Properties getPropertiesObjectLoaded() throws IOException {

         FileInputStream fp = new FileInputStream("Resources\\config.properties");
         Properties prop = new Properties();
         prop.load(fp);
         return  prop;

     }

     public static String getUrl() throws IOException {

         Properties prop  = getPropertiesObjectLoaded();
         String myUrl = prop.getProperty("url");
         return  myUrl;

     }

     public  static  String getUsername() throws IOException {
        return getPropertiesObjectLoaded().getProperty("username");
     }

     public static String getPassword() throws IOException {
         return getPropertiesObjectLoaded().getProperty("password");
     }

}
