package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.ReusableMethods;
import utilies.TestBase;

public class N1 extends TestBase {

    @Test
    public void test01(){
            // https://www.kiwi.com sayfasina gidin
        driver.get("https://www.kiwi.com");
            // Cookies i reddedin
        WebElement cookies=driver.findElement(By.xpath("//div[text()='Kabul et']"));
        cookies.click();
           // Sayfa basliginin "Kiwi" icerdigini test edin
        String expectedTitle="Kiwi";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

            // Sag ust kisimdan dil ve para birimi secenegini Français (Belgium) ve TL olarak secin
        WebElement dilsecimi=driver.findElement(By.xpath("//div[text()='TRY']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(dilsecimi).click(dilsecimi).perform();
        ReusableMethods.bekle(2);
        WebElement selectElement= driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
        Select select=new Select(selectElement);
        select.selectByVisibleText("Français (Belgium)");

        WebElement paraBirimi= driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
        Select select1=new Select(paraBirimi);
        select1.selectByVisibleText("Euro - EUR");

        WebElement buttonElement= driver.findElement(By.xpath("//button[@type='submit']"));
        buttonElement.click();
           // Sectiginiz dil ve para birimini dogrulayin
        WebElement dilParaBirimi= driver.findElement(By.xpath("//div[text()='EUR']"));
        Assert.assertTrue(dilParaBirimi.getText().contains("EUR"));
            // Ucus secenegi olarak tek yon secelim
        WebElement ucusSecenegi= driver.findElement(By.xpath("(//div[text()='Aller-retour'])[1]"));
        ucusSecenegi.click();
        WebElement tekYon=driver.findElement(By.xpath("//p[text()='Aller simple']"));
        tekYon.click();
            // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        WebElement kVTemizle= driver.findElement(By.xpath("//div[@data-test='PlacePickerInputPlace-close']"));
        kVTemizle.click();

        WebElement kalkisNoktasi= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
        kalkisNoktasi.sendKeys("Ankara");
        driver.findElement(By.xpath("//div[text()='Ankara, Turquie']")).click();

        WebElement varisNoktasi= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        varisNoktasi.sendKeys("Atina");
        driver.findElement(By.xpath("//div[text()='Athènes, Grèce']")).click();
        ReusableMethods.bekle(2);

            // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        driver.findElement(By.xpath("//div[text()='Départ']")).click();
        ReusableMethods.bekle(4);
        driver.findElement(By.xpath("//div[@data-value='2023-01-17']")).click();
        driver.findElement(By.xpath("//div[text()='Définir les dates']")).click();
        driver.findElement(By.xpath("//span[text()='Trouver un logement avec Booking.com']")).click();

        WebElement button= driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContentChildren__StyledButtonPrimitiveContentChildren-sc-1m4y8u8-0 jiqdNk'])[4]"));
        button.click();
        ReusableMethods.bekle(2);

            // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        driver.findElement(By.xpath("(//div[@class='Radio__TextContainer-sc-crlwn1-2 jDLzDU'])[1]")).click();
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//span[text()='Le moins cher']")).click();
            // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 100 €den kucuk oldgunu dogurlayalim
        WebElement fiyatElement= driver.findElement(By.xpath("(//span[@class=' length-4'])[3]"));
        String fiyat= fiyatElement.getText();
        fiyat=fiyat.replaceAll(" €","").replaceAll("\\.","");

       Assert.assertTrue(Integer.parseInt(fiyat)<100);

    }
}
