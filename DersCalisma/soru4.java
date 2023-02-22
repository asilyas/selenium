package DersCalisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class soru4 extends TestBase {

    @Test
    public void test01() {

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        WebElement video = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        actions.scrollToElement(video).perform();
        bekle(2);

        //4- videoyu izlemek icin Play tusuna basin
        driver.switchTo().frame(video);
        WebElement videoCalisti = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        videoCalisti.click();
        bekle(3);
        //5- videoyu calistirdiginizi test edin
        Assert.assertTrue(videoCalisti.isEnabled());

    }
}