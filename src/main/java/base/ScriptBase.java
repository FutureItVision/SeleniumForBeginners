package base;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

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
    @Parameters({"browser","environment"})
    @BeforeClass
    public void beforeTest(String browser,String environment) throws MalformedURLException, InterruptedException {

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--kiosk");
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver");
            driver = new ChromeDriver(chromeOptions);
        }  else if (browser.equalsIgnoreCase("sauceLabChrome")) {
            System.out.println(" Executing on CHROME");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(browser);
            caps.setCapability("browserName", "chrome");
            caps.setCapability("platform", "macOS 10.13");
            caps.setCapability("version", "latest");caps.setCapability("tunnel-identifier", "mplatformTunnel");
            driver = new RemoteWebDriver(new URL(URL), caps);

        } else if (browser.equalsIgnoreCase("sauceLabFirefox")) {
            System.out.println(" Executing on Firefox");
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setBrowserName(browser);
            caps.setCapability("browserName","firefox");
            caps.setCapability("version", "latest");
            //caps.setCapability("tunnel-identifier", "mplatformTunnel");
            driver = new RemoteWebDriver(new URL(URL), caps);

        }
        else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");
            driver = new FirefoxDriver();
            System.out.println(" Executing on FireFox");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }


        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

    }
}
