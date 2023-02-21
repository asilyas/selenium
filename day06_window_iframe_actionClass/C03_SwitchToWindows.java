package day06_window_iframe_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_SwitchToWindows extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfaya gidip, arama kutusunun erisilebilir oldugunu test edin
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        String amazonWindowhandleDegeri=driver.getWindowHandle();

        // yeni bir tab olarak wisequarter.com'a gidin (önce yeni bi taba geçmek için switch)
        // url'in wisequarter icerdigini test edin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        String expeIcerik="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expeIcerik));
        String wiseWindowHandle=driver.getWindowHandle();

        // amazon'un acik oldugu tab'a geri donup
        driver.switchTo().window(amazonWindowhandleDegeri);

        // Nutella icin arama yapin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // Sonuclarin Nutella icerdigini test edin
        String actualSonusYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        String expeIceriknu="Nutella";

        Assert.assertTrue(actualSonusYazisi.contains(expeIceriknu));

        // yeni bir window olarak youtube.com'a gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        // Url'in youtube icerdigini test edin
        String expeIcerY="youtube";
        String actualURL=driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expeIcerY));

        // wisequarter'in acik oldugu sayfaya donun

        driver.switchTo().window(wiseWindowHandle);
        // Title'in WiseQuarter icerdigini test edin
        expeIcerik="Wise Quarter";
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expeIcerik));


    }
}
