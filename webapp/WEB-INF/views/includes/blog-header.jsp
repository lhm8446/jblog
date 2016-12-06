<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
			<ul>
				<c:if test="${empty authUser }">
				<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
				</c:if>
				
				<c:if test="${not empty authUser }">
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
				</c:if>
				
				<c:if test="${not empty authUser }">
				<li><a href="${pageContext.request.contextPath }/${id }/admin/basic">블로그 관리</a></li>
				</c:if>
				
				<li><a href="${pageContext.request.contextPath}/${id }">블로그 메인</a></li>
			</ul>
