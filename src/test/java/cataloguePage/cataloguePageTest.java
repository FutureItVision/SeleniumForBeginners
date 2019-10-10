package cataloguePage;

import base.ScriptBase;
import controller.CataloguePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class cataloguePageTest extends ScriptBase {


    CataloguePage cataloguePage;

    @BeforeTest
    public void beforetest(){

        init();
    }


    @Test
    public void verifyWomenCatalogeTabDisplay(){
        cataloguePage=new CataloguePage(driver) ;
        cataloguePage.homePageCataloge(driver,"Women");
    }
}
