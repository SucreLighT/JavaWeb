<%@ page import="cn.sucre.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: sucre
  Date: 2020/6/30
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EL获取对象、集合中的数据</title>
    </head>
    <body>
        <%
            User user = new User();
            user.setName("张三");
            user.setAge(23);
            user.setBirthday(new Date());

            request.setAttribute("u",user);

            List list = new ArrayList();
            list.add("aaa");
            list.add("bbb");
            list.add(user);

            request.setAttribute("list",list);


            Map map = new HashMap();
            map.put("sname","李四");
            map.put("gender","男");
            map.put("user",user);

            request.setAttribute("map",map);


        %>

        <h3>EL获取对象中的值</h3>
        姓名：${requestScope.u.name} <br>
        年龄：${requestScope.u.age} <br>
        出生日期：${requestScope.u.birthday} <br>
        格式化出生日期：${requestScope.u.birStr} 对应存在getBirStr方法才能生效<br>

        <h3>el获取List值</h3>
        ${list}<br>
        ${list[0]}<br>
        ${list[1]}<br>
        ${list[10]}<br>

        ${list[2].name}

        <h3>el获取Map值</h3>
        ${map.gender}<br>
        ${map["gender"]}<br>
        ${map.user.name}
    </body>
</html>
