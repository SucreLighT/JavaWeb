package cn.sucre.jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/25
 * @time: 14:52
 */
public class JedisSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.sadd("set", "java", "php", "c++");

        Set<String> set = jedis.smembers("set");
        System.out.println(set);

        jedis.close();
    }
}
