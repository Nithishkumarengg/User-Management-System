<jsp:include page="include/Header.jsp"/>

<form action="${pageContext.request.contextPath}/Site" method="post">
username: <input type="text" name="username"  value="${param.username}" required="required"/><br/>
email   :     <input type="email" name="email" value="${param.email}" required="required"/><br/>
<input type="hidden" name="form" value="updateuseroperation">
<input type="hidden" name="user_id" value="${param.user_id}">
<input type="submit" value="updateuser">
</form>
<br>
<br>
<br>
<br>
<jsp:include page="include/Footer.jsp"/>