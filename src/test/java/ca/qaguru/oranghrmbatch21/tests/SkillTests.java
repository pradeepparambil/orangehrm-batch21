package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SkillTests extends TestBase {
     int countBefore;
     int countAfter;

     // VERIFY  EDITH ICON, DELETE ICON, DELETE AND ADD BUTTON ARE VISIBLE/CLICKABLE->TC001
    @Test
    public void elementClickable() {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.SKILLS);
        headerPage.assertWelcomeMessage();
        SkillPage skillpage=new SkillPage(driver);
        skillpage.elementClickable();

    }
//DELETE BUTTON IS VISSIBLE -> TC002
    @Test
    public void deleteButtnVissible() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.SKILLS);
        headerPage.assertWelcomeMessage();
        SkillPage skillPage=new SkillPage(driver);
        skillPage.elementClickable();
        skillPage.isDeleteButtonVissible();

    }

    // DELETE A SKILL USING DELETE ICON ->TCOO3
    @Test
    public void deleteWithDelIcon() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.SKILLS);
        headerPage.assertWelcomeMessage();
        SkillPage skillPage=new SkillPage(driver);
        skillPage.elementClickable();
        skillPage.useDeleteIcon();

        //System.out.println(skillPage.getCountBefore());
        //System.out.println(skillPage.getCountAfter());
        if(skillPage.getCountBefore()!=skillPage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Deletion is not successful");

    }

// DELETE  USING DELETE BUTTON -> TCOO4
    @Test
    public void deleteWithDeleteBtn() throws InterruptedException {
        boolean success=false;
        LoginPage loginPage = new LoginPage(driver);
        HeaderPage headerPage = new HeaderPage(driver);
        loginPage.login("admin", "admin123", true, null);
        headerPage.selectMenu(MenuOptions.SKILLS);
        headerPage.assertWelcomeMessage();
        SkillPage skillPage=new SkillPage(driver);
        skillPage.elementClickable();
        skillPage.deleteRecord();
        if(skillPage.getCountBefore()!=skillPage.getCountAfter()){
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
        headerPage.selectMenu(MenuOptions.SKILLS);
        SkillPage skillPage=new SkillPage(driver);
        skillPage.elementClickable();
        skillPage.addTextboxpresent();
    }

    // VERIFY IF EDIT TEXT BOX IS PRESENT ->TC006
    @Test
    public void editTextBoxPresent(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.SKILLS);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.elementClickable();
        educationPage.editTextboxPresent();

    }



    // EDIT A SKILL -> TC007
    @Test
    public void editSkill() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.SKILLS);
        SkillPage skillPage=new SkillPage(driver);
        skillPage.elementClickable();
        skillPage.editSkillLevel("Public relation","Operating system");

    }

//ADD NEW  SKILL -> TC008
     @Test
    public void addNewSkill() throws InterruptedException {
         boolean success=false;

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.SKILLS);

        SkillPage skillPage=new SkillPage(driver);
        skillPage.elementClickable();
        skillPage.saveNewSkill("HR Management","management");

        if(skillPage.getCountBefore()!=skillPage.getCountAfter()){
            success=true;
        }
        Assert.assertTrue(success,"Failed to add new education level");

        // String uuid = UUID.randomUUID().toString();
        //educationPage.saveNewEducation("level1"+uuid);
    }



}