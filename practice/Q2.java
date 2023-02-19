package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Q2 {
    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.edge.driver","src/driver/msedgedriver.exe");

        WebDriver driver=new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://www.otto.de");

        String ottoTitle=driver.getTitle();

        String ottoUrl=driver.getCurrentUrl();

        if(ottoTitle.contains("OTTO")&& ottoUrl.contains("OTTO")){
            System.out.println("TEST PASSED = " + ottoUrl);
        }else {
            System.out.println("Test FAILED  ="+ottoUrl);
        }

        driver.navigate().to("https://wisequarter.com");

        String wqTitle=driver.getTitle();
        System.out.println("wqTitle = " + wqTitle);



        boolean isTRue =wqTitle.contains("Quarter");

        if(isTRue){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAİLED");
        }

        driver.navigate().back();

        driver.navigate().refresh();

        driver.navigate().forward();

        driver.close();

        driver.quit();
    }


}
