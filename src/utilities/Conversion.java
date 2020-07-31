package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String countryShort)
    {

        String convertedcountry="";

         switch(countryShort)
         {
             case "IN" : convertedcountry="India";break;
             case "AF" : convertedcountry="Afghanistan";break;
             case "AS" : convertedcountry="American Samoa";break;
             case "IO" : convertedcountry="British Indian Ocean Territory";break;
             case "CN" : convertedcountry="China";break;
             case "US" :  convertedcountry= "United States";break;


         }

        return  convertedcountry;

    }


    public static String convertGender(String shortGender)
    {
        String convertedGender="";

        switch (shortGender)
        {
            case "0" : convertedGender="Male"; break;
            case "1" : convertedGender="Female"; break;
            case "2" : convertedGender="Other"; break;
       }

        return convertedGender;


    }
    
    public static  String convertDate(String dbDateStr) throws ParseException {

        

// first conver this string into date

        Date dbDate = new SimpleDateFormat("yyyy-MM-dd").parse(dbDateStr);

// now convert this date in string format --> "dd/MM/yyyy"

        String convertedDate = new SimpleDateFormat("dd/MM/yyyy").format(dbDate);

        return  convertedDate;
    }    


}
