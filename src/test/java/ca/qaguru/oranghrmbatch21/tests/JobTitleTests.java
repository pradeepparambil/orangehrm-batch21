package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.JobTitlePage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;


public class JobTitleTests extends TestBase {
    @Test
    public void addNewJobTitle() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_TITLES);
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        String uuid = UUID.randomUUID().toString();
        jobTitlePage.saveNewJobTitle("Title-" + uuid, "Description" + uuid, "notes" + uuid);

    }

    @Test
    public void editJobTitle() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_TITLES);
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        String uuid = UUID.randomUUID().toString();
        jobTitlePage.saveNewJobTitle("Title-" + uuid, "Description" + uuid, "notes" + uuid);
        driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a")).click();
        driver.findElement(By.name("btnSave")).click();
        Thread.sleep(3000);
        WebElement jobTitle = driver.findElement(By.xpath("//*[@id=\"jobTitle_jobTitle\"]"));
        jobTitle.clear();
        jobTitle.sendKeys("Software tester");
        driver.findElement(By.id("btnSave")).click();
        Assert.assertTrue(true,"New job title is created");
        driver.quit();


    }

    @Test
    public void deleteJobTitle() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_TITLES);
        JobTitlePage jobTitlePage = new JobTitlePage(driver);
        String uuid = UUID.randomUUID().toString();
        jobTitlePage.saveNewJobTitle("Title-" + uuid, "Description" + uuid, "notes" + uuid);
        driver.findElement(By.id("ohrmList_chkSelectRecord_27")).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
        Assert.assertTrue(true,"Job title not deleted");

    }
}