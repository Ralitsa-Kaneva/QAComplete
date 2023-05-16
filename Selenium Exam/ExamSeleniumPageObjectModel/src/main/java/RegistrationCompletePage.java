import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class RegistrationCompletePage {

    @FindBy(xpath = "//*[@class=\"btn btn-primary\"]")
    private static WebElement buttonContinue;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    private static WebElement successMessage;

    static {
        PageFactory.initElements(Browser.getDriver(), RegistrationCompletePage.class);
    }

    public static void verifyRegistrationIsComplete(String expectedSuccessMessage) {
        Browser.getWait().until(ExpectedConditions.elementToBeClickable(buttonContinue));
        String actualSuccessMessage = successMessage.getText();
        Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);
    }
}
