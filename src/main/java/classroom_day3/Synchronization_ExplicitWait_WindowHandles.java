package classroom_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Synchronization_ExplicitWait_WindowHandles {

    WebDriver driver;

    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.naukri.com/");
    }

    public void handleWindows() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.numberOfWindowsToBe(3));


        Boolean isNumberOfWindowsAreExpected = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.numberOfWindowsToBe(3));


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
            Boolean isOnlyWindowPresent = new WebDriverWait(driver, 30).until(ExpectedConditions.numberOfWindowsToBe(1));
            if (isOnlyWindowPresent) {
                driver.switchTo().window(parentWindowHandle);

                WebElement searchButton = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("qsb-keyword-sugg")));
                searchButton.sendKeys("Selenium");
                driver.findElement(By.xpath("//button[text()='Search']")).click();
            }
        }

    }

    public static void main(String[] args) {
        Synchronization_ExplicitWait_WindowHandles webDriverCommands = new Synchronization_ExplicitWait_WindowHandles();
        webDriverCommands.browserSetup();
        webDriverCommands.handleWindows();

    }
//CE:http://demo.guru99.com/popup.php
//    https://www.seleniumeasy.com/test/window-popup-modal-demo.html
}
