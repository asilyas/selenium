package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_fileExistTesti extends TestBase {

    @Test
    public void test(){

         //   2. https://the-internet.herokuapp.com/download adresine gidelim.
          driver.get("https://the-internet.herokuapp.com/download");

         //   3. logo.png dosyasını indirelim

          driver.findElement(By.linkText("logo.png")).click();
         //   4. Dosyanın başarıyla indirilip indirilmediğini test edelim
          bekle(5);

          // dosya download a ineceği için dinamik dosya yolu oluşturalım

          String dinamikDosyaYolu=System.getProperty("user.home")+"\\Downloads\\logo.png";

          Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));




    }
}
