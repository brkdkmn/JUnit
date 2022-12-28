package day08_handlingWindows;

import org.junit.Assert;
import org.junit.Test;
import utilies.ReusableMethods;
import utilies.TestBase;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01(){
        //amazon'a gidin
        driver.get("https://www.amazon.com");

        //amazon'q gittiginizi test edin
        String expectedKelime="amazon";
        String  actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedKelime));

        ReusableMethods.bekle(3);
    }
}
