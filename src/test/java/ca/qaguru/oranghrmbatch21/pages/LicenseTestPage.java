package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LicenseTestPage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idLicenseNameText = "license_name";
    private final String idBtnSave = "btnSave";
    private final String idBtnCancel = "btnCancel";

    private final String idLicenseRecordList = "recordsListTable";
    private final String nameCheckList = "chkListRecord[]";
    private final String idBtnDel = "btnDel";
    public LicenseTestPage(WebDriver driver) {
        super(driver);
    }
    public void saveNewLicense(String title){
   click(By.id(idBtnAdd));
   setText(By.id(idLicenseNameText), title);
   click(By.id(idBtnSave));
    }
}
