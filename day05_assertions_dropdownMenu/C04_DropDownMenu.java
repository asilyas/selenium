package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    // ● Bir class oluşturun: C3_DropDownAmazon
    // ● https://www.amazon.com/ adresine gidin.
    // - Test 1
    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //	-Test 2
    // 1. Kategori menusunden Books secenegini secin
    // 2. Arama kutusuna Java yazin ve aratin
    // 3. Bulunan sonuc sayisini yazdirin
    // 4. Sonucun Java kelimesini icerdigini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
        driver.navigate().refresh();
    }
   @AfterClass
    public static void teardown(){
       // driver.close();
   }

   @Test
    public void test01(){
       WebElement ddm=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));

       Select select=new Select(ddm);

       int actualOptionSayisi =select.getOptions().size();

       int expectedOptionSayisi=45;

       Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

   }
   @Test
    public void test02(){
       WebElement ddm=driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]"));

       Select select=new Select(ddm);

       select.selectByVisibleText("Books");

       WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

       aramaKutusu.sendKeys("Java"+ Keys.ENTER);

       WebElement sonucYaziElementi= ddm.findElement(By.xpath("//h1[@class=‘a-size-base s-desktop-toolbar a-text-normal’]"));

       System.out.println(sonucYaziElementi.getText());

       String expeIcerik="Java";
       String actualSonucYazisi=sonucYaziElementi.getText();

       Assert.assertTrue(actualSonucYazisi.contains(expeIcerik));
   }

}
