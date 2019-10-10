package homepage;

import base.ScriptBase;
import controller.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends ScriptBase {
    HomePage homePage;

    @BeforeTest
    public void beforetest(){

       // init();
    }

   @Test
    public void VerifyhomepageContactBarInfo(){
    homePage=new HomePage(driver);
    homePage.homepageContactBarInfo();
    }

    @Test
    public void VerifyHatSearch(){
        homePage=new HomePage(driver);
        homePage.productsSearch("Hat",driver,"7");
    }
    @Test
    public void VerifySleeveSearch(){
        homePage=new HomePage(driver);
        homePage.productsSearch("Sleeve",driver,"4");
    }

}

