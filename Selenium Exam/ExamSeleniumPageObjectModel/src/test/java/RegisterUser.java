import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUser {
    @BeforeMethod
    public void setupDriver() {
        Browser.setup();
    }

    @AfterMethod
    public void quitBrowser() {
        Browser.exitBrowser();
    }

    @Test
    public void registerUserTest() {
        HomePage.goTo();
        HomePage.clickRegister();
        RegisterPage.enterFirstLastName("Ralitsa","Kaneva");
        RegisterPage.enterEmail();
        RegisterPage.enterTelephoneNumber();
        RegisterPage.enterPassword();
        RegisterPage.confirmPassword();
        RegisterPage.subscribe();
        RegisterPage.acceptTerms();
        RegisterPage.clickContinueButton();
        RegistrationCompletePage.verifyRegistrationIsComplete("Your Account Has Been Created!");

    }
}
