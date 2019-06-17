package loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mengchen
 * @time 19-4-28 下午3:47
 */
public class HashLoadBalance {
    public String getServer(String remoteIp) {
        // 重建一个Map，避免服务器上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);
        // 取得Ip地址List
        List<String> keyList = new ArrayList<>(serverMap.keySet());
        int hashCode = remoteIp.hashCode();
        int serverPos = hashCode % keyList.size();
        return keyList.get(serverPos);
    }
}
