<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post">
	<table>
		<tr>
			<td><label>아이디</label></td>
			<td><input type="text" name="userid" value="${UserInfoDTO.userid }"></td>
		</tr>
		<tr>
			<td><label>비밀번호</label></td>
			<td><input type="password" name="pwd" value="${UserInfoDTO.pwd }"></td>
		</tr>	
	</table>
	<input type="submit" value="제출">	
</form>
</body>
</html>