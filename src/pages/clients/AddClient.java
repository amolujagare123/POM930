package pages.clients;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    WebDriver driver;

    @FindBy(xpath="//input[@id='client_name']")
    WebElement txtClinetName;

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement txtSurname;

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement txtAdd1;

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement txtAdd2;


    @FindBy (xpath="//input[@id='client_city']")
    WebElement txtCity;

    @FindBy (xpath="//button[@id='btn-submit']")
    WebElement btnSave;



    @FindBy (xpath="//span[@id='select2-client_language-container']")
    WebElement containerLanguage;

    @FindBy (xpath="//input[@type='search']")
    WebElement searchBox;

    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchBox.sendKeys(language); // English
        driver.findElement(By.xpath("//li[contains(text(),'"+language+"')]")).click();
    }



    public AddClient(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setTxtClinetName(String clientname)
    {
        txtClinetName.sendKeys(clientname);
    }

    public void setTxtSurname(String surname)
    {
        txtSurname.sendKeys(surname);
    }

    public void setTxtAdd1(String add1)
    {
        txtAdd1.sendKeys(add1);
    }

    public void setTxtAdd2(String add2)
    {
        txtAdd2.sendKeys(add2);
    }

    public void setTxtCity(String city)
    {
        txtCity.sendKeys(city);
    }

    public void clickBtnSave()
    {
        btnSave.click();
    }
}
