<%--
  Created by IntelliJ IDEA.
  User: sucre
  Date: 2020/6/29
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EL获取域中数据</title>
    </head>
    <body>
        <%
            //在域中存储数据
            session.setAttribute("name","李四");
            request.setAttribute("name","张三");
            session.setAttribute("age","23");

        %>

        <h3>el获取值</h3>
        ${requestScope.name}<br>
        ${sessionScope.age}<br>
        ${sessionScope.haha}此处显示了一个空字符串<br>
        ${name} request域比session域小，因此这里获取的是request中的值 <br>
        ${sessionScope.name} 获取session域中的name

    </body>
</html>
