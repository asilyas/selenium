package DersCalisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class practiceOdev1 {

    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Antartica
    choose your command  -> Browser Commands
    click submit button
 */

     public static void main(String[] args) {
          WebDriverManager.firefoxdriver().setup();
          WebDriver driver=new FirefoxDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

          driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

          // cookiesi geç
         WebElement coki=driver.findElement(By.id("cookieChoiceDismiss"));
         WebElement reklam=driver.findElement(By.id("ezmob-footer-close"));

         if(reklam.isDisplayed()){
             reklam.click();
             coki.click();
         }else  {
             coki.click();
         }

        //  fill the firstname
         driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("lionel");

          //  fill the lastname
         driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Messi");

         // check the gender

          driver.findElement(By.id("sex-0")).click();

         // check the experience

         driver.findElement(By.id("exp-1")).click();

          // fill the date

          driver.findElement(By.id("datepicker")).sendKeys("02-02-2020");

         //  choose your profession -> Automation Tester

         driver.findElement(By.id("profession-1")).click();

         // choose your tool -> Selenium Webdriver.

         driver.findElement(By.id("tool-2")).click();

         // choose your continent -> Antartica options

         driver.findElement(By.id("continents")).sendKeys("aaa");

         // choose your command  -> Browser Commands

         driver.findElement(By.id("selenium_commands")).sendKeys("b");

// hangi repoya hangı projeyı yuklemek ıstıyorsunuz ornek olarak bakalım

         // click submit button ...

         driver.findElement(By.id("submit")).click();

         driver.close();
     }
}
