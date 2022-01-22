package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguagePage extends PageBase {
    private static final String idBtnAdd = "btnAdd";
    private static final String idTxtLanguage = "language_name";
    private static final String idBtnSave = "btnSave";
    private static final String idBtnCancel = "btnCancel";
    private static final String idBtnDelete = "btnDel";


    public LanguagePage(WebDriver driver) {
        super(driver);
    }
    public static String saveNewLanguage(String language_name) {
        click(By.id(idBtnAdd));
        setText(By.id(idTxtLanguage), language_name);
        click(By.id(idBtnSave));
        return language_name;


    }
}
