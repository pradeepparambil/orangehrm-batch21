package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import ca.qaguru.oranghrmbatch21.pages.PayGradePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class PayGradeTests extends TestBase {

    @Test
    public void addNewPayGrade (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.PAY_GRADES);
        PayGradePage payGradePage = new PayGradePage(driver);
        String uuid = UUID.randomUUID().toString();
        payGradePage.saveNewPayGrade("Name-"+uuid);
        WebElement payGrade = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[10]/td[2]/a"));
        Assert.assertTrue(payGrade.isDisplayed(), "PayGrade is not Displayed");
    }
}
