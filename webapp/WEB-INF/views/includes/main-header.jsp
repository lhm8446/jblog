<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		
		<ul class="menu">
			<li><a href="${pageContext.request.contextPath }">메인화면</a></li>
			<c:if test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath }/user/loginform">로그인</a></li>
			</c:if>
			<c:if test="${empty authUser }">
			<li><a href="${pageContext.request.contextPath }/user/joinform">회원가입</a></li>
			</c:if>
			<c:if test="${not empty authUser }">
			<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
			</c:if>
			<c:if test="${not empty authUser }">
			<li><a href="${pageContext.request.contextPath }/${authUser.id }">내블로그</a></li>
			</c:if>
		</ul>