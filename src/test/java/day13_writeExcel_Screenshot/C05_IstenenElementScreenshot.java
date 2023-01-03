package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_IstenenElementScreenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        //amazona gidin
        driver.get("https://www.amazon.com");

        //Nutella aratin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //sonuclarin Nutella icerdigini test edin
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu=aramaSonucElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        //arama sonuc elementinin screenshot'ini cekin

              //1-screenshot alacagimiz elementi locate et
             //2-kaydedecegimiz dosyayi olustur

        File elementSS=new File("target/ekranResimleri/elementSS.jpg");

            //3-gecici dosyayi olusturup element uzerinden screenshot yapalim

        File gecici= aramaSonucElementi.getScreenshotAs(OutputType.FILE);

           //4-gecici dosyayi, hedef dosyaya kopyala

        FileUtils.copyFile(gecici,elementSS);
    }
}
