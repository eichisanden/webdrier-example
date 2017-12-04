import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.grid.selenium.GridLauncherV3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.net.PortProber.findFreePort;


public class SeleniumGridTest {
    @Before
    public void setup() throws Exception {
        // Setup Chrome webdriver
        ChromeDriverManager.getInstance().forceCache().setup();
        String driverPath = System.getProperty("webdriver.chrome.driver");
        System.out.println(driverPath);

        // Start hub
        GridLauncherV3.main(new String[]{"-port", "4444"});
        // Start node
        GridLauncherV3.main(new String[]{"-port", "5555",
                "-role", "node",
                "-hub", "http://localhost:4444/grid/register"
        });

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = WebDriverRunner.CHROME;
    }

    @Test
    public void test() {
        open("http://www.google.com/");
        $(By.name("q")).val("Appium Advent Calendar 2017").submit();
        System.out.println(title());
    }

    @After
    public void tearDown() {
        close();
    }
}
