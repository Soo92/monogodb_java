<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="input" action="mongoServlet" method="post">
<input type="hidden" name="command" value="input">
<table>
	<tr><th>empno : </th><td><input type="text" name="empno"></td></tr>
	<tr><th>ename : </th><td><input type="text" name="ename"></td></tr>
	<tr><th>job : </th><td><input type="text" name="job"></td></tr>
	<tr><th>deptno</th><td><input type="text" name="deptno"></td></tr>
	<tr>
		<td colspan=2 align="center">
			<input type="submit" value="input">&nbsp;
			<input type="reset" value="cancel"
			onclick="location.href='mongoServlet?command=list">
			<input type="button" value="리스트 보기" 
			onclick="location.href='mongoServlet?command=list'">
		</td>
	</tr>
</table>
</form>
</body>
</html>