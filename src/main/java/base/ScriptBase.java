package base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ScriptBase {
    public  WebDriver driver;
    public static final Logger log=Logger.getLogger(ScriptBase.class.getName());
    public static final String USERNAME="ZamanTest";
    public static final String ACCESS_KEY="030f0777-f8b7-44bd-b148-5dd4726a924d";
    public static final String URL="http://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:80/wd/hub";


    public void init(){
        String Log4jConfigPath="log4j.properties";
        PropertyConfigurator.configure(Log4jConfigPath);
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

    }

    public void saucelab() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        caps.setCapability("browserName","chrome");
        caps.setCapability("platform","macOS 10.13");
        caps.setCapability("version","latest");
        driver=new RemoteWebDriver(new URL(URL),caps);
        driver.get("http://automationpractice.com/index.php");

    }

}
