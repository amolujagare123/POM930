package UITesting;

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


    @Test
    public void checkTxtUsernameVisibilty()
    {
        boolean expected  = true;
        boolean atual = false;
       try {

            atual = login.txtUsername.isDisplayed(); // --> true
       }
       catch (Exception e)
       {
                 e.printStackTrace();
       }
        Assert.assertEquals(atual,expected,"Element is not there");
        // expected =?? --. true -- boolean

    }

    @Test
    public void checkTxtUsernameEnability()
    {
        boolean expected  = true;
        boolean atual = false;
        try {

            atual = login.txtUsername.isEnabled(); // --> true
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals(atual,expected,"Element is not there");
    }

}
