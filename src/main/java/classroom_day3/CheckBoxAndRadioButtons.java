package classroom_day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxAndRadioButtons {

    WebDriver driver;

    public void browserSetup() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//main//resources//drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/radio.html");
    }

    public void handleRadioButtons() {
        List<WebElement> radioButtonElements = driver.findElements(By.xpath("//*[@type='radio']"));


        // To print the text of each radio button and to click on it
        for (WebElement e : radioButtonElements) {
            System.out.println("Value of the element--->" + e.getAttribute("value"));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            e.click();
        }
        WebElement secondRadioButton = driver.findElement(By.xpath("//*[@type='radio'][2]"));
        WebElement thirdRadioButton = driver.findElement(By.xpath("//*[@type='radio'][3]"));
        secondRadioButton.click();
        if (!thirdRadioButton.isSelected()) {
            System.out.println("Third Radio button is not selected succesfully");
        }
        if (secondRadioButton.isSelected()) {
            System.out.println("Second Radio button is  selected succesfully");
        }


    }

    public void handleCheckbox() {
        List<WebElement> checkBoxElements = driver.findElements(By.xpath("//*[@type='checkbox']"));
        int i = 1;
        for (WebElement checkBox : checkBoxElements) {
            checkBox.click();
            if (checkBox.isSelected()) {
                System.out.println("Checkbox " + i + " is selected successfully!");
            }

            checkBox.click();
            if (!checkBox.isSelected()) {
                System.out.println("Checkbox " + i + " is deselected successfully!");
            }
            i++;
        }

    }

    public static void main(String[] args) {
      CheckBoxAndRadioButtons webDriverCommands = new CheckBoxAndRadioButtons();
        try {

            webDriverCommands.browserSetup();
            webDriverCommands.handleCheckbox();
        }
        catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            webDriverCommands.driver.quit();
        }

//        webDriverCommands.handleRadioButtons();

    }
//CE:https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
}
