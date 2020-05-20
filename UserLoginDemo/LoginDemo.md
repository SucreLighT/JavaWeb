# 实现用户登录案例

    1. 导入写好的html页面以及相关jar包到WEB-INF的lib目录下
    2. 创建数据库以其中的user表
    3. 在Util目录下创建JDBCUtils类用于建立数据库连接池
    4. domain目录下创建数据库对应的实体类User
    5. DAO目录下创建数据库实体的操作类UserDAO，
       从JDBCUtils类中获取数据资源，执行sql查询操作并返回相应的查询结果
    6. 编写LoginServlet文件
        从表单中获取username和password信息，将信息封装之后调用UserDAO类与数据库中数据进行判断，
        根据sql查询结果返回不同的Servlet跳转
    
## 注意
    login.html前端界面中的form表单的action跳转路径为：虚拟目录+Servlet的资源路径，即/ + LoginDemo/LoginServlet

## 使用BeanUtils进行大量数据的封装，简化操作
    用于封装JavaBean，即标准Java类，这些类具有以下要求：
    1. 类必须由public修饰
    2. 必须有空参构造
    3. 成员变量必须由private修饰
    4. 有setter和getter方法
    常用方法：
     setProperty(Object,name,value)//设置属性值
     getProperty(Object,name)//获取属性值
     opulate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中
     
## 注意 成员变量和属性的区别
    成员变量是指类中定义的变量，如username
    属性是指setter和getter方法截取后的产物，例如：getUsername()的对应存在一个属性为username
    通常情况下两者一致，但是！！！
    例如在类中自定义的方法getMingzi()用于获取username属性，此时成员变量为username，属性为mingzi
    如，当使用BeanUtils.setProperty(user,username,zhangsan)后打印user显示username为空，因为不存在username的属性
    使用BeanUtils.setProperty(user,minbgzi,zhangsan)后显示正确。