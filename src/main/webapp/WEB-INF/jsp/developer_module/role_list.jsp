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
					<legend>角色管理</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             	<a href="addRole" class="layui-btn layui-btn-normal layui-btn-small">
		                        <i class="layui-icon">&#xe608;</i> 添加角色
		                    </a>
			                
			                <!-- 角色列表 -->
							<table lay-even class="layui-table">
			                    <colgroup>
			                        <col width="150">
			                        <col width="200">
			                        <col>
			                    </colgroup>
			                    <thead>
			                        <tr>                        
			                            <th>ID</th>
			                            <th>角色名称</th>
			                            <th>角色权限</th>
			                            <th>状态</th>
			                            <th>说明</th>
			                            <th>创建时间</th>
			                            <th>操作</th>
			                    </thead>
			                    <tbody>
			                    <c:if test="${list != null}">
				                    <c:forEach items="${list}" var="item">
				                    	<tr>
				                        	<td>${item.id}</td>
				                           	<td>${item.roleName}</td> 
				                            <td>${item.ruleIds}</td>
				                            <td>
				                            <c:if test="${item.status == 1}">正常</c:if>
				                            <c:if test="${item.status == 0}">禁用</c:if>
				                            </td>
				                            <td>${item.remark}</td>
				                            <td>${item.createTime}</td>
				                            <td>
				                            	<a href="editRole" class="layui-btn layui-btn-normal layui-btn-mini">
			                        				编辑
			                       				</a>
						                       <a href="deleteRole" class="layui-btn layui-btn-danger layui-btn-mini">
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