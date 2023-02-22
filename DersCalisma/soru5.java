package DersCalisma;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class soru5 extends TestBase {


    @Test
    public void test01(){

        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement overMeFirst = driver.findElement(By.xpath("//button[@class='dropbtn'][1]"));
        actions.moveToElement(overMeFirst).perform();
        bekle(3);
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("//a[@class='list-alert'][1]")).click();
        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        bekle(3);
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickYazisi = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickYazisi).perform();
        bekle(3);
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickYazisi.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement clickMe = driver.findElement(By.id("double-click"));
        actions.doubleClick(clickMe).perform();
        bekle(2);


    }
}

