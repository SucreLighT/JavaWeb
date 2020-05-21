## 服务器端发送给客户端的数据
        消息格式主要包括：
        1. 响应行： 协议/版本 响应状态码 状态码描述
            状态码：
                1. 状态码都是3位数字 
                2. 分类：
                    1. 1xx：服务器就收客户端消息，但没有接受完成，等待一段时间后，发送1xx多状态码
                    2. 2xx：成功。代表：200
                    3. 3xx：重定向。代表：302(重定向)，304(访问缓存)
                    4. 4xx：客户端错误。
                            * 代表：
                            * 404（请求路径没有对应的资源） 
                            * 405：请求方式没有对应的doXxx方法
                     5. 5xx：服务器端错误。代表：500(服务器内部出现异常) 
        2. 响应头：
                1. 格式：头名称： 值
                2. 常见的响应头：
                       1. Content-Type：服务器告诉客户端本次响应体数据格式以及编码格式
                       2. Content-disposition：服务器告诉客户端以什么格式打开响应体数据
                           * 值：
                               * in-line:默认值,在当前页面内打开
                               * attachment;filename=xxx：以附件形式打开响应体。文件下载
        3. 响应空行
        4. 响应体:传输的数据
        
 ## Response对象
    * 用来设置响应消息格式
        1. 设置响应行的状态码 setStatus(int sc)
        2. 设置响应头数据：setHeader(String name, String value) 
        3. 设置响应体：
            步骤：
                1.获取输出流
                    设置编码防止中文乱码
                    response.setContentType("text/html;charset=utf-8");
                    字符输出流：PrintWriter getWriter()
                    字节输出流：ServletOutputStream getOutputStream()
                2. 使用输出流将数据输出到浏览器
 ## 案例
    * 重定向
        1. 简单的重定向方法
            response.sendRedirect("/day15/responseDemo2");
           
        2. 重定向redirect与转发forward的比较
            重定向的特点:redirect
                1. 地址栏发生变化
                2. 重定向可以访问其他站点(服务器)的资源
                3. 重定向是两次请求。不能使用request对象来共享数据
            转发的特点：forward
                1. 转发地址栏路径不变
                2. 转发只能访问当前服务器下的资源
                3. 转发是一次请求，可以使用request对象来共享数据
        
        3. 关于路径是否要加虚拟目录
            规则：判断路径是给谁用的？判断请求将来从哪儿发出
            * 给客户端浏览器使用：需要加虚拟目录 /
            * 给服务器使用：不需要加虚拟目录，如转发路径
        4. 建议使用request.getContextPath()动态获取虚拟目录   
        
