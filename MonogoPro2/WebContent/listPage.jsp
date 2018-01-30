<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%if(!(request.getParameter("command").equals("list")||request.getParameter("command").equals("detail")))
	response.sendRedirect("mongoServlet?command=list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<tr><td colspan=7 align="right">
<c:choose>
    <c:when test="${param.command=='detail'}">
		<a href="mongoServlet?command=list">리스트 보기</a>
    </c:when>    
    <c:otherwise>
		<a href="input.jsp">데이터 입력</a>
    </c:otherwise>
</c:choose>
	</td></tr>
	<tr><th>empno</th><th>ename</th><th>job</th>
	<th>hiredate</th><th>deptno</th><th>수정</th><th>삭제</th></tr>
	<c:forEach items="${employees}" var="emp">
		<tr>
			<td><a href="mongoServlet?
			command=detail&empno=${emp.empno}">${emp.empno}</a></td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.hiredate}</td>
			<td>${emp.deptno}</td>
			<td><a href="mongoServlet?
			command=update_form&empno=${emp.empno}">수정</a></td>
			<td><a href="mongoServlet?
			command=delete&empno=${emp.empno}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>


