package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends PageBase {

    private String idUsername = "txtUsername";
    private String idPassword = "txtPassword";
    private String idLogin = "btnLogin";
    private String idErrMsg = "spanMessage";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password, boolean validCredentials, String expErrMsg){
        setText(By.id(idUsername), username);
        setText(By.id(idPassword),password);
        click(By.id(idLogin));

        HeaderPage headerPage = new HeaderPage(driver);
        if(validCredentials){
            Assert.assertTrue(headerPage.isMenuVisible());
        }else {
            Assert.assertFalse(headerPage.isMenuVisible());
            Assert.assertEquals(getText(By.id(idErrMsg)),expErrMsg, "Incorrect Error Message");
        }
    }

}
