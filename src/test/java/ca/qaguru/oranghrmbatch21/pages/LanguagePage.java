package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LanguagePage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtLanguage = "language_name";
    private final String idBtnSave = "btnSave";
    private final String idBtnCancel = "btnCancel";
    private final String idBtnDelete = "btnDel";
    private final String lnkLanguage = "//a[text()='XXX']";
    private final String chkLanguage = "//a[text()='XXX']//preceding::input[@type='checkbox'][1]";


    public LanguagePage(WebDriver driver) {
        super(driver);
    }

    public void saveNewLanguage(String language_name) {
        click(By.id(idBtnAdd));
        setText(By.id(idTxtLanguage), language_name);
        click(By.id(idBtnSave));
        Assert.assertTrue(isElementVisible(By.xpath(lnkLanguage.replace("XXX", language_name))), "Language is not saved");

    }

    public void DeleteLanguage(String language_name) {
        click(By.xpath(chkLanguage.replace("XXX", language_name)));
        //Assert.assertFalse(click(By.xpath(chkLanguage.replace("XXX", language_name))));
        click(By.id(idBtnDelete));
        }

    public void EditLanguage(String language_name) {
        click(By.xpath(lnkLanguage.replace("XXX", language_name)));
        setText(By.id(idTxtLanguage), language_name);
        click(By.id(idBtnSave));
        Assert.assertTrue(isElementVisible(By.xpath(lnkLanguage.replace("XXX", language_name))), "Language is not saved");

    }
}