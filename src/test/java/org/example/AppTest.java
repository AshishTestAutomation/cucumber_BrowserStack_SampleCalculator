package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppTest
{
    public static DesiredCapabilities capabilities;
    public static AndroidDriver<MobileElement> driver;
    public static MobileElement two,plus,equal,total,minus,clear,mul,div;

    @BeforeTest(description="Application Configuration")
    public static void InitialConfigTest() throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8M92XTTKL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        URL url=new URL("http://0.0.0.0:4723/wd/hub");
        driver= new AndroidDriver<>(url,capabilities);
        two= driver.findElement(By.xpath("//android.widget.Button[@index='13']"));
        plus= driver.findElement(By.xpath("//android.widget.Button[@index='15']"));
        minus= driver.findElement(By.xpath("//android.widget.Button[@index='11']"));
        mul= driver.findElement(By.xpath("//android.widget.Button[@index='7']"));
        div= driver.findElement(By.xpath("//android.widget.Button[@index='3']"));
        equal= driver.findElement(By.xpath("//android.widget.Button[@index='19']"));
        total= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        clear=driver.findElement(By.xpath("//android.widget.Button[@index='0']"));

    }

    @BeforeMethod(description="Application Configuration")
    public static void clearMsgDisplay() throws MalformedURLException, InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            if (clear.isDisplayed()) {
                clear.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test(description = "Verify Add Functionality")
    public static void Test_1_Add() throws MalformedURLException, InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            plus.click();
            two.click();
            equal.click();
            String result=total.getText();
            SoftAssert sa=new SoftAssert();
            sa.assertEquals(result,"4","Addition is wrong");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(description = "Verify Subtraction Functionality")
    public static void Test_2_sub() throws MalformedURLException, InterruptedException {

        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            minus.click();
            two.click();
            equal.click();
            String result=total.getText();
            SoftAssert sa=new SoftAssert();
            sa.assertEquals(result,"0","Subtraction is wrong");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(description = "Verify Multiplication Functionality")
    public static void Test_3_Mul() throws MalformedURLException, InterruptedException {

        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            mul.click();
            two.click();
            equal.click();
            String result=total.getText();
            SoftAssert sa=new SoftAssert();
            sa.assertEquals(result,"4","Subtraction is wrong");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(description = "Verify Division Functionality")
    public static void Test_4_Div() throws MalformedURLException, InterruptedException {

        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            div.click();
            two.click();
            equal.click();
            String result=total.getText();
            SoftAssert sa=new SoftAssert();
            sa.assertEquals(result,"1","Subtraction is wrong");
            sa.assertAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @AfterTest(enabled=true,description = "Application Close")
    public static void tearDown(){
        driver.quit();
    }
}
