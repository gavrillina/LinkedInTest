package pages;

import buissnes_object.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Hihglighter;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='login-email']")
    private WebElement loginField;

    @FindBy(xpath = ".//*[@id='login-password']")
    private WebElement passworFiel;

    @FindBy(xpath = ".//*[@id='login-submit']")
    private WebElement loginButton;


    public void logIn(User user) {

        waitForElementToBeClickable(loginField);
        loginField.sendKeys(user.getUSERNAME());
        Hihglighter.highlightElement(loginField);

        waitForElementToBeClickable(passworFiel);
        passworFiel.sendKeys(user.getUSERPASSWORD());

        Hihglighter.highlightElement(passworFiel);
        waitForElementToBeClickable(loginButton);

        Hihglighter.highlightElement(loginField);
        loginButton.click();


    }
}
