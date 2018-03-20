<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ include file="tag.jsp" %>
    <%@ include file="head.jsp"  %>
    
 <div class="layui-layout layui-layout-admin">
		<div class="layui-header nav-header">
            <div class="layui-logo nav-logo">
            	${webTitle}
            	<i class="iconfont" id="nav_slide_btn">&#xe61c;</i>
            </div>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="#" class="nav-a">
                        <i class="iconfont">&#xe625;</i> ${admin.adminPhone}
                    </a>
                </li>
                <li class="layui-nav-item"><a href="<%= (request.getContextPath()+"/admin/logout")%>" class="nav-a" id="nav_log_out">退出登录</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black" id="left_nav">
            <div class="layui-side-scroll">
                <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                	<c:forEach items="${admin.ruleList}" var="parent">
                		<li class="layui-nav-item layui-nav-itemed">
                			<!-- 父权限 -->
	                		<c:if test="${parent.isMenu == 1 && parent.parentId == 0}">
	                			
	                			<a class="" href="javascript:;">${parent.ruleName}</a>
	               		
	                		 	<!-- 子权限 -->
	                		 	<c:forEach items="${admin.ruleList}" var="child" >
			                    <dl class="layui-nav-child">
			                        <c:if test="${child.parentId == parent.id && child.isMenu == 1}">
			                            <dd><a href="<c:url value='/${child.rule}' />">${child.ruleName}</a></dd>
			                        </c:if>
			                    </dl>
			                    </c:forEach>
			                    
		                    </c:if>
	                    </li>
                    </c:forEach>
                 
                    
                </ul>
            </div>
        </div>

<script>
layui.use('element', function(){
  var element = layui.element;
  
  //一些事件监听
  element.on('tab(demo)', function(data){
    console.log(data);
  });
});
</script> 