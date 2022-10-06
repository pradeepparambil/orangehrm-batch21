package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LicenceTests extends TestBase {
     int countBefore;
     int countAfter;

     // VERIFY  EDITH ICON, DELETE ICON, DELETE AND ADD BUTTON ARE VISIBLE/CLICKABLE->TC001
    @Test
    public void elementClickable() {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LICENSES);
        headerPage.assertWelcomeMessage();
        LicencePage licencePage=new LicencePage(driver);
        licencePage.elementClickable();

    }
//DELETE BUTTON IS VISIBLE -> TC002
    @Test
    public void deleteButtnVissible() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LICENSES);
        headerPage.assertWelcomeMessage();
        LicencePage licencePage=new LicencePage(driver);
        licencePage.elementClickable();
        licencePage.isDeleteButtonVissible();

    }

    // DELETE A LICENCE  USING DELETE ICON ->TCOO3
    @Test
    public void deleteWithDelIcon() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LICENSES);
        headerPage.assertWelcomeMessage();
        LicencePage licencePage=new LicencePage(driver);
        licencePage.elementClickable();
        licencePage.useDeleteIcon();

        System.out.println(licencePage.getCountBefore());
        System.out.println(licencePage.getCountAfter());
        if(licencePage.getCountBefore()!=licencePage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Deletion is not successful");

    }

// DELETE A LICENCE  USING DELETE BUTTON -> TCOO4
    @Test
    public void deleteWithDeleteBtn() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.LICENSES);
        headerPage.assertWelcomeMessage();
        LicencePage licencePage=new LicencePage(driver);
        licencePage.elementClickable();
        licencePage.deleteRecord();

        if(licencePage.getCountBefore()!=licencePage.getCountAfter()){
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
        headerPage.selectMenu(MenuOptions.LICENSES);
        LicencePage licencePage=new LicencePage(driver);
        licencePage.elementClickable();
        licencePage.addTextboxpresent();


    }

    // VERIFY IF EDIT TEXT BOX IS PRESENT ->TC006
    @Test
    public void editTextBoxPresent(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LICENSES);
        LicencePage licencePage=new LicencePage(driver);
        licencePage.elementClickable();
        licencePage.editTextboxPresent();

    }



    // EDIT A LICENCE -> TC007
    @Test
    public void editLicence() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LICENSES);
        LicencePage licencePage=new LicencePage(driver);
        licencePage.elementClickable();
        licencePage.editLicence("new licence");



    }

//ADD NEW EDUCATION LEVEL -> TC008
     @Test
    public void addNewLicence() throws InterruptedException {
         boolean success=false;

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LICENSES);
        LicencePage licencePage=new LicencePage(driver);
         licencePage.elementClickable();
         licencePage.saveNewLicence("Name of new licence");


        //System.out.println(licencePage.getCountBefore());
        //System.out.println(licencePage.getCountAfter());

         if(licencePage.getCountBefore()!=licencePage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Failed to add new education level");

        // String uuid = UUID.randomUUID().toString();
        //educationPage.saveNewEducation("level1"+uuid);
    }



}