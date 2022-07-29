<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="join.jsp" name="joinForm" id="joinForm" method="post">
		아이디		<input type="text" name="userid" id="userid"><br>
		비밀번호	<input type="password" name="userpw" id="userpw"><br>
		이름		<input type="text" name="username" id="username"><br>
		폰번호		<input type="text" name="userphone" id="userphone"><br>
		<br>
<!-- 		<input type="submit"> -->
		<input type="button" value="회원가입" onclick="sendit()">
	</form>
	
	<script type="text/javascript">
		function sendit() {
			// validation check
			// 아이디, 비밀번호 "" 체크
			// 비밀번호 8자리 이상 체크
			// 이름""체크
			// 휴대폰 ""체크
			// form submit()
			
// 			let joinForm = document.joinForm;
// 			let id = joinForm.userid;
// 			let pw = joinForm.userpw;
// 			let name = joinForm.username;
// 			let phone = joinForm.userphone;
			
// 			if( id.value == "" ){
// 				alert("아이디를 입력해주세요");
// 				return false;
// 			}
			
// 			if( pw.value == "" && pw.value.length >= 8 ){
// 				alert("패스워드를 8자리 입력해주세요");
// 				return false;
// 			}
			
// 			if( name.value == "" ){
// 				alert("이름을 입력해주세요");
// 				return false;
// 			}
			
// 			if( phone.value == "" ){
// 				alert("폰번호를 입력해주세요");
// 				return false;
// 			}
			
// 			joinForm.submit();
			
			
			// 선생님
			let frm = document.getElementById("joinForm");
			
			// 아이디로 받아오기
			let idTag = document.getElementById("userid");
			let pwTag = document.getElementById("userpw");
			// frm이용해서 받아오기
			let nameTag = frm.username;
			let phoneTag = frm.userphone;
			
			if( idTag.value == "" ){
				alert("아이디를 입력하세요");
				idTag.focus();
				return false;
			}
			if( pwTag.value == "" ){
				alert("패스워드를 입력하세요");
				pwTag.focus();
				return false;
			}
			if( pwTag.value.length < 8 ){
				alert("비밀번호는 8자리이상으로 입력하세요");
				pwTag.focus();
				return false;
			}
			if( nameTag.value == "" ){
				alert("이름을 입력하세요");
				nameTag.focus();
				return false;
			}
			if( phoneTag.value == "" ){
				alert("폰번호를 입력하세요");
				phoneTag.focus();
				return false;
			}
			// form.submit()
			frm.submit();
			
			
			
		}
	</script>
</body>
</html>