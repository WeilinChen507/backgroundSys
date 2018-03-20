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
					<legend>网站设置</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			            	<div class="layui-field-box">
								<form action="website_setting" charset="utf-8" method="POST" class="layui-form">
									<div class="layui-form-item">
		
									<div class="layui-form-item">
										<label class="layui-form-label">网站标题</label>
										<div class="layui-input-inline">
											<input type="text" value="${websiteTitle}" placeholder="请输入网站标题" autocomplete="off" class="layui-input" name="websiteTitle">
										</div>
									</div>
									
									<div class="layui-form-item">
										<label class="layui-form-label">网站版权</label>
										<div class="layui-input-inline">
											<input type="text" value="${copyright}" placeholder="请输入网站版权" autocomplete="off" class="layui-input" name="copyright">
										</div>
									</div>
									
									<!-- 添加 -->
									<div class="layui-input-block">
									<c:if test="${tips != null}">
										<span><font face="微软雅黑"  color="#393D49" size="3.5">${tips}</font></span>
										</br></br>
									</c:if>
										<button class="layui-btn layui-btn-normal" lay-filter="submit-btn" lay-submit>添加</button>
									</div>
								</form>
							</div>
			                
			            </div>
					</div>
				</fieldset>
			</div>
		</div>
	
</body>
</html>