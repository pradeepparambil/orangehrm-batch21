package ca.qaguru.oranghrmbatch21.tests;

import ca.qaguru.oranghrmbatch21.library.TestBase;
import ca.qaguru.oranghrmbatch21.pages.HeaderPage;
import ca.qaguru.oranghrmbatch21.pages.LicenseTestPage;
import ca.qaguru.oranghrmbatch21.pages.LoginPage;
import ca.qaguru.oranghrmbatch21.pages.MenuOptions;
import lombok.extern.java.Log;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.UUID;

public class LicenseTest extends TestBase {
    @Test
    public void addLicenseTest() {
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.login("admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LICENSES);
        LicenseTestPage licenseTest = new LicenseTestPage(driver);
        String uuid = UUID.randomUUID().toString();
        licenseTest.saveNewLicense("Title" + uuid);
    }
}
