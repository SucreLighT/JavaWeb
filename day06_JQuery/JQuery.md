## JQuery

### JQuery简介
1. JQuery是一个快速、简洁的JavaScript框架，用于简化JS开发，优化HTML文档操作、事件处理、动画设计和Ajax交互。
2. JQuery对象和JS对象区别与转换
    + JQuery对象在操作时，更加方便。
    + JQuery对象和js对象方法不通用的。
    + 两者相互转换
       * jq -- > js : jq对象[索引] 或者 jq对象.get(索引)
       * js -- > jq : $(js对象)

### JQuery语法
1. 基本操作：
    + 事件绑定，获取html元素，执行相应的操作。
        + 例如：$("#b1").click(function(){});
    + 入口函数，与JavaScript中的window.onload = function () {}类似
        + 使用方式： $(function () {});或$(document).ready(function(){});
    + $(function)  和 window.onload 区别
        + window.onload 只能执行一次,如果执行第二次，第一次的执行会被覆盖掉，$(function)可以执行多次，不会覆盖。
        + $(function)是在 html 所有标签(DOM)都加载之后，就会去执行，window.onload事件是等到所有内容，包括外部图片之类的文件加载完后，才会执行。
    + 样式控制，用于修改css样式，获取html对象后调用css()方法即可
        + $("#div1").css("background-color","red"); 使用css样式中的属性名
        + $("#div1").css("backgroundColor","pink"); 使用JQ的属性名，将间隔符-删除，小写改大写即可。
        
2. 选择器分类
    1. 基本选择器
        1. 标签选择器（元素选择器）
            * 语法： $("html标签名") 获得所有匹配标签名称的元素
      	2. id选择器 
      		* 语法： $("#id的属性值") 获得与指定id属性值匹配的元素
      	3. 类选择器
      		* 语法： $(".class的属性值") 获得与指定的class属性值匹配的元素
      	4. 并集选择器：
      		* 语法： $("选择器1,选择器2....") 获取多个选择器选中的所有元素
    2. 层级选择器
      	1. 后代选择器
      		* 语法： $("A B ") 选择A元素内部的所有B元素		
      	2. 子选择器
      		* 语法： $("A > B") 选择A元素内部的所有B子元素,**只涉及儿子，不包括孙子及以下**
    3. 属性选择器
      	1. 属性名称选择器 
      		* 语法： $("A[属性名]") 包含指定属性的选择器
      	2. 属性选择器
      		* 语法： $("A[属性名='值']") 包含指定属性等于指定值的选择器
      		* **匹配符号**：=表示等于，!=表示不等于，^=表示以该值为前缀，$=表示以该值为后缀，*=表示包含该值
      	3. 复合属性选择器
         	* 语法： $("A[属性名='值'][]...") 包含多个属性条件的选择器，**是交集关系，必须同时满足**
    4. 过滤选择器
      	1. 首元素选择器 
      		* 语法： :first 获得选择的元素中的第一个元素
      	2. 尾元素选择器 
      		* 语法： :last 获得选择的元素中的最后一个元素
      	3. 非元素选择器
      		* 语法： :not(selector) 不包括指定内容的元素
      	4. 偶数选择器
      		* 语法： :even 偶数，从 0 开始计数
      	5. 奇数选择器
      		* 语法： :odd 奇数，从 0 开始计数
      	6. 等于索引选择器
      		* 语法： :eq(index) 指定索引元素
      	7. 大于索引选择器 
      		* 语法： :gt(index) 大于指定索引元素
      	8. 小于索引选择器 
      		* 语法： :lt(index) 小于指定索引元素
      	9. 标题选择器
      		* 语法： :header 获得标题（h1~h6）元素，固定写法
    5. 表单过滤选择器
      	1. 可用元素选择器 
      		* 语法： :enabled 获得可用元素
      	2. 不可用元素选择器 
      		* 语法： :disabled 获得不可用元素
      	3. 选中选择器 
      		* 语法： :checked 获得单选/复选框选中的元素
      	4. 选中选择器 
      		* 语法： :selected 获得下拉框选中的元素
      		
### JQuery操作HTML-DOM操作
1. 内容操作,**设置内容时，直接在方法中传入字符串值即可**
    1. html(): 获取/设置元素的标签体内容   <a><font>内容</font></a>  --> <font>内容</font>
	2. text(): 获取/设置元素的标签体纯文本内容   <a><font>内容</font></a> --> 内容
	3. val()： 获取/设置元素的value属性值
	
2. 属性操作
    1. 通用属性操作
        1. attr(): 获取/设置元素的属性
        2. removeAttr():删除属性
        3. prop():获取/设置元素的属性
        4. removeProp():删除属性
        * **attr和prop区别？**
            1. 如果操作的是元素的固有属性，则建议使用prop
            2. 如果操作的是元素自定义的属性，则建议使用attr
            3. **下拉列表的selected属性以及复选框的checked属性只能用prop**
    2. 对CSS的class属性操作
        1. addClass():向被选元素添加一个或多个类
        2. removeClass(): 从被选元素删除一个或多个类
        3. toggleClass():对被选元素进行添加/删除类的切换操作
            * toggleClass("one"): 判断如果元素对象上存在class="one"，则将属性值one删除掉，如果元素对象上不存在class="one"，则添加。
        4. css():设置或返回样式属性
3. CRUD操作
    **可以传递多个参数CRUD多个元素**:
    ```
      var txt1="<p>文本。</p>";              // 使用 HTML 标签创建文本
      var txt2=$("<p></p>").text("文本。");  // 使用 jQuery 创建文本
      var txt3=document.createElement("p");
      txt3.innerHTML="文本。";               // 使用 DOM 创建文本 text with DOM
      $("body").append(txt1,txt2,txt3);        // 追加新元素
    ```
    1. append():父元素将子元素追加到末尾
        * 对象1.append(对象2): 将对象2添加到对象1元素内部，并且在末尾
    2. prepend():父元素将子元素追加到开头
        * 对象1.prepend(对象2):将对象2添加到对象1元素内部，并且在开头
    3. appendTo():
        * 对象1.appendTo(对象2):将对象1添加到对象2内部，并且在末尾
    4. prependTo()：
        * 对象1.prependTo(对象2):将对象1添加到对象2内部，并且在开头
    5. after():添加元素到元素后边
        * 对象1.after(对象2)： 将对象2添加到对象1后边。对象1和对象2是兄弟关系
    6. before():添加元素到元素前边
        * 对象1.before(对象2)： 将对象2添加到对象1前边。对象1和对象2是兄弟关系
    7. insertAfter()
        * 对象1.insertAfter(对象2)：将对象2添加到对象1后边。对象1和对象2是兄弟关系
    8. insertBefore()
        * 对象1.insertBefore(对象2)： 将对象2添加到对象1前边。对象1和对象2是兄弟关系
    9. remove():移除元素
        * 对象.remove():删除被选元素（及其子元素）
    10. empty():清空元素的所有后代元素。
        * 对象.empty():从被选元素中删除子元素，但是保留当前对象以及其属性节点
        
### JQuery动画
三种方式显示和隐藏元素
1. 默认显示和隐藏方式
    + show([speed,[easing],[fn]])
        1. speed：动画的速度。三个预定义的值("slow","normal", "fast")或表示动画时长的毫秒数值(如：1000)
        2. easing：用来指定切换效果，默认是"swing"，可用参数"linear"
            * swing：动画执行时效果是 先慢，中间快，最后又慢
            * linear：动画执行时速度是匀速的
        3. fn：在动画完成时执行的函数，每个元素执行一次。
    + hide([speed,[easing],[fn]])
    + toggle([speed],[easing],[fn])

2. 滑动显示和隐藏方式
    1. slideDown([speed],[easing],[fn])
    2. slideUp([speed,[easing],[fn]])
    3. slideToggle([speed],[easing],[fn])

3. 淡入淡出显示和隐藏方式
    1. fadeIn([speed],[easing],[fn])
    2. fadeOut([speed],[easing],[fn])
    3. fadeToggle([speed,[easing],[fn]])
    
    
### Jquery遍历
1. js的遍历方式
        * for(初始化值;循环结束条件;步长)
2. jq的遍历方式
    1. jq对象.each(callback)
        1. 语法：jquery对象.each(function(index,element){});  
            * index:就是元素在集合中的索引
            * element：就是集合中的每一个元素对象
            * this：集合中的每一个元素对象
        2. 回调函数返回值：
            * true:如果当前function返回为false，则结束循环(break)。
            * false:如果当前function返回为true，则结束本次循环，继续下次循环(continue)
    2. $.each(object, [callback])
    3. for..of方式，jquery 3.0 版本之后提供的方式，类似于foreach循环: for(元素对象 of 容器对象)
    
### JQuery事件绑定
1. jquery标准的绑定方式
    * jq对象.事件方法(回调函数)；
    * 注：如果调用事件方法，不传递回调函数，则会触发浏览器默认行为。
        * 表单对象.submit();//让表单提交
2. on绑定事件/off解除绑定
    * jq对象.on("事件名称",回调函数)
    * jq对象.off("事件名称")
        * 如果off方法不传递任何参数，则将组件上的所有事件全部解绑
3. 事件切换：toggle
    * jq对象.toggle(fn1,fn2...)
        * 当单击jq对象对应的组件后，会执行fn1.第二次点击会执行fn2.....
    * 注意：1.9版本 .toggle() 方法删除,jQuery Migrate（迁移）插件可以恢复此功能。
         <script src="../js/jquery-migrate-1.0.0.js" type="text/javascript" charset="utf-8"></script>