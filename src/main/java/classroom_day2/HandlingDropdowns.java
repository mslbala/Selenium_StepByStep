package classroom_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandlingDropdowns {
    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("//F://Selenium_July//Day 2/Dropdowns.html");
    }

    public void handleMultipleWindows() throws InterruptedException {
        WebElement browsersDropdown = driver.findElement(By.name("Browsers"));
        Select selectObject = new Select(browsersDropdown);

        selectObject.selectByVisibleText("Opera");
        Thread.sleep(5000);
        selectObject.selectByIndex(1);
        Thread.sleep(5000);
        selectObject.selectByValue("3");

        List<WebElement> allDropdownOptions = selectObject.getOptions();
        for (WebElement eachValueInDropDown : allDropdownOptions) {
            System.out.println("Value in dropdown :" + eachValueInDropDown.getText());
        }
//        selectObject.deselectAll();
    }


    public static void main(String[] args) throws InterruptedException {
        HandlingDropdowns handleAlertsObject = new HandlingDropdowns();
        handleAlertsObject.setUp();
        handleAlertsObject.handleMultipleWindows();


    }

}
