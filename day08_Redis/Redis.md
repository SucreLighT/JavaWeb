## Redis
1. redis是一款高性能的NOSQL系列的非关系型数据库

2. NOSQL和关系型数据库比较
    1. 优点：
        * 成本：nosql数据库简单易部署，基本都是开源软件，不需要像使用oracle那样花费大量成本购买使用，相比关系型数据库价格便宜。
        * 查询速度：nosql数据库将数据存储于缓存之中，关系型数据库将数据存储在硬盘中，自然查询速度远不及nosql数据库。
        * 存储数据的格式：nosql的存储格式是key,value形式、文档形式、图片形式等等，所以可以存储基础类型以及对象或者是集合等各种格式，而数据库则只支持基础类型。
        * 扩展性：关系型数据库有类似join这样的多表查询机制的限制导致扩展很艰难。
    
    2. 缺点：
        * 维护的工具和资料有限，因为nosql是属于新的技术，不能和关系型数据库10几年的技术同日而语。
        * 不提供对sql的支持，如果不支持sql这样的工业标准，将产生一定用户的学习和使用成本。
        * 不提供关系型数据库对事务的处理。
    
    3. 非关系型数据库的优势：
        * 性能NOSQL是基于键值对的，可以想象成表中的主键和值的对应关系，而且不需要经过SQL层的解析，所以性能非常高。
        * 可扩展性同样也是因为基于键值对，数据之间没有耦合性，所以非常容易水平扩展。
    
    4. 关系型数据库的优势：
        * 复杂查询可以用SQL语句方便的在一个表以及多个表之间做非常复杂的数据查询。
        * 事务支持使得对于安全性能很高的数据访问要求得以实现。对于这两类数据库，对方的优势就是自己的弱势，反之亦然。
    
    5. 总结
    * 关系型数据库与NoSQL数据库并非对立而是互补的关系，即通常情况下使用关系型数据库，在适合使用NoSQL的时候使用NoSQL数据库，
    让NoSQL数据库对关系型数据库的不足进行弥补。
    * 一般会将数据存储在关系型数据库中，在nosql数据库中备份存储关系型数据库的数据

3. redis安装使用：官网下载压缩包后直接解压
    1. 文件说明
        * redis.windows.conf：配置文件
        * redis-cli.exe：redis的客户端
        * redis-server.exe：redis服务器端
    2. 启动：
        * redis-server.exe redis.windows.conf 启动服务器
        * redis-cli.exe -h 127.0.0.1 -p 6379 启动客户端
        
4. 数据类型
    1. 字符串类型 string
        * 存储： `set key value` `set username zhangsan`
        * 获取： `get key`  `get username` :"zhangsan"
        * 删除： `del key`  `del age`
    2. 哈希类型 hash
        * 存储： `hset key field value` `hset myhash username lisi` `hset myhash password 123`    
        * 获取：
            * `hget key field` `hget myhash username` :lisi"
            *  `hgetall key` `hgetall myhash`
        * 删除： `hdel key field` `hdel myhash username`

    3. 列表类型 list:允许重复元素。可以添加一个元素到列表的头部（左边）或者尾部（右边）
        * 添加：
            * `lpush key value` 将元素加入列表左表   
            * `rpush key value` 将元素加入列表右边
            * `lpush myList a`       
        * 获取：
            * `lrange key start end` ：范围获取，所有范围为：0 -1
            * `lrange myList 0 -1`
        * 删除：
            * `lpop key` 删除列表最左边的元素，并将元素返回
            * `rpop key` 删除列表最右边的元素，并将元素返回 
    4. 集合类型 set ： 不允许重复元素,按字典顺序排放
        * 存储：`sadd key value` `sadd myset a`
        * 获取：
            * `smembers key` 获取set集合中所有元素
            * `smembers myset`
        * 删除：
            * `srem key value` 删除set集合中的某个元素	
            * `srem myset a`
    5. 有序集合类型 sortedset：不允许重复元素，且元素有顺序.每个元素都会关联一个double类型的分数。redis正是通过分数来为集合中的成员进行从小到大的排序。可以具有相同分数，此时按照字典排序。
        * 存储：
            * `zadd key score value`
            * `zadd mysort 60 zhangsan`
        * 获取：
            * `zrange key start end [withscores]`
            * `zrange mysort 0 -1` 
        * 删除：
            * `zrem key value`
            * `zrem mysort lisi`
5. 通用命令
    1. keys * : 查询所有的键
    2. type key ： 获取键对应的value的类型
    3. del key：删除指定的key value
    
6. Redis数据库的持久化
    1. RDB：默认方式，不需要进行配置，默认就使用这种机制
        * 在redis.windwos.conf文件中设置`save 900 1`表示after 900 sec (15 min) if at least 1 key changed
        * 在一定的间隔时间中，检测key的变化情况，然后持久化数据，在redis目录下保存为dump.rdb文件               				
        * 注意：修改配置文件后，重启服务器r`edis-server.exe redis.windows.conf`	
    2. AOF：日志记录的方式，可以记录每一条命令的操作。可以每一次命令操作后，持久化数据。
        * 编辑redis.windwos.conf文件：`appendonly no（关闭aof） --> appendonly yes （开启aof）`
        * `appendfsync always`：每一次操作都进行持久化，`appendfsync everysec`：每隔一秒进行一次持久化，`appendfsync no`：不进行持久化

## Jedis：一款java操作redis数据库的工具
1. 使用
    *  下载并导入jedis的jar包
    * 基本步骤：
     ```
    //1. 获取连接
    Jedis jedis = new Jedis("localhost",6379); //如果使用空参构造，默认值 "localhost",6379端口
    //2. 操作
    jedis.set("username","zhangsan");
    //3. 关闭连接
    jedis.close();
      ```
2. 直接调用jedis对象中的方法操作各类数据即可。

