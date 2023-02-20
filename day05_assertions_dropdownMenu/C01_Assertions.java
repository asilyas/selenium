package day05_assertions_dropdownMenu;

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

public class C01_Assertions {
    /*

       1) Bir class oluşturun: YoutubeAssertions
       2) https://www.youtube.com adresine gidin
       3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
          ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
          ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
          ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
          ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin  */

       static WebDriver driver;

       @BeforeClass
    public static void setup(){
           WebDriverManager.edgedriver().setup();
           driver=new EdgeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
           driver.get("https://youtube.com");
       }

       @Test
     public void test01(){
           String actualTitle= driver.getTitle();
           String exeptTitleTitle= "YouTube";

           Assert.assertTrue(exeptTitleTitle.equals(actualTitle));

       }
     @Test
    public void test02(){
          WebElement LogoEle =driver.findElement(By.id("logo-icon"));
           Assert.assertTrue(LogoEle.isDisplayed());
       }

     @Test
    public void test03(){
           WebElement searcBox=driver.findElement(By.id("search"));
           Assert.assertTrue(searcBox.isEnabled());

     }

     @Test
    public void test04(){
           String unEXpeTitle="youtube";
           String actuTitle=driver.getTitle();
           Assert.assertNotEquals(unEXpeTitle,actuTitle);


         }
      @AfterClass
     public static void teardown(){
         //  driver.close();
      }

     }

