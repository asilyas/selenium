package DersCalisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

import java.util.List;

public class soru6 extends TestBaseClass {
    @Test
    public void test1() {
        /*
        Test01 :
        1- amazon gidin
        2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        3- dropdown menude 40 eleman olduğunu doğrulayın
        Test02
        1- dropdown menuden elektronik bölümü seçin
        2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        4- ikinci ürüne relative locater kullanarak tıklayin
        5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        Test03
        1- yeni bir sekme açarak amazon anasayfaya gidin
        2-dropdown’dan bebek bölümüne secin
        3-bebek puset aratıp bulundan sonuç sayısını yazdırın 4-sonuç yazsının puset içerdiğini test edin
        5-üçüncü ürüne relative locater kullanarak tıklayin
        6-title ve fiyat bilgilerini assign edelim

         */

        //1- amazon gidin
        driver.get("https://www.amazon.com/");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın

        WebElement dropdownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select dropdown = new Select(dropdownMenu);
        List<WebElement> dropdownOptions = dropdown.getOptions();

        int sayi = 1;
        for (WebElement option : dropdownOptions) {
            System.out.println((sayi++) + " --" + option.getText());
        }
        //3- dropdown menude 40 eleman olduğunu doğrulayın

        //  Assert.assertEquals("40 dropdown eleman yok",40,dropdownOptions.size());   2.yöntem

        if (dropdownOptions.size() == 40) {
            System.out.println("Dropdown menüsünde 40 eleman var.");
        } else {
            System.out.println("Dropdown menüsünde 40 eleman yok.");
        }
    }

    //Test02
    @Test
    public void test2() {
        //1- dropdown menuden elektronik bölümü seçin

        WebElement dropdownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select dropdown = new Select(dropdownMenu);
        dropdown.selectByVisibleText("Electronics");
        bekle(2);

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();
        bekle(2);

        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin

        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultText.getText());
        Assert.assertTrue("iphone içermiyor", resultText.getText().contains("iphone"));

        if (resultText.getText().contains("iphone")) {
            System.out.println("Arama sonuçları 'iphone' içeriyor.");
        } else {
            System.out.println("Arama sonuçları 'iphone' içermiyor.");
        }
        bekle(2);

        //4- ikinci ürüne relative locater kullanarak tıklayin

        WebElement secondProduct = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]"));
        String secondProductElementFiyat = driver.findElement(By.xpath("(//div[@class='a-row a-size-base a-color-base'])[2]")).getText();

        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim

        System.out.println("ikinci ürün fiyatı= " + secondProductElementFiyat);
        System.out.println(secondProduct.getText());
        secondProduct.click();
      //  driver.findElement(By.id("submit.add-to-cart")).click();
        bekle(2);
    }

    //Test03
    @Test
    public void test3() {

        //1- yeni bir sekme açarak amazon anasayfaya gidin

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        //2-dropdown’dan bebek bölümüne secin

        WebElement dropdownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select dropdown = new Select(dropdownMenu);
        dropdown.selectByVisibleText("Baby");

        //3-bebek puset aratıp bulunan sonuç sayısını yazdırın

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("bebek puset"+ Keys.ENTER);



        //4-sonuç yazsının puset içerdiğini test edin

        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultText.getText());
        Assert.assertTrue("puset içermiyor", resultText.getText().contains("puset"));

        //5-üçüncü ürüne relative locater kullanarak tıklayin

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();

        //6-title ve fiyat bilgilerini assign edelim

        String ucuncuUrunFiyati=driver.findElement(By.xpath("(//span[@class='a-size-mini olpWrapper'])[1]")).getText();


    }
  }