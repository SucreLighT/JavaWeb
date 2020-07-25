package cn.sucre.jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/25
 * @time: 14:55
 */
public class JedisSortedSet {
    public static void main(String[] args) {

        Jedis jedis = new Jedis();

        jedis.zadd("sortedset", 30, "tom");
        jedis.zadd("sortedset", 30, "bob");
        jedis.zadd("sortedset", 55, "alice");


        Set<String> sortedset = jedis.zrange("sortedset", 0, -1);

        System.out.println(sortedset);

        jedis.close();
    }
}
