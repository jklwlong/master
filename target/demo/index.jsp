<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>  
<link type="text/css" href="http://css.ykimg.com/youku/dist/css/find/main_26.css" rel="stylesheet">
<script type="text/javascript" src="jquery.js"></script> 
</head> 
<body>
<form id="sub">
姓名：<input name="" value="">
身份证：<input name="" value="">
手机号：<input name="" value=""></br></br>
</form>
<button onclick="sub()">提交</button>
</body>
<script type="text/javascript">
function sub(){
	$.ajax({
		url : "/user/test2')",
		data : ('#sub').serialize(),
		type : 'post',
		dataType : "JSON",
		success : function(data) {

		}
	})
}
	
</script>
</html>
