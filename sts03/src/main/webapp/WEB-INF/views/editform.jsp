<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정페이지</h1>
	<!-- /guest/9999 -->
	<form action="./" method="post">
	<input type="hidden" name="_method" value="PUT"/>
	<table>
		<tr>
			<td>
				<label for="sabun">사번</label>
			</td>
			<td>
				<input type="text" name="sabun" id="sabun" value="${bean.sabun }">
			</td>
		</tr>
		<tr>
			<td>
				<label for="name">이름</label>
			</td>
			<td>
				<input type="text" name="name" id="name" value="${bean.name }">
			</td>
		</tr>
		<tr>
			<td>
				<label for="pay">금액</label>
			</td>
			<td>
				<input type="text" name="pay" id="pay" value="${bean.pay }">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">입력</button>
				<button type="reset">취소</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>