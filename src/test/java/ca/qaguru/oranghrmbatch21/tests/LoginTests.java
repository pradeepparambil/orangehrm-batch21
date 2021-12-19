package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginTestWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123",true,null);
    }

    @Test
    public void loginTestWithInValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sumo", "blahblah", false,"Invalid credentials");
    }


}
