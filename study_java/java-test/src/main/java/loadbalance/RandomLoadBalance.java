package loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author mengchen
 * @time 19-4-28 下午3:32
 */
public class RandomLoadBalance {

    public static String getServer() {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);
        ArrayList<String> keyList = new ArrayList<>(serverMap.keySet());

        String server = null;
        Random random = new Random();
        return keyList.get(random.nextInt(keyList.size()));
    }
}
