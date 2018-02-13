package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utility.Hihglighter;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = ".//*[@class='launchpad-card fl launchpad-add-full-profile-info launchpad-card--size-large launchpad-add-full-profile-info--is-start-date-treatment ember-view launchpad-card--is-selected']")
    private WebElement blockSelfInformaation;

    @FindBy(xpath = ".//*[@name='startMonth']")
    private WebElement selectMonth;

    @FindBy(xpath = ".//*[@id='launchpad-add-full-profile-info-start-date-year-select']")
    private WebElement selectYear;

    @FindBy(xpath = ".//*[@class='button-primary-small launchpad-add-full-profile-info__start-date-save']")
    private WebElement saveButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectMonth() {

        waitForElementToBeClickable(blockSelfInformaation);
        Hihglighter.highlightElement(blockSelfInformaation);
        waitForElementToBeClickable(selectMonth);
        Hihglighter.highlightElement(selectMonth);

        selectMonth.click();

        Select selMonth = new Select(selectMonth);
        selMonth.selectByIndex(12);
    }

    public void selectYear() {

        Hihglighter.highlightElement(selectYear);
        waitForElementToBeClickable(selectYear);
        selectYear.click();

        Select selYear = new Select(selectYear);
        selYear.selectByValue("1991");

        selectYear.click();
    }

    public void fillBrthdayData() throws InterruptedException {

        selectMonth();
        selectYear();

        waitForElementToBeClickable(saveButton);
        Hihglighter.highlightElement(saveButton);
        saveButton.click();

        Thread.sleep(3000);

    }
}


