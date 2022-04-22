<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 페이지</title>
<style>
	table,tr,td,th{
	 	border : 1px solid;
	 	border-collapse : collapse;
	 	padding : 10px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="mem" items="${memberList}">
		<tr>
			<td><a href="memberView?mId=${mem.mId}">${mem.mId}</a></td>
			<td>${mem.mName}</td>
			<td><a href="memberModiForm?mId=${mem.mId}">수정</a></td>
			<td><a href="memberDelete?mId=${mem.mId}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>