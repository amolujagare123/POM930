package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
   // WebDriver driver;

   //  WebElement txtUser = driver.findElement(By.xpath(""));

    @FindBy (xpath = "//input[@id='email']")
    WebElement txtUsername;

    @FindBy (xpath = "//input[@id='password']")
    WebElement txtPassword;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy (xpath = "//a[contains(text(),'I forgot')]")
    WebElement btnForgotPassword;

    public void clickBtnforgotpassword()
    {
        btnForgotPassword.click();
    }


    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void setTxtUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public  void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public  void clickBtnLogin()
    {
        btnLogin.click();
    }





}
