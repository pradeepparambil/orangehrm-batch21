package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.LanguagePage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageTest extends TestBase {

    @Test
    public void addNewLanguageTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagePage.saveNewLanguage("Hindi");
        WebElement select = driver.findElement(By.xpath("//*[@id=\"recordsListTable\"]/tbody/tr[5]/td[1]/input"));
        select.click();
        Thread.sleep(2000);

    }
}