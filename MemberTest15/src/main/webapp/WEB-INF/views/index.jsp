<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberTest Index</title>
</head>
<body>
	<h1>Index페이지</h1>
	
	<!-- 회원가입 페이지로 이동하는 방법1 -->
	<!-- <a href="joinForm">회원가입1</a> -->
	
	<!-- 회원가입 페이지로 이동하는 방법2 : 버튼에서 바로 이동-->
	<button onclick="location.href='joinForm'">회원가입2</button>
	
	<!-- 회원목록 페이지로 이동하는 방법3 : 스크립트 사용-->
	<input type="button" onclick="mList()" value="회원목록">
	
</body>

<script>
	function mList(){
		location.href='mList';
	}
</script>

</html>
