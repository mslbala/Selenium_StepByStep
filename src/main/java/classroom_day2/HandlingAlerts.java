package classroom_day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingAlerts {
    WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
    }

    public void handleAlerts() throws InterruptedException {

        //Handle simple alert
        driver.findElement(By.xpath("(//button[text()='Click me!'])[1]")).click();
        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
        System.out.println("Text in simple alert is "+text);
        alert.accept();

        //Handle confirmation alert
        driver.findElement(By.xpath("(//button[text()='Click me!'])[2]")).click();
        alert.dismiss();

        //Handle prompt alert
        driver.findElement(By.xpath("//button[text()='Click for Prompt Box']")).click();
//        Thread.sleep(10000);
        alert.sendKeys("Bala handles prompt alert");
        alert.accept();

    }


    public static void main(String[] args) throws InterruptedException {
        HandlingAlerts handleAlertsObject = new HandlingAlerts();
        handleAlertsObject.setUp();
        handleAlertsObject.handleAlerts();


    }

}
