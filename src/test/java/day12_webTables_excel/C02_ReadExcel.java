package day12_webTables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilies.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        //dosya yolunu olusturalim

        String dosyaYolu="src/test/java/day12_webTables_excel/ulkeler.xlsx";

        // FileInputStream objesi olusturup,parametre olarak dosya yolunu yazalim

        FileInputStream fis= new FileInputStream(dosyaYolu);

        // Kod alanimizda excel'in bir kopyasini olusturuo
        // tum bilgileri ona kopyalayacagiz

        Workbook workbook= WorkbookFactory.create(fis);

        // Workbook icerisinde birden fazla sayfa olabilir
        // istedigimiz sayfaya gidelim

        Sheet sheet = workbook.getSheet("Sayfa1");

        // Angola yazdirmak istedigimiz icin 5. satira gidelim

        Row row = sheet.getRow(5);

        // 5.satirda 2.;ndex'teki datayi alalim

        Cell cell= row.getCell(2);
        System.out.println(cell);

    }
}
