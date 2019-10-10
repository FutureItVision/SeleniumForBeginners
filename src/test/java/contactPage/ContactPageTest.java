package contactPage;

import base.ScriptBase;
import controller.ContactPage;
import controller.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactPageTest extends ScriptBase {

ContactPage contactPage;



    @BeforeTest
    public void beforetest(){

        init();
    }

    @Test
    public void verifyValidContactPageCreate() {
        contactPage = new ContactPage(driver);
        contactPage.SuccessContcatInfoValidation("Test2@gmail.com","test","This is test","Customer service");


    }
}
