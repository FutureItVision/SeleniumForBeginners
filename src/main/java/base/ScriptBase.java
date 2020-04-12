package base;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.net.MalformedURLException;
import java.net.URL;

public class ScriptBase {
    public static WebDriver driver;
    public static final Logger log=Logger.getLogger(ScriptBase.class.getName());
    public static ExtentReports extent;
    public static final String USERNAME="futureItVision";
    public static final String ACCESS_KEY="f927b277-969a-4791-8ca7-cb195b8cedf8";
    public static final String GET_URL="https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";

    public WebDriver getDriver() {
        return driver;
    }

    @Parameters("browser")
    @BeforeClass
    public void befortest(String browser) throws MalformedURLException {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
            driver=new ChromeDriver();

        }else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver");
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("safari")){
            System.setProperty("webdriver.safari.noinstall","true");
            driver=new SafariDriver();
        }else if(browser.equalsIgnoreCase("chromeSaucelab")){
            DesiredCapabilities caps=new DesiredCapabilities();
            /*caps.setBrowserName(browser);
            caps.setCapability("browserName","chrome");
            caps.setCapability("platform","Windows 8");
            caps.setCapability("version","54");*/

            caps.setBrowserName(browser);
            caps.setCapability("browserName","firefox");
            caps.setCapability("platform","LINUX");
            caps.setCapability("browserVersion","16");
            caps.setCapability("os","Linux");
            caps.setCapability("url","sauce-ondemand:?os=Linux&browser=firefox&browser-version=16");
            //caps.setCapability("tunnelIdentifier","futureItVision");
            caps.setBrowserName(System.getenv("SELENIUM_BROWSER"));
            caps.setVersion(System.getenv("SELENIUM_VERSION"));
            caps.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));


            driver=new RemoteWebDriver(new URL(GET_URL),caps);
        }

        driver.get("http://automationpractice.com/index.php");
    }


}
