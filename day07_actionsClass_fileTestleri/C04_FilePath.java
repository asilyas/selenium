package day07_actionsClass_fileTestleri;

import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FilePath {

     @Test
    public void test01(){


         // C:\Users\Lenovo\IdeaProjects\com.selenium\src\test\java\day07_actionsClass_fileTestleri\text.txt

         // içinde bulunduğumuz projenin yolu user.dir

         String dosyaYolu="C:\\Users\\Lenovo\\Desktop";

         boolean sonuc= Files.exists(Paths.get(dosyaYolu));
         System.out.println(sonuc);

         System.out.println(System.getProperty("user.home"));

         System.out.println(System.getProperty("user.dir"));

     }
}
