package top.mcwebsite.rsa;

import com.sun.org.apache.xml.internal.security.keys.KeyUtils;
import org.apache.commons.codec.binary.StringUtils;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.encoders.Base64;
import sun.security.rsa.RSAPublicKeyImpl;
import sun.security.util.KeyUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @author mengchen
 * @time 18-8-27 下午5:48
 */
public class RSATest {

    private static final String PRIVATE_KEY_ATTRIBUTE_NAME = "privateKey";

    PrivateKey privateKey;
    RSAPublicKey publicKey;


    /*****生成密钥对，返回公钥、私钥放session********/
    public RSAPublicKey generateKey() {
        KeyPair keyPair = RSAUtils.generateKeyPair();
        publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.privateKey = privateKey;
//        System.out.println(publicKey);
        System.out.println(publicKey.getModulus().toString(16));
        System.out.println(Base64.toBase64String(publicKey.getModulus().toByteArray()));
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

    public String jiami(String parameter) throws UnsupportedEncodingException {
        byte[] encrypt = RSAUtils.encrypt(publicKey, parameter.getBytes("UTF-8"));
        System.out.println(new String(encrypt));
        return Base64.toBase64String(encrypt);

    }

    public static void main(String[] args) throws IOException {
        RSATest test = new RSATest();
        test.generateKey();
//        AsymmetricKeyParameter key = PublicKeyFactory.createKey(Base64.decode("AOdA2+GiuFAlOwvlXjA9vIszWpICGZkW8RDEoxp/CwFjKNXiCEdLlCT1pTGJ8Yl5uG2VxzBbGkfy+HLwVxVPpcSLA2ZFtsidQQF+hGMqZk28rqgDaba7zb0u9n6NSwFHicMNz8w/jwWl3RQNb521NtASVaym3n0z3mDH2LZbryfx"));

        System.out.println(test.jiami("mengchen129314"));

        System.out.println(Base64.decode("AJ0yQzAIYzCvCGI8eKEbLo++UFttrsICFqm3kiKXheVbBn6b/IGBXB/zz7TFtTzifVOmLISz+WDU2qc2h4nT8PTLUdeh+dRZinrsgVaVkxnrvVCTTJsR9OJtN0hBwTaaYyySo86FEWXWHxMOKJnR1ZPFDGSb5AGefcFZwW+EE04Z"));
    }

}
