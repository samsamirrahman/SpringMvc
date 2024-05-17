<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Update Page</title>
</head>
<body>
	<frm:form modelAttribute="emp" method="post" action="emp_edit">
		<div align="center" style="color: green; text-align: center;">
	      
			<table border="1">
				<tr>
					<td>Employee Name</td>
					<td><frm:input path="empid"  /></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td><frm:input path="ename"  /></td>
				</tr>

				<tr>
					<td>Employee Job</td>
					<td><frm:input path="job" /></td>
				</tr>

				<tr>
					<td>Employee Salary</td>
					<td><frm:input path="sal" /></td>
				</tr>
				<tr>
					<td>Employee Department</td>
					<td><frm:input path="dep" /></td>
				</tr>


				<tr>
					<td><input type="submit" value="save"></td>
					<td><input type="reset" value="cancel"></td>
				</tr>

			</table>

		</div>
	</frm:form>
</body>
</html>