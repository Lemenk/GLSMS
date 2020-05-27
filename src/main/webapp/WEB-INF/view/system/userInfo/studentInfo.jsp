<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--
  User: Lemenk
  Date: 2020/5/13 20:46
  Description: 
 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>个人资料</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
    </head>
    <body class="childrenBody">
        <form class="layui-form layui-row">
            <div class="layui-col-md6 layui-col-xs12" style="margin-left: 320px;margin-top: 50px;">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block" style="width: 300px;">
                        <input type="text" id="stuName" value="" disabled class="layui-input layui-disabled">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">学号</label>
                    <div class="layui-input-block" style="width: 300px;">
                        <input type="text" id="stuNo" value="" disabled lay-verify="required"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">用户类别</label>
                    <div class="layui-input-block" style="width: 300px;">
                        <input type="text" id="roleName" value="" disabled class="layui-input layui-disabled">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">手机号码</label>
                    <div class="layui-input-block" style="width: 300px;">
                        <input type="tel" id="phone" value="" disabled lay-verify="phone"
                               class="layui-input userPhone">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block" style="width: 300px;">
                        <input type="text" id="email" value="" disabled lay-verify="email"
                               class="layui-input userEmail">
                    </div>
                </div>
                <div class="layui-form-item userAddress">
                    <label class="layui-form-label">家庭住址</label>
                    <div class="layui-input-block" style="width: 300px;">
                        <input type="tel" id="homeAddress" value="" disabled lay-verify="phone"
                               class="layui-input userPhone">
                    </div>
                </div>
            </div>
        </form>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/page/user/userInfo.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cacheUserInfo.js"></script>
        <script>
            var $, tab, dataStr, layer;
            layui.use(['form', 'element', 'layer', 'jquery'], function () {
                var form = layui.form,
                    element = layui.element;
                    $ = layui.$;

                var ajaxObj = new XMLHttpRequest();
                ajaxObj.open('get', '${pageContext.request.contextPath}/student/studentInfo');
                ajaxObj.onreadystatechange = function () {
                    // 为了保证 数据 完整返回，我们一般会判断 两个值
                    if (ajaxObj.readyState === 4 && ajaxObj.status === 200) {
                        // 如果能够进到这个判断 说明 数据 完美的回来了,并且请求的页面是存在的
                        // 5.在注册的事件中 获取 返回的 内容 并修改页面的显示
                        console.log('数据返回成功');

                        var test = ajaxObj.responseText;
                        console.log(test);

                        var split1 = test.split("\"stuNo\":\"");
                        var split2=split1[1].split("\",\"stuNa");
                        console.log(split2[0]);
                        var stuNo =test.split("\"stuNo\":\"")[1].split("\",\"stuNa")[0];
                        var stuName = test.split("\"stuName\":\"")[1].split("\",\"ema")[0];
                        var email = test.split("\"email\":\"")[1].split("\",\"phone")[0];
                        var phone = test.split("\"phone\":\"")[1].split("\",\"stuDept")[0];
                        var homeAddress = test.split("\"homeAddress\":\"")[1].split("\"}")[0];

                        document.getElementById("stuName").value=stuName;
                        document.getElementById("stuNo").value=stuNo;
                        document.getElementById("roleName").value="学生";
                        document.getElementById("email").value=email;
                        document.getElementById("phone").value=phone;
                        document.getElementById("homeAddress").value=homeAddress;


                    }
                };
                ajaxObj.send();

            });
        </script>
    </body>
</html>
