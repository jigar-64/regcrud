<%@page import="java.util.Base64"%>
<%@page import="com.example.demoRegCrud.entities.Hobbies"%>
<%@page import="com.example.demoRegCrud.entities.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.example.demoRegCrud.utlity.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Hobbies</th>
			<th>DOB</th>
			<th>Designation</th>
			<th>Address</th>
			<th>Image</th>
			<th>Action</th>
		</tr>
		<%
		List<Employee> employees = (List<Employee>) request.getAttribute("employees");

		for (Employee emp : employees) {
			String img = Base64.getEncoder().encodeToString(emp.getImage().getBytes(1, (int) emp.getImage().length()));
		%>
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getGender()%></td>
			<td><ul>
					<%
					for (Hobbies hoby : emp.getHobbies()) {
					%>
					<li><%=hoby.getName()%></li>
					<%
					}
					%>
				</ul></td>
			<td><%=emp.getDate()%></td>
			<td><%=emp.getDesignation()%></td>
			<td><%=emp.getAddress()%></td>
			<td><img alt="" src="data:image/png;base64,<%= img%>" height="100px" width="100px"></td>
			<td>
			<a href="/update/<%=emp.getId()%>"><button>Update</button></a>
			<a href="/delete/<%=emp.getId()%>"><button>Delete</button></a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	
	<script type="text/javascript">
		document.querySelector('button').addEventListener('click', (e) => {
			e.preventDefault();
			
			var c = false;
			
			if(c){
				form.submit();
			}else{
				return false;
			}
		})
	</script>
</body>
</html>