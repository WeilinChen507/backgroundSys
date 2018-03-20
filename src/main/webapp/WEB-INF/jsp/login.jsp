<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="common/head.jsp" %>
	<link rel="stylesheet" href= <c:url value ="/static/css/login.css" /> />
</head>
<body>
	<div class="loginWrap">
		<h2>${webTitle}</h2>
		<form class="layui-form" action="login" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">账号</label>
				<div class="layui-input-block">
					<input type="text" name="adminPhone" value="${adminPhone}"
					autocomplete="off" placeholder="请输入手机号码" class="layui-input" lay-verify="required">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-block">
					<input type="password" name="adminPassword" value="${adminPassword}"
					placeholder="请输入密码" autocomplete="off" class="layui-input" lay-verify="required">
				</div>
			</div>

			<div class="layui-form-item submit-item">
				<div class="layui-input-block">
				<c:if test="${error != null}"> 
					<font face="微软雅黑" color="#393D49" size="3.5">${error}</font>
					</br></br>
				</c:if> 
					<button class="layui-btn" type="submit">立即登录</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>