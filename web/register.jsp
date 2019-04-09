<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2019
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="register"></jsp:param>
</jsp:include>
<body>
<form action="register" method="post" class="col-md-6 mx-auto">
    <div class="form-group">
        <label>Email address</label>
        <input type="text" name="username" class="form-control" >
    </div>
    <div class="form-group">
        <label >Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<jsp:include page="fragment/script.jsp"></jsp:include>
</body>
</html>
