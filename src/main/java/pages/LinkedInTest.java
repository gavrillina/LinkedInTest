package pages;

import buissnes_object.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseTest;
import utility.WebDriverSingleton;

public class LinkedInTest extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    private static final String START_URL = "https://linkedin.com";


    @BeforeTest
    private void openBrowserAndDoLogin() {

        driver = WebDriverSingleton.getDriver();
        driver.get(START_URL);
    }

    @Test(dataProvider = "testDataForLogIn")
    private void logIn(User user) {
        loginPage = new LoginPage(driver);
        loginPage.logIn(user);
    }

    @Test(dependsOnMethods = "logIn")
    private void fillDataBD() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.fillBrthdayData();

    }

    @AfterTest
    private void closeBrowser() {

        driver.quit();
    }


    @DataProvider
    public Object[][] testDataForLogIn() {

        return new Object[][]{{User.LOGIN}};
    }

}
