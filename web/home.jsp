<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.FeedbackEntity" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2019
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="Home"></jsp:param>
</jsp:include>
<%String username = (String) request.getAttribute("name"); String pass = (String) request.getAttribute("pass");%>
<% ArrayList<FeedbackEntity> arrayList = (ArrayList) request.getAttribute("arrayList");
//    for (FeedbackEntity list: arrayList
//         ) {
//        out.println(arrayList.get(0));
//    }

%>
<body>
    <div class="col-md-7 mx-auto" >
        <div>
            <form action="feedback" method="get">
                <input type="hidden" name="pass" value="<%=pass%>">
                <input type="hidden" name="username" value="<%=username%>">
                <button type="submit" class="btn btn-primary"> feedback của bạn</button>
            </form>
        </div>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col"><%=username%></th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>
    </div>
<jsp:include page="fragment/script.jsp"></jsp:include>
</body>
</html>
