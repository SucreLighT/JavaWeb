package cn.sucre.jedis;

import redis.clients.jedis.Jedis;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/25
 * @time: 14:27
 */

public class JedisDemo1 {
    public static void main(String[] args) {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        jedis.set("username", "zhangsan");
        //3. 关闭连接
        jedis.close();
    }
}
