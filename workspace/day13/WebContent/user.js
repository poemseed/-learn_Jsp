/**
 * 
 */
// 회원가입 폼 validation check
function sendit(){
	let frm = document.joinForm;
	let userid = frm.userid; 
	let userpw = frm.userpw; 
	let userpw_re = frm.userpw_re; 
	let username = frm.username; 
	let userphone = frm.userphone; 
	
	// 아이디 "" 처리
	if( userid.value == "" ){
		alert("아이디를 입력해주세요");
		userid.focus();
		return false;
	}
	// 아이디 5자리 이상, 16자리 미만
	if( userid.value.length <= 4 || userid.value.length >= 16 ){
		alert("5자리이상 16자리 미만을 입력하세요");
		userid.focus();
		return false;
	}
	// 비밀번호 ""처리
	if( userpw.value == "" ){
		alert("비밀번호를 입력하세요");
		userpw.focus();
		return false;
	}else{
		// 비밀번호 8자리 이상
		if( userpw.value.length < 8 ){
			alert("8자리이상 입력하세요");
			userpw.focus();
			return false;
		}
		
	}
	// 비밀번호, 비밀번호 확인이 같은지 체크
	if( userpw.value != userpw_re.value ){
		alert("비밀번호가 일치하지 않습니다.다시 확인하세요");
		userpw_re.focus();
		return false;
	}
	
	// 이름이 ""처리
	if( username.value == ""){
		alert("이름을 입력하세요")
		username.focus();
		return false;
	}
	
	// 휴대폰 번호 ""처리
	if( userphone.value == "" ){
		alert("휴대폰번호를 입력하세요");
		userphone.focus();
		return false;
	}
	
	frm.submit();

}

// 아이디 중복 확인 
function checkId(userid){
	if( userid == "" ){
		alert("아이디를 입력해주세요")
		return false;
	}else{
		// ajax 통신
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "idcheck.jsp?userid="+userid, true);
		xhr.send();
		xhr.onreadystatechange = function(){
			if( xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200 ){
				// 받을때 공백이 포함될수 있기때문에 trim()사용해서 공백제거
				if(xhr.responseText.trim() == "ok"){
					// 사용할 수 있는 아이디입니다.
					document.getElementById("text").innerHTML = "사용할 수 있는 아이디입니다."
				}else{
					// 중복된 아이디입니다.
					document.getElementById("text").innerHTML = "중복된 아이디입니다."
				}
				
				
			}
		}
		
		
	}
	
	
}








