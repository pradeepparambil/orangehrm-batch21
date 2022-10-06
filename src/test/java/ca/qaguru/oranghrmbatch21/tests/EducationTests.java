package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.EducationPage;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.UUID;

public class EducationTests extends TestBase {
     int countBefore;
     int countAfter;

     // VERIFY  EDITH ICON, DELETE ICON, DELETE AND ADD BUTTON ARE VISSIBLE/CLICKABLE->TC001
    @Test
    public void elementClickable() {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        headerPage.assertWelcomeMessage();
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();

    }
//DELETE BUTTON IS VISSIBLE -> TC002
    @Test
    public void deleteButtnVissible() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        headerPage.assertWelcomeMessage();
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();
        educationPage.isDeleteButtonVissible();
    }

    // DELETE AN EDUCATION LEVEL USING DELETE ICON ->TCOO3
    @Test
    public void deleteWithDelIcon() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        headerPage.assertWelcomeMessage();
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();
        educationPage.useDeleteIcon();
        //System.out.println(educationPage.getCountBefore());
        //System.out.println(educationPage.getCountAfter());
        if(educationPage.getCountBefore()!=educationPage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Deletion is not successful");

    }

// DELETE AN EDUCATION LEVEL USING DELETE BUTTON -> TCOO4
    @Test
    public void deleteWithDeleteBtn() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        headerPage.assertWelcomeMessage();
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();
        educationPage.deleteRecord();
        if(educationPage.getCountBefore()!=educationPage.getCountAfter()){
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
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();
        educationPage.addTextboxpresent();

    }

    // VERIFY IF EDIT TEXT BOX IS PRESENT ->TC006
    @Test
    public void editTextBoxPresent(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();
        educationPage.editTextboxPresent();

    }



    // EDIT EDUCATION LEVEL -> TC007
    @Test
    public void editEduLevel() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();
        educationPage.editEduLevel("Masters in civil Eng.");
        Thread.sleep(1000);

    }

//ADD NEW EDUCATION LEVEL -> TC008
     @Test
    public void addNewEducation() throws InterruptedException {
         boolean success=false;

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        //educationPage.elementClickable();
        educationPage.saveNewEducation("Master's Degree");
        //System.out.println(educationPage.getCountBefore());
        //System.out.println(educationPage.getCountAfter());
        if(educationPage.getCountBefore()!=educationPage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Failed to add new education level");

        // String uuid = UUID.randomUUID().toString();
        //educationPage.saveNewEducation("level1"+uuid);
    }



}