package random;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBase;

public class S9_IFrame extends TestBase {

    @Test
    public void iframeTes(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.
        WebElement actualYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(actualYaziElementi.isEnabled());
        System.out.println(actualYaziElementi.getText());
        ReusableMethods.bekle(2);

        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrameElement= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);
        WebElement yaziKutusu =driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutusu.clear();
        yaziKutusu.sendKeys("Merhaba Dunya");

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();

        WebElement elementSelenium= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementSelenium.isDisplayed());
        System.out.println(elementSelenium.getText());
    }

}
