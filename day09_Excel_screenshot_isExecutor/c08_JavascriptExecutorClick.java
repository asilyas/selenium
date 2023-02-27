package day09_Excel_screenshot_isExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class c08_JavascriptExecutorClick extends TestBase {
    @Test
    public void test01(){

        driver.get("https://wisequarter.com");
        driver.navigate().refresh();

        WebElement otomasyonElementi=driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));

        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView();",otomasyonElementi);

        bekle(2);

        jse.executeScript("arguments[0].click();",otomasyonElementi);

        bekle(2);

        jse.executeScript("alert('JUnit Bitti');");

        bekle(2);
    }
}
