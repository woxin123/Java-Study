package top.mcwebsite.rsa;

import com.sun.org.apache.xml.internal.security.keys.KeyUtils;
import org.apache.commons.codec.binary.StringUtils;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.encoders.Base64;
import sun.security.rsa.RSAPublicKeyImpl;
import sun.security.util.KeyUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author mengchen
 * @time 18-8-27 下午5:48
 */
public class RSATest {

    private static final String PRIVATE_KEY_ATTRIBUTE_NAME = "privateKey";

    PrivateKey privateKey;
    static RSAPublicKey  publicKey;


    /*****生成密钥对，返回公钥、私钥放session********/
    public RSAPublicKey generateKey() {
        KeyPair keyPair = RSAUtils.generateKeyPair();
        publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.privateKey = privateKey;
//        System.out.println(publicKey);
        System.out.println(publicKey.getPublicExponent());
        System.out.println(Base64.toBase64String(publicKey.getModulus().toByteArray()));
        System.out.println(publicKey.getModulus());
        System.out.println(Base64.toBase64String(publicKey.getPublicExponent().toByteArray()));
        return publicKey;
    }
//
//    /*******从session中清除私钥*************/
//    public void removePrivateKey(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        session.removeAttribute(PRIVATE_KEY_ATTRIBUTE_NAME);
//    }


    /*********解密字符串*****************/
    public String decrxxyptParameter(String parameter) {
        if (parameter != null) {
            return RSAUtils.decrypt(privateKey, parameter);
        }
        return null;
    }

    public static String jiami(String parameter) throws UnsupportedEncodingException {
        byte[] encrypt = RSAUtils.encrypt(publicKey, parameter.getBytes("UTF-8"));
        System.out.println(new String(encrypt));
        return Base64.toBase64String(encrypt);

    }

    public static String encryptByPublicKey(String data, String key) throws Exception {
        byte[] keyb = Base64.decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyb);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] mi = cipher.doFinal(data.getBytes());

        return new String( Base64.encode(new BigInteger(mi).toString(16).getBytes()));
    }

    public static void main(String[] args) throws Exception {
        RSATest test = new RSATest();
        test.generateKey();
////        AsymmetricKeyParameter key = PublicKeyFactory.createKey(Base64.decode("AOdA2+GiuFAlOwvlXjA9vIszWpICGZkW8RDEoxp/CwFjKNXiCEdLlCT1pTGJ8Yl5uG2VxzBbGkfy+HLwVxVPpcSLA2ZFtsidQQF+hGMqZk28rqgDaba7zb0u9n6NSwFHicMNz8w/jwWl3RQNb521NtASVaym3n0z3mDH2LZbryfx"));
//
//        System.out.println(test.jiami("mengchen129314"));
//
//        System.out.println(Base64.decode("AJ0yQzAIYzCvCGI8eKEbLo++UFttrsICFqm3kiKXheVbBn6b/IGBXB/zz7TFtTzifVOmLISz+WDU2qc2h4nT8PTLUdeh+dRZinrsgVaVkxnrvVCTTJsR9OJtN0hBwTaaYyySo86FEWXWHxMOKJnR1ZPFDGSb5AGefcFZwW+EE04Z"));
//        System.out.println(new String(Base64.decode("5oiR5piv5YK75a2Q")));
//        System.out.println(new String(Base64.encode("我是傻子".getBytes("UTF-8"))));



        String raskey = "AIjb4RH6mGLgPJ6aVw56u++GSO3ibmtwOqsEsoDyhRsF6agsFtIJ1TtpaoUnaKiiiCGWyVZ62iRmuVRra3FKr+0oqhmr52htGAhOeu4Jk8LuIcaPvGxidbt3avzZFJZyeWz2m/GWRy2tcfrfUgWEm77gUfsvuwo/8xCI3oJRc9vP";
        byte[] key = Base64.decode(raskey);
        BigInteger bigInteger = new BigInteger(key);
        System.out.println(bigInteger);
        BigInteger e = new BigInteger("65537");
//        BigInteger n = bigInteger;
//
//        BigInteger m = new BigInteger("mengchen129314".getBytes());
//
//        BigInteger c = m.modPow(e, n);
//        System.out.println(c);
//        System.out.println(Base64.toBase64String(c.toString(16).getBytes()));
//        String mi = encryptByPublicKey("mengchen129314", raskey);
//        System.out.println(mi);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(bigInteger, e);
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        publicKey = rsaPublicKey;
        String mi = jiami("mengchen129314");
        System.out.println(mi);
    }

}
