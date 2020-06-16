## 会话技术
1. 会话：浏览器第一次给服务器发送请求时会话建立，直到有一方断开，一次会话中包含多次请求和响应。
2. 方式：客户端使用Cookie，服务器端使用Session

## Cookie
1. 实现原理：基于响应头中的set-cookie字段以及请求头中的cookie字段实现。
    + set-cookie字段信息例如：
        Set-Cookie: name=xyz; expires=Friday, 04-Feb-07 22:03:38 GMT; path=/; domain=runoob.com
        其中，expires 字段是一个指令，告诉浏览器在给定的时间和日期之后"忘记"该 Cookie；
    + 请求头中的cookie字段为：Cookie: name=xyz

2. cookie的使用
    + 创建cookie对象`new Cookie(String name, String value)`
    + 设置生存周期`cookie.setMaxAge(60*60*24);`
    + 发送cookie到响应头`response.addCookie(Cookie cookie)`
    + 获取cookie` Cookie[] request.getCookies()`

3. 在默认情况下，浏览器关闭后，cookie将会销毁，使用`setMaxAge(int second)`
    + second为正数，表示cookie存储在本地硬盘中的时间；
    + second为负数为默认情况；
    + second为0表示删除cookie信息。

4. setPath(String path)用于设置cookie的获取范围。
    + 默认情况下，设置为当前的虚拟目录；
    + 如果要共享，则可以将path设置为"/"，表示根目录下所有项目共享cookie。

5. setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
    + 例如，setDomain(".baidu.com"),那么tieba.baidu.com和news.baidu.com中cookie可以共享

6. cookie的作用和特点
    + cookie存储数据在客户端浏览器
    + 浏览器对于单个cookie的大小有限制(4kb)以及对同一个域名下的总cookie数量也有限制(20个)
    + cookie一般用于存储少量的不太敏感的数据
    + 在不登录的情况下，cookie用于完成服务器对客户端的身份识别
    
## JSP
1. JSP文件在调用时，会被转换成.java文件然后编译成为字节码文件，之后返回给客户端
2. JSP本质上是一个Servlet类，对应的.java文件继承了HttpJspBase这个类，该类继承了HttpServlet
3. JSP定义java代码的方式
    + <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
    + <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置，成员变量、成员方法、代码块，用得少。
    + <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。
4. JSP中的内置对象，不需要创建和获取，直接可以使用
    + 一个有九个 request，response，out等
    + response.getWriter()和out.write()的区别：
      在tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
      response.getWriter()数据输出永远在out.write()之前