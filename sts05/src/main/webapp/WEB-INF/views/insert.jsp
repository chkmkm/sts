<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script></script>
</head>
<body>
	<h1>입력페이지</h1>
	<form action="/sts05/guest/insert" method="post">
	<p>
		<label for="sabun">사번</label>
		<input type="text" name="sabun" id="sabun"/>
	</p>
	<p>
		<label for="name">이름</label>
		<input type="text" name="name" id="name"/>
	</p>
	<p>
		<label for="pay">금액</label>
		<input type="text" name="pay" id="pay"/>
	</p>
	<p>
		<button>입력</button>
	</p>
	</form>
</body>
</html>