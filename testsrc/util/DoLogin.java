package util;

import org.testng.annotations.BeforeClass;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.getPassword;
import static utilities.ConfigReader.getUsername;

public class DoLogin extends  OpenUrl{

    @BeforeClass
    public void login() throws IOException {

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickBtnLogin();

    }


}
