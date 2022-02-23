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

import java.util.UUID;

public class LanguageTest extends TestBase {

    @Test
    public void addNewLanguageTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagePage languagePage = new LanguagePage(driver);
        String languge = "Hindi"+ UUID.randomUUID();
        languagePage.saveNewLanguage(languge);
    }
    @Test
    public void deleteLanguage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagePage languagePage = new LanguagePage(driver);
        String language = "Hindi"+ UUID.randomUUID();
        languagePage.saveNewLanguage(language);
        languagePage.DeleteLanguage(language);

    }
    @Test
    public void editLanguage(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagePage languagePage = new LanguagePage(driver);
        String language = "Hindi"+ UUID.randomUUID();
        languagePage.saveNewLanguage(language);
        languagePage.EditLanguage(language);
        languagePage.DeleteLanguage(language);

    }

    }