import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterUser {
    private WebDriver browser;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        browser.get("http://shop.pragmatic.bg");
    }

    @AfterMethod
    public void exitBrowser() {
        browser.quit();
    }

    @Test
    public void registerUser() {
        //Click on MyAccount button
        WebElement buttonMyAccount = browser.findElement(By.xpath("//*[@class=\"dropdown\"]//*[@class=\"hidden-xs hidden-sm hidden-md\"]"));
        buttonMyAccount.click();
        //Click Register from the list
        WebElement myAccountDropDown = browser.findElement(By.xpath("//*[@class=\"dropdown-menu dropdown-menu-right\"]//*[contains(text(),\"Register\")]"));
        myAccountDropDown.click();
        //Enter First name
        WebElement firstNameInputField = browser.findElement(By.id("input-firstname"));
        firstNameInputField.sendKeys("Ralitsa");
        //Enter Last name
        WebElement lastNameInputField = browser.findElement(By.id("input-lastname"));
        lastNameInputField.sendKeys("Kaneva");
        //Enter email
        WebElement emailInputField = browser.findElement(By.id("input-email"));
        String emailPrefix = RandomStringUtils.randomAlphanumeric(5);
        String emailHost = RandomStringUtils.randomAlphabetic(3);
        String emailDomain = RandomStringUtils.randomAlphabetic(3);
        String randomEmail = emailPrefix + "@" + emailHost + "." + emailDomain;
        emailInputField.sendKeys(randomEmail);
        //Enter telephone
        WebElement telephoneInputField = browser.findElement(By.id("input-telephone"));
        String telephoneNumberSuffix = RandomStringUtils.randomNumeric(8);
        String randomTelephoneNumber = "08" + telephoneNumberSuffix;
        telephoneInputField.sendKeys(randomTelephoneNumber);
        //Enter password
        WebElement passwordInputField = browser.findElement(By.id("input-password"));
        String password = RandomStringUtils.randomAlphanumeric(10);
        passwordInputField.sendKeys(password);
        //ConfirmPassword
        WebElement passwordConfirmInputField = browser.findElement(By.id("input-confirm"));
        passwordConfirmInputField.sendKeys(password);
        //Select subscription
        WebElement subscribeRadioButtonYes = browser.findElement(By.xpath("//*[@class=\"radio-inline\"][1]/*[@type= \"radio\"] "));
        subscribeRadioButtonYes.click();
        //Accept Terms
        WebElement agreeCheckbox = browser.findElement(By.name("agree"));
        agreeCheckbox.click();
        //Continue
        WebElement buttonContinue = browser.findElement(By.xpath("//*[@value=\"Continue\"]"));
        buttonContinue.click();

        //Verify the registration
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"btn btn-primary\"]")));
        WebElement successMessage = browser.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        String actualSuccessMessage = successMessage.getText();
        Assert.assertEquals(actualSuccessMessage,"Your Account Has Been Created!");

    }
}
