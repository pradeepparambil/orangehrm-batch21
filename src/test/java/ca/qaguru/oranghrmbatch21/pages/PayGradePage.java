package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class PayGradePage extends PageBase {
    private final String addButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button";
    private final String checkBoxes = "//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String firstTextBox = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[2]/div";
    private final String smallDeleteButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[1]/i";
    private final String editButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]/i";
    private final String deleteConfirmationButton = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]";
    private final String bigDeleteButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/button";

    //*****Add new name page*******
    private final String addNewName = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input";
    private final String saveButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]";

    //*****Edit PayGrade Page******

    public PayGradePage(WebDriver driver) {
        super(driver);
    }

    public void selectAllJobtitle() {
        int count = 0;
        List<WebElement> elem = driver.findElements(By.xpath(checkBoxes));
        count = elem.size();
        elem.get(0).click();
        System.out.println(count);
    }
    public void addNewJobTitle(String title) {
        click(By.xpath(addButton));
        setText(By.xpath(addNewName), title);
        click(By.xpath(saveButton));
    }

    public void deleteJobTitle() {
        click(By.xpath(smallDeleteButton));
        click(By.xpath(deleteConfirmationButton));
    }
    public void deleteAllButton(){
        click(By.xpath(bigDeleteButton));
        click(By.xpath(deleteConfirmationButton));
    }
    public void editButton(){
        click(By.xpath(editButton));

    }

}
