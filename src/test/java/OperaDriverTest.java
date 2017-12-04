import io.github.bonigarcia.wdm.OperaDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;


public class OperaDriverTest {
    @Test
    public void test() {
        OperaDriverManager.getInstance().setup();
        String driverPath = System.getProperty("webdriver.opera.driver");
        System.out.println(driverPath);

        WebDriver webDriver = new OperaDriver();
        webDriver.get("http://www.google.com/");

        WebElement element = webDriver.findElement(By.name("q"));
        element.sendKeys("Appium Advent Calendar 2017");
        element.submit();

        System.out.println(webDriver.getTitle());

        webDriver.quit();
    }
}
