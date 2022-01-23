package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EducationPage extends PageBase {
    private final String idEduAddBtn = "btnAdd";
    private final String idEduTxtLevel="education_name";
    private final String idEduSaveBtn="btnSave";
    private final String getIdEduCancelBtn= "btnCancel";

    public EducationPage(WebDriver driver) {
        super(driver);
    }

    public void saveNewEducation(String level1) {
        click(By.id(idEduAddBtn));
        setText(By.id(idEduTxtLevel), level1);
        click(By.id(idEduSaveBtn));
    }
}
