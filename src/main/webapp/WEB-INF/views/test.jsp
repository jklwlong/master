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
</style> 
</head> 
<body>
	<table>
		<c:forEach var="user" items="${user}">
			<tr>
				<td>${user.username}</td>
				<td>${user.password}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript">

	function sub() {
		if($('#name').val()==''||$('#name').val()==null){
			alert("名字不能为空");
			return;
		}
		if($('#idNumber').val()==''||$('#idNumber').val()==null){
			alert("身份证不能为空");
			return;
		}
		if($('#mobile').val()==''||$('#mobile').val()==null){
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
</script>
</html>
