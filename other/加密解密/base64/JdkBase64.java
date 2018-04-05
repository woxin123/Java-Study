/**
* 使用JDK中的base64
*/
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.io.IOException;

public class JdkBase64 {

  private static String src = "这里的山路十八弯";

  public static void jdkBase64() {
    try {
      BASE64Encoder encoder = new BASE64Encoder();
      String encode = encoder.encode(src.getBytes());
      System.out.println("encoder: " + encode);

      BASE64Decoder decoder = new BASE64Decoder();
      String decode = new String(decoder.decodeBuffer(encode));
      System.out.println("decode: " + decode);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public static void main(String[] args) {
    JdkBase64.jdkBase64();
  }
}
