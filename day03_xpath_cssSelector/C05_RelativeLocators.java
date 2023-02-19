package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) {
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html\n");

        WebElement berlinElementi = driver.findElement(By.xpath("//*[@*='pid7_thumb']"));
        WebElement nycElementi = driver.findElement(By.xpath("//*[@*='pid3_thumb']"));
        WebElement bostonElementi = driver.findElement(By.xpath("//*[@*='pid6_thumb']"));
        WebElement seilorElementi = driver.findElement(By.xpath("//*[@*='pid11_thumb']"));



    }
}
