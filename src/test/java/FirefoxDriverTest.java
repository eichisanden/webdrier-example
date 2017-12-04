import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverTest {
    @Test
    public void test() {
        FirefoxDriverManager.getInstance().setup();
        String driverPath = System.getProperty("webdriver.gecko.driver");
        System.out.println(driverPath);

        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("http://www.google.com/");

        WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("Appium Advent Calendar 2017");
        element.submit();

        System.out.println(webDriver.getTitle());

        webDriver.quit();
    }
}
