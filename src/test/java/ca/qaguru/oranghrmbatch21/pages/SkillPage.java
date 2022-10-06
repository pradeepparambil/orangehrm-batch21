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

public class SkillPage extends PageBase {
    private int countBefore;
    private int countAfter;


    private final String xpathSkillAddBtn = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    private final String xpathEditIcons="//i[@class='oxd-icon bi-pencil-fill']";
    private final String xpathDeleteIcons="//i[@class='oxd-icon bi-trash']";
    private final String xpathCheckBoxes="//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String xpathDeleteBtns="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']";
    private final String xpathDeleteConfirmBtn="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
    private final String xpathAddTextBox="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input";
    private final String xpathSkillSaveBtn="//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]";
    private final String xpathSkillCancelBtn= "//button[@type='button'and @class='oxd-button oxd-button--medium oxd-button--ghost']";
    private final String xpathEditBox="//input[@class='oxd-input oxd-input--active']";
    private final String xpathSkillEditsaveBtn="//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    private final String xpathDescriptionBox="//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']";
    public SkillPage(WebDriver driver) {
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
       Assert.assertTrue(isElementVisible(By.xpath(xpathEditBox)),"edith box not visible");
}
public void addTextboxpresent(){
      click(By.xpath(xpathSkillAddBtn));
      Assert.assertTrue(isElementVisible(By.xpath(xpathAddTextBox)),"Text box not visible");
}

    public void elementClickable(){
        Assert.assertTrue(isElementClickable(By.xpath(xpathSkillAddBtn)),"Add button not clickable");
        Assert.assertTrue(isElementClickable(By.xpath(xpathEditIcons)),"Edit icon not clickable");
        Assert.assertTrue(isElementClickable(By.xpath(xpathDeleteIcons)),"Delete icon not clickable");
    }

    public void isDeleteButtonVissible() throws InterruptedException {
        List<WebElement> skillLevels=driver.findElements(By.xpath(xpathCheckBoxes));
        skillLevels.get(1).click();
        Thread.sleep(500);
        Assert.assertTrue(isElementVisible(By.xpath(xpathDeleteBtns)),"Delete button not vissible");

    }


    public void deleteRecord() throws InterruptedException
    {
        boolean record=true;
    List<WebElement> skilllevels=driver.findElements(By.xpath(xpathCheckBoxes));
      int  countBefore=skilllevels.size();
      setCountBefore(countBefore);


        if(countBefore>1) {
            skilllevels.get(1).click();//to delete record from top
            //driver.navigate()
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
        public void editSkillLevel(String level,String Description) throws InterruptedException {
            int numberOficons=0;
        List<WebElement>editIcons=driver.findElements(By.xpath(xpathEditIcons));
         numberOficons=editIcons.size();
         editIcons.get(1).click();
         Thread.sleep(1000);
         List<WebElement>textbox=driver.findElements(By.xpath(xpathEditBox));
         textbox.get(1).clear();
         textbox.get(1).sendKeys(level);
         Thread.sleep(1000);

         WebElement textbox2=driver.findElement(By.xpath(xpathDescriptionBox));
         textbox2.clear();
         textbox2.sendKeys(Description);
         Thread.sleep(1000);

        //setText(By.xpath(xpathEditBox),level);
        //setText(By.xpath(xpathDescriptionBox),Description);
        click(By.xpath(xpathSkillEditsaveBtn));
        Thread.sleep(1000);

        }




    public  void saveNewSkill(String level1,String description)  {
        List<WebElement> beforeAdd=driver.findElements(By.xpath(xpathCheckBoxes));
        setCountBefore(beforeAdd.size());

        click(By.xpath(xpathSkillAddBtn));

        setText(By.xpath(xpathAddTextBox),level1);
        driver.findElement(By.xpath(xpathDescriptionBox)).sendKeys(description);
        //setText(By.xpath(xpathDescriptionBox),description);
        click(By.xpath(xpathSkillSaveBtn));

        WebDriverWait wait=new WebDriverWait(driver,20);
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathCheckBoxes)));

            List<WebElement> afterAdd = driver.findElements(By.xpath(xpathCheckBoxes));
            setCountAfter(afterAdd.size());
    }


}
