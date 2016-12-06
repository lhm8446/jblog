<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>${map.blogVo.title }</h1>
			<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		</div>
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
					<h4>Spring Camp 2016 참여기</h4>
					<p>
						<c:if test="${empty postVo }">
							${map.postContent.content }
						</c:if>
						
						<c:if test="${not empty postVo }">
							${postVo.content }
						</c:if>
					
					<p>
				</div>
				<ul class="blog-list">
				
					<c:if test="${empty postList }">
					<c:forEach items="${map.postVo }" var="vo" varStatus="status">				
					<li><a href="${pageContext.request.contextPath}/content/${vo.no }/${id }">${vo.title }</a> <span>${vo.regDate }</span>	</li>
					</c:forEach>
					</c:if>
					
					<c:if test="${not empty postList }">
					<c:forEach items="${postList }" var="vo" varStatus="status">				
					<li><a href="${pageContext.request.contextPath}/content/${vo.no }/${id }">${vo.title }</a> <span>${vo.regDate }</span>	</li>
					</c:forEach>
					</c:if>
					
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}/gallery/assets/${map.blogVo.logo }">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${map.categoryVo }" var="vo" varStatus="status">				
				<li><a href="${pageContext.request.contextPath}/post/${vo.no }/${id }">${vo.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
	</div>
</body>
</html>