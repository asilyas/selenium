package DersCalisma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class practiceOdev2 {

    /* ...Exercise4...
Navigate to  https://testpages.herokuapp.com/styled/index.html
Click on  Calculater under Micro Apps
Type any number in the first input
Type any number in the second input
Click on Calculate
Get the result
Print the result
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver","src/driver/msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to  https://testpages.herokuapp.com/styled/index.html

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculater under Micro Apps

        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input

        driver.findElement(By.xpath("//*[@id=\"number1\"]")).sendKeys("5");

        // Type any number in the second input

        driver.findElement(By.id("number2")).sendKeys("6");

        // Click on Calculate

        driver.findElement(By.xpath("//*[@id=\"calculate\"]")).click();

        // Get the result

        String sonuc=driver.findElement(By.id("answer")).getText();
        
        // Print the result

        System.out.println("sonuc = " + sonuc);

        // close the page

        driver.close();
        
    }


}
