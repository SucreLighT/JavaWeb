package cn.sucre.jedispool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/25
 * @time: 15:30
 */
public class JedisPoolDemo {
    public static void main(String[] args) {

        // 1. 创建连接池对象
        JedisPool jedisPool = new JedisPool();

        // 2. 从连接池中获取一个jedis对象
        Jedis jedis = jedisPool.getResource();

        // 3. 使用jedis对象
        jedis.set("hehe","haha");

        // 4. 关闭对象，返还到连接池中
        jedis.close();
    }
}
