package ca.qaguru.oranghrmbatch21.pages;

import ca.qaguru.oranghrmbatch21.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends PageBase {
    private WebDriver driver;
    private String idMenu = "mainMenu";

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMenuVisible(){
        return isElementVisible(By.id(idMenu));
    }
}
