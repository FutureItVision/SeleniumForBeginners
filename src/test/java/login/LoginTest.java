package login;

import base.ScriptBase;
import controller.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends ScriptBase {
    LoginPage loginPage;

   @BeforeTest
   public void beforetest(){

       //init();
   }
   @Test (alwaysRun =true,priority = 1,description = "Verify Invalid Login Test")
    public void verifyInvalidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.invalidSignin("futuregroup123@gmail.com","123lkkkckeo");


    }
    @Test (priority = 2,description = "Verify Invalid Login With Invalid Email",dependsOnMethods="verifyInvalidLogin")
    public void verifyInvalidLoginWithInvalidEmail() {
        loginPage = new LoginPage(driver);
        loginPage.invalidSignin("futuregroup123@gmail.com","12345");


    }

    @Test (priority = 3)
    public void verifyvalidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.validSignin("futureitgroup@gmail.com","admin123");


    }

    @AfterTest
    public void closeBrowsr(){
      driver.close();
       driver.quit();
    }

}