package classroom_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Synchronization_FluentWait_WebElement {

    WebDriver driver;

    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, SECONDS);
        driver.get("https://www.naukri.com/");
    }

    public void handleWindows() {
        Boolean isNumberOfWindowsAreExpected = new WebDriverWait(driver, 30).until(ExpectedConditions.numberOfWindowsToBe(4));
        if (isNumberOfWindowsAreExpected) {
            String parentWindowHandle = driver.getWindowHandle();
            System.out.println("Current window handle is---->" + parentWindowHandle);
            Set<String> windowHandles = driver.getWindowHandles();


            for (String windowHandleID : windowHandles) {
                System.out.println("Window handle id---->" + windowHandleID);
                if (!parentWindowHandle.equals(windowHandleID)) {
                    driver.switchTo().window(windowHandleID);
                    driver.close();
                }
            }
            Boolean isOnlyWindowPresent = new WebDriverWait(driver, 30)
                    .until(ExpectedConditions.numberOfWindowsToBe(1));

            if (isOnlyWindowPresent) {
                driver.switchTo().window(parentWindowHandle);

                //EXPLICIT WAIT
                WebElement searchButton = new WebDriverWait(driver, 30)
                        .until(ExpectedConditions.visibilityOfElementLocated(By.id("qsb-keyword-sugg")));
                searchButton.sendKeys("Selenium");

                //FLUENT WAIT
                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(5))
                        .ignoring(NoSuchElementException.class);

                WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return driver.findElement(By.xpath("//button[text()='Search']"));
                    }
                });
                webElement.click();

            }
        }
    }

    public static void main(String[] args) {
        day3.Synchronization_FluentWait_WebElement webDriverCommands = new day3.Synchronization_FluentWait_WebElement();
        webDriverCommands.browserSetup();
        webDriverCommands.handleWindows();

    }
}
//CE:http://demo.guru99.com/popup.php
//    https://www.seleniumeasy.com/test/window-popup-modal-demo.html
