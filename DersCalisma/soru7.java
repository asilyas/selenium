package DersCalisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class soru7 extends TestBase {


    @Test
    public void test01(){
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        // 2."Login Portal" a kadar asagi inin
        WebElement logineGidis=driver.findElement(By.xpath("(//div[@class='section-title'])[2]"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(logineGidis);

        // 3."Login Portal" a tiklayin
        logineGidis.click();
        // 4.Diger window'a gecin
        String yeniSayfaWHD=driver.getWindowHandle();

        for (String each:driver.getWindowHandles()) {
            if (!each.equals(yeniSayfaWHD)){
                driver.switchTo().window(each);
                break;
            }
        }

        bekle(3);
        // 5."username" ve "password" kutularina deger yazdirin
        WebElement username=driver.findElement(By.id("text"));
        username.click();
        username.sendKeys("username");
        WebElement password=driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("password");
        bekle(3);
        // 6."login" butonuna basin
        WebElement login=driver.findElement(By.id("login-button"));
        login.click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String alertYazi=driver.switchTo().alert().getText();
        String expectedicerik="validation failed";
        Assert.assertEquals(expectedicerik,alertYazi);
        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        // 9.Ilk sayfaya geri donun
        driver.switchTo().window(yeniSayfaWHD);
        bekle(3);
        // 10.Ilk sayfaya donuldugunu test edin
        String expectedURL="http://webdriveruniversity.com/";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);


    }

}