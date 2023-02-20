package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class C03_RadioButtons {
    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    // a. Verilen web sayfasına gidin.
    //     https://facebook.com
    // b. Create an account buton’una basin
    // c. Radio button elementlerini locate edin ve size uygun olani secin
    // d. Seçtiğiniz radio butonun seçili diğerlerinin seçili olmaduğını test edin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
   @After
    public void teardown(){
        driver.close();
   }
   @Test
    public void test01(){
        driver.get("https://facebook.com");

        driver.findElement(By.xpath("//*[@id='u_0_0_QM']")).click();

       WebElement erkekelement= driver.findElement(By.xpath("(//input[@type=‘radio’])[2]"));
       WebElement kadinkelement= driver.findElement(By.xpath("(//input[@type=‘radio’])[1]"));
       WebElement ozelelement= driver.findElement(By.xpath("(//input[@type=‘radio’])[3]"));

       erkekelement.click();

       Assert.assertTrue(erkekelement.isSelected());
       Assert.assertTrue(kadinkelement.isSelected());
       Assert.assertTrue(ozelelement.isSelected());

    }

}
