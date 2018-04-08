

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
* DES加密算法
*/
public class DESUtil {
    public DESUtil() {
    }

    // 测试
    public static void main(String[] args) {
        String dataSource = "toHexString";
        // 密码长度是8的倍数
        String password = "12345678";
        // 加密
        byte[] result = DESUtil.encypt(dataSource.getBytes(), password);
        System.out.println("加密后: " + new String(result));
        // 解密
        byte[] decryptresult = DESUtil.decrypt(result, password);
        System.out.println("解密后: " + new String(decryptresult));
    }

    /**
    * 获取Cipher对象
    */
    private static Cipher generateCipher(String password, int cipherMode) {
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKeySpec = new DESKeySpec(password.getBytes());
            // 创建一个秘钥工厂，然后把DESKeySpec转换成SecretKey
            SecretKeyFactory desKeyFactory = SecretKeyFactory.getInstance("DES");
            // 生成一个秘钥
            SecretKey secretKey = desKeyFactory.generateSecret(desKeySpec);
            // Cliper对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用秘钥初始化Cipher对象，ENCRYPT_MODE用于将Cipher初始化为常量
            cipher.init(cipherMode, secretKey, random);
            return cipher;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * 加密
    */
    public static byte[] encypt(byte[] dataSource, String password) {
        Cipher cipher = generateCipher(password, Cipher.ENCRYPT_MODE);
        try {
            return cipher.doFinal(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
    * 解密
    */
    public static byte[] decrypt(byte[] src, String password) {
        Cipher cipher = generateCipher(password, Cipher.DECRYPT_MODE);
        try {
            return cipher.doFinal(src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
