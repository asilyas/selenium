package DersCalisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class practiceOdev3 {
    // .......Exercise5........

   // Navigate to website https://testpages.herokuapp.com/styled/index.html
   // Under the ORIGINAL CONTENTS click on Alerts
   // print the URL
   // navigate back
   // print the URL
   // Click on Basic Ajax
   // print the URL
   // enter value 20 and ENTER
   // and then verify Submitted Values is displayed open page
   // close driver


    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();
        WebDriver driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to website https://testpages.herokuapp.com/styled/index.html

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Under the ORIGINAL CONTENTS click on Alerts

        driver.findElement(By.id("alerts")).click();

        // print the URL

        System.out.println(driver.getCurrentUrl());

        // navigate back

        driver.navigate().back();

        // print the URL

        driver.getCurrentUrl();

        // Click on Basic Ajax

        driver.findElement(By.id("basicajax")).click();

        // print the URL

        System.out.println(driver.getCurrentUrl());

        // enter value 20 and ENTER

        driver.findElement(By.id("lteq30")).sendKeys("20"+ Keys.ENTER);

        // and then verify Submitted Values is displayed open page

        System.out.println(driver.findElement(By.xpath("/html/body/p[1]")).isDisplayed());

        // close driver

        driver.close();

    }
}
