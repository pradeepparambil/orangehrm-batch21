package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobTitlePage extends PageBase {
    private final String idBtnAdd = "btnAdd";
    private final String idTxtTitle = "jobTitle_jobTitle";
    private final String idTxtDescription = "jobTitle_jobDescription";
    private final String idTxtNotes = "jobTitle_note";
    private final String idBtnChooseFile = "jobTitle_jobSpec";
    private final String idBtnSave = "btnSave";
    private final String idBtnCancel = "btnCancel";

    public JobTitlePage(WebDriver driver) {
        super(driver);
    }

    public void saveNewJobTitle(String title, String description, String notes) {
        click(By.id(idBtnAdd));
        setText(By.id(idTxtTitle),title);
        setText(By.id(idTxtDescription),description);
        setText(By.id(idTxtNotes),notes);
        click(By.id(idBtnSave));
    }
}
