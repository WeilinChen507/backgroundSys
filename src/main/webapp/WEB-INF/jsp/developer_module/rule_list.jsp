<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="../common/head.jsp"  %>
<style type="text/css">
	.fenyeWrap {
	    text-align: center;
	    margin-top: 25px;
	}
</style>
</head>
<body class="layui-layout-body">
	<%@ include file="../common/nav.jsp" %>
	
	<div class="layui-body" id="content_body">
			<!-- 内容主体区域 -->
			<blockquote class="layui-elem-quote layui-wran-color" style="margin:15px 15px 0 15px;">注意：权限是整个系统的控制核心，非开发人员请勿操作！</blockquote>
			
			<div style="padding: 15px;">
				<fieldset class="layui-elem-field layui-field-title">
					<legend>权限管理</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             	<a href="<c:url value='/developer_module/add_rule' />" class="layui-btn layui-btn-normal layui-btn-small">
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
					                            <td>
					                            	<fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
					                            </td>
					                            <td>${item.sort}</td>
					                            <td>
					                            	<a href="<c:url value='/developer_module/edit_rule/${item.id}' />" class="layui-btn layui-btn-normal layui-btn-mini">
				                        				编辑
				                       				</a>
							                       <a href="<c:url value='/developer_module/delete_rule/${item.id}' />" class="layui-btn layui-btn-danger layui-btn-mini">
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
								                        <td>
									                        <fmt:formatDate value="${child.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
								                        </td>
								                        <td>${child.sort}</td>
							                            <td>
							                            	<a href="<c:url value='/developer_module/edit_rule/${child.id}' />" class="layui-btn layui-btn-normal layui-btn-mini">
						                        				编辑
						                       				</a>
									                       <a href="<c:url value='/developer_module/delete_rule/${child.id}' />" class="layui-btn layui-btn-danger layui-btn-mini">
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
									                            <td>
									                            	<fmt:formatDate value="${tChild.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />
									                            </td>
									                            <td>${tChild.sort}</td>
									                            <td>
									                            	<a href="<c:url value='/developer_module/edit_rule/${tChild.id}' />" class="layui-btn layui-btn-normal layui-btn-mini">
								                        				编辑
								                       				</a>
											                       <a href="<c:url value='/developer_module/delete_rule/${tChild.id}' />" class="layui-btn layui-btn-danger layui-btn-mini">
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
			                <div class="fenyeWrap">
								<div id="fenye"></div>
								<div>当前页共 ${fn:length(list)} 条记录</div>
							</div>
			                
			            </div>
					</div>
				</fieldset>
			</div>
		</div>
	
</body>
<script>
	//权限排序
	<!--
	function sortRule(obj,ruleId){
		var sortNum = $(obj).val();
		$.get('sortRule',{"ruleId":ruleId,"sortNum":sortNum},function(data){
			if(data.code == 0 || data.isok==-1 || data.isok==false){
				showTs(0,data.msg,3000);
			}else if(data.isok==true){
				showTs(1,data.msg,2000);
			}else{
				showTs(0,'网络异常',3000);
			}
		});
	}
	-->
	layui.use(['form','laypage'], function(){
		//列表筛选
		var form = layui.form;
        var laypage = layui.laypage;
		form.on('select(oneLevelRule)', function(data) {
            $(this).parents('form').submit();
        });
		
		//分页
        laypage.render({
            elem: 'fenye',
            count: "${pagination.sumPage}", //总条数
            curr: "${pagination.currentPage}", //当前页
            groups: 5, //连续显示分页数
            limit:1,
            jump: function(obj, first){
                if(!first){
                    var currPage = obj.curr;//得到了当前页，用于向服务端请求对应数据
                    
                    location.href =  "${pageContext.request.contextPath}" + "/" + "developer_module/rule_list" + "/" + currPage;
                }
            }
        });
	});
</script>

</html>
