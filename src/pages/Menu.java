package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

    @FindBy(xpath="//a[text()='Dashboard']")
    WebElement lnkDashBoard;

    @FindBy (xpath="//span[contains(text(),'Clients')]")
    WebElement lnkClinets;

    @FindBy (xpath="//a[contains(text(),'Add Client')]")
    WebElement lnkAddclient;

    @FindBy (xpath="//a[contains(text(),'View Clients')]")
    WebElement lnkViewClient;

    public Menu(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void clickDashboard()
    {
        lnkDashBoard.click();
    }

    public void clickAddclient()
    {
        lnkClinets.click();
        lnkAddclient.click();
    }

    public void clickViewClient()
    {
        lnkClinets.click();
        lnkViewClient.click();
    }

}
