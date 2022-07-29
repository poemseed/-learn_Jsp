<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax를 이용한 실시간 순위 나타내기</h1>
	<table border="1">
		<tr>
			<th>실시간 검색 순위</th>
			<th>키워드</th>
		</tr>
		<tr>
			<td id="td1">순위</td>
			<td id="td2">키워드</td>
		</tr>
	</table>
	
	<script type="text/javascript">
		let word = new Array();
		let obj = "";
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "data2.json", true);
		xhr.send();
		xhr.onreadystatechange = function(){
			if( xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200 ){
				//alert(xhr.responseText);
				// json형식으로 데이터 자르기
				// alert(JSON.parse(xhr.responseText))
				obj = JSON.parse(xhr.responseText);	// 응답받은 Text를 JSON으로 파싱
				//alert(obj.search_word);
				
				// 파싱된 obj에서 search_word라는 key를 가지고 있는 value보면
				//[{},{},{},{},{}]가 나온다. 즉 배열이다.
				for( let i = 0; i < obj.search_word.length; i++ ){
					// obj.search_word 배열의 각 방에는 또 json들이 담겨있다.{"rank":"1","name":"코로나"}
					// 각 방에 있는 json들에서 name키로 담겨있는 검색어를 꺼내서 word배열에다가 담아준다.
					word[i] = obj.search_word[i].name;
				}
				
			}
		}
		
		let i = 0;
		let interval = setInterval(function(){
			// 0,1,2,3,4 -> 5가 되는 순간 다시 0이 되어야한다.
			i = i%obj.search_word.length;
			document.getElementById("td1").innerHTML = i+1;
			document.getElementById("td2").innerHTML = word[i];
			i++;
		}, 2000);
		
		clearInterval(interval);
	</script>
</body>
</html>