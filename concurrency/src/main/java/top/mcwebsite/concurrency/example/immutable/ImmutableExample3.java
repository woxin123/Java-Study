package top.mcwebsite.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import top.mcwebsite.concurrency.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * final  Collections.unmodifiableXxx() 创建一个内容不可变的集合
 * 将集合集成并包装，把修改数据的方法重写，抛出不允许的操作异常。
 *
 * @author mengchen
 * @time 19-3-30 下午8:41
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3<K, V> {

    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet<Integer> set = ImmutableSet.copyOf(list);

    public static final ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4, 5, 6);

    public static final ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2)
            .put(3, 4).build();

    public static void main(String[] args) {
//        set.add(4);
//        map.put(1, 4);
        System.out.println(map.get(1));
    }


}
