package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MembershipPage extends PageBase {

    private final String idBtnAdd = "btnAdd";
    private final String idBtnDelete = "btnDelete";
    private final String idTxtName = "membership_name";
    private final String idBtnSave = "btnSave";
    private final String idBtnCancel = "btnCancel";
    private final String idBtnDeleteOk = "dialogDeleteBtn";
    private final String xpathDeleteMsg="//*[contains(text(),'Successfully Deleted')]";
    private final String expDeleteMsg ="Successfully Deleted";
    private final String xpathDeleteCancel = "//input[@class='btn reset' and @value='Cancel']";
    private final String xpathMembership="//a[contains(text(),'XXX')]";
    private final String chkMembership ="//a[contains(text(),'XXX')]//preceding::input[@type='checkbox'][1]";
    private final String xpathAlreadyExist ="//span[contains(text(),'Already exists')]";
    private final String expErrMsg = "Already exists";

    public MembershipPage(WebDriver driver) {
        super(driver);
    }


    public void saveMembership(String membership, Boolean save) {
        if(!(isElementVisible(By.xpath(xpathMembership.replace("XXX", membership))))) {
            click(By.id(idBtnAdd));
            setText(By.id(idTxtName), membership);
            click(By.id(idBtnSave));
            isMembershipVisible(membership, save);
        }
        else{
            click(By.id(idBtnAdd));
            setText(By.id(idTxtName), membership);
            Assert.assertEquals(getText(By.xpath(xpathAlreadyExist)),expErrMsg, "Incorrect Error Message");

        }
    }
    public void CancelNewMembership(String membership,Boolean save) {
        click(By.id(idBtnAdd));
        setText(By.id(idTxtName),membership);
        click(By.id(idBtnCancel));
        isMembershipVisible(membership,save);

    }
    public void DeleteMembership(String membership,Boolean save) {
        if (!(driver.findElement(By.xpath(chkMembership.replace("XXX", membership)))).isSelected()) {
            click(By.xpath(chkMembership.replace("XXX", membership)));
            click(By.id(idBtnDelete));
            click(By.id(idBtnDeleteOk));
           //Assert.assertEquals(getText(By.xpath(xpathDeleteMsg)),expDeleteMsg, "Incorrect Error Message");
            isMembershipVisible(membership,save);

        }
        else{
            click(By.id(idBtnDelete));
            click(By.id(idBtnDeleteOk));
            isMembershipVisible(membership,save);

        }
    }

 public void CancelDeleteMembership(String membership,Boolean save) {
        if (!(driver.findElement(By.xpath(chkMembership.replace("XXX", membership)))).isSelected()) {
            click(By.xpath(chkMembership.replace("XXX", membership)));
            click(By.id(idBtnDelete));
            click(By.xpath(xpathDeleteCancel));
            isMembershipVisible(membership,save);

        }
        else{
            click(By.id(idBtnDelete));
             click(By.xpath(xpathDeleteCancel));
            isMembershipVisible(membership,save);

        }
    }



    public void isMembershipVisible(String membership, Boolean save ) {
       if(save){
        Assert.assertTrue(isElementVisible(By.xpath(xpathMembership.replace("XXX", membership))), "Membership not Visible");
    }
       else{
           Assert.assertFalse(isElementVisible(By.xpath(xpathMembership.replace("XXX", membership))), "Membership is Visible");
       }

       }

    public void EditMembership(String membership, String newMembership, boolean save) {
        if(isElementVisible(By.xpath(xpathMembership.replace("XXX", membership)))){
            click(By.xpath(chkMembership.replace("XXX", membership)));
            //WebElement name = driver.findElement(By.id(idTxtName));
            click(By.xpath((xpathMembership.replace("XXX", membership))));
            setText(By.id(idTxtName),newMembership);
            click(By.id(idBtnSave));
            isMembershipVisible(newMembership, save);

        }



    }
}