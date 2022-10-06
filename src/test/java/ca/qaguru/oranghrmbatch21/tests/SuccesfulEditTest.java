package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.*;
import org.testng.annotations.Test;

public class SuccesfulEditTest extends TestBase {
    @Test
    public void editJobTitle() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_TITLES);
        JobTitlePage jobTitlePage = new JobTitlePage(driver);

        Thread.sleep(2000);

        String newTitle = "Manager";
        jobTitlePage.editJobTitle(newTitle);

        Thread.sleep(5000);


    }
}
