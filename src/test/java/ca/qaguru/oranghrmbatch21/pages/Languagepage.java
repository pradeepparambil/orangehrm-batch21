package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Languagepage extends PageBase {
    private int countBefore;
    private int countAfter;


    private final String xpathLangAddBtn = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    private final String xpathEditIcons="//i[@class='oxd-icon bi-pencil-fill']";
    private final String xpathDeleteIcons="//i[@class='oxd-icon bi-trash']";
   private final String xpathCheckBoxes="//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String xpathDeleteBtns="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']";
    private final String xpathDeleteConfirmBtn="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
    private final String xpathLangAddTxtbox="//input[@class='oxd-input oxd-input--active']";
    private final String xpathLangSaveBtn="//button[@type='submit']";
    private final String xpathLangCancelBtn= "//button[@type='button'and @class='oxd-button oxd-button--medium oxd-button--ghost']";

  private final String xpathLangEditTxtbox="//input[@class='oxd-input oxd-input--active']";
   private final String xpathLanEditsaveBtn="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    public Languagepage(WebDriver driver) {
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
       Assert.assertTrue(isElementVisible(By.xpath(xpathLangEditTxtbox)),"edith box not visible");
}
public void addTextboxpresent(){
      click(By.xpath(xpathLangAddBtn));
      Assert.assertTrue(isElementVisible(By.xpath(xpathLangAddTxtbox)),"Text box not visible");
}

    public void elementClickable(){
        Assert.assertTrue(isElementClickable(By.xpath(xpathLangAddBtn)),"Add button not clickable");
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
    List<WebElement> languages=driver.findElements(By.xpath(xpathCheckBoxes));
      int  countBefore=languages.size();
      setCountBefore(countBefore);


        if(countBefore>1) {
            languages.get(1).click();//to delete record from top
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
        public void editLanguage(String level) throws InterruptedException {
            int numberOficons=0;
        List<WebElement>editIcons=driver.findElements(By.xpath(xpathEditIcons));
         numberOficons=editIcons.size();
         editIcons.get(1).click();
        setText(By.xpath(xpathLangEditTxtbox),level);
        click(By.xpath(xpathLanEditsaveBtn));
        Thread.sleep(1000);
        }




    public  void saveNewLanguage(String level1) throws InterruptedException {
        List<WebElement> beforeAdd=driver.findElements(By.xpath(xpathCheckBoxes));
        setCountBefore(beforeAdd.size());
        click(By.xpath(xpathLangAddBtn));
        setText(By.xpath(xpathLangAddTxtbox),level1);
        click(By.xpath(xpathLangSaveBtn));
        WebDriverWait wait=new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathCheckBoxes)));

            List<WebElement> afterAdd = driver.findElements(By.xpath(xpathCheckBoxes));
            setCountAfter(afterAdd.size());
    }


}
