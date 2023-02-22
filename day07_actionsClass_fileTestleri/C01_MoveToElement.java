package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MoveToElement extends TestBase {


    @Test
    public void test01(){

        // 1- https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        driver.navigate().refresh();

        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement accountListElementi= driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
        Actions actions =new Actions(driver);
        actions.moveToElement(accountListElementi).perform();
        bekle(2);
        // 3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

        // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

        WebElement yourListElementi=driver.findElement(By.id("my-lists-tab"));
        Assert.assertTrue(yourListElementi.isDisplayed());

        bekle(4);


    }
}
