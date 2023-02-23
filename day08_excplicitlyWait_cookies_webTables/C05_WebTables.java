package day08_excplicitlyWait_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C05_WebTables extends TestBase {

    @Test
    public void test01(){

        //  1.“https://www.amazon.com” adresine gidin
        driver.get("https://amazon.com");

        //  2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //  3.Web table tum body’sini yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        //  4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement>satirlarListesi=driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(10,satirlarListesi.size());
        //  5.Tum satirlari yazdirin
        int satirSayisi=1;

        for (WebElement eachSatir:satirlarListesi) {
            System.out.println(satirSayisi++ +"===="+eachSatir.getText());
        }
        //  6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement>ucuncuSatirDatalarList=driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13,ucuncuSatirDatalarList.size());
        //  7. 5.sutunu yazdirin
        List<WebElement>besinciSutunList=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("======5. SUTUN ======");
        satirSayisi=1;
        for (WebElement eachDATA:besinciSutunList) {
            System.out.println(satirSayisi++ +"--"+eachDATA.getText());
        }
        //  8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println("istenen data: \n"+getData(3,5));

        // 9. 7.satırın 9. datasının "Shoes" içerdiğini test edin

        String actualData=getData(7,9);
        String expeIcerik="Shoes";

        Assert.assertTrue(actualData.contains(expeIcerik));


        bekle(3);
    }

   public  String getData(int satirNo,int sutunNo){
        // 3.satir 5.sutun daki bilgiyi yazdırın

       String dataXpath= "//tbody/tr["+satirNo+"]/td["+sutunNo+"]";

       String istenenData=driver.findElement(By.xpath(dataXpath)).getText();

       return istenenData;

   }

}
