package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import org.testng.annotations.Test;


public class JobTitleTests extends TestBase {
    @Test
    public void addNewJobTitle (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","admin123",true,null);




    }

}
