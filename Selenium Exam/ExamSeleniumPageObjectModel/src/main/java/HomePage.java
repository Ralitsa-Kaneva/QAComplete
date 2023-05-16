import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//*[@class=\"dropdown\"]//*[@class=\"hidden-xs hidden-sm hidden-md\"]")
    static WebElement buttonMyAccount;

    @FindBy(xpath = "//*[@class=\"dropdown-menu dropdown-menu-right\"]//*[contains(text(),\"Register\")]")
    static WebElement registerOption;

    static String url = "http://shop.pragmatic.bg";

    static {
        PageFactory.initElements(Browser.getDriver(),HomePage.class);
    }

    public static void goTo() {
        Browser.getDriver().get(url);
    }

    public static void clickRegister() {
        buttonMyAccount.click();
        registerOption.click();
    }

}
