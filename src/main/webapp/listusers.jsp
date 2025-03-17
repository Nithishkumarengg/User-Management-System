<%@page import="job.entity.user"%>
<%@page import="java.util.List"%>
<jsp:include page="include/Header.jsp">
<jsp:param value="listusers" name="TitlePage"/>
</jsp:include>
<h3>LIST USERS</h3>
<table border="1" border-spacing="20px" width="auto" margin-right="20px">
  <thead  >
    <th>user_id</th>
    <th>username</th>
    <th>email</th>
    <th>operation(s)</th>
    
  </thead>
<%
List<user> listusers=(List)request.getAttribute("listusers");
for(user _users : listusers){
	out.print("<tr>");
	out.print("<td>"+_users.getUser_id()+"</td>");
	out.print("<td>"+_users.getUsername()+"</td>");
	out.print("<td>"+_users.getEmail()+"</td>");
	out.print("<td> <a href=" +request.getContextPath()+"/Site?page=updateuser&user_id="+_users.getUser_id()+"&username="+_users.getUsername()+"&email="+_users.getEmail()+">Update</a>");
	out.print(" | ");
	out.print(" <a href=" +request.getContextPath()+"/Site?page=deleteuser&user_id="+_users.getUser_id()+">delete</a></td>");
	
}
%>
</table>



<jsp:include page="include/Footer.jsp"></jsp:include>