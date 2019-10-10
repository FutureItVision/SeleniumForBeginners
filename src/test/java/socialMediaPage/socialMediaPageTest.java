package socialMediaPage;

import base.ScriptBase;
import controller.LoginPage;
import controller.SocialMediaPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class socialMediaPageTest extends ScriptBase {
SocialMediaPage socialMediaPage;

    @BeforeTest
    public void beforetest(){

        init();
    }

    @Test
    public void verifyFacebookPage() {
        socialMediaPage = new SocialMediaPage(driver);
        socialMediaPage.socialMediaPageVerification("facebook",driver,"Selenium Framework Public Group | Faceboo");

    }

    @Test
    public void verifyTwitterPage() {
        socialMediaPage = new SocialMediaPage(driver);
        socialMediaPage.socialMediaPageVerification("twitter",driver,"Selenium Framework (@seleniumfrmwrk) | Twitter");

    }

    @Test
    public void verifyYoutubePage() {
        socialMediaPage = new SocialMediaPage(driver);
        socialMediaPage.socialMediaPageVerification("youtube",driver,"Selenium Framework - YouTube");

    }
}

