<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%--
  User: Lemenk
  Date: 2020/5/6 11:36
  Description: 教师操作页面
 --%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>教师操作</title>
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
        <div style="display: none; margin-top: 20px" id="userToolBar">
            <button type="button" class="layui-btn layui-btn-sm" lay-event="queryAll" id="queryAll">查看全部</button>
            <button type="button" class="layui-btn layui-btn-sm" lay-event="queryTrue" id="queryTrue">已通过</button>
            <button type="button" class="layui-btn layui-btn-sm" lay-event="queryFalse" id="queryFalse">已拒绝</button>
            <button type="button" class="layui-btn layui-btn-sm" lay-event="queryNo" id="queryNo">未处理</button>
        </div>
        <!-- 数据表格结束 -->

        <!-- 添加和修改的弹出层开始 -->
        <div style="display: none;padding: 20px" id="remarkDiv">
            <form class="layui-form" lay-filter="dataFrm" id="dataFrm">
                <div class="layui-form-item">
                    <div class="layui-form-item layui-form-text">
                        <div class="layui-input-block" style="margin-left: 0">
                            <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align: center;">
                    <div class="layui-input-block" style="margin-left: 0">
                        <button type="button"
                                class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release"
                                lay-filter="doSubmit" lay-submit="">提交
                        </button>
                        <button type="reset"
                                class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh">重置
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <!-- 添加和修改的弹出层结束 -->

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
                    , url: '${pageContext.request.contextPath}/apply_handle/loadStudentApplyInfo' //数据接口
                    , title: '流程数据表'//数据导出来的标题
                    , toolbar: "#userToolBar"   //表格的工具条
                    , height: 'full'
                    , cellMinWidth: 100 //设置列的最小默认宽度
                    , page: true  //是否启用分页
                    , cols: [[   //列表数据
                        /*{field: 'id', title: 'ID', align: 'center'}
                        ,*/{field: 'stuNo', title: '学号', align: 'center'}
                        , {field: 'stuName', title: '学生姓名', align: 'center'}
                        , {field: 'className', title: '班级', align: 'center'}
                        , {field: 'statusName', title: '当前状态', align: 'center'}
                        , {field: 'applyTime', title: '申请时间', align: 'center'}
                        , {field: 'handleTime', title: '处理时间', align: 'center'}
                        , {field: 'handler', title: '经办人员', align: 'center'}
                        , {fixed: 'right', title: '操作', toolbar: '#statusTpl', align: 'center', templet: '#statusTpl'}
                    ]]
                    , id: 'userTableReload'
                });
            });
        </script>

        <script type="text/html" id="statusTpl">
            {{# if(d.status == 0 ){ }}
            <a class="layui-btn layui-btn-xs" lay-event="handleYes" id="a2">同意</a>
            <a class="layui-btn layui-btn-xs" lay-event="handleNo" id="a3">拒绝</a>
            {{#  } }}
            {{# if(d.status == 1 ){ }}
            <a class="layui-btn layui-btn-xs layui-btn-disabled">已通过</a>
            {{#  } }}
            {{# if(d.status == 2 ){ }}
            <a class="layui-btn layui-btn-xs layui-btn-disabled">已拒绝</a>
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

                    if (layEvent === 'handleYes') { //同意
                        console.log(obj.data.id);
                        $.post("${pageContext.request.contextPath}/apply_handle/agreeApply", {id: data.id}, function (res) {
                            layer.msg("同意此申请");
                            //刷新数据 表格
                            tableIns.reload();
                        });
                    } else if (layEvent === 'handleNo') { //拒绝
                        layer.confirm('确定要拒绝此申请申请吗', function (index) {
                            $.post("${pageContext.request.contextPath}/apply_handle/refuseApply", {id: data.id}, function (res) {
                                //刷新数据 表格
                                tableIns.reload();
                            });
                            layer.close(index);
                        });
                    }
                });
                //监听头部工具栏事件
                table.on("toolbar(userTable)", function (obj) {
                    switch (obj.event) {
                        case 'queryAll':
                            layer.msg("查看全部列表");
                            queryAllApply();
                            break;
                        case 'queryTrue':
                            layer.msg("查看已通过列表");
                            queryTrueApply();
                            break;
                        case 'queryFalse':
                            layer.msg("查看已拒绝列表");
                            queryFalseApply();
                            break;
                        case 'queryNo':
                            layer.msg("查看未处理列表");
                            queryNoApply();
                            break;
                    }
                });
                var url;
                var mainIndex;

                //查看全部列表
                function queryAllApply() {
                    tableIns.reload();
                }

                //查看已通过列表
                function queryTrueApply() {
                    tableIns.reload({
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        //根据条件查询
                        , where: {
                            status: 1
                        }
                    });
                }

                //查看已拒绝列表
                function queryFalseApply() {
                    tableIns.reload({
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        //根据条件查询
                        , where: {
                            status: 2
                        }
                    });
                }

                //查看未处理列表
                function queryNoApply() {
                    tableIns.reload({
                        page: {
                            curr: 1 //重新从第 1 页开始
                        }
                        //根据条件查询
                        , where: {
                            status: 0
                        }
                    });
                }
            });
        </script>
    </body>
</html>