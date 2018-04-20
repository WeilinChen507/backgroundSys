<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jsp"  %>

</head>
<body class="layui-layout-body">
	<%@ include file="../common/nav.jsp" %>
	
	<div class="layui-body" id="content_body">
			<!-- 内容主体区域 -->
			<blockquote class="layui-elem-quote layui-wran-color" style="margin:15px 15px 0 15px;">注意：权限是整个系统的控制核心，非开发人员请勿操作！</blockquote>
			
			<div style="padding: 15px;">
				<fieldset class="layui-elem-field layui-field-title">
					<legend>添加管理员</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             	<div class="layui-field-box">
								<form action="add_admin" charset="utf-8" method="POST" class="layui-form">
									<div class="layui-form-item">
										<label class="layui-form-label">管理员账号</label>
										<div class="layui-input-inline">
											<input type="text" value="${adminForm.adminAccount}" placeholder="请输入管理员账号，必填" autocomplete="off" class="layui-input" name="adminAccount" lay-verify="required|username">
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">管理员手机</label>
										<div class="layui-input-inline">
											<input type="text" value="${adminForm.adminPhone}" placeholder="请输入管理员手机，必填" autocomplete="off" class="layui-input" name="adminPhone"  lay-verify="required|phone">
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">管理员密码</label>
										<div class="layui-input-inline">
											<input type="password" value="${adminForm.adminPassword}" placeholder="请输入管理员密码，必填" autocomplete="off" class="layui-input" name="adminPassword" lay-verify="required|pass">
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">重复密码</label>
										<div class="layui-input-inline">
											<input type="password" value="${adminForm.repeatedPassword}" placeholder="请再次输入密码，必填" autocomplete="off" class="layui-input" name="repeatedPassword" lay-verify="required">
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">管理员角色</label>
										<div class="layui-input-inline">
											<c:forEach var="item" items="${roleList}">
												<c:choose>
													<c:when test="${adminForm != null && adminForm.roleId == item.id}">
														<input type="radio" name="roleId" value="${item.id}" title="${item.roleName}" checked>
													</c:when>
													<c:otherwise>
														<input type="radio" name="roleId" value="${item.id}" title="${item.roleName}" >
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</div>
									</div>
									  

									<div class="layui-form-item">
										<label class="layui-form-label">管理员姓名</label>
										<div class="layui-input-inline">
											<input type="text" value="${adminForm.adminFullname}" placeholder="请输入管理员姓名，必填" autocomplete="off" class="layui-input" name="adminFullname"  lay-verify="required">
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">状态</label>
										<div class="layui-input-inline">
											<c:choose>
												<c:when test="${adminForm == null || adminForm.status == 2}">
													<input type="radio" name="status" value="1" title="可用" >
											      	<input type="radio" name="status" value="2" title="禁用" checked>
												</c:when>
												<c:otherwise>
													<input type="radio" name="status" value="1" title="可用" checked>
											      	<input type="radio" name="status" value="2" title="禁用" >
												</c:otherwise>
											</c:choose>
										</div>
									</div>
									
									<!-- 错误提示 -->
									<div class="layui-input-block">
										<c:if test="${tips != null}">
											<span><font face="微软雅黑"  color="#393D49" size="3.5">${tips}</font></span>
											</br></br>
										</c:if>
										<button class="layui-btn layui-btn-normal" lay-filter="submit-btn" lay-submit>立即提交</button>
										<a class="layui-btn layui-btn-normal" href="add_admin">重置</a>
									</div>
								</form>
							</div>
			                
			            </div>
					</div>
				</fieldset>
			</div>
		</div>
	
</body>
<script>
layui.use('form', function(){
	  var form = layui.form;
	  
	  form.verify({
 		  username: function(value, item){ //value：表单的值、item：表单的DOM对象
		    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
		      return '账号不能有特殊字符';
		    }
		  }
	  
		  ,pass: [
		    /^[\S]{6,12}$/
		    ,'密码必须6到12位，且不能出现空格'
		  ]  
		}); 
	  
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	});
</script>
</html>