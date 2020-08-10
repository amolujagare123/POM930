package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

public class LoginTest extends OpenUrl {

    Login login ;




  @BeforeClass
  public  void beforeLogin()
  {
      login = new Login(driver);
  }

    // Username Field
    @Test
    public void checkTxtUsernameVisibility()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.txtUsername.isDisplayed();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals(actual,expected,"Username field is not Visible !");

    }

    @Test
    public void checkTxtUsernameEnability()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.txtUsername.isEnabled();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals(actual,expected,"Username field is not Enabled !");

    }
    // Password Field
    @Test
    public void checkTxtPasswordVisibility()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.txtPassword.isDisplayed();

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals(actual,expected,"Password field is not Visible !");

    }

    @Test
    public void checkTxtPasswordEnability()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.txtPassword.isEnabled();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertEquals(actual,expected,"Password field is not Enabled !");

    }

    // Login Button
    @Test
    public void checkBtnLoginVisibility()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.btnLogin.isDisplayed();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertEquals(actual,expected,"Login Button is not Visible !");

    }

    @Test
    public void checkBtnLoginEnability()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.btnLogin.isEnabled();


        }catch(Exception e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals(actual,expected,"Login Button is not Enabled !");
    }

    // ForgotPassword Button
    @Test
    public void checkBtnForgotPasswordVisibility()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.btnForgotPassword.isDisplayed();
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertEquals(actual,expected,"Login Button is not Visible !");

    }

    @Test
    public void checkBtnForgotPasswordEnability()
    { boolean expected=true;
        boolean actual=false;

        try{
            actual= login.btnForgotPassword.isEnabled();


        }catch(Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertEquals(actual,expected,"Login Button is not Enabled !");
    }


    @Test
    public void checkheaserLoginSpelling()
    {
        String expected = "Login";
        String actual = "";
        try {
             actual = login.headingLogin.getText();
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"Spelling is incorrect");


    }

    @Test
    public void checkTxtEmailWatermark()
    {
       String expected ="Email";
        String actual = "";
        try {
            actual = login.txtUsername.getAttribute("placeholder");
            System.out.println("Actual:"+actual);
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"watermark is incorrect");

    }


    @Test
    public void checklblLoginHeading()
    {
        String expected = "h1";
        String actual = "";
        try {
            actual =   login.headingLogin.getTagName();//login.txtUsername.getAttribute("placeholder");
            System.out.println("Actual:"+actual);
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"Login text is not a heading");

    }


    @Test
    public void checkLblEmailFontSize()
    {
        String expected = "14px";

        String actual = "";
        try {
            actual =   login.lblLogin.getCssValue("font-size");
            System.out.println("Actual:"+actual);
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"incorrect font size");
    }


    @Test
    public void checkLblEmailFontFamily()
    {
        String expected ="-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = "";
        try {
            actual =   login.lblLogin.getCssValue("font-family");
            System.out.println("Actual:"+actual);
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"incorrect font size");

    }

    // label Email should have 'sans-serif' as a font included
    @Test
    public void checkLblEmailFont()
    {
        String expected ="sans-serif1";

       // String actual = "";
        String fontFamily="";

        try {
            fontFamily =   login.lblLogin.getCssValue("font-family");

            //-apple-system, system-ui, BlinkMacSystemFont, "Segoe UI",
            // Roboto, "Helvetica Neue", Arial, sans-serif

            // whether the above string contains a string 'san-serif' or not

            System.out.println("Actual:"+fontFamily);
        }
        catch (Exception e)
        {

        }

       boolean result =  fontFamily.contains(expected);
        System.out.println("Result:"+result);

        // if the result is true ---> test is passed
        // if the result is false ---> test is failed

        Assert.assertTrue(result,"The given font is not there in the font family");

   


    }


    @Test
    public void checkBtnLoginColor()
    {
        String expected ="#2C8EDD";
        String actual = "";
        try {
            String colorInRGB =   login.btnLogin.getCssValue("background-color");
            // we should convert the color in rgb format into the hex format

            actual  = Color.fromString(colorInRGB).asHex().toUpperCase();

            System.out.println("Actual:"+actual);
        }
        catch (Exception e)
        {

        }

        Assert.assertEquals(actual,expected,"incorrect color");

    }


}
