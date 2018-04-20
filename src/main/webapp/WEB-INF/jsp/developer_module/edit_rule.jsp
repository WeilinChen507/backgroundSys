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
					<legend>修改权限</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             	<div class="layui-field-box">
								<form action="<c:url value='/developer_module/edit_rule' />" method="POST" class="layui-form">
									<input type="hidden" value="${rule_id}" name="id">
								
									<div class="layui-form-item">
										<label class="layui-form-label">权限名称</label>
										<div class="layui-input-inline">
											<input type="text" value="${ruleForm.ruleName}" placeholder="请输入权限名称，必填" autocomplete="off" class="layui-input" name="ruleName" lay-verify="required">
										</div>
										<div class="layui-form-mid layui-word-aux">示例：开发者模块</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">权限规则</label>
										<div class="layui-input-inline">
											<input type="text" value="${ruleForm.rule}" placeholder="请输入权限规则，必填" autocomplete="off" class="layui-input" name="rule" lay-verify="required">
										</div>
										<div class="layui-form-mid layui-word-aux">示例：developer_module/add_rule</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">是否菜单</label>
										<div class="layui-input-inline">
											<c:choose>
												<c:when test="${ruleForm == null || ruleForm.isMenu == 2}">
													<input type="radio" name="isMenu" value="1" title="是" >
											      	<input type="radio" name="isMenu" value="2" title="否" checked>
												</c:when>
												<c:otherwise>
													<input type="radio" name="isMenu" value="1" title="是" checked>
											      	<input type="radio" name="isMenu" value="2" title="否" >
												</c:otherwise>
											</c:choose>
										</div>
									</div>
									  
									<div class="layui-form-item">
									    <label class="layui-form-label">所属菜单</label>
									    <div class="layui-input-block">
									      <select name="parentId" lay-verify="required">
									        <option value=""></option>
									        <c:forEach items="${ruleList}" var="item">
									        	<c:if test="${item.isMenu == 1 && item.parentId == 0}">
									        		//一级菜单
									        		<c:choose>
									        			<c:when test="${ruleForm != null && item.id == ruleForm.parentId}">
									        				<option value="${item.id}" selected>一级菜单：${item.ruleName}</option>
									        			</c:when>
									        			<c:otherwise>
									        				<option value="${item.id}">一级菜单：${item.ruleName}</option>
									        			</c:otherwise>
									        		</c:choose>
									        		<c:forEach items="${ruleList}" var="child">
									        			<c:if test="${child.isMenu == 1 && child.parentId == item.id}">
									        				//二级菜单
									        				<c:choose>
										        				<c:when test="${ruleForm != null && child.id == ruleForm.parentId}">
										        					<option value="${child.id}" selected>——二级菜单：${child.ruleName}</option>
										        				</c:when>
										        				<c:otherwise>
										        					<option value="${child.id}" >——二级菜单：${child.ruleName}</option>
										        				</c:otherwise>
									        				</c:choose>
									        			</c:if>
									        		</c:forEach>
									        	</c:if>
									        </c:forEach>
									      </select>
									    </div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">排序</label>
										<div class="layui-input-inline">
											<input type="text" value="${ruleForm.sort}" placeholder="请输入排序序号，必填" autocomplete="off" class="layui-input" name="sort"  lay-verify="required">
										</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label">状态</label>
										<div class="layui-input-inline">
											<c:choose>
												<c:when test="${ruleForm == null || ruleForm.status == 2}">
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
										<a class="layui-btn layui-btn-normal" href="<c:url value='/developer_module/edit_rule/${ruleForm.id}' />">重置</a>
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