package IO流;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @program: java_suanfa
 * @description:
 * @author: HuRan
 * @create: 2020-09-11 10:57
 */
public class IOTest {
    @Test
    public void testFileReader() throws IOException {
        File file = new File("hello.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fr = new FileReader(file);
         int data = fr.read();
        while (data != -1) {
            System.out.println((char)data);
            data = fr.read();
        }
        fr.close();
    }

}