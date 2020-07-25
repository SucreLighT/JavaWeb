package cn.sucre.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/25
 * @time: 14:46
 */
public class JedisList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.lpush("list", "a", "b", "c");
        jedis.rpush("list", "a", "b", "c");

        List<String> list = jedis.lrange("list", 0, -1);
        System.out.println(list);

        String element1 = jedis.lpop("list");
        System.out.println(element1);

        String element2 = jedis.rpop("list");
        System.out.println(element2);

        jedis.close();
    }
}
