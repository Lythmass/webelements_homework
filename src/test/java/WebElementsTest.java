
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class WebElementsTest extends TestCase {
    WebDriver driver;
    public WebElementsTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void firstTest () throws InterruptedException {
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
}
