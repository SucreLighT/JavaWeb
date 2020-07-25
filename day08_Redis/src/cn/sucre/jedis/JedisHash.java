package cn.sucre.jedis;

import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @description:
 * @author: sucre
 * @date: 2020/07/25
 * @time: 14:36
 */
public class JedisHash {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "female");

        String name = jedis.hget("user", "name");
        int age = Integer.parseInt(jedis.hget("user", "age"));
        String gender = jedis.hget("user", "gender");

        System.out.println(name + "--" + age + "--" + gender);

        Map<String, String> user = jedis.hgetAll("user");

        for (Map.Entry<String, String> set : user.entrySet()
        ) {
            System.out.println(set.getKey() + ":" + set.getValue());
        }

        // for(String key : keySets){
        //     String value = user.get(key);
        //     System.out.println(key + ":" + value);
        // }

        jedis.close();
    }
}
