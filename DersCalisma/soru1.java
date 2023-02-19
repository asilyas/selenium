package DersCalisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class soru1 {
     static   WebDriver driver;
  /*        1) Bir class oluşturun: YoutubeAssertions
            2) https://www.youtube.com adresine gidin
            3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
            ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
            ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
            ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
            ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin   */

    @BeforeClass
    public static void test1(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
    }
    @AfterClass
    public static void after(){
        driver.close();
    }


    @Test
    public void test02(){
        String actualTitleTest=driver.getTitle();
        String expectedTitle="YouTube";

        Assert.assertEquals(expectedTitle,actualTitleTest);
    }
   @Test
    public void test03(){
       WebElement Logo=driver.findElement(By.id("logo-icon"));

       Assert.assertTrue(Logo.isDisplayed());

   }
   @Test
    public void test04(){
        WebElement SEaarchBox=driver.findElement(By.id("search"));

        Assert.assertTrue(SEaarchBox.isEnabled());
   }
    @Test
    public void test05(){
      String Baslik=driver.getTitle();
      String Expected="youtube";

      Assert.assertNotEquals(Baslik,Expected);
    }

}
