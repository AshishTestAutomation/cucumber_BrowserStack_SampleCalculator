package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SmokeTests {
    public static DesiredCapabilities capabilities;
    public static AndroidDriver<MobileElement> driver;
    public static MobileElement two, plus, equal, total, minus, clear, mul, div;

    @Given("Open Calculator")
    public void open_calculator() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RZ8M92XTTKL");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(url, capabilities);
        two = driver.findElement(By.xpath("//android.widget.Button[@index='13']"));
        plus = driver.findElement(By.xpath("//android.widget.Button[@index='15']"));
        minus = driver.findElement(By.xpath("//android.widget.Button[@index='11']"));
        mul = driver.findElement(By.xpath("//android.widget.Button[@index='7']"));
        div = driver.findElement(By.xpath("//android.widget.Button[@index='3']"));
        equal = driver.findElement(By.xpath("//android.widget.Button[@index='19']"));
        total = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
        clear = driver.findElement(By.xpath("//android.widget.Button[@index='0']"));
    }

    @When("adding number {int} and number {int}")
    public void adding_number_and_number(Integer int1, Integer int2) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            plus.click();
            two.click();
            equal.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Result should be sum of the two given numbers")
    public void result_should_be_sum_of_the_two_given_numbers() {
        String result = total.getText();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(result, "4", "Addition is wrong");
        sa.assertAll();
    }

    @When("Subtracting number {int} and number {int}")
    public void subtractingNumberAndNumber(int arg0, int arg1) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            minus.click();
            two.click();
            equal.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Result should be deduction of the two given numbers")
    public void result_should_be_deduction_of_the_two_given_numbers() {
        String result = total.getText();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(result, "0", "Subtraction is wrong");
        sa.assertAll();
    }

    @When("Multiplying number {int} and number {int}")
    public void multiplying_number_and_number(Integer int1, Integer int2) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            mul.click();
            two.click();
            equal.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Result should be the multiplication of the two given numbers")
    public void result_should_be_the_multiplication_of_the_two_given_numbers() {
        String result = total.getText();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(result, "4", "Multiplication is wrong");
        sa.assertAll();
    }

    @When("Dividing number {int} and number {int}")
    public void dividing_number_and_number(Integer int1, Integer int2) {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            two.click();
            div.click();
            two.click();
            equal.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("Result should be the division of the two given numbers")
    public void result_should_be_the_division_of_the_two_given_numbers() {
        String result = total.getText();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(result, "1", "Division is wrong");
        sa.assertAll();
        driver.quit();
    }
}