package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MembershipsTests extends TestBase {
     int countBefore;
     int countAfter;

     // VERIFY  EDITH ICON, DELETE ICON, DELETE AND ADD BUTTON ARE VISIBLE/CLICKABLE->TC001
    @Test
    public void elementClickable() {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        headerPage.assertWelcomeMessage();
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();

    }
//DELETE BUTTON IS VISIBLE -> TC002
    @Test
    public void deleteButtnVissible() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        headerPage.assertWelcomeMessage();
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();
        membershipsPage.isDeleteButtonVissible();

    }

    // DELETE A MEMBERSHIPS USING DELETE ICON ->TCOO3
    @Test
    public void deleteWithDelIcon() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        headerPage.assertWelcomeMessage();
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();
        membershipsPage.useDeleteIcon();

        //System.out.println(membershipsPage.getCountBefore());
        //System.out.println(membershipsPage.getCountAfter());
        if(membershipsPage.getCountBefore()!=membershipsPage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Deletion is not successful");

    }

// DELETE A MEMBERSHIPS USING DELETE BUTTON -> TCOO4
    @Test
    public void deleteWithDeleteBtn() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        headerPage.assertWelcomeMessage();
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();
        membershipsPage.deleteRecord();

        if(membershipsPage.getCountBefore()!=membershipsPage.getCountAfter()){
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
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();
        membershipsPage.addTextboxpresent();

    }

    // VERIFY IF EDIT TEXT BOX IS PRESENT ->TC006
    @Test
    public void editTextBoxPresent(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();
        membershipsPage.editTextboxPresent();

    }



    // EDIT EDUCATION LEVEL -> TC007
    @Test
    public void editMemeberships() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        headerPage.assertWelcomeMessage();
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();
        membershipsPage.editEduLevel("NDA");

        Thread.sleep(1000);

    }

//ADD NEW MEMBERSHIPS -> TC008
     @Test
    public void addNewEducation() throws InterruptedException {
         boolean success=false;

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        headerPage.assertWelcomeMessage();
        MembershipsPage membershipsPage=new MembershipsPage(driver);
        membershipsPage.elementClickable();
        membershipsPage.saveNewMemberships("new memberships...");

        System.out.println(membershipsPage.getCountBefore());
        System.out.println(membershipsPage.getCountAfter());
        if(membershipsPage.getCountBefore()!=membershipsPage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Failed to add new education level");

        // String uuid = UUID.randomUUID().toString();
        //educationPage.saveNewEducation("level1"+uuid);
    }



}