package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.*;
import org.testng.annotations.Test;

public class JobTitleTests extends TestBase {
    @Test
    public void addNewJobTitle() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_TITLES);
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        for(int i=0; i<3;i++) {
            jobTitlePage.addNewJobTitle("Executive Engineer"+i );
        }
        Thread.sleep(2000);







    }
}
