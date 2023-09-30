
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;


public class WebElementsTest extends TestCase {
    WebDriver driver;
    public WebElementsTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void firstTest () {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls"); // easy!
        System.out.println(driver.getTitle()); // very good!

        WebElement button = driver.findElement(By.xpath("//button[text()='Remove']"));
        System.out.println(button.isEnabled());
        button.click(); // clicked!

        while(true) {
            if (button.getText().equals("Add")) {
                break;
            }
        }
        System.out.println(button.getText()); //Add

        WebElement isGone = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println(isGone.getText());

        driver.quit();
    }

    @Test
    public void secondTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        WebElement elementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i < 3; i++) elementButton.click(); //3 times!

        WebElement lastDeleteButton = driver.findElement(By.cssSelector("div#elements button:last-child"));
        System.out.println(lastDeleteButton.getText()); // Last one!

        System.out.println(GetSecondTestDeleteButtonsSize()); // 3

        driver.findElement(By.xpath("//button[contains(@class, 'added')][last()]")).click();
        System.out.println(GetSecondTestDeleteButtonsSize()); // 2

        driver.quit();
    }

    public int GetSecondTestDeleteButtonsSize() {
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        return deleteButtons.size();
    }
}
