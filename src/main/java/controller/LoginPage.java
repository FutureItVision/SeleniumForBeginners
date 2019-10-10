package controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {



    @FindBy(xpath = "//*[@id='header']//a[@class='login']")
    WebElement signinButton;
    @FindBy(id = "email")
    WebElement emailSenkey;
    @FindBy(id = "passwd")
    WebElement passwordSenkey;
    @FindBy(css = "#SubmitLogin > span")
    WebElement SigninSubmitButton;
    @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
    WebElement invalidSignInerror;
    @FindBy(css="#center_column > p") WebElement signinWelcomeMessage;



    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void invalidSignin(String email,String Pass){
        signinButton.click();
        emailSenkey.sendKeys(email);
        passwordSenkey.sendKeys(Pass);
        SigninSubmitButton.click();
        Assert.assertEquals(invalidSignInerror,invalidSignInerror);

    }

    public void validSignin(String email,String Pass){
        signinButton.click();
        emailSenkey.sendKeys(email);
        passwordSenkey.sendKeys(Pass);
        SigninSubmitButton.click();
        Assert.assertEquals(signinWelcomeMessage,signinWelcomeMessage);

    }


}
