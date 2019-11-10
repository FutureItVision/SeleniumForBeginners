package cataloguePage;

import base.ScriptBase;
import controller.CataloguePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class cataloguePageTest extends ScriptBase {


    CataloguePage cataloguePage;

    @Test
    public void verifyWomenCatalogeTabDisplay(){
        log.info("#########----verifyWomenCatalogeTabDisplay test Start----##########");
        cataloguePage=new CataloguePage(driver) ;
        cataloguePage.homePageCataloge(driver,"Women");
        log.info("#########---verifyWomenCatalogeTabDisplay test End----##########");

    }
    @AfterTest
    public void closeBrowsr(){
        driver.close();
        driver.quit();
    }
}
