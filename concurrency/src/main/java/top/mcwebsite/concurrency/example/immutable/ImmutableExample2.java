package top.mcwebsite.concurrency.example.immutable;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.Collections;
import java.util.Map;

/**
 * final  Collections.unmodifiableXxx() 创建一个内容不可变的集合
 * 将集合集成并包装，把修改数据的方法重写，抛出不允许的操作异常。
 * @author mengchen
 * @time 19-3-30 下午8:41
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    public static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }


}
