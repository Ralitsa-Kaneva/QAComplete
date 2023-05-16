import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @FindBy(id = "input-firstname")
    static WebElement firstNameInputField;

    @FindBy(id = "input-lastname")
    static WebElement lastNameInputField;

    @FindBy(id = "input-email")
    static WebElement emailInputField;

    @FindBy(id = "input-telephone")
    static WebElement telephoneInputField;

    @FindBy(id = "input-password")
    static WebElement passwordInputField;

    @FindBy(id = "input-confirm")
    static WebElement passwordConfirmInputField;

    @FindBy(xpath = "//*[@class=\"radio-inline\"][1]/*[@type= \"radio\"] ")
    static WebElement subscribeRadioButtonYes;

    @FindBy(name = "agree")
    static WebElement agreeCheckbox;

    @FindBy(xpath = "//*[@value=\"Continue\"]")
    static WebElement buttonContinue;

    static {
        PageFactory.initElements(Browser.getDriver(),RegisterPage.class);
    }

    static String password;

    public static void enterFirstLastName(String firstName, String lastname) {
        firstNameInputField.sendKeys(firstName);
        lastNameInputField.sendKeys(lastname);
    }

    public static void enterEmail() {
        String emailPrefix = RandomStringUtils.randomAlphanumeric(5);
        String emailHost = RandomStringUtils.randomAlphabetic(3);
        String emailDomain = RandomStringUtils.randomAlphabetic(3);
        String randomEmail = emailPrefix + "@" + emailHost + "." + emailDomain;
        emailInputField.sendKeys(randomEmail);
    }

    public static void enterTelephoneNumber(){
        String telephoneNumberSuffix = RandomStringUtils.randomNumeric(8);
        String randomTelephoneNumber = "08" + telephoneNumberSuffix;
        telephoneInputField.sendKeys(randomTelephoneNumber);
    }

    public static void enterPassword() {
        password = RandomStringUtils.randomAlphanumeric(10);
        passwordInputField.sendKeys(password);
    }

    public static void confirmPassword() {
        passwordConfirmInputField.sendKeys(password);
    }

    public static void subscribe() {
        subscribeRadioButtonYes.click();
    }

    public static void acceptTerms() {
        agreeCheckbox.click();
    }

    public static void clickContinueButton() {
        buttonContinue.click();
    }
}
