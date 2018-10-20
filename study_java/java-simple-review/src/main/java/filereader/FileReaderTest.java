package filereader;

import java.io.*;
import java.nio.CharBuffer;

/**
 * @author mengchen
 * @time 18-10-16 下午5:17
 */
public class FileReaderTest {



    public static void main(String[] args) throws IOException {
        String path = "/home/mengchen/Study/JavaStudy/study_java/java-simple-review/src/main/resources/test.txt";
        InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        int c;
        StringBuffer sb = new StringBuffer("");
        CharBuffer cb = CharBuffer.allocate(512);
        String line ;
        while ((c = reader.read(cb)) != -1) {
            sb.append(cb);
        }
        reader.close();
        inputStream.close();
        System.out.println(sb.toString());
    }
}
