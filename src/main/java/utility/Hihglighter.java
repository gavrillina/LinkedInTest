package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hihglighter    {
    public static void highlightElement(WebElement element) {

        WebDriver driver = WebDriverSingleton.getDriver();
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='5px solid green'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }
}
