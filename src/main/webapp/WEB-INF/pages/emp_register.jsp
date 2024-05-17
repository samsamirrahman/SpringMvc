<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>



</h1>
	<frm:form modelAttribute="emp">
		<div align="center" style="color: green; text-align: center;">
			<table border="1">
				<tr>
					<td>Employee Name</td>
					<td><frm:input path="ename" /> </td>
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
					<td><input type="submit" value="submit"></td>
					<td><input type="reset" value="cancel"></td>
				</tr>

			</table>

		</div>
	</frm:form>

</body>
</html>