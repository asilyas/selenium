package DersCalisma;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class soru3 {

    /*
            1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify th4. Click on 'Signup / Login' button
            4. Click on 'Signup / Login' button
            5. Verify 'New User Signup!' is visibleat home page is visible successfully
            6. Enter name and email address
            7. Click 'Signup' button
            8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
            9. Fill details: Title, Name, Email, Password, Date of birth
            10. Select checkbox 'Sign up for our newsletter!'
            11. Select checkbox 'Receive special offers from our partners!'
            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
            13. Click 'Create Account button'
            14. Verify that 'ACCOUNT CREATED!' is visible
            15. Click 'Continue' button
            16. Verify that 'Logged in as username' is visible
            17. Click 'Delete Account' button
            18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationexercise.com");
    }

    @Test
    public void test01(){

        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify th4. Click on 'Signup / Login' button
        WebElement homePage = driver.findElement(By.xpath("/html"));
        Assert.assertTrue(homePage.isDisplayed());

    }
    @Test
    public void test02() {
        // 4. Click on 'Signup / Login' button
        // 5. Verify 'New User Signup!' is visible at home page is visible successfully

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        WebElement newUser = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        Assert.assertTrue(newUser.isDisplayed());

    }

    @Test
    public void test03() {

        // 6. Enter name and email address
        // 7. Click 'Signup' button
        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("aaaa");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("aaaaaaaaaa@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa=\"signup-button\"]")).click();

        WebElement accountEnter = driver.findElement(By.xpath("//*[text()=\"Enter Account Information\"]"));
        Assert.assertTrue(accountEnter.isDisplayed());

    }

    @Test
    public void test04(){
        //  9. Fill details: Title, Name, Email, Password, Date of birth
        //  10. Select checkbox 'Sign up for our newsletter!'
        //  11. Select checkbox 'Receive special offers from our partners!'
        //  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //  13. Click 'Create Account button'
        //  14. Verify that 'ACCOUNT CREATED!' is visible

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("12345");

        driver.findElement(By.id("days")).sendKeys("10");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)");

        driver.findElement(By.xpath("//*[@id=\"months\"]/option[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"years\"]/option[28]")).click();
        driver.findElement(By.id("newsletter")).submit();
        driver.findElement(By.xpath("//label[@for=\"optin\"]")).submit();
        driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("ilyas");
        driver.findElement(By.id("last_name")).sendKeys("uckac");
        driver.findElement(By.id("company")).sendKeys("amazon");
        driver.findElement(By.id("address1")).sendKeys("mah,44000,cad");
        driver.findElement(By.xpath("//*[@id=\"country\"]/option[2]")).click();
        driver.findElement(By.id("state")).sendKeys("california");
        driver.findElement(By.id("city")).sendKeys("silikon wallay");
        driver.findElement(By.id("zipcode")).sendKeys("5542");
        driver.findElement(By.id("mobile_number")).sendKeys("05324445544");

    }
   @Test
   public void test05(){

        //    15. Click 'Continue' button
       //     16. Verify that 'Logged in as username' is visible
       //     17. Click 'Delete Account' button
       //     18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        driver.findElement(By.xpath("//*[text()=\"Continue\"]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        System.out.println("username oluşturuldu yazısı görüldü"+driver.findElement(By.xpath("//*[text()=\" Logged in as \"]")).isDisplayed());

        driver.findElement(By.xpath("//*[text()=\" Delete Account\"]")).click();
        System.out.println("hesap silindi yazısı görüldü"+driver.findElement(By.xpath("//*[text()=\"Account Deleted!\"]")).isDisplayed());
        driver.findElement(By.xpath("//*[text()=\"Continue\"]")).click();
}

    @AfterClass
    public static void tearDown(){

        driver.close();
    }
}