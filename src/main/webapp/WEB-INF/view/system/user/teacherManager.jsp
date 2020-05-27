<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>教师管理</title>
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

		<form class="layui-form" method="post" id="searchFrm" >
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">教师编号:</label>
					<div class="layui-input-inline">
						<input type="text" name="techId" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">教师姓名:</label>
					<div class="layui-input-inline">
						<input type="text" name="techName" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">学院:</label>
					<div class="layui-input-inline">
						<select name="deptName" id="deptName1" lay-filter="deptName">
							<option value="0">请选择</option>
						</select>
					</div>
				</div>
			</div>

			<div class="layui-form-item" style="text-align: center;">
				<div class="layui-input-block">
					<button type="button" class="layui-btn layui-btn-normal  layui-icon layui-icon-search" id="doSearch">查询</button>
					<button type="reset" class="layui-btn layui-btn-warm  layui-icon layui-icon-refresh" id="reset1">重置</button>
				</div>
			</div>
		</form>

		<!-- 搜索条件结束 -->

		<!-- 数据表格开始 -->
		<table class="layui-hide" id="userTable" lay-filter="userTable"></table>
		<div style="display: none;" id="userToolBar" >
			<button type="button" class="layui-btn layui-btn-sm" lay-event="add">添加</button>
		</div>
		<div id="userBar" style="display: none;">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</div>
		<!-- 数据表格结束 -->

		<!-- 添加和修改的弹出层开始 -->
		<div style="display: none;padding: 20px" id="saveOrUpdateDiv">
			<form class="layui-form" lay-filter="dataFrm" id="dataFrm">

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">教师姓名:</label>
						<div class="layui-input-inline">
							<input type="hidden" name="id">
							<input type="text" name="techName" lay-verify="required" placeholder="请输入教师姓名" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">教师编号:</label>
						<div class="layui-input-inline">
							<input type="text" name="techId" lay-verify="required"
								   placeholder="请输入教师编号" autocomplete="off" class="layui-input" id="techId">
						</div>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">所属学院:</label>
						<div class="layui-input-inline">
							<select name="deptName" id="deptName" lay-filter="deptName">
								<option value="0">请选择</option>
							</select>
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">邮箱:</label>
						<div class="layui-input-inline">
							<input type="text" name="email" lay-verify="email" placeholder="请输入常用邮箱" autocomplete="off"
								   class="layui-input">
						</div>
					</div>
				</div>

				<div class="layui-form-item" style="text-align: center;">
					<div class="layui-input-block" style="margin-left: 0;margin-top: 20px">
						<button type="button" class="layui-btn layui-btn-normal layui-btn-sm layui-icon layui-icon-release" lay-filter="doSubmit" lay-submit="">提交</button>
						<button type="reset" class="layui-btn layui-btn-warm layui-btn-sm layui-icon layui-icon-refresh">重置</button>
						<a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="resetUserPwd">重置密码</a>
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
					, url: '${pageContext.request.contextPath}/teacher/loadAllTeacher' //数据接口
					, title: '教师数据表'//数据导出来的标题
					, toolbar: "#userToolBar"   //表格的工具条
					, height: 'full-200'
					, cellMinWidth: 100 //设置列的最小默认宽度
					, page: true  //是否启用分页
					, cols: [[   //列表数据
						{type: 'checkbox', fixed: 'left'}
						, {field: 'id', title: 'ID', align: 'center', width: '70'}
						, {field: 'techId', title: '教师编号', align: 'center', width: '150'}
						, {field: 'techName', title: '教师姓名', align: 'center', width: '130'}
						, {field: 'deptName', title: '学院', align: 'center', width: '230'}
						, {field: 'email', title: '邮箱', align: 'center', width: '200'}
						, {fixed: 'right', title: '操作', toolbar: '#userBar', width: 300, align: 'center'}
					]]
				});
				//模糊查询
				$("#doSearch").click(function () {
					var params = $("#searchFrm").serialize();
					tableIns.reload({
						url: "${pageContext.request.contextPath}/teacher/loadAllTeacher?" + params
					})
				});

				//重置按钮点击事件
				$("#reset1").click(function () {
					tableIns.reload({
						url: "${pageContext.request.contextPath}/teacher/loadAllTeacher"
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
				});
				//监听行工具事件
				table.on('tool(userTable)', function (obj) {
					var data = obj.data; //获得当前行数据
					var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
					if (layEvent === 'del') { //删除
						layer.confirm('真的删除【' + data.techName + '】这个教师吗', function (index) {
							//向服务端发送删除指令
							$.post("${pageContext.request.contextPath}/teacher/deleteTeacher", {techId: data.techId}, function (res) {
								layer.msg(res.msg);
								//刷新数据 表格
								tableIns.reload();
							})
						});
					} else if (layEvent === 'edit') { //编辑
						openUpdateUser(data);
					} else if (layEvent === 'resetUserPwd') {
						layer.confirm('真的重置【' + data.techName + '】这个教师的密码吗', function (index) {
							//向服务端发送删除指令
							$.post("${pageContext.request.contextPath}/teacher/resetUserPwd", {techId: data.techId}, function (res) {
								layer.msg(res.msg);
							})
						});
					} else if (layEvent === 'selectUserRole') {
						openselectUserRole(data);
					}
				});

				var url;
				var mainIndex;

				//打开添加页面
				function openAddUser() {
					//清除disabled样式
					$("#techId").removeProp("disabled");
					mainIndex = layer.open({
						type: 1,
						title: '添加教师',
						content: $("#saveOrUpdateDiv"),
						area: ['800px', '400px'],
						success: function (index) {
							//清空表单数据
							$("#dataFrm")[0].reset();
							url = "${pageContext.request.contextPath}/teacher/addTeacher";
						}
					});
				}

				//打开修改页面
				function openUpdateUser(data) {
					//为学号框加上不可编辑的样式
					$("#techId").prop("disabled","disabled");
					mainIndex = layer.open({
						type: 1,
						title: '修改教师信息',
						content: $("#saveOrUpdateDiv"),
						area: ['800px', '400px'],
						success: function (index) {
							form.val("dataFrm", data);
							url = "${pageContext.request.contextPath}/teacher/updateTeacher";
						}
					});
				}

				//学院下拉列表
				$.get("${pageContext.request.contextPath}/dept/loadColDept",function(objs){
					var depts=objs.data;
					var dept=$("#deptName");
					var dept1=$("#deptName1");
					$.each(depts,function(index,item){
						dept.append("<option value="+item.id+">"+item.deptName+"</option>");
					});
					$.each(depts,function(index,item){
						dept1.append("<option value="+item.id+">"+item.deptName+"</option>");
					});
					form.render("select");
				})

				//提交按钮的事件
				form.on("submit(doSubmit)", function (obj) {
					//序列化表单数据
					var params = $("#dataFrm").serialize();
					$.post(url, params, function (obj) {
						layer.msg(obj.msg);
						//关闭弹出层
						layer.close(mainIndex)
						//刷新数据 表格
						tableIns.reload();
					})
				});
			});
		</script>
	</body>
</html>