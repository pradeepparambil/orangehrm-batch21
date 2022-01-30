package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MembershipPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import org.testng.annotations.Test;

import java.util.UUID;



public class MembershipTests extends TestBase {

    @Test ()
    public void addNewMembership(){
        String membership = "membership"+ UUID.randomUUID().toString();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipPage membershipPage =new MembershipPage(driver);
        membershipPage.saveMembership(membership,true);

    }
    @Test()
    public void addNewMembershipClickCancel(){
        String uuid = UUID.randomUUID().toString();
        String membership = "membership"+ uuid;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipPage membershipPage =new MembershipPage(driver);
        membershipPage.CancelNewMembership(membership,false);
    }

   @Test()
    public void addExistingMembership(){
        String uuid = UUID.randomUUID().toString();
        String membership = "membership"+ uuid;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipPage membershipPage =new MembershipPage(driver);
        membershipPage.saveMembership(membership,true);
        membershipPage.saveMembership(membership,true);
               }


    @Test()
    public void deleteMembershipClickCancel(){
        String uuid = UUID.randomUUID().toString();
        String membership = "membership"+ uuid;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipPage membershipPage =new MembershipPage(driver);
        membershipPage.saveMembership(membership,true);
        membershipPage.CancelDeleteMembership(membership,true);
    }

    @Test()
    public void deleteMembership(){
       String uuid = UUID.randomUUID().toString();
        String membership = "membership"+ uuid;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipPage membershipPage =new MembershipPage(driver);
        membershipPage.saveMembership(membership,true);
        membershipPage.DeleteMembership(membership,false);
    }
    @Test()
    public void editMembership(){
        String uuid = UUID.randomUUID().toString();
        String membership = "membership"+ uuid;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.MEMBERSHIPS);
        MembershipPage membershipPage =new MembershipPage(driver);
        membershipPage.saveMembership(membership,true);
        membershipPage.EditMembership(membership,membership+" new",true);
    }





    }






