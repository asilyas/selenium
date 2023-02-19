package day03_xpath_cssSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class C06_MavenIlkClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
/*
        1- https://www.amazon.com/ sayfasina gidelim
        2- arama kutusunu locate edelim
        3- “Samsung headphones” ile arama yapalim
        4- Bulunan sonuc sayisini yazdiralim
        5- Ilk urunu tiklayalim
        6- Sayfadaki tum basliklari yazdiralim


 */
        driver.get("https://amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        System.out.println(driver.findElement(By.xpath("//h1[@class=‘a-size-base s-desktop-toolbar a-text-normal’]")).getText());

        driver.findElement(By.xpath("(//span[@class=‘a-size-medium a-color-base a-text-normal’])[1]")).click();

        driver.navigate().back();

        List<WebElement>baslikElementleriListesi=driver.findElements(By.xpath("//a[@class=‘a-link-normal s-navigation-item’]"));

        int baslikNo=1;
        for (WebElement eachElement:baslikElementleriListesi) {
            System.out.println(baslikNo+ "-------"+eachElement.getText());
            baslikNo++;
        }
        Thread.sleep(3000);
        driver.close();


    }
}
