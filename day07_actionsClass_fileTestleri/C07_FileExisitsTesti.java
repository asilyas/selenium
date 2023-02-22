package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExisitsTesti {

    @Test
    public void test(){

        //  çalıştığımız package içinde text.txt isimli bir  file olduğunu test edin

        String dinamikDosyayolu=System.getProperty("user.dir")+"\\src/test/java/day07_actionsClass_fileTestleri/text.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyayolu)));
    }
}
