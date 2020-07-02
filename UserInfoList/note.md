## 服务器中三层架构
1. 界面层（表示层，web层）：用户通过界面上的组件与服务器交互。
    + 接受用户参数，封装数据，调用service层进行处理，并完成jsp转发显示。
2. 业务逻辑层（service层）：处理业务逻辑，最为重要。
    + 组合DAO中的简单方法，形成复杂的逻辑操作。
3. 数据访问层（dao层）：操作数据存储文件。
    + 定义数据库最基本的CURD操作。

## 开发过程
1. 新建项目模块，选择Java Enterprise中的Web项目。
2. 创建对应的数据库表。
3. 配置Tomcat服务器，设置虚拟访问目录以及端口。
4. 在web目录下新建WEB-INF目录，其中新建lib目录用于存放项目依赖的jar包。
5. 导入jar包并将lib目录add as library。
6. 将前端静态资源导入到web目录下，启动服务器测试静态页面是否正确显示。
7. 在src下创建目录cn.sucre，其下创建如下目录：
    + domain：具体的JavaBean实现类。
    + util：相关工具类，如连接数据库。
    + web：web层代码。
    + service：service层代码。
    + dao：dao层代码。

## 案例分析
### 查询用户信息列表
1. web层
    + 创建Servlet，调用service层的findAll()，返回list集合List<User>。
    + 将list集合存到request域中。
    + 将list转发到list.jsp中显示，采用jstl+el技术，使用foreach标签遍历list生成table。
2. service层
    + 设计UserService接口，其中编写findALL()方法。
    + 创建UserServiceImpl类实现接口，该类中调用dao层中的数据基本操作方法。
    + 在web层中实例化该实现类来实现方法调用，开发中常用这种面向实现类的方式。
3. dao层
    + 设计UserDao接口以及相应的实现类UserDaoImpl，实现类中包含数据基本操作。
4. 开发过程：
    + 在domain中创建User实体类，并加入setter和getter以及toString方法。
    + 修改index.jsp界面，使其跳转到service的Servlet，其中注意采用**动态获取虚拟目录**。
    + 配置druid连接池配置文件，在util中设计JDBCUtils用于连接数据库。
    + 创建相关Servlet和java类实现功能。