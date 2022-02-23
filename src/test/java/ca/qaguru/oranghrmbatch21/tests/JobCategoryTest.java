package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.JobCategoryPage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import org.testng.annotations.Test;

public class JobCategoryTest extends TestBase {

    @Test
    public void jobCategoryTest(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("admin", "admin123",true,null);

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);

        JobCategoryPage jobCategoryPage = new JobCategoryPage(driver);
        jobCategoryPage.createJobCategory("IT Professionals");
    }

}
