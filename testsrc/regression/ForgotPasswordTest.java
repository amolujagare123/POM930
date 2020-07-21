package regression;

import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;
import util.OpenUrl;

public class ForgotPasswordTest extends OpenUrl {

    @Test
    public void forgotPasswordTest()
    {

        Login login = new Login(driver);
        login.clickBtnforgotpassword();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@scriptinglogic.net");
        forgotPassword.clickBtnSubmit();

    }

}
