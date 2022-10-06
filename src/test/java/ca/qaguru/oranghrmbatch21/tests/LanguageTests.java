package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LanguageTests extends TestBase {
     int countBefore;
     int countAfter;

     // VERIFY  EDITH ICON, DELETE ICON, DELETE AND ADD BUTTON ARE VISIBLE/CLICKABLE->TC001
    @Test
    public void elementClickable() {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        headerPage.assertWelcomeMessage();
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();

    }
//DELETE BUTTON IS VISSIBLE -> TC002
    @Test
    public void deleteButtnVissible() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        headerPage.assertWelcomeMessage();
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();
        languagepage.isDeleteButtonVissible();

    }

    // DELETE A LANGUAGE USING DELETE ICON ->TCOO3
    @Test
    public void deleteWithDelIcon() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        headerPage.assertWelcomeMessage();
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();
        languagepage.useDeleteIcon();

       // System.out.println(languagepage.getCountBefore());
       // System.out.println(languagepage.getCountAfter());
        if(languagepage.getCountBefore()!=languagepage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Deletion is not successful");

    }

// DELETE A LANGUAGE USING DELETE BUTTON -> TCOO4
    @Test
    public void deleteWithDeleteBtn() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        headerPage.assertWelcomeMessage();
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();
        languagepage.deleteRecord();

        if(languagepage.getCountBefore()!=languagepage.getCountAfter()){
            success=true;
            Assert.assertTrue(success,"could not delete!!!");
        }

    }

    //VERIFY IF ADD TEXT BOX IS PRESENT->TC005
    @Test
    public void addTextBoxPresent(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();
        languagepage.addTextboxpresent();
    }

    // VERIFY IF EDIT TEXT BOX IS PRESENT ->TC006
    @Test
    public void editTextBoxPresent(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();
        languagepage.editTextboxPresent();

    }



    // EDIT A LANGUAGE -> TC007
    @Test
    public void editLanguage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();
        languagepage.editLanguage("malayalam");

        Thread.sleep(1000);

    }

//ADD NEW LANGUAGE -> TC008
     @Test
    public void addNewEducation() throws InterruptedException {
         boolean success=false;

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        headerPage.assertWelcomeMessage();
        Languagepage languagepage=new Languagepage(driver);
        languagepage.elementClickable();
        languagepage.saveNewLanguage("malayalam-tamil");

        //System.out.println(languagepage.getCountBefore());
        //System.out.println(languagepage.getCountAfter());
        if(languagepage.getCountBefore()!=languagepage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Failed to add new education level");

        // String uuid = UUID.randomUUID().toString();
        //educationPage.saveNewEducation("level1"+uuid);
    }



}