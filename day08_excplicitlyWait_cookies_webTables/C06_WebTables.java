package day08_excplicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables extends TestBase {

    @Test
    public void test01() {

        // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        WebElement headerBasliklari = driver.findElement(By.xpath("//div[@class='rt-tr']"));
        System.out.print(headerBasliklari.getText() + " ");

        //  System.out.println("header başlıkları"+driver.findElement(By.xpath("//div[@class=\"rt-thead -header\"]\n")));

        // 3. 3.sutunun basligini yazdirin
        System.out.println(driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]")).getText());

        // 4. Tablodaki tum datalari yazdirin
        WebElement birinciSatir = driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[1]"));

        int satirDegeri = 1;

        for (int i = 1; i <= 3; i++) {
            System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])[" + i + "]")).getText());
        }

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        List<WebElement> hucre = driver.findElements(By.xpath("//div[@class='rt-table']//div[@role='gridcell']"));


        int bosOLmayanHucre = 0;

        for (WebElement each : hucre) {
            if (!each.getText().isEmpty()) {
                bosOLmayanHucre++;
            }
        }
        System.out.println(bosOLmayanHucre);


        // 6. Tablodaki satir sayisini yazdirin

        List<WebElement> satir = driver.findElements(By.xpath("//div[@class='rt-table']//div[@role='row']"));

        System.out.println("Tabloda " + (satir.size() - 1) + " adet satır vardır.");

        // 7. Tablodaki sutun sayisini yazdirin

        List<WebElement> sutun = driver.findElements(By.xpath("//div[@class='rt-table']//div[@role='columnheader']"));

        System.out.println("Tabloda " + sutun.size() + " adept sütun vardır.");

        // 8. Tablodaki 3.sutun yazdirin
        for (int i = 1; i <= 3; i++) {
            System.out.println(driver.findElement(By.xpath("(//div[@class='rt-table']//div[@role='gridcell'][3])[" + i + "]")).getText());

        }

        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        WebElement kiera = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@role='row'][descendant::div[text()='Kierra']]\n"));
        WebElement salary = kiera.findElement(By.xpath(".//div[@role='gridcell'][5]\n"));
        System.out.println(salary.getText());

        // String kierra=kiera.getText();
        //String ExpeKiera="Kierra";
        //  if (kierra.equals(ExpeKiera)){
        //    System.out.println(driver.findElement(By.xpath("(//div[@class='rt-table']//div[@role='gridcell'][5])[2]")).getText());
        //}

        //10. Page sayfasinda bir method olusturun, Test sayfasindan
        //    satir ve sutun sayisini girdigimde bana datayi yazdirsin

        yazdirtData(driver,3,3);
    }

    public static void yazdirtData(WebDriver driver, int satir, int sutun) {
        WebElement veriler = driver.findElement(By.xpath("//div[@class='rt-tr-group'][" + satir + "]//div[@role='gridcell'][" + sutun + "]"));
        System.out.println(veriler.getText());


    }
}