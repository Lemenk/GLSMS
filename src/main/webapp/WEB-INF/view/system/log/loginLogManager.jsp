<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>登录日志管理</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="icon" href="favicon.ico">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css" media="all"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css" media="all"/>
    </head>
    <body class="childrenBody">
        <!-- 搜索条件开始 -->
        <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
            <legend>查询条件</legend>
        </fieldset>

        <form class="layui-form" method="post" id="searchFrm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">用户类别:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="loginRole" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">用户编号:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="loginUsername" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">开始时间:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="startTime" id="startTime" readonly="readonly" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">结束时间:</label>
                    <div class="layui-input-inline">
                        <input type="text" name="endTime" id="endTime" readonly="readonly" autocomplete="off"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item" style="text-align: center;margin-right: 40px">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
                    <button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh" id="reset1">重置</button>
                </div>
            </div>
        </form>

        <!-- 搜索条件结束 -->

        <!-- 数据表格开始 -->
        <table class="layui-hide" id="userTable" lay-filter="userTable" style="margin-left: 30px;"></table>
        <div style="display: none;" id="userToolBar">
            <button type="button" class="layui-btn layui-btn-sm" lay-event="deleteBatch">批量删除</button>
        </div>
        <div id="userBar" style="display: none;">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </div>
        <!-- 数据表格结束 -->

        <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
        <script type="text/javascript">
            var tableIns;
            layui.use(['jquery', 'layer', 'form', 'table','laydate'], function () {
                var $ = layui.jquery;
                var layer = layui.layer;
                var form = layui.form;
                var table = layui.table;
                var laydate = layui.laydate;

                //渲染时间
                laydate.render({
                    elem:'#startTime',
                    type:'datetime'
                });
                laydate.render({
                    elem:'#endTime',
                    type:'datetime'
                });


                //渲染数据表格
                tableIns = table.render({
                    elem: '#userTable'   //渲染的目标对象
                    , url: '${pageContext.request.contextPath}/log/loadAllLogLogin' //数据接口
                    , title: '登录日志数据表'//数据导出来的标题
                    , toolbar: "#userToolBar"   //表格的工具条
                    , height: 'full-150'
                    , cellMinWidth: 100 //设置列的最小默认宽度
                    , page: true  //是否启用分页
                    , cols: [[   //列表数据
                        {type: 'checkbox', fixed: 'left'}
                        , {field: 'id', title: 'ID', align: 'center', width: '70'}
                        , {field: 'loginRole', title: '用户类别', align: 'center', width: '150'}
                        , {field: 'loginUsername', title: '用户编号', align: 'center', width: '130'}
                        , {field: 'loginIp', title: '登录IP地址', align: 'center', width: '230'}
                        , {field: 'loginTime', title: '登陆时间', align: 'center', width: '200'}
                        , {fixed: 'right', title: '操作', toolbar: '#userBar', width: 300, align: 'center'}
                    ]]
                })

                //模糊查询
                $("#doSearch").click(function () {
                    var params = $("#searchFrm").serialize();
                    tableIns.reload({
                        url: "${pageContext.request.contextPath}/log/loadAllLogLogin?" + params
                    })
                });

                //重置按钮点击事件
                $("#reset1").click(function () {
                    tableIns.reload({
                        url: "${pageContext.request.contextPath}/log/loadAllLogLogin"
                    });
                });

                //监听头部工具栏事件
                table.on("toolbar(userTable)", function (obj) {
                    switch (obj.event) {
                        case 'add':
                            openAddUser();
                            break;
                        case 'deleteBatch':
                            deleteBatch();
                            break;
                    }
                    ;
                })
                //监听行工具事件
                table.on('tool(userTable)', function (obj) {
                    var data = obj.data; //获得当前行数据
                    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                    if (layEvent === 'del') { //删除
                        layer.confirm('真的删除【' + data.loginUsername + '】这条登录日志吗', function (index) {
                            //向服务端发送删除指令
                            $.post("${pageContext.request.contextPath}/log/deleteLogLogin", {id: data.id}, function (res) {
                                layer.msg(res.msg);
                                //刷新数据 表格
                                tableIns.reload();
                            })
                        });
                    }
                });

                //批量删除
                function deleteBatch() {
                    //得到选中的数据行
                    var checkStatus = table.checkStatus('userTable');
                    var data = checkStatus.data;
                    var params = "";
                    $.each(data, function (i, item) {
                        if (i === 0) {
                            params += "ids=" + item.id;
                        } else {
                            params += "&ids=" + item.id;
                        }
                    });
                    alert(data);
                    alert(params);
                    layer.confirm('真的删除选中的这些日志吗', function (index) {
                        //向服务端发送删除指令
                        $.post("${pageContext.request.contextPath}/log/deleteBatchLogLogin", params, function (res) {
                            layer.msg(res.msg);
                            //刷新数据 表格
                            tableIns.reload();
                        })
                    });
                }
            });
        </script>
    </body>
</html>