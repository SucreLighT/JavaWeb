# TomcatAndServlet

## Tomcat服务器软件：
	* Tomcat：
		1. 安装目录建议不要有中文和空格
		2. 默认访问端口为8080：http://localhost:8080 
		3. 可能遇到的问题：
				1. 黑窗口一闪而过：
					* 原因： 没有正确配置JAVA_HOME环境变量
				2. 端口号被占用
		4. 配置:
			* 部署项目的方式：
				1. 直接将项目打成一个war包，放置到webapps目录下。
				2. 配置conf/server.xml文件
					在<Host>标签体中配置
					<Context docBase="..." path="..." />
					* docBase:项目存放的路径
					* path：虚拟目录
				3. 在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写，这种方法最好，不要用的时候只要将该自定义的xml文件删除即可。
					<Context docBase="..." />		
		5. java动态项目的目录结构：
			-- 项目的根目录
			-- WEB-INF目录：
				-- web.xml：web项目的核心配置文件
				-- classes目录：放置字节码文件的目录
				-- lib目录：放置依赖的jar包


## Servlet：运行在服务器端的小程序
	* Servlet就是一个接口，定义了Java类被浏览器访问到(tomcat识别)的规则，自定义一个类，实现Servlet接口，复写其中方法。

	* 配置Servlet
		1. 在web.xml中配置：
		    <!--配置Servlet -->
		    <servlet>
		        <servlet-name>demo1</servlet-name>
		        <servlet-class>cn.itcast.web.servlet.ServletDemo1</servlet-class>
		    </servlet>
		
		    <servlet-mapping>
		        <servlet-name>demo1</servlet-name>
		        <url-pattern>/demo1</url-pattern> 虚拟路径，用于浏览器中访问
		    </servlet-mapping>
		2. Servlet3.0支持注解配置。可以不需要web.xml了。
		    在类上使用@WebServlet注解，进行配置
		    @WebServlet({"资源路径"})

	* 执行原理：
		1. 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
		2. 查找web.xml文件，查找对应的<url-pattern>内容。
		3. 如果找到，则获取对应的<servlet-class>类名
		4. tomcat通过类名使用class.forName()将字节码文件加载进内存，并cls.newInstance()
		5. 执行该Servlet子类中的方法，如service()

	* Servlet的生命周期：
		1. 默认情况下，第一次被访问时，Servlet被创建，执行init方法，只执行一次
			* 在<servlet>标签下可以配置执行Servlet的创建时机
			  <load-on-startup>的值为负数，表示第一次被访问时创建；为0或正整数表示在服务器启动时创建
			* Servlet的init方法只执行一次，说明Servlet在内存中只存在一个对象，Servlet是单例的
			  多个用户同时访问时，可能存在线程安全问题。
			  解决：尽量不要在Servlet类中定义成员变量。即使定义了成员变量，也不要对修改值，可以在函数中定义局部变量
		2.  destroy方法在Servlet被销毁之前执行，一般用于释放资源，只执行一次

## IDEA配置问题
	1. 新建模块后在WEB-INF下新建两个文件夹，classes用于存放servlet的字节码文件（.class），lib用于存放项目引用的包。
	2. 随后在Project Structure中进入Modules，将Paths的两个输出路径均改成该classes路径，然后在Dependencies中，选择＋号，新建JARS路径，选择创建的lib文件夹。  
    3. tomcat真正访问的是“tomcat部署的web项目”，对应着"工作空间项目" 的web目录下的所有资源，其中WEB-INF目录下的资源不能被浏览器直接访问。
	4. 进入Artifacts选项，增加输出目录为当前模块的输出目录，随后在Tomcat的Deployment中使用该目录。
	
## HttpServlet
    * 体系结构
        Servlet -- 接口
            |
        GenericServlet -- 抽象类
            |
        HttpServlet  -- 抽象类
    * GenericServlet：将Servlet接口中其他的方法做了默认空实现，只将service()方法作为抽象，定义Servlet类时，可以继承GenericServlet，实现service()方法即可
    * HttpServlet：是Servlet对http协议的一种封装，更加简化操作
        只需要定义类继承HttpServlet并复写doGet/doPost方法即可
        工作原理：浏览器发送七种请求，其中主要是get和post，Servlet根据req.getMethod()判断请求类型并执行相应的doGet/doPost方法   