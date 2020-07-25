package cn.sucre.jedis;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/25
 * @time: 14:30
 */
public class JedisString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();

        jedis.set("username", "zhangsan");

        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的 key value
        //将activecode：hehe键值对存入redis，并且20秒后自动删除该键值对
        jedis.setex("activecode", 20, "hehe");

        jedis.close();
    }
}
