package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PayGradePage extends PageBase {

    private final String idBtnAdd = "btnAdd";
    private final String idPayGradeName ="payGrade_name";
    private final String idBtnSave = "btnSave";
    private final String lnkPayGrade= "//a[text()='XXX']";
    private final String chkPayGrade = "//a[text()='XXX']//preceding::input[@type='checkbox'][1]";

    public PayGradePage(WebDriver driver){
        super(driver);
    }
    public void saveNewPayGrade(String name){
        click(By.id(idBtnAdd));
        setText(By.id(idPayGradeName),name);
        click(By.id(idBtnSave));
        Assert.assertTrue(isElementPresent(By.xpath(lnkPayGrade.replace("XXX",name))),"Paygrade Not Added");
    }

}
