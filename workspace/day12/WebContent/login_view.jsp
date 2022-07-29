<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login_db.jsp" method="post" name="frm">
		<p>
			<label>아이디 : <input type="text" name="userid"> </label>
		</p>
		<p>
			<label>비밀번호 : <input type="password" name="userpw" onkeyup="enterLogin();"> </label>
		</p>
		<input type="button" value="로그인" onclick="sendit();">
	</form>
	
	<script>
		function enterLogin(){
			// 비밀번호치고  enter키 누르면 로그인
			if( window.event.keyCode == 13 ){
				sendit();
			}
		}
	
		function sendit(){
			// validation check
			let frm = document.frm;
			let userid = frm.userid;
			let userpw = frm.userpw;
			
			// 아이디 "" 처리
			if( userid.value == ""){
				alert("아이디를 입력해주세요");
				userid.focus();
				return false;
			}
			// 비밀번호 "" 처리
			if( userpw.value == ""){
				alert("비밀번호를 입력해주세요");
				userpw.focus();
				return false;
			}
			
			frm.submit();
			
		}
	</script>
</body>
</html>