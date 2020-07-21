package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

    @FindBy(xpath = "//input[@type='text']")
    WebElement txtEmail;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    public ForgotPassword(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public  void setTxtEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void clickBtnSubmit()
    {
        btnSubmit.click();
    }

}
