package classroom_day3;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionsChaining {

    WebDriver driver;

    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.get("http://demo.automationtesting.in/Register.html");
    }

    public void tryOptionsInActionsClass() {
        WebElement interactionsLink = driver.findElement(By.xpath("//a[contains(text(),'Interactions ')]"));
        WebElement dragAndDropLink = driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]"));
        WebElement staticLink = driver.findElement(By.xpath("//a[contains(text(),'Static')]"));
        WebElement dynamicLink = driver.findElement(By.xpath("//a[contains(text(),'Dynamic')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(interactionsLink).moveToElement(dragAndDropLink).moveToElement(dynamicLink).click().perform();
        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle, "expected Title");
    }

    public static void main(String[] args) {
        ActionsChaining webDriverCommands = new ActionsChaining();
        webDriverCommands.browserSetup();
        webDriverCommands.tryOptionsInActionsClass();

    }
//CE:http://demo.guru99.com/test/delete_customer.php
}
