package random;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilies.ReusableMethods;
import utilies.TestBase;

public class S10_WindowHandle2 extends TestBase {

    @Test
    public void test01(){

        //● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkWHd= driver.getWindowHandle();
        //● Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        // 2.sayfanin whd'de Stringe atayin
        String ikinciSayfaWhd= driver.getWindowHandle();
        //● Sayfa title’nin “wisequarter” icermedigini test edin
        String expectedYeniSayfaTitle="wisequarter";
        String actualYeniSayfaTitle= driver.getTitle();
        Assert.assertFalse(actualYeniSayfaTitle.contains(expectedYeniSayfaTitle));
        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        //● Sayfa title’nin “Walmart” icerdigini test edin
        String expectedWindowTitle="Walmart";
        String actualWindowTitle= driver.getTitle();
        Assert.assertTrue(actualWindowTitle.contains(expectedWindowTitle));
        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(ilkWHd);
        expectedTitle="Amazon";
        actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ReusableMethods.bekle(3);
    }
}
