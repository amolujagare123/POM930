package pages.clients;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddClient {
WebDriver driver;

    @FindBy(xpath="//input[@id='client_name']") WebElement txtClientName;
    @FindBy (xpath="//input[@id='client_surname']") WebElement txtSurname;
    @FindBy (xpath="//span[@id='select2-client_language-container']") WebElement containerLanguage;
    @FindBy (xpath="//input[@type='search']")  WebElement searchLanguage;

    //Address

    @FindBy (xpath="//input[@id='client_address_1']") WebElement txtAdd1;
    @FindBy (xpath="//input[@id='client_address_2']") WebElement txtAdd2;
    @FindBy (xpath="//input[@id='client_city']") WebElement txtCity;
    @FindBy(xpath="//input[@id='client_state']") WebElement txtState;
    @FindBy(xpath="//input[@id='client_zip']") WebElement txtZip;
    @FindBy(xpath="//span[@class='select2-selection__placeholder']") WebElement containerCountry;
    @FindBy(xpath="//input[@class='select2-search__field']") WebElement searchCountry;

    //Personal

    //@FindBy(xpath="//span[@id='select2-client_gender-container']") WebElement txtGender;
    @FindBy(xpath="//input[@id='client_birthdate']") WebElement txtBirthDay;

    //Contact Information

    @FindBy(xpath="//input[@id='client_phone']") WebElement txtPhone;
    @FindBy(xpath="//input[@id='client_fax']") WebElement txtFax;
    @FindBy(xpath="//input[@id='client_mobile']") WebElement txtMobile;
    @FindBy(xpath="//input[@id='client_email']") WebElement txtEmail;
    @FindBy(xpath="//input[@id='client_web']") WebElement txtWebAddress;


    // Taxes Information
    @FindBy(xpath="//input[@id='client_vat_id']") WebElement txtVatId;
    @FindBy(xpath="//input[@id='client_tax_code']") WebElement txtTaxCode;

    @FindBy (xpath="//button[@id='btn-submit']")WebElement btnSave;
    @FindBy(xpath="//button[@id='btn-cancel']") WebElement btnCancel;
    @FindBy (id ="select2-client_gender-container") WebElement containerGender;



// Click on Add Client Link

    public AddClient(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // Data Entry
    //Add Personal Information

    public void setTxtClientName(String clientname)    {  txtClientName.sendKeys(clientname);     }

    public void setTxtSurname(String surname)    {    txtSurname.sendKeys(surname);    }

    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchLanguage.sendKeys(language); // English
        driver.findElement(By.xpath("//li[contains(text(),'"+language+"')]")).click();
    }

    // Add Address
    public void setTxtAdd1(String add1)     { txtAdd1.sendKeys(add1);     }
    public void setTxtAdd2(String add2)     { txtAdd2.sendKeys(add2);     }
    public void setTxtCity(String city)     { txtCity.sendKeys(city);     }
    public void setTxtState(String state)   { txtState.sendKeys(state);   }
    public void setTxtZip(String zip)     { txtZip.sendKeys(zip);     }

    public void setCountry(String country)
    {
        containerCountry.click();
        searchCountry.sendKeys(country); // English
        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();
    }
    //Personal Inforamtion

    public void setDobUsingJS(String setDateStr)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value','"+setDateStr+"')",txtBirthDay);

    }


    public void setTxtDOB(String setDateStr) throws ParseException {
       txtBirthDay.click();

       // to convert string to date  , format or parse ->parse
        // PSD FDS

        System.out.println(setDateStr);
        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);
        System.out.println(setDate);
        String currDateStr = driver.findElement(By.className("datepicker-switch")).getText();
        System.out.println(currDateStr);

        Date currDate= new SimpleDateFormat("MMMM yyyy").parse(currDateStr);
        System.out.println(currDate);


        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1)
                ,new DateTime(setDate).withDayOfMonth(1)).getMonths();

        boolean isFuture=true;

        if(monthDiff<0) { // -5
            isFuture = false; // negative monthDiff
            monthDiff = (-1) *monthDiff;
        }

        for(int i=0 ;i<monthDiff;i++)
        {
            if (isFuture)
                driver.findElement(By.className("next")).click();
            else
                driver.findElement(By.className("prev")).click();
        }

        // convert the setDate (in date format) to String , FDS , PSD

        String setDateDayStr = new SimpleDateFormat("dd").format(setDate); // 18

        //td[@class='day' and text()='01']

        // 01 - number in string format - lets conver the number in string format to integer
        System.out.println(setDateDayStr);

        int setDateDayInt = Integer.parseInt(setDateDayStr);
        System.out.println(setDateDayInt);

        driver.findElement(By.xpath(" //td[@class='day' and text()='"+setDateDayInt+"']")).click();

    }
    //Contact Information

    public void setTxtPhone(String phone)     { txtPhone.sendKeys(phone);     }
    public void setTxtFax(String fax)     { txtFax.sendKeys(fax);     }
    public void setTxtMobile(String mobile)     { txtMobile.sendKeys(mobile);     }
    public void setTxtEmail(String email)     { txtEmail.sendKeys(email);     }
    public void setWebAddress(String web)     { txtWebAddress.sendKeys(web);     }
    //Taxes Information
    public void setTxtVaitId(String vat)     { txtVatId.sendKeys(vat);     }
    public void setTxtTaxesCode(String tcode)     { txtTaxCode.sendKeys(tcode);     }
    public void clickBtnSave()
    {
        btnSave.click();
    }

    public void setGender(String gender) {

        containerGender.click();
        driver.findElement(By.xpath("//li[contains(text(),'"+gender+"')]")).click();
    }
}
