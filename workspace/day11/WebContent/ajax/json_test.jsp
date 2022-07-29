<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "data.json", true);
		xhr.send();
		xhr.onreadystatechange = function(){
			if( xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200 ){
				//alert(xhr.responseText);
				// json형식으로 데이터 자르기
				let obj = JSON.parse(xhr.responseText);
				// result라는 키값으로 value값 얻기
				alert(obj.result);
				alert(obj.count);
			}
		}
	
	</script>
</body>
</html>