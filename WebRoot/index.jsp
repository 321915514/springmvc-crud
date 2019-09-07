<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#input").click(function(){
				$.ajax({
					url:"<c:url value='ajax'/>",
					type:"get",
					success:function(data){
						
						alert(data.username);
						console.log(data);
						
						
						
					}
				
				
				})
				
				
				
			})
			
			
			
		});
	
	
	
	</script>
  </head>
  
  <body>
    <a href="hello">点击</a>
    <input type="button" value="点击" id="input">
    <form action="login" method="post">
    	用户名:<input type="text" name="username">${error.username}<br>
    	密码:<input type="text" name="password" >${error.password}<br>
    	生日:<input type="text" name="birthday">${error.birthday}<br>
    	<input type="submit" value="登录">
    </form>
    
    
    <form action="upload" method="post" enctype="multipart/form-data">
    	照片:<input type="file" name="photo">
    	<input type="submit">
    </form>
  </body>
</html>
