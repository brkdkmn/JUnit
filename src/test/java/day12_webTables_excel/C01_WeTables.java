package day12_webTables_excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBase;

import java.util.List;

public class C01_WeTables extends TestBase {

    @Test
    public void test01(){

        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // 2. Headers da bulunan basliklari yazdirin
        WebElement headerElementi= driver.findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("basliktaki bilgiler : " + headerElementi.getText());
        // 3. 3.sutunun basligini yazdirin
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        System.out.println("3.sutun basligi : " + basliklarListesi.get(2).getText());
        // 4. Tablodaki tum datalari yazdirin
        WebElement tumBodyElementi= driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println("Body : "+tumBodyElementi.getText() );
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> datalarListesi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        int siraNo=1;
        for (WebElement each:datalarListesi
             ) {
           if (!(each.getText().equals("") || each.getText().equals(" "))){
               System.out.println(siraNo+". - " +each.getText() );
               siraNo++;
           }
        }
        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementListesi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Satir sayisi : " + satirElementListesi.size());
        // 7. Tablodaki sutun sayisini yazdirin
             // Basta basliklar listesi olustirmustuk onun size() 'ni alalim
        System.out.println("Sutun Sayisi : " + basliklarListesi.size());
        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunDatalarListesi=driver.findElements(By.xpath("((//div[@class='rt-tr-group']))//div[1]/div[3]"));
        for (WebElement each:ucuncuSutunDatalarListesi
        ) {
            if (!(each.getText().equals("") || each.getText().equals(" "))){
                System.out.println(each.getText());

            }
        }
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
             // index'i saydiralim,Kierra=yi bulunca , index'in 4 fazlasini yazdiralim

        for (int i = 0; i < datalarListesi.size(); i++) {

            if (datalarListesi.get(i).getText().equals("Kierra")){
                System.out.println("Istenen kisinin maasi : " +datalarListesi.get(i+4).getText());
            }

        }

        //10. Page sayfasinda bir method olusturun,
        // Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

    }
}
