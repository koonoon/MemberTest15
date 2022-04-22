<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 페이지</title>
</head>
<body>
	<h1>회원수정 페이지</h1>
	
	<form action="memberModify" method="POST">
	
	아이디 : ${modi.mId}<br/>
	<input type="hidden" name="mId" value="${modi.mId}">
	비밀번호 : <input type="password" name="mPw"/> <br/>
	이름 : <input type="text" name="mName" placeholder="${modi.mName}"/> <br/>
	생년월일 : <input type="date" name="mBirth"/> <br/>
	성별 : 남자<input type="radio" name="mGender" value="남"/> 
		  여자<input type="radio" name="mGender" value="여"/> <br/>
	이메일 : <input type="email" name="mEmail" placeholder="${modi.mEmail}"/> <br/>
	<input type="submit" value="수정"/>
	<input type="reset" value="다시작성"/>
	
	</form>
	
</body>
</html>