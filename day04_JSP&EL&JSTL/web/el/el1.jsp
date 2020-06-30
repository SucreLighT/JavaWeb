<%--
  Created by IntelliJ IDEA.
  User: sucre
  Date: 2020/6/29
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>EL运算符表达式</title>
    </head>
    <body>
        \${3 > 4}忽略表达式<br>
        <h3>算数表达式</h3>
        ${3 + 4}<br>
        ${3 / 4}<br>
        ${3 div 4}<br>
        ${3 % 4}<br>
        ${3 mod 4}<br>
        <h3>比较表达式</h3>
        ${3 <= 4}<br>
        <h3>逻辑表达式</h3>
        ${3 < 4 && 4 < 5}<br>
        ${3 < 4 and 4 < 5}<br>
    </body>
</html>
