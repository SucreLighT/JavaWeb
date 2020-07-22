## Ajax
1. 概念：AJAX = Asynchronous JavaScript and XML（异步的 JavaScript 和 XML）
    * 同步：客户端必须等待服务器端的响应。在等待的期间客户端不能做其他操作。
    * 异步：客户端不需要等待服务器端的响应。在服务器处理请求的过程中，客户端可以进行其他的操作。
    * Ajax技术能在无需重新加载整个网页的情况下，更新部分网页，使网页实现异步更新。
2. 实现方式
    * 原生JS方式
        1. 创建核心对象xmlhttp
            ```
            var xmlhttp;
            if (window.XMLHttpRequest)
            {// code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
           ```
        2. 使用open方法建立连接  
            参数：
            * 请求方式：GET、POST
                * get方式，请求参数在URL后边拼接。send方法为空参。
                * post方式，请求参数在send方法中定义。
            * 请求的URL。
            * 同步或异步请求：true（异步）或 false（同步）。
            * 例如：xmlhttp.open("GET","ajaxServlet?username=tom",true);
        3. 使用send方法发送请求
        4. 接受并处理来自服务器的响应结果
            * 使用XMLHttpRequest对象的responseText或responseXML属性接受结果。
            * 当服务器响应成功后再获取
            * 当xmlhttp对象的就绪状态改变时，触发事件onreadystatechange。
            ```
            xmlhttp.onreadystatechange=function()
            {
                //判断readyState就绪状态是否为4，判断status响应状态码是否为200
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {
                   //获取服务器的响应结果
                    var responseText = xmlhttp.responseText;
                    alert(responseText);
                }
            }
            ```
    * JQ中使用Ajax
        1. $.ajax()
            * 语法：$.ajax({键值对});
            * 键值对主要包括：
                * url：设置请求路径，必选项。
                * type：请求方式，默认为GET。
                * data：发送到服务器的数据。
                * 回调函数：主要有beforeSend、error、dataFilter、success、complete。
                ```
                $.ajax({
                    url:"ajaxServlet1111" , // 请求路径
                    type:"POST" , //请求方式
                    //data: "username=jack&age=23",//请求参数
                    data:{"username":"jack","age":23},
                    success:function (data) {
                        alert(data);
                    },//响应成功后的回调函数
                    error:function () {
                        alert("出错啦...")
                    },//表示如果请求响应出现错误，会执行的回调函数
    
                    dataType:"text"//设置接受到的响应数据的格式
                });
                ```
        2. $.get()：发送GET类型请求
            * 语法：$.get(url, [data], [callback], [type])
                * 参数：
                    * url：请求路径
                    * data：请求参数
                    * callback：回调函数
                    * type：响应结果的类型
    
        3. $.post()：发送post请求
            * 语法：$.post(url, [data], [callback], [type])
                * 参数：
                    * url：请求路径
                    * data：请求参数
                    * callback：回调函数
                    * type：响应结果的类型

    
## Json


