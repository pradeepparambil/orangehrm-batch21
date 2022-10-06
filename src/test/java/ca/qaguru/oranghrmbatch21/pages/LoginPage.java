package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends PageBase {

    private String xpathUsername = "//input[@name='username']";
    private String xpathPassword = "//input[@name='password']";
    private String xpathLogin = "//button[@type='submit']";
    private String xpathErrMsg = "//div[@role='alert']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password, boolean validCredentials, String expErrMsg){
        setText(By.xpath(xpathUsername), username);
        setText(By.xpath(xpathPassword),password);
        click(By.xpath(xpathLogin));

        HeaderPage headerPage = new HeaderPage(driver);
        if(validCredentials){
            Assert.assertTrue(headerPage.isMenuVisible());
        }else {
            Assert.assertFalse(headerPage.isMenuVisible());
            Assert.assertEquals(getText(By.xpath(xpathErrMsg)),expErrMsg, "Incorrect Error Message");
        }
    }

}
