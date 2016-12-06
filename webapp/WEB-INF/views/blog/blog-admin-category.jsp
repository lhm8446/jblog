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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
var count = 1;
var render = function(vo){
		
	var htmls = 
		"<tr><td id='cno'>"+count+"</td>" +
			"<td>"+vo.name+"</td>"+
			"<td>"+vo.postNo+"</td>"+
			"<td>"+vo.des+"</td>"+
			"<td id='btn-del'><a href =''>"+
			"<img src='${pageContext.request.contextPath}/assets/images/delete.jpg'></a></td>"+
		"</tr>"		;
		
		count++;
		
		$("#newcategory").prepend(htmls);
}
var fetchList = function(){
	$.ajax({
		url : "${pageContext.request.contextPath }/api/categoryform",
		type : "get",
		dateType : "json",
		success : function(response){
			if(response.result != "success"){
				console.error(response.message);
				return;
			}
			
			//redering
			$(response.data).each(function(index, vo){
				
				render(vo);

			})
		},
		error : function(jqXHR, status, e) {
			console.log(status + ":" + e);
		}
	});
}
$(function() {
	
	
	
	fetchList();

$("#btn-category").submit(function(){
	
	$.ajax({
		url:"${pageContext.request.contextPath}/api/category",
		type:"post",
		dateType:"json",
		data:"name=" + $("#name").val() +
			 "&des=" + $("#des").val(),
		success : function(response){
			if(response.result != "success"){
				console.error(response.message);
				return;
			}
			render(response.data);
		},
		error : function(jqXHR, status, e) {
			console.log(status + ":" + e);
		}
	});
});

$("#btn-del").click(function(event){
	
	event.preventDefault();

	$.ajax({
		url:"${pageContext.request.contextPath}/api/categorydelete",
		type:"post",
		dateType:"json",
		data:"no=" +$("#cno").val,
		success : function(response){
			
			fetchList();

		},
		error : function(jqXHR, status, e) {
			console.log(status + ":" + e);
		}
	})
});
});

</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Spring 이야기</h1>
			<c:import url="/WEB-INF/views/includes/blog-header.jsp" />
		</div>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<c:import url="/WEB-INF/views/includes/admin-header.jsp">
					<c:param name="menu" value="category" />
				</c:import>
		      	<table class="admin-cat">
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		
		      		<tbody id ="newcategory"> 
					</tbody>  
				</table>
      	
      			<h4 class="n-c">새로운 카테고리 추가</h4>
      			<form id="btn-category" >
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input id="name" type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input id="des" type="text" name="des"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      	</form>
			</div>
		</div>
		<div id="footer">
			<p>
				<strong>Spring 이야기</strong> is powered by JBlog (c)2016
			</p>
		</div>
		
		<div id="dialog" title="삭제" style="display:none">
			<br>
			<p>삭제하시겠습니까</p>
			<br>
			<form method="post" action="${pageContext.request.contextPath }/guestbook">
					<input id="a" type="hidden" name="a" value="ajax-delete">
					<input id="no" type='hidden' name="no"><label id="wr" style="display:none">비밀번호가 틀렸습니다.</label>
					<label>비밀번호</label>
					<input id="pass1" type="password" name="password">
		</form>
		<p></p>
	</div>
	</div>
</body>
</html>