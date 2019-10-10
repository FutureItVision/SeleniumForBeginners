package controller;

import base.ScriptBase;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class CataloguePage extends ScriptBase {


    public CataloguePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    public void homePageCataloge(WebDriver driver,String catalogeTab){
        mousOver(driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li/a[@title='"+catalogeTab+"']")),driver);

    }

    public void mousOver(WebElement element,WebDriver driver){
        Actions actions=new Actions(driver);
        element=element;
        actions.moveToElement(element).perform();

    }



}