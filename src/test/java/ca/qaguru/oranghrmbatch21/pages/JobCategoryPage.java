package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobCategoryPage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtName = "jobCategory_name";
    private final String idBtnSave = "btnSave";


    public JobCategoryPage(WebDriver driver) {
        super(driver);
    }
    public void createJobCategory(String nameInput){
        click(By.id(idBtnAdd));
        setText(By.id(idTxtName), nameInput);
        click(By.id(idBtnSave));


    }

}
