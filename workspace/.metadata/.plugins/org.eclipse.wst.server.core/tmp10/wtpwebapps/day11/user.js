/**
 * 
 */
// 회원가입 폼 validation check
// 아이디 "" 처리
// 아이디 5자리 이상, 16자리 미만
// 비밀번호 ""처리
// 비밀번호 8자리 이상
// 비밀번호, 비밀번호 확인이 같은지 체크
// 이름이 ""처리
// 휴대폰 번호 ""처리

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


