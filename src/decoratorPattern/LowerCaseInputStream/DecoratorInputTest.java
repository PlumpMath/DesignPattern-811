package decoratorPattern.LowerCaseInputStream;

import java.io.*;

/**
 * Created by pqylj on 2015/11/20 0020.
 */
public class DecoratorInputTest {
    public static void main(String[] args) {
        int c;
        try {
            InputStream stream = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("test.txt")
                    )
            );
            while ((c = stream.read()) >= 0) {
                System.out.print((char) c);
            }
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
