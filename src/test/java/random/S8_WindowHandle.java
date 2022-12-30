package random;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBase;

import java.util.Set;

public class S8_WindowHandle extends TestBase {

    @Test
    public void test01() {

        // https://www.trendyol.com adresine gidin
        driver.get("https://www.trendyol.com");
        String ilkSayfaWHD=driver.getWindowHandle();
        // cerezleri kabul et
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        ReusableMethods.bekle(4);

        //  nutella aratın ve nutella yazdiğini dogrulayin
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@data-testid='suggestion']"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        ReusableMethods.bekle(2);

        String expectedKelime="nutella";
        String actualKelime=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedKelime,actualKelime);
        // ELEKTRONIK menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement beklenecekElektronik=driver.findElement(By.xpath("//a[@href='/butik/liste/5/elektronik']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(beklenecekElektronik).perform();
        ReusableMethods.bekle(2);
        beklenecekElektronik.sendKeys(Keys.PAGE_DOWN);
        //cikan 4.urunu secin
        driver.findElement(By.xpath("(//div[@class='image-overlay-body'])[4]")).click();
        ReusableMethods.bekle(2);
        //  daha sonra nutella'in göründüğünü test edin
        Set<String> tumUrunler=driver.getWindowHandles();
        String ikinciSaysaWHD="";
        for (String eachWHD:tumUrunler
        ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSaysaWHD=eachWHD;
            }
        }
        driver.switchTo().window(ikinciSaysaWHD);
        String expectedYeniSayfa="Nutella";
        String actualYeniSayfa=driver.findElement(By.xpath("//a[text()='Nutella']")).getText();
        Assert.assertEquals(expectedYeniSayfa,actualYeniSayfa);
        //   sepete ekleyin sepette oldugunu test edin
        driver.findElement(By.xpath("//button[@class='add-to-basket']")).click();
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//p[text()='Sepetim']")).click();
        ReusableMethods.bekle(2);
        WebElement sepetim= driver.findElement(By.xpath("//p[@title='Nutella Kakaolu Fındık Krem Çikolata 400 g']"));
        Assert.assertTrue(sepetim.isDisplayed());
        // sepeti onayla
        driver.findElement(By.xpath("(//div[@class='pb-summary-approve'])[1]")).click();
        ReusableMethods.bekle(2);
        //   sonra ilk sayfaya donus yapip anasayfaya tiklayin
        driver.switchTo().window(ilkSayfaWHD);
        driver.findElement(By.xpath("//a[@id='logo']")).click();





    }
}
