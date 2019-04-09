<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2019
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragment/head.jsp">
    <jsp:param name="title" value="Feedback"></jsp:param>
</jsp:include>
<% String username = (String) request.getAttribute("username"); String pass = (String) request.getAttribute("pass");%>
<body>
<form action="feedback" method="post" class="mx-auto col-md-7 ">
    <%-- ----------------------------------------- chất lượng sản phẩm --------------------------------------------- --%>
    <fieldset class="border border-secondary ">
        <h5 class="text-center">Feedback</h5>
        <div class="ml-3 mt-5 ">
            <div class="text-center">
                <input name="pass" value="<%=pass%>">
                <input name="username" value="<%=username%>">
            </div>
            <div>
                <h6>product quality</h6>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="quality1" value="not good" name="quality" class="custom-control-input">
                <label class="custom-control-label" for="quality1">not good</label>
            </div>

            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="quality2" value="good" name="quality" class="custom-control-input">
                <label class="custom-control-label" for="quality2">good</label>
            </div>

            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="quality3" value="very good" name="quality" class="custom-control-input">
                <label class="custom-control-label" for="quality3">very good</label>
            </div>
        </div>

        <%-- ----------------------------- bạn có thích sản phẩm của chúng tôi không ----------------------------------- --%>
        <div class="ml-3 mt-5 ">
            <div>
                <h6>Do you like the product?</h6>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="like1" value="no" name="like" class="custom-control-input">
                <label class="custom-control-label" for="like1">no</label>
            </div>

            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="like2" value="yes" name="like" class="custom-control-input">
                <label class="custom-control-label" for="like2">yes</label>
            </div>

            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="like3" value="like so much" name="like" class="custom-control-input">
                <label class="custom-control-label" for="like3">like so much</label>
            </div>
        </div>

        <%-- ----------------------------- Sản phẩm/dịch vụ này có đáng để bạn chi tiền ----------------------------------- --%>
        <div class="ml-3 mt-5 ">
            <div>
                <h6>Is this product / service worth your money?</h6>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="money1" value="no" name="money" class="custom-control-input">
                <label class="custom-control-label" for="money1">no</label>
            </div>

            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="money2" value="yes" name="money" class="custom-control-input">
                <label class="custom-control-label" for="money2">yes</label>
            </div>

            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="money3" value="very worth it" name="money" class="custom-control-input">
                <label class="custom-control-label" for="money3">very worth it</label>
            </div>
        </div>
        <%-- ---------------------------------- đánh giá của người dùng -------------------------------------------- --%>
        <div class="ml-3 mt-5 ">What you want in the next version</div>
        <div class="input-group col-md-5 ml-3 mt-5 ">
            <textarea class="form-control" name="version" aria-label="With textarea"></textarea>
        </div>

        <button type="submit" class="btn btn-primary ml-3 mt-5 ">submit</button>
    </fieldset>
</form>
<jsp:include page="fragment/script.jsp"></jsp:include>
</body>
</html>
