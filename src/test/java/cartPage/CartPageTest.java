package cartPage;

import base.ScriptBase;
import controller.CartPage;
import controller.CataloguePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class CartPageTest extends ScriptBase {
    CartPage cartPage;

    @BeforeTest
    public void beforetest() throws MalformedURLException {

       // init();
        saucelab();
    }


    @Test
    public void verifyBlouseAddCartwithQuantity(){
        log.info("#########----verifyBlouseAddCartwithQuantity test Start----##########");
        cartPage=new CartPage(driver) ;
        cartPage.addCartWithMultipleQuantity("Blouse",5,driver);
        log.info("#########---verifyBlouseAddCartwithQuantity test End----##########");

    }

    @Test
    public void verifySleeveAddCartwithQuantity(){
        cartPage=new CartPage(driver) ;
        cartPage.addCartWithMultipleQuantity("Faded Short Sleeve T-shirts",10,driver);


    }


}
