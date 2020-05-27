<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>学生申请统计分析</title>
        <%--<meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Access-Control-Allow-Origin" content="*">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="icon" href="favicon.ico">--%>
    </head>
    <body style="height: 500%; margin: 0">
        <div id="container" style="height: 450%"></div>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/echarts.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/echarts-gl.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/ecStat.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/dataTool.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/china.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/world.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/bmap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/stat/jquery-3.4.1.min.js"></script>
        <script type="text/javascript">
            $.get("${pageContext.request.contextPath}/stat/loadApplyStatJson",function (data) {
                var dom = document.getElementById("container");
                var myChart = echarts.init(dom);
                var app = {};
                var option = null;
                option = {
                    title: {
                        text: '学生申请统计',
                        subtext: '来自于数据库',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: data
                    },
                    series: [
                        {
                            name: '申请状态',
                            type: 'pie',
                            radius: '80%',
                            center: ['50%', '50%'],
                            data: data,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                if (option && typeof option === "object") {
                    myChart.setOption(option, true);
                }
            });
        </script>
    </body>
</html>