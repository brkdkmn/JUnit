package practice;

import com.github.dockerjava.core.exec.WaitContainerCmdExec;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBase;

public class N3_Action extends TestBase {

    @Test
    public void test01(){

        // https://www.booking.com/ sayfasina gidelim
        driver.get("https://www.booking.com/");
           // para birimi olarak TL secelim
        WebElement tryYazisi= driver.findElement(By.xpath("(//span[@aria-hidden='true'])[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(tryYazisi).click().perform();

        action.sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.ARROW_UP).perform();

        WebElement paraBirimiElementi= driver.findElement(By.xpath("(//a[@data-et-click='customGoal:YTTHbXeeVJWcWPaDMWOMHTcNSDEWCAWdPZKe:2'])[47]"));
        action.moveToElement(paraBirimiElementi).click(paraBirimiElementi).perform();


            // ulke olarak Turkiye yi secelim
        WebElement dilElementi= driver.findElement(By.xpath("(//div[@aria-hidden='true'])[1]"));
        action.moveToElement(dilElementi).click(dilElementi).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement dilTurkceElementi= driver.findElement(By.xpath("//div[@lang='tr']"));
        action.click(dilElementi);
           // sayfanin en altindan ulkeler kismini secelim
        action.sendKeys(Keys.END).perform();
        ReusableMethods.bekle(2);
        WebElement ulkelerElementi= driver.findElement(By.xpath("(//a[@data-ga='seoindexlinks'])[1]"));
        action.sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        action.click(ulkelerElementi).perform();
           // ulkeler sayfasindan turkiye yi secelim
        WebElement turkiyeElementi=driver.findElement(By.xpath("//a[@href='/country/tr.tr.html?label=gen173nr-1FCAEoggI46AdIM1gEaOQBiAEBmAEouAEXyAEM2AEB6AEB-AELiAIBqAIDuAKxmuGdBsACAdICJGNiMTkzYTgxLTc1YWUtNDExYy04MmMwLTlmM2MwNjcwN2IwMtgCBuACAQ&sid=357f6bef4e76151f921ece0bf26ac9c8']"));

        action.moveToElement(turkiyeElementi).click(turkiyeElementi).perform();

            // turkiye sayfasinin secildigini test edin
        String exoectedTitle="Turkiye";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(exoectedTitle,actualTitle);

    }
}
