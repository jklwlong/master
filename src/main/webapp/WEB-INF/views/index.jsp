<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>  
<link type="text/css" href="http://css.ykimg.com/youku/dist/css/find/main_26.css" rel="stylesheet">
<script type="text/javascript" src="/jquery.js"></script>
<style>
.dc {
	border: 1px solid;
	height: 151px;
	width: 715px;
	color: #9a9090;
	word-break: break-all;
}
table{border:1px solid #999999;    border-collapse: collapse;}
table tr td{border:1px solid #999999;}
</style> 
</head> 
<body>
<form id="sub">
姓名：<input name="name" id="name" value="">
身份证：<input name="idNumber" id="idNumber" value="">
手机号：<input name="mobile" id="mobile" value=""></br></br>
测试：<input name="url" type="radio" checked value="https://portaltest.yuanbaopu.com/three/jzjf.htm" />
正式：<input name="url" type="radio" value="https://portal.yuanbaopu.com/three/jzjf.htm" /></br></br>
自定义：<input name="auto" value="" style="width:600px">
</form>
<button onclick="sub()">提交</button></br></br>
<div class="dc" id="content"></div>
<button onclick="test()">提交1</button>


<table>
<tr><td>1</td><td>2</td></tr>
<tr><td>2</td><td>1</td></tr>
<tr><td>3</td><td>1</td></tr>

</table>

</body>
<script type="text/javascript">
	function sub() {
		if ($('#name').val() == '' || $('#name').val() == null) {
			alert("名字不能为空");
			return;
		}
		if ($('#idNumber').val() == '' || $('#idNumber').val() == null) {
			alert("身份证不能为空");
			return;
		}
		if ($('#mobile').val() == '' || $('#mobile').val() == null) {
			alert("手机号不能为空");
			return;
		}
		$.ajax({
			url : "/user/test2.do",
			data : $('#sub').serialize(),
			type : 'post',
			dataType : "JSON",
			success : function(data) {
				$('#content').text("");
				$('#content').text(data);
			}
		})
	}

	function test() {
		$.ajax({
			url : "http://192.168.4.123:8080/invitation/saveMetric.do",
			data :{"name":"啊罗","media":"罗哈媒体","phone":"15844665599"},
			type : 'post',
			dataType : "JSON",
			success : function(data) {
				console.log(data);
			}
		})
	}
</script>
</html>
