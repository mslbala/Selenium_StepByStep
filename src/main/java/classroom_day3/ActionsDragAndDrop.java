package classroom_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionsDragAndDrop {

    WebDriver driver;

    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.get("http://way2automation.com/way2auto_jquery/droppable.php");
    }

    public void tryOptionsInActionsClass() {
        driver.switchTo().frame(0);
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(draggableElement));
        WebElement droppableElement = driver.findElement(By.id("droppable"));
        System.out.println("Size of the element=" + droppableElement.getSize());
        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggableElement, droppableElement).perform();

        driver.findElement(By.linkText("Revert draggable Position")).click();

    }


    /*public void tryActionsClass() {
        WebElement frameElement = driver.findElement(By.xpath("(//iframe)[1]"));
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));

        WebElement dragElement = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')][1]"));
        WebElement dropElement = driver.findElement(By.xpath("//p[contains(text(),'Drop here')][1]"));

        Actions actionsObject = new Actions(driver);
        actionsObject.dragAndDrop(dragElement, dropElement).perform();
        actionsObject.sendKeys("Bala");

//        actionsObject.dragAndDropBy(source,xOffSet,yOffSet).perform(); --->how to get the co-ordinates -> use getSize();
//        actionsObject.sendKeys(Keys.CONTROL).sendKeys(Keys.ENTER).perform();
//        actionsObject.moveToElement(element1Locator).moveToElement(element2Locator).click().perform();
//        actionsObject.clickAndHold(element).doubleClick().release().contextClick().

    }
*/
    public static void main(String[] args) {
        day3.ActionsDragAndDrop webDriverCommands = new day3.ActionsDragAndDrop();
        webDriverCommands.browserSetup();

        webDriverCommands.tryOptionsInActionsClass();

    }
//CE:http://demo.guru99.com/test/drag_drop.html
}
