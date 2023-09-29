
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementsTest extends TestCase {
    WebDriver driver;
    public WebElementsTest(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }
    @Test
    public void firstTest () throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.quit();
    }
}
