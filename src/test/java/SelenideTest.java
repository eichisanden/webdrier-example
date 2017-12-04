import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideTest {
    @Test
    public void test() {

        System.setProperty("wdm.chromeDriverVersion", "2.32");

        Configuration.browser = WebDriverRunner.CHROME;
        open("http://www.google.com/");

        String driverPath = System.getProperty("webdriver.chrome.driver");
        System.out.println(driverPath);

        $(By.name("q")).val("Appium Advent Calendar 2017").submit();

        System.out.println(Selenide.title());
    }
}
