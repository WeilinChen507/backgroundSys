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
			<div style="padding: 15px;">
				<fieldset class="layui-elem-field layui-field-title">
					<legend>管理员管理</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             	<a href="add_admin" class="layui-btn layui-btn-normal layui-btn-small">
		                        <i class="layui-icon">&#xe608;</i> 添加管理员
		                    </a>
			                
			                <!-- 角色列表 -->
							<table lay-even class="layui-table">
			                    <thead>
			                        <tr>                        
			                            <th>ID</th>
			                            <th>管理员账号</th>
			                            <th>管理员名字</th>
			                            <th>管理员手机</th>
			                            <th>管理员角色</th>
			                            <th>管理员状态</th>
			                            <th>创建时间</th>
			                            <th>操作</th>
			                    </thead>
			                    <tbody>
			                    <c:if test="${list != null}">
				                    <c:forEach items="${list}" var="item">
				                    	<tr>
				                        	<td>${item.id}</td>
				                           	<td>${item.adminAccount}</td> 
				                            <td>${item.adminFullname}</td>
				                            <td>${item.adminPhone}</td>
				                            <td>${item.role.roleName}</td>
				                            <td>
				                            <c:if test="${item.status == 1}">正常</c:if>
				                            <c:if test="${item.status == 0}">禁用</c:if>
				                            </td>
				                            <td>
				                            	<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
				                            
				                            </td>
				                            <td>
				                            	<a href="edit_admin/${item.id }" class="layui-btn layui-btn-normal layui-btn-mini">
			                        				编辑
			                       				</a>
						                       <a href="delete_admin/${item.id }" class="layui-btn layui-btn-danger layui-btn-mini">
						                        	删除
						                       </a>
				                            </td>
				                   		</tr>
				          			</c:forEach>
			          			</c:if>
			                    </tbody>
			                </table>
			                
			            </div>
					</div>
				</fieldset>
			</div>
		</div>
	
</body>
</html>