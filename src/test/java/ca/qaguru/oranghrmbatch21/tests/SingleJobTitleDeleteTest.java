package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.JobTitlePage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import org.testng.annotations.Test;

public class SingleJobTitleDeleteTest extends TestBase {
    @Test
    public void deletesingleJobTitle() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_TITLES);
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        Thread.sleep(3000);
        jobTitlePage.deleteJobTitle();
    }
}
