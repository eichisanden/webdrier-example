import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverTest {
    @Test
    public void test() {
        ChromeDriverManager.getInstance().forceCache().setup();
        String driverPath = System.getProperty("webdriver.chrome.driver");
        System.out.println(driverPath);

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.google.com/");

        WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("Appium Advent Calendar 2017");
        element.submit();

        System.out.println(webDriver.getTitle());

        webDriver.quit();
    }
}
