package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilies.ReusableMethods;
import utilies.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01(){

        //1. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //2. 7.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='7.png']")).click();
        ReusableMethods.bekle(5);

        //. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //Test icin oncelikle dosyanin indirildiginde dosya yolunun ne olacak bunu olusturmaliyiz

        String dosyaYolu=System.getProperty("user.home") + "/Downloads/7.png";

        // Bir dosyanin bilgisayarimizda var oldugunu (exist) test etmek icin
        // Javadaki Files class'indan yardim aliriz

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        ReusableMethods.bekle(2);
    }

    @Test
    public void test02(){
        // masaustunde merhabaJava.txt dosyasi oldugunu test edin

        String dosyaYolu2 = System.getProperty("user.home")+ "/Desktop/merhabaJava.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }
}

