package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class MYM_SmokeTests {

    public static DesiredCapabilities capabilities;
    public AndroidDriver<MobileElement> driver;
    public static MobileElement CountryLanguagesTitle,allLanguages,countLang, ukEng,validate,accept,okBtn,slang,modif,signIn,email,SignInBtn,
            pwd,error;

    @Given("Application is opened")
    public void application_is_opened() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8M92XTTKL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability("appPackage", "com.psa.mym.myds");
        capabilities.setCapability("appActivity", "com.psa.mym.activity.SplashscreenActivity");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(url, capabilities);
    }

    @Then("Accept the message")
    public void accept_the_message() {
        try {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            accept = driver.findElement(By.xpath("//android.widget.TextView[@text='ACCEPTER']"));
            if (accept.isDisplayed()) {
                accept.click();
            }
            //driver.switchTo().activeElement().click();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("Click on Modifier")
    public void click_on_modifier() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<MobileElement> AllElements = (List<MobileElement>) driver.findElements(By.className("android.widget.TextView"));

            for (MobileElement ele : AllElements)
            {
                if(ele.getAttribute("text").equalsIgnoreCase("MODIFIER")){
                    driver.findElement(By.id("com.psa.mym.myds:id/btn_edit")).click();
                    Thread.sleep(2000);
                }

            }

        } catch (NoSuchElementException | InterruptedException e) {
            e.getLocalizedMessage();
        }
    }

    @Then("User should be Moved to Country-Language Screen")
    public void user_should_be_moved_to_country_language_screen() {

        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            SoftAssert sa = new SoftAssert();
            CountryLanguagesTitle=driver.findElement(By.xpath("//android.widget.TextView[@text='Pays - Langue']"));
            String countryLanguage = CountryLanguagesTitle.getText();
            sa.assertEquals(countryLanguage, "Pays - Langue");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("select United Kingdom \\(English)")
    public void select_united_kingdom_english() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            List<MobileElement> AllLang = (List<MobileElement>) driver.findElements(By.id("com.psa.mym.myds:id/radioButton"));
            for (MobileElement lang : AllLang)
            {
                    if (lang.getAttribute("text").equalsIgnoreCase("United Kingdom (English)")!=true) {
                        //MobileElement LanguageIndex = driver.findElement(By.xpath("//android.widget.RelativeLayout[@index="+i+"]"));
                        MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
                                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + "United Kingdom (English)" + "\"));");
                        el.click();
                        Thread.sleep(2000);
                        break;
                    }



            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("click on OK button")
    public void click_on_ok_button() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            okBtn = driver.findElement(By.id("com.psa.mym.myds:id/validateButton"));
            okBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Language should be changed to United Kingdom \\(English)")
    public void language_should_be_changed_to_united_kingdom_english() {
        try {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            slang = driver.findElement(By.id("com.psa.mym.myds:id/txt_language"));
            String selectedlang = slang.getAttribute("text");
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(selectedlang, "Country: United Kingdom  / Language: English ");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Modifier should by changed with Modify")
    public void modifier_should_by_changed_with_modify() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            modif = driver.findElement(By.id("com.psa.mym.myds:id/btn_edit"));
            String mod = modif.getAttribute("text");
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(mod, "MODIFY");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("click on SIGN IN button")
    public void click_on_sign_in_button() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            signIn = driver.findElement(By.id("com.psa.mym.myds:id/btnConnexion"));
            signIn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("User should be moved to Sign IN Account screen")
    public void user_should_be_moved_to_sign_in_account_screen() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            email = driver.findElement(By.id("com.psa.mym.myds:id/editEmail"));
            String emailLabel = email.getAttribute("text");
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(emailLabel, "Email");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Sign In button should be disabled")
    public void sign_in_button_should_be_disabled() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            SignInBtn=driver.findElement(By.id("com.psa.mym.myds:id/btnConnexion"));
            String emailLabel = SignInBtn.getAttribute("enabled");
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(emailLabel, "false");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("Enter Invalid username")
    public void enter_invalid_username() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            email = driver.findElement(By.id("com.psa.mym.myds:id/editEmail"));
            email.sendKeys("sdhgdjhgajgdj@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("Enter Invalid password")
    public void enter_invalid_password() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            pwd=driver.findElement(By.id("com.psa.mym.myds:id/editPassword"));
            pwd.sendKeys("sdhgdjhgajgdj@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Sign In button should be enabled")
    public void sign_in_button_should_be_enabled() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            SignInBtn=driver.findElement(By.id("com.psa.mym.myds:id/btnConnexion"));
            Thread.sleep(500);
            String SignInActInact = SignInBtn.getAttribute("enabled");
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(SignInActInact, "true");
            SignInBtn.click();
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Inline error message should appear")
    public void inline_error_message_should_appear() {
        try {
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            error = driver.findElement(By.id("com.psa.mym.myds:id/tv_errorMessage"));
            String errorMsg = error.getAttribute("text");
            SoftAssert sa = new SoftAssert();
            sa.assertEquals(errorMsg, "Incorrect email or password");
            sa.assertAll();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}