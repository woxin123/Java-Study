package loadbalance;

import java.util.*;

/**
 * @author mengchen
 * @time 19-4-28 下午4:04
 */
public class WeightRoundRobin {

    private static Integer pos;

    public static String getServer() {
        // 重建一个Map，避免服务器上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>(IpMap.serverWeightMap);

        // 取得Ip地址List
        List<String> serverList = new ArrayList<>();
        Iterator<String> iterator = serverMap.keySet().iterator();
        while (iterator.hasNext()) {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                serverList.add(server);
            }
        }
        String server = null;
        synchronized (pos){
            if (pos > serverList.size()) {
                pos = 0;
            }
            server = serverList.get(pos);
            pos++;
        }
        return server;
    }
}
