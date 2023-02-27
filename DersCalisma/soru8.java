package DersCalisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class soru8 extends TestBase {

    @Test
    public void test01(){
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement product = driver.findElement(By.xpath("//*[@id='frame']"));
        driver.switchTo().frame(product);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();


        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        bekle(3);
        //4. Popup mesajini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@class='modal-body']")).getText());

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualUrl = driver.getCurrentUrl();
        String expectedURL = "http://webdriveruniversity.com/index.html";

        Assert.assertEquals(expectedURL,actualUrl);
        bekle(3);


    }


}

