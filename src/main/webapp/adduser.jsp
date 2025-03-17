<jsp:include page="include/Header.jsp"/>

<form action="${pageContext.request.contextPath}/Site" method="post">
username: <input type="text" name="username" required="required"/><br/>
email   :     <input type="email" name="email" required="required"/><br/>
<input type="hidden" name="form" value="adduseroperation">
<input type="submit" value="adduser">
</form>
<br>
<br>
<br>
<br>
<jsp:include page="include/Footer.jsp"/>