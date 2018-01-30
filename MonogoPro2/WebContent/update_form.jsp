<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="mongoServlet" method="post">
<input type="hidden" name="command" value="update">
<input type="hidden" name="empno" value="${employee.empno}">
<table>
	<tr><th>empno : </th><td><input type="text" name="empno" value="${employee.empno }" ></td></tr>
	<tr><th>ename : </th><td><input type="text" name="ename" value="${employee.ename }"></td></tr>
	<tr><th>job : </th><td><input type="text" name="job" value="${employee.job }"></td></tr>
	<tr><th>deptno</th><td><input type="text" name="deptno" value="${employee.deptno }"></td></tr>
	<tr>
		<td colspan=2 align="center">
			<input type="submit" value="update">&nbsp;
			<input type="reset" value="cancel" onclick="location.href='mongoServlet?command=list'">
			<input type="button" value="리스트 보기" onclick="location.href='mongoServlet?command=list'">
		</td>
	</tr>
</table>
</form>
</body>
</html>