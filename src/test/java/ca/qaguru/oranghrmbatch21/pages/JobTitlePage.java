package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class JobTitlePage extends PageBase {
    private final String jobTitleTestBox = "//div[contains(@style,'flex: 2 1 0%;')]";
    private final String addButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button/i";
    private final String newJobTitle = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input";
    private final String cancelButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[1]";
    private final String saveButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]";

    private final String smallDeleteButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[1]/i";
    private final String smallEditButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[4]/div/button[2]/i";
    private final String bigDeleteButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/button";
    //private String headerCheckBox = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[1]/div/div[1]/div/label/input";
   // private String checkBox = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span/i";
    private final String singleDeleteConfirmation = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]";
    //private List <WebElement> checkBoxex = driver.findElements(By.xpath("//input[@type='checkbox']"));

    private final String xpathjobtitle = "//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']";
    private final String countOfSelectedCheckBoxes = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/div/span";
    //********Edit Page*************
    private final String newEditJobTitle = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input";
    private final String saveEditButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]";
    private final String cancelEditButton = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[1]";



   //private List<WebElement> checkBoxes = driver.findElements(By.xpath(xpathjobtitle));

   public void selectAllJobtitle() {
        int count = 0;

        List<WebElement> elem = driver.findElements(By.xpath(xpathjobtitle));
        count = elem.size();
        //elem.get(count - 1).click();
       elem.get(0).click();
        System.out.println(count);
       /* for(WebElement chkbox : elem){
            chkbox.click();
        }*/
    }

    public void verifyCheckBoxCheck() {
        int count = 0;
        int isCheckCount = 0;

        List<WebElement> checkBoxes = driver.findElements(By.xpath(xpathjobtitle));
        count = checkBoxes.size();
        //elem.get(count - 1).click();

        System.out.println(count);
        for(WebElement chkbox : checkBoxes){
            chkbox.click();
            if(chkbox.isSelected()){
                isCheckCount = isCheckCount+1;
            }
        }
        System.out.println("Check Boxes checked : "+ isCheckCount);
        String actual = "("+isCheckCount+") Records Selected";
        String selected = String.valueOf(driver.findElement(By.xpath(countOfSelectedCheckBoxes)));
        Assert.assertEquals(selected,actual);

    }



    //int num = checkBoxXpath.size();


    public JobTitlePage(WebDriver driver) {
        super(driver);
    }

    public void addNewJobTitle(String title) {
        boolean added = false;
        click(By.xpath(addButton));
        setText(By.xpath(newJobTitle), title);
        click(By.xpath(saveButton));
        List <WebElement> jobTitleTextBoxes = driver.findElements(By.xpath(jobTitleTestBox));
        for (WebElement txtBox : jobTitleTextBoxes){
            String jTitle = txtBox.getText();
            if(jTitle.equals(title)){
                added = true;
                break;
            }
            Assert.assertTrue(added);
        }
       // WebDriverWait wait = new WebDriverWait(driver, 30);
       // Alert alert = driver.switchTo().alert();
       // System.out.println(alert.getText());;

       /* if(wait.until(ExpectedConditions.alertIsPresent())==null)
            System.out.println("alert was not present");
        else
            System.out.println("alert was present");*/
    }
   /* public void nofCheckboxex(){
        List <WebElement>  checkBoxXpath = driver.findElements(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/label/span"));
        System.out.println("No of check boxes = " + checkBoxXpath.size());
    }*/

    // public void deleteJobTitle(By by){

    // }
    public void deleteJobTitle() {//click(By.xpath(checkBox));
        List <WebElement> jobTitleTextBoxes = driver.findElements(By.xpath(jobTitleTestBox));
        boolean exist = false;
        String title = jobTitleTextBoxes.get(0).getText();
        click(By.xpath(smallDeleteButton));
        click(By.xpath(singleDeleteConfirmation));

        for (WebElement txtBox : jobTitleTextBoxes){
            String jTitle = txtBox.getText();
            if(jTitle.equals(title)){
                exist = true;
                break;
            }
        }
        Assert.assertFalse(exist);

    }
    public void deleteAllButton(){
        //

        click(By.xpath(bigDeleteButton));
        click(By.xpath(singleDeleteConfirmation));
        //System.out.println(checkBoxes.size());




    }
    public void editJobTitle(String newTitle){

        click(By.xpath(smallEditButton));
        //WebElement jobTitleTextBox = (new WebDriverWait(driver, 10))
               // .until(ExpectedConditions.elementToBeClickable(By.xpath(newEditJobTitle)));
        WebElement jobTitleTextBox = driver.findElement(By.xpath(newEditJobTitle));
        jobTitleTextBox.clear();
        //setText(By.xpath(newJobTitle), newTitle);
        while(!jobTitleTextBox.getText().equals("")){
            jobTitleTextBox.sendKeys(Keys.BACK_SPACE);
        }
        jobTitleTextBox.sendKeys(newTitle);
        //setText(By.xpath(newEditJobTitle), newTitle);

        click(By.xpath(saveButton));
        //WebDriverWait wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        List <WebElement> jobTitleTextBoxes = driver.findElements(By.xpath(jobTitleTestBox));
        Assert.assertEquals(getText(By.xpath(jobTitleTextBoxes.get(0).getText())),newTitle);
    }





}
