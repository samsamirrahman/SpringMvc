<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
  <c:choose>
   <c:when test="${!empty result}">
	 <div align="center">
	 <h1 style="color: green">
     <c:out value="${result}"></c:out>
     </h1>
     </div>
   </c:when>
  
  </c:choose>

	<c:choose>
	
		<c:when test="${!empty emplist}">
			<h1 style="color: red; text-align: center;">Employee Reports</h1>

			<div align="center">
			<table border="1" style="color: green; align-items: center;">
				<tr style="color: red; border: 2px;">
					<th>EmployeeID</th>
					<th>Employee Name</th>
					<th>Employee Salary</th>
					<th>Employee Job</th>
					<th>Employee DepartMent</th>
				</tr>

				<c:forEach var="emp" items="${emplist}">
					<tr style="color: blue;">
						<td>${emp.empid}</td>
						<td>${emp.ename}</td>
						<td>${emp.sal}</td>
						<td>${emp.job}</td>
						<td>${emp.dep}</td>
                        <td><a href="emp_edit?id=${emp.empid}"> <img alt="Edit" src="/ZMiniProject1/src/main/webapp/WEB-INF/image/edit1.png"> </a></td>
                        <td><a href="emp_delete?id=${emp.empid}"><img alt="Delete" src="delete.png"></a></td>
                       
                        
					</tr>

				</c:forEach>
				
			</table>
			</div>
		</c:when>
		<c:otherwise>

         <h1 style="color: red; text-align: center;">Employee Not Found</h1>
		</c:otherwise>
	</c:choose>
	<div align="center"> <a href="emp_add">Add</a>&nbsp;
	  <a href="/"> Home</a>
	
	</div>
	
	
</body>
</html>