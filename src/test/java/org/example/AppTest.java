package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.net.URL;

public class AppTest
{
    public static DesiredCapabilities capabilities;
    public static AndroidDriver<MobileElement> driver;

    @BeforeTest(description="Application Configuration")
    public static void InitialConfigTest() throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        //capabilities.setCapability("appPackage", "com.google.android.calculator");
        //capabilities.setCapability("appActivity", "com.google.android.calculator2.Calculator");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

    }
    @Test(description = "Verify Add Functionality")
    public static void InitialConfig() throws MalformedURLException, InterruptedException {
        URL url=new URL("http://0.0.0.0:4723/wd/hub");
        driver= new AndroidDriver<>(url,capabilities);
        Thread.sleep(3000);
        try {
            MobileElement two= driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sec.android.app.popupcalculator:id/calc_keypad_btn_02']"));
            MobileElement plus= driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sec.android.app.popupcalculator:id/calc_keypad_btn_add']"));
            MobileElement equal= driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal']"));
            two.click();
            Thread.sleep(1000);
            plus.click();
            Thread.sleep(1000);
            two.click();
            Thread.sleep(1000);
            equal.click();
            Thread.sleep(2500);
            MobileElement total= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
            String result=total.getText();
            //System.out.println("Output on Calc display: "+result);
            SoftAssert sa=new SoftAssert();
            sa.assertEquals(result,"4");
            sa.assertAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterTest(description = "Application Close")
    public static void tearDown(){
        driver.quit();
    }
}
