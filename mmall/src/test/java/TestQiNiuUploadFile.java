import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import top.mcwebsite.util.PropertiesUtil;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author mengchen
 * @time 19-2-18 下午4:41
 */
public class TestQiNiuUploadFile {

    public static final String ACCESSKEY;

    public static final String SECRETKEY;

    static {
        ACCESSKEY = PropertiesUtil.getProperty("qiniu.accessKey");
        SECRETKEY = PropertiesUtil.getProperty("qiniu.secretKey");
    }

    public static void main(String[] args) {
        File file = new File("/home/mengchen/Pictures/哈士奇.jpg");
        String bucketName = "mcenthusiasm";
        getBucketsInfo();
        upload(bucketName, file);
    }

    public static void getBucketsInfo() {
        try {
            BucketManager bucketManager = getBucketManager();
            String[] bucketNms = bucketManager.buckets();
            for (String bucketName : bucketNms) {
                System.out.println(bucketName);
            }
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    public static BucketManager getBucketManager() {
        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        return bucketManager;
    }

    public static UploadManager getUploadManager() {
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        return uploadManager;
    }

    public static String getToken(String bucket) {
        Auth auth = Auth.create(ACCESSKEY, SECRETKEY);
        String upToken = auth.uploadToken(bucket);
        return upToken;
    }

    public static void upload(String bucketName, File file) {
        try {
            UploadManager uploadManager = getUploadManager();
            String token = getToken(bucketName);
            String uploadFileName = UUID.randomUUID().toString() + ".jpg";
            System.out.println(uploadFileName);
            Response response = uploadManager.put(file, uploadFileName, token);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}
