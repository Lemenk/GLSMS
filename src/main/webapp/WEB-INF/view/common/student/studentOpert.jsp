<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--
  User: Lemenk
  Date: 2020/5/6 11:36
  Description: 学生操作页面
 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学生操作</title>
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

        <!-- 数据表格开始 -->
        <table class="layui-hide" lay-data="id:'tableTest'" id="userTable" lay-filter="userTable"></table>
        <%--<div style="display: none; margin-top: 20px" id="userToolBar">
            <button type="button" class="layui-btn layui-btn-sm" lay-event="add">添加</button>
        </div>--%>
        <!-- 数据表格结束 -->

        <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
        <script type="text/javascript">
            var tableIns;
            layui.extend({
                dtree: '${pageContext.request.contextPath}/resources/layui_ext/dist/dtree'
            }).use(['jquery', 'layer', 'form', 'table', 'dtree'], function () {
                var $ = layui.jquery;
                var layer = layui.layer;
                var form = layui.form;
                var table = layui.table;
                var dtree = layui.dtree;
                //渲染数据表格
                tableIns = table.render({
                    elem: '#userTable'   //渲染的目标对象
                    , url: '${pageContext.request.contextPath}/student_process/loadStudentProcess' //数据接口
                    , title: '流程数据表'//数据导出来的标题
                    , height: 'full'
                    , cellMinWidth: 100 //设置列的最小默认宽度
                    , page: false  //是否启用分页
                    , cols: [[   //列表数据
                        /*{field: 'id', title: 'ID', align: 'center'}
                        ,*/{field: 'procId', title: '序号', align: 'center'}
                        , {field: 'procName', title: '流程步骤', align: 'center'}
                        , {
                            field: 'statusName', title: '当前状态', align: 'center', templet: function (d) {
                                if (d.status === 3) {
                                    return '<div style="color: red;font-weight: bold">' + d.statusName + '<div>';
                                } else if (d.status === 2) {
                                    return '<div style="color: green;">' + d.statusName + '<div>';
                                } else {
                                    return d[this.field];
                                }
                            }
                        }
                        , {field: 'applyTime', title: '申请时间', align: 'center'}
                        , {field: 'handleTime', title: '办理时间', align: 'center'}
                        , {field: 'handler', title: '经办人员', align: 'center'}
                        , {
                            fixed: 'right',
                            title: '操作',
                            toolbar: '#statusTpl',
                            width: 300,
                            align: 'center',
                            templet: '#statusTpl'
                        }
                    ]]
                });
            });
        </script>

        <script type="text/html" id="statusTpl">
            {{# if(d.status == 0 ){ }}
            <a class="layui-btn layui-btn-xs" lay-event="apply" id="apply1">点击申请</a>
            {{#  } }}
            {{# if(d.status == 1 ){ }}
            <a class="layui-btn layui-btn-xs layui-btn-disabled" lay-event="apply1" id="apply2">审核中</a>
            {{#  } }}
            {{# if(d.status == 2 ){ }}
            <a class="layui-btn layui-btn-xs layui-btn-disabled" lay-event="apply1" id="apply3">已通过</a>
            {{#  } }}
            {{# if(d.status == 3 ){ }}
            <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="apply" id="apply5">重新申请</a>
            {{#  } }}
        </script>
        <script>

            layui.use(['layer', 'table'], function () {
                var $ = layui.jquery;
                var table = layui.table;

                table.on('tool(userTable)', function (obj) {
                    var data = obj.data; //获得当前行数据
                    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                    var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

                    if (layEvent === 'apply') { //申请
                        $.post("${pageContext.request.contextPath}/student_process/studentApply", {id: data.id}, function (res) {
                            layer.msg("申请成功");
                            //刷新数据 表格
                            tableIns.reload({
                                url: "${pageContext.request.contextPath}/student_process/loadStudentProcess"
                            });
                        });
                    }
                });
            });
        </script>
    </body>
</html>