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
        + $("#div1").css("backgroundColor","pink"); 使用JQ的属性名，即将-删除，小写改大写即可。