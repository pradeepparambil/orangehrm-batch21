package ca.qaguru.oranghrmbatch21.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;
    private String idMenu = "mainMenu";

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMenuVisible(){
        try {
            driver.findElement(By.id(idMenu));
        }catch (Exception exc){
            return false;
        }

        return true;
    }

}
