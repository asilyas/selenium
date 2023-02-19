package DersCalisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class soru2 {
     static WebDriver driver;

      @BeforeClass
      public static void setup() {
          WebDriverManager.edgedriver().setup();
          driver= new EdgeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          driver.get("https://www.amazon.com");
          driver.navigate().refresh();

    }
    @AfterClass
    public static void teardown(){
          driver.close();
    }
    @Test
    public void test1(){
          WebElement AppleTikla =driver.findElement(By.id("twotabsearchtextbox"));
          AppleTikla.sendKeys("Apple");
          driver.findElement(By.id("nav-search-submit-button")).click();

          driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[2]")).click();

         driver.findElement(By.id("landingImage")).click();


    }
@Test
    public void test2(){
      WebElement resim= driver.findElement(By.id("landingImage"));
    Assert.assertTrue(resim.isDisplayed());

}
}


