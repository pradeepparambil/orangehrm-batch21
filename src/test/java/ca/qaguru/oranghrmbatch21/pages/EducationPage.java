package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;
import java.util.List;
import java.util.UUID;

public class EducationPage extends PageBase {
    private int countBefore;
    private int countAfter;


    private final String xpathEduAddBtn = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    private final String xpathEditIcons="//i[@class='oxd-icon bi-pencil-fill']";
    private final String xpathDeleteIcons="//i[@class='oxd-icon bi-trash']";
   private final String xpathCheckBoxes="//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String xpathDeleteBtns="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']";
    private final String xpathDeleteConfirmBtn="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
    private final String xpathEduTxtLevel="//input[@class='oxd-input oxd-input--active']";
    private final String xpathEduSaveBtn="//button[@type='submit']";
    private final String xpathEduCancelBtn= "//button[@type='button'and @class='oxd-button oxd-button--medium oxd-button--ghost']";

  private final String xpathEduLevelEdit="//input[@class='oxd-input oxd-input--active']";
   private final String EduEditsaveBtn="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    public EducationPage(WebDriver driver) {
        super(driver);
    }

    public void setCountBefore(int Bc){
        this.countBefore=Bc;
    }
    public void setCountAfter(int Ac){
        this.countAfter=Ac;
    }

    public int getCountBefore(){
        return countBefore;
    }
    public int getCountAfter(){
        return countAfter;
    }

public void editTextboxPresent(){
    List<WebElement>editIcons=driver.findElements(By.xpath(xpathEditIcons));
    int numberOficons=editIcons.size();
    editIcons.get(numberOficons-1).click();
       Assert.assertTrue(isElementVisible(By.xpath(xpathEduLevelEdit)),"edith box not visible");
}
public void addTextboxpresent(){
      click(By.xpath(xpathEduAddBtn));
      Assert.assertTrue(isElementVisible(By.xpath(xpathEduTxtLevel)),"Text box not visible");
}

    public void elementClickable(){
        Assert.assertTrue(isElementClickable(By.xpath(xpathEduAddBtn)),"Add button not clickable");
        Assert.assertTrue(isElementClickable(By.xpath(xpathEditIcons)),"Edit icon not clickable");
        Assert.assertTrue(isElementClickable(By.xpath(xpathDeleteIcons)),"Delete icon not clickable");
    }

    public void isDeleteButtonVissible() throws InterruptedException {
        List<WebElement> EduLevels=driver.findElements(By.xpath(xpathCheckBoxes));
        EduLevels.get(1).click();
        Thread.sleep(500);
        Assert.assertTrue(isElementVisible(By.xpath(xpathDeleteBtns)),"Delete button not vissible");

    }


    public void deleteRecord() throws InterruptedException
    {
        boolean record=true;
    List<WebElement> Edulevels=driver.findElements(By.xpath(xpathCheckBoxes));
      int  countBefore=Edulevels.size();
      setCountBefore(countBefore);


        if(countBefore>1) {
            Edulevels.get(countBefore - 1).click();//to delete record from bottom
            click(By.xpath(xpathDeleteBtns));
            Thread.sleep(1000);
            click(By.xpath(xpathDeleteConfirmBtn));
            Thread.sleep(1000);
        }else {
            record = false;
            Assert.assertTrue(record,"no data to be deleted");
        }
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathCheckBoxes)));
        List<WebElement> afterDelete = driver.findElements(By.xpath(xpathDeleteIcons));
        setCountAfter(afterDelete.size());

        }



        public void useDeleteIcon() throws InterruptedException {
        boolean records =true;
        List<WebElement>DeleteIcons=driver.findElements(By.xpath(xpathDeleteIcons));
        int numOfDelIcons=DeleteIcons.size();
        setCountBefore(numOfDelIcons);
        if(numOfDelIcons>=1) {
            DeleteIcons.get(numOfDelIcons - 1).click();// to delete record from bottom
            click(By.xpath(xpathDeleteConfirmBtn));
        }
        else {
            records=false;
            SoftAssert assertion=new SoftAssert();
            assertion.assertFalse(records,"no records to be deleted");
        }
            WebDriverWait wait=new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathCheckBoxes)));
            List<WebElement> afterDelete = driver.findElements(By.xpath(xpathDeleteIcons));
            setCountAfter(afterDelete.size());


        }
        public void editEduLevel(String level) throws InterruptedException {
            int numberOficons=0;
        List<WebElement>editIcons=driver.findElements(By.xpath(xpathEditIcons));
         numberOficons=editIcons.size();
         editIcons.get(numberOficons).click();
        setText(By.xpath(xpathEduLevelEdit),level);
        click(By.xpath( EduEditsaveBtn));
        Thread.sleep(1000);
        }




    public  void saveNewEducation(String level1) throws InterruptedException {
        List<WebElement> beforeAdd=driver.findElements(By.xpath(xpathCheckBoxes));
        setCountBefore(beforeAdd.size());
        click(By.xpath(xpathEduAddBtn));
        setText(By.xpath(xpathEduTxtLevel),level1);
        click(By.xpath(xpathEduSaveBtn));
        WebDriverWait wait=new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathCheckBoxes)));

            List<WebElement> afterAdd = driver.findElements(By.xpath(xpathCheckBoxes));
            setCountAfter(afterAdd.size());
    }


}
