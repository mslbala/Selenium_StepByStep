package classroom_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrames {
    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("http://www.londonfreelance.org/courses/frames/index.html");
    }

    public void handleFrames() throws InterruptedException {
        //switch frame using frame name or id
        driver.switchTo().frame("main");
        String textInTop = driver.findElement(By.xpath("/html/body/h2")).getText();
        System.out.println("Text at the top of the frame main------>" + textInTop);
        driver.switchTo().defaultContent();

        //switch frame using frame index
        driver.switchTo().frame(3);
        driver.findElement(By.linkText("Sample content")).click();
        driver.switchTo().defaultContent();

        //switch frame using web element
        WebElement sixthFrameElement = driver.findElement(By.xpath("(//frame)[6]"));
        driver.switchTo().frame(sixthFrameElement);
        String textInFooter = driver.findElement(By.xpath("/html/body/h2")).getText();
        System.out.println("Text at footer ------>" + textInFooter);


    }


    public static void main(String[] args) throws InterruptedException {
        HandlingFrames handleAlertsObject = new HandlingFrames();
        handleAlertsObject.setUp();
        handleAlertsObject.handleFrames();


    }

}
