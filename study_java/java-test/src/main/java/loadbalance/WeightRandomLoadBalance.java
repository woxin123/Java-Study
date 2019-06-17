package loadbalance;

import java.util.*;

/**
 * @author mengchen
 * @time 19-4-28 下午5:19
 */
public class WeightRandomLoadBalance {

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
        int randomPos = new Random().nextInt(serverList.size());
        return serverList.get(randomPos);
    }
}
