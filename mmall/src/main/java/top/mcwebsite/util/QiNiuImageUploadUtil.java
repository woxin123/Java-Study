package top.mcwebsite.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Default;
import java.io.File;
import java.util.List;

/**
 * @author mengchen
 * @time 19-2-18 下午7:42
 */
public class QiNiuImageUploadUtil {

    private static final Logger logger = LoggerFactory.getLogger(QiNiuImageUploadUtil.class);

    private static final String QINIU_ACCESSKEY = PropertiesUtil.getProperty("qiniu.accessKey");

    private static final String QINIU_SECRETKEY = PropertiesUtil.getProperty("qiniu.secretKey");

    private static final String BUCKETNAME = PropertiesUtil.getProperty("qiniu.bucketName");

    private static Configuration configuration = new Configuration(Zone.zone0());

    private static UploadManager uploadManager = new UploadManager(configuration);

    private static Auth auth = Auth.create(QINIU_ACCESSKEY, QINIU_SECRETKEY);

    private static String upToken = auth.uploadToken(BUCKETNAME);

    public static boolean uploadImageToQiNiuYun(List<File> files) {
        for (File file : files) {
            Response response = null;
            try {
                response = uploadManager.put(file, file.getName(), upToken);
            } catch (QiniuException e) {
                logger.error("上传文件: {}, 出错", file.getName());
            }
            if (!response.isOK()) {
                return false;
            }
            logger.info("文件：{}，上传成功", file.getName());
        }
        return true;
    }
}
