package regression.Clients;

import org.testng.annotations.Test;
import pages.Menu;
import pages.clients.AddClient;
import util.DoLogin;

public class AddclientTest extends DoLogin {


    @Test
    public void addClienttest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddclient();

        AddClient addClient = new AddClient(driver);

        /*addClient.setTxtClinetName("amol");
        addClient.setTxtSurname("ujagare");
        addClient.setTxtAdd1("katraj");
        addClient.setTxtAdd2("BVP");
        addClient.setTxtCity("Pune");
        addClient.clickBtnSave();*/

        addClient.setLanguage("English");


    }

}
