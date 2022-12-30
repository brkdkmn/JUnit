package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {

        String dosyaYolu="C:\\Users\\Asus\\Desktop\\merhabaJava.txt";

        FileInputStream fis=new FileInputStream(dosyaYolu);



        System.out.println(System.getProperty("user.dir"));
        // o anda calsan dosyanin C01_FileInputStream yolunu verir
        // C:\Users\Asus\IdeaProjects\com.Team105JUnit
        System.out.println(System.getProperty("user.home"));
        // Kullanicinin temel path'ini verir
        // C:\Users\Asus

        // Masaustune gitmek istersek
        // C:\Users\Asus + /Desktop eklememiz yeterlidir

        // Downloads'a gitmek istersek
        // C:\Users\Asus + /Downloads eklememiz yeterlidir

        /* Kodlarımızın dınamık olması
         yani kısının bılgısayarındakı kullanıcı adı gibi detaylara takılmaması için
         file testlerinde kullanılacak
         dosya yolunu "user.home" temel path'ini çalıştıgı bılgısayardan alacak sekılde olustururuz
        */

       // dosyaYolu="C:\\Users\\Asus\\Desktop\\merhabaJava.txt";
        String dinamikDosyaYolu=System.getProperty("user.home") + "\\Desktop\\merhabaJava.txt";




    }
}
