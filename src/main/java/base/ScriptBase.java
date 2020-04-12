package base;
import com.relevantcodes.extentreports.ExtentReports;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public static final String USERNAME="khanjada";
    public static final String ACCESS_KEY="52e6f143-6938-432e-b449-10b965aae045";
    public static final String URL="https://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:443/wd/hub";
    public static ExtentReports extent;
    public WebDriverWait wait;

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
        }
        else if(browser.equalsIgnoreCase("sauceLabChrome")){
            DesiredCapabilities caps=new DesiredCapabilities();
            caps.setCapability("browserName","chrome");
            caps.setCapability("platform","macOS 10.13");
            caps.setCapability("version","latest");
            caps.setCapability("tunnel-identifier","futureItVision");
            driver=new RemoteWebDriver(new URL(URL),caps);
        }
        driver.get("http://automationpractice.com/index.php");
    }


}
