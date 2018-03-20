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
					<legend>系统首页</legend>
					<div class="layui-field-box">
						<!-- 内容主体区域 -->
			            <div style="padding: 15px;">
			             <table lay-even class="layui-table" >
		                    <colgroup>
		                        <col width="150">
		                        <col width="200">
		                        <col>
		                    </colgroup>
		                    <thead>
		                        <tr>                        
		                            <th>系统配置</th>
		                            <th>系统信息</th>
		                            
		                        </tr>
		                    </thead>
		                    <tbody >
		                    	<tr>
			                    	<td>java vresion</td>
									<td>jdk1.8</td>
								</tr>
								<tr>
			                    	<td>tomcat vresion</td>
									<td>8.0</td>
								</tr>
								<tr>
			                    	<td>mysql vresion</td>
									<td>5.6</td>
								</tr>
								<tr>
			                    	<td>spring vresion</td>
									<td>4.1.7</td>
								</tr>
								<tr>
			                    	<td>mybatis vresion</td>
									<td>3.3.0</td>
								</tr>
								<tr>
			                    	<td>framework</td>
									<td>spring + springmvc + mybatis</td>
								</tr>
		                     </tbody>
	                	</table>
			            </div>
			            
			            <fieldset class="layui-elem-field layui-field-title">
			            	<legend>任何问题</legend>
			            	<div class="layui-field-box">
								<!-- 内容主体区域 -->
					            <div style="padding: 15px;">
					            	<font color="#666666" size="3">
					            	联系：陈先生</br></br>
					            	电话：13145780665
					            	</font>
					            </div>
					        </div>
			            </fieldset>
			            
			            <fieldset class="layui-elem-field layui-field-title">
			            	<legend>网站版权</legend>
			            	<div class="layui-field-box">
								<!-- 内容主体区域 -->
					            <div style="padding: 15px;">
					            	<font color="#666666" size="3">
					            	copyright：${copyright}
					            	</font>
					            </div>
					        </div>
			            </fieldset>
					</div>
				</fieldset>
			</div>
		</div>
	
</body>
</html>