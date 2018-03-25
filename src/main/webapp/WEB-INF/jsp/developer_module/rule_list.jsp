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
					<legend>权限管理</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             	<a href="" class="layui-btn layui-btn-normal layui-btn-small">
		                        <i class="layui-icon">&#xe608;</i> 添加权限
		                    </a>
			                
			                <!-- 权限列表 -->
							<table lay-even class="layui-table">
			                    <colgroup>
			                        <col width="150">
			                        <col width="200">
			                        <col>
			                    </colgroup>
			                    <thead>
			                        <tr>                        
			                            <th>ID</th>
			                            <th>权限名称</th>
			                            <th>权限规则</th>
			                            <th>状态</th>
			                            <th>是否菜单</th>
			                            <th>图标</th>
			                            <th>级别</th>
			                            <th>创建时间</th>
			                            <th>排序</th>
			                            <th>操作</th>
			                    </thead>
			                    <tbody>
			                    <c:if test="${list != null}">
				                    <c:forEach items="${list}" var="item">
				                    	<!-- 首先输出父级 -->
				                    	<c:if test="${item.parentId == 0}">
					                    	<tr>
					                        	<td>${item.id}</td>
					                           	<td>${item.ruleName}</td> 
					                            <td>${item.rule}</td>
					                            <td>
						                            <c:if test="${item.status == 1}">正常</c:if>
						                            <c:if test="${item.status == 2}"><font color="red">禁用</font></c:if>
					                            </td>
					                            <td>
						                            <c:if test="${item.isMenu == 1}">是</c:if>
						                            <c:if test="${item.isMenu == 2}"><font color="red">否</font></c:if>
						                        </td>
					                            <td>
					                            	<i class="${item.icon}"></i>
					                            </td>
					                            <td>
						                            <c:choose>
							                            <c:when test="${item.parentId == 0}">一级菜单</c:when>
							                            <c:when test="${item.isMenu == 1}">二级菜单</c:when>
						                            </c:choose>
					                            </td>
					                            <td>${item.createTime}</td>
					                            <td>${item.sort}</td>
					                            <td>
					                            	<a href="" class="layui-btn layui-btn-normal layui-btn-mini">
				                        				编辑
				                       				</a>
							                       <a href="" class="layui-btn layui-btn-danger layui-btn-mini">
							                        	删除
							                       </a>
					                            </td>
					                   		</tr>
					                   		<c:forEach items="${list}" var="child">
						                   		<!-- 输出二级菜单 -->
						                   		<c:if test="${child.parentId != 0 && child.isMenu == 1 && child.parentId == item.id}"> 
						                   			<tr>
							                        	<td>${child.id}</td>
							                           	<td>——${child.ruleName}</td> 
							                            <td>${child.rule}</td>
							                            <td>
								                            <c:if test="${child.status == 1}">正常</c:if>
								                            <c:if test="${child.status == 2}"><font color="red">禁用</font></c:if>
							                            </td>
							                            <td>
								                            <c:if test="${child.isMenu == 1}">是</c:if>
								                            <c:if test="${child.isMenu == 2}"><font color="red">否</font></c:if>
							                            </td>
							                            <td>
							                            	<i class="${child.icon}"></i>
							                            </td>
							                            <td>
								                            <c:choose>
									                            <c:when test="${child.parentId == 0}">一级菜单</c:when>
									                            <c:when test="${child.isMenu == 1}">二级菜单</c:when>
								                            </c:choose>
							                            </td>
								                            <td>${child.createTime}</td>
								                            <td>${child.sort}</td>
							                            <td>
							                            	<a href="" class="layui-btn layui-btn-normal layui-btn-mini">
						                        				编辑
						                       				</a>
									                       <a href="" class="layui-btn layui-btn-danger layui-btn-mini">
									                        	删除
									                       </a>
							                            </td>
							                   		</tr>
						                   			<!-- 输出二级菜单下的操作 -->
						                   			<c:forEach items="${list}" var="tChild"> 
							                   			<c:if test="${tChild.isMenu != 1 && tChild.parentId == child.id}">
							                   				<tr>
									                        	<td>${tChild.id}</td>
									                           	<td>————${tChild.ruleName}</td> 
									                            <td>${tChild.rule}</td>
									                            <td>
										                            <c:if test="${tChild.status == 1}">正常</c:if>
										                            <c:if test="${tChild.status == 2}"><font color="red">禁用</font></c:if>
									                            </td>
									                            <td>
										                            <c:if test="${tChild.isMenu == 1}">是</c:if>
										                            <c:if test="${tChild.isMenu == 2}"><font color="red">否</font></c:if>
									                            </td>
									                            <td>
									                            	<i class="${tChild.icon}"></i>
									                            </td>
									                            <td>
										                            <c:choose>
											                            <c:when test="${tChild.parentId == 0}">一级菜单</c:when>
											                            <c:when test="${tChild.isMenu == 1}">二级菜单</c:when>
										                            </c:choose>
									                            </td>
									                            <td>${tChild.createTime}</td>
									                            <td>${tChild.sort}</td>
									                            <td>
									                            	<a href="" class="layui-btn layui-btn-normal layui-btn-mini">
								                        				编辑
								                       				</a>
											                       <a href="" class="layui-btn layui-btn-danger layui-btn-mini">
											                        	删除
											                       </a>
									                            </td>
									                   		</tr>
							                   			</c:if>
						                   			</c:forEach>
						                   		</c:if>
						                   	</c:forEach>
				                   		</c:if>
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