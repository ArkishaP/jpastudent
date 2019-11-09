<%@page import="jpastudent.dao.StudentDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jpastudent.model.Student"%>
<%@page import="java.util.List"%>
<html>
<body>
<div>
	<ul>
		<li><a href="Register.jsp">Register Student</a>
	</ul>
</div>
<div>
	<table>
		<tr>
			<th>Roll no</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Course</th>
			<th>Result</th>
			<th></th>
		</tr>
		<%
			List<Student> slist = new ArrayList<Student>();
			slist = new StudentDao().displayStudents();
			for(Student s:slist){
		%>
		<tr>
			<td><%=s.getRollno()%></td>
			<td><%=s.getFname() %></td>
			<td><%=s.getLname() %></td>
			<td><%=s.getCourse()%></td>
			<td><%=s.getResult() %></td>
			<td><a href=<%="Delete?rollno="+s.getRollno()%>>Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
</div>
</body>
</html>