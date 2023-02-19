package day04_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C07_ilkAssertion {
    static WebDriver driver;
    /*
    1- Bir class oluşturun: BestBuyAssertions
    2- https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    3- Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin
    4- titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    5- logoTest => BestBuy logosunun görüntülendigini test edin
    6- FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    @BeforeClass
    public static void setup(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }
    @Test
   public void test02(){
        String expectedIcerik="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedIcerik));

   }
   @Test
   public void test03(){
       WebElement logoElementi=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
      Assert.assertTrue(logoElementi.isDisplayed());
   }
   @Test
   public  void test04(){
        WebElement frncaLink=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(frncaLink.isDisplayed());
   }
}
