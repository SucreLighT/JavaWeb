 ## JSP
 1. JSP文件在调用时，会被转换成.java文件然后编译成为字节码文件，之后返回给客户端
 2. JSP本质上是一个Servlet类，对应的.java文件继承了HttpJspBase这个类，该类继承了HttpServlet
 3. JSP定义java代码的方式
     + <%  代码 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
     + <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置，成员变量、成员方法、代码块，用得少。
     + <%= 代码 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。
 4. JSP中的指令
     + 格式：<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
     + page：配置JSP页面  
     contentType：等同于response.setContentType()，用于设置响应体的mime类型以及字符集。  
     import：导包。  
     errorPage：页面异常时自动跳转到指定页面。  
     isErrorPage：标识当前也是是否是错误页面。只有是时，可以使用内置对象exception。
     + include：页面包含
     + taglib：导入资源  
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        * prefix：前缀，自定义的标签名，uri：资源路径
 5. JSP中的注释
    + `<!--  -->`:只能注释html代码片段
    + `<%-- --%>`：可以注释所有,推荐使用
 6. JSP中的内置对象，不需要创建和获取，直接可以使用，前四个为域对象
     + 变量名-真实类型-作用  
     		* pageContext-PageContext-当前页面共享数据，还可以获取其他八个内置对象  
     		* request-HttpServletRequest-一次请求访问的多个资源(转发)  
     		* session-HttpSession-一次会话的多个请求间  
     		* application-ServletContext-所有用户间共享数据  
     		* response-HttpServletResponse-响应对象  
     		* page-Object-当前页面(Servlet)的对象  this  
     		* out-JspWriter-输出对象，数据输出到页面上  
     		* config-ServletConfig-Servlet的配置对象  
     		* exception-Throwable-异常对象  
     + response.getWriter()和out.write()的区别：
       在tomcat服务器真正给客户端做出响应之前，会先找response缓冲区数据，再找out缓冲区数据。
       response.getWriter()数据输出永远在out.write()之前
       
 ## MVC框架
 1. Model：使用JavaBean，View：JSP，Controller：Servlet。
 2. 耦合性低，方便维护，重用性高。
 
 ## EL表达式
 1. 用于在JSP界面中简化java代码的编写
 2. 语法格式：${表达式}
 3. 如果要忽略EL表达式：
    + 在JSP的page指令中设置isELIgnored="true"
    + 使用反斜杠转义来忽略单个表达式：\${表达式}
 4. 运算符：
    + `+ - * / div % mod`
    + `> < >= <= == !=`
    + `&& || ! and or not`
    + 空运算符empty：判断字符串、集合或数组对象是否为null或者长度为0。
 5. EL表达式只能从四个域对象中获取值。
    + 语法：${域名称.键名}
    + 例如：在request域中存储了name=张三，获取：${requestScope.name}
    + 如果获取的键名不存在，则会返回一个空字符串
    + 直接使用${键名}获取，表示依次从最小的域中查找该键名，直到找到位置。
    + 获取对象的值${域名称.键名.属性名}其本质上会去调用属性的getter方法，如果不存在getter方法则无法获取。
    + 获取List集合中的值：${域名称.键名[索引]}
    + 获取Map集合中的值：${域名称.键名.key名称}或者${域名称.键名["key名称"]}
 
 ## JSTL JSP标准标签库
 1. 简化和替换JSP页面上的java代码
 2. 使用步骤：
    + 导入jstl相关jar包
    + 引入标签库：taglib指令：  <%@ taglib %>
    + 使用标签
 3. if标签 相当于if语句
    + test必须属性，接受boolean表达式，如果为true则显示标签体内容
 4. choose:相当于java代码的switch语句
    + 使用choose标签声明         			相当于switch声明
    + 使用when标签做判断         			相当于case
    + 使用otherwise标签做其他情况的声明    	相当于default
 
 5. foreach:相当于java代码的for语句