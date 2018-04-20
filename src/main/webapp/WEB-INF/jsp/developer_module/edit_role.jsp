<%@page import="cn.weilin.backgroundSys.dto.RoleForm"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jsp"  %>
	<style>
		.lky-form-checkbox {
			display: inline-block;
			width: 23%;
		}
	</style>
</head>
<body class="layui-layout-body">
	<%@ include file="../common/nav.jsp" %>
	
	<div class="layui-body" id="content_body">
			<!-- 内容主体区域 -->			
			<div style="padding: 15px;">
				<fieldset class="layui-elem-field layui-field-title">
					<legend>添加角色</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             	<div class="layui-field-box">
								<form action="<c:url value='/developer_module/edit_role' />" charset="utf-8" method="POST" class="layui-form">
									<input type="hidden" name="id" value="${roleForm.id}">
									
									<div class="layui-form-item">
										<label class="layui-form-label">角色名称</label>
										<div class="layui-input-inline">
											<input type="text" value="${roleForm.roleName}" placeholder="请输入角色名称，必填" autocomplete="off" class="layui-input" name="roleName" lay-verify="required">
										</div>
										<div class="layui-form-mid layui-word-aux">示例：后台管理员</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">角色说明</label>
										<div class="layui-input-inline">
											<input type="text" value="${roleForm.remark}" placeholder="请输入角色说明，必填" autocomplete="off" class="layui-input" name="remark" lay-verify="required">
										</div>
										<div class="layui-form-mid layui-word-aux">示例：部分权限</div>
									</div>
							
								  <div class="layui-form-item">
								    <label class="layui-form-label">角色权限</label>
								    <div class="layui-input-block">
								      <c:forEach var="item" items="${ruleList}" >
								      	<c:if test="${item.parentId == 0 && item.isMenu == 1}">
								      		<!-- 一级菜单 -->
								      		一级菜单
								      		
								      		<input  type="checkbox" name="ruleIds" value="${item.id}" title="${item.ruleName}" >
								      		<br>
								      		<c:forEach var="child" items="${ruleList}" >
								      			<c:if test="${child.parentId == item.id && child.parentId != 0 && child.isMenu == 1}">
									      			<!-- 二级菜单 -->
									      			———二级菜单
									      			<input  type="checkbox" name="ruleIds" value="${child.id}" title="${child.ruleName}" >
									      			<br>
								      			
									      			<c:forEach var="tChild" items="${ruleList}" >
									      				<c:if test="${tChild.parentId == child.id && tChild.parentId != 0 && tChild.isMenu == 2}">
									      					<!-- 子权限 -->
									      					——————子权限
									      					<input  type="checkbox" name="ruleIds" value="${tChild.id}" title="${tChild.ruleName}" >
									      					<br>
									      				</c:if>
									      			</c:forEach>
								      			</c:if>
								      		</c:forEach>
								      	</c:if>
								      </c:forEach>
								    </div>
								  </div>
							
									<div class="layui-form-item">
										<label class="layui-form-label">状态</label>
										<div class="layui-input-inline">
											<c:choose>
												<c:when test="${roleForm == null || roleForm.status == 2}">
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
										<a class="layui-btn layui-btn-normal" href="<c:url value='/developer_module/edit_role/${roleForm.id}' />">重置</a>
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
	  
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	});
</script>
</html>