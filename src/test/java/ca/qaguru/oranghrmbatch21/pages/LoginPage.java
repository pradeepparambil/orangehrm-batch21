package ca.qaguru.oranghrmbatch21.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;
    private String idUsername = "txtUsername";
    private String idPassword = "txtPassword";
    private String idLogin = "btnLogin";
    private String idErrMsg = "spanMessage";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password, boolean validCredentials, String expErrMsg){
        WebElement txtUsername = driver.findElement(By.id(idUsername));
        txtUsername.clear();
        txtUsername.sendKeys(username);
        WebElement txtPassword = driver.findElement(By.id(idPassword));
        txtPassword.clear();
        txtPassword.sendKeys(password);
        WebElement btnLogin = driver.findElement(By.id(idLogin));
        btnLogin.click();
        HeaderPage headerPage = new HeaderPage(driver);
        if(validCredentials){
            Assert.assertTrue(headerPage.isMenuVisible());
        }else {
            Assert.assertFalse(headerPage.isMenuVisible());
            WebElement lblErrMsg = driver.findElement(By.id(idErrMsg));
            Assert.assertEquals(lblErrMsg.getText(),expErrMsg, "Incorrect Error Message");
        }
    }
}
