package day06_window_iframe_actionClass;
import org.junit.Assert;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import utilities.TestBase;

public class C02_SwitchToIFrame extends TestBase {

    @Test

    public void test01(){

        // https://the-internet.herokuapp.com/iframe  adresine gidin

        driver.get("https://the-internet.herokuapp.com/iframe");

        // "Your content goes here." yazisinin gorunur oldugunu test edin

        /*

            Bazen locate islemimizden emin olmamiza ragmen
            Locator calismaz
            Bunun sebebi kullanmak istedigimiz webelement'in
            bir iframe'in child'i olmasi olabilir.
            Eger Kullanmak istedigimiz webelement
            anasayfa icine gomulen baska bir websayfasinin elementi ise
            once gomulu sayfaya gecmemiz gerekir
            HTML komutlarinda sayfa icerisine sayfa gomebilmek icin
            <iframe> kullanilir
            Biz de istedigimiz elementi kullanmak icin once
            o frame'e switch yapmaliyiz

            1- gecis yapmak istediginiz frame'i locate edi
            2- switchTo() ile o frame'e gecis yapin
            3- Sonra istediginiz element ile istediginiz islemi yapin

         */

        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(frameElementi);



        WebElement yaziElementi = driver.findElement(By.tagName("p"));

        Assert.assertTrue(yaziElementi.isDisplayed());


        // elemental selenium linkine click yapın.

        /*
        Bir frame e geçiş yaptıktan sonra oradan çıkıncaya veya başka bir frame geçinceye kadar driver
        o frame içinde kalır.

         işimiz bittiğinide veya başka frame geçmek istedğimizde önce çalışacağımız
        yere geçiş yapmalıyız.
         */
        driver.switchTo().parentFrame(); // içiçe frame lerde bi üst seviyeye çıkar
        // driver.switchTo().defaultContent(); // direk anasayfaya çıkar
        driver.findElement(By.linkText("Elemental Selenium")).click();


        bekle(3);

    }

}

