package loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mengchen
 * @time 19-4-28 上午9:38
 */
public class RoundRobin {

    private static Integer pos = 0;

    public static String getServer() {
        // 重建一个Map，避免上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);
        // 取得Ip地址List
        List<String> keyList = new ArrayList<>(serverMap.keySet());
        String server = null;
        synchronized (pos) {
            if (pos > keyList.size()) {
                pos = 0;
            }
            server = keyList.get(pos);
            pos++;
        }
        return server;
    }
}
