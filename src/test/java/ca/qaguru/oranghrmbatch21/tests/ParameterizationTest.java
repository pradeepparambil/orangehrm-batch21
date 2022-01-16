package ca.qaguru.oranghrmbatch21.tests;

import org.testng.annotations.Test;

public class ParameterizationTest {
    @Test(dataProvider = "LoginInfo", dataProviderClass = ParameterizationTestData.class)
    public void sampleTest(String username, String password){
        System.out.println("Username : "+ username + " Password: "+ password);
    }
}
