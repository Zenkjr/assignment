package controller;

import entity.FeedbackEntity;
import entity.UserEntity;
import model.FeedbackModel;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FeedbackController extends HttpServlet {
    UserEntity userEntity = new UserEntity();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FeedbackEntity feedbackEntity = new FeedbackEntity();
        FeedbackModel fbModel = new FeedbackModel();

        UserModel userModel = new UserModel();



        String[] quality = request.getParameterValues("quality");
        String[] like = request.getParameterValues("like");
        String[] money = request.getParameterValues("money");

        feedbackEntity.setVersion(request.getParameter("version"));

        UserEntity us =  userModel.getUserByNameAndPassword(userEntity);

        feedbackEntity.setId(us.getId());
        feedbackEntity.setQuality(quality[0]);
        feedbackEntity.setLikeProduct(like[0]);
        feedbackEntity.setMoney(money[0]);


        fbModel.insert(feedbackEntity);


        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("<h2><font color=green>Your chon :</font></h2>");
        writer.println("<br><font color=blue>" + quality[0] + "</font>");
        writer.println("<br><font color=blue>" + like[0] + "</font>");
        writer.println("<br><font color=blue>" + money[0] + "</font>");
        writer.println("<br><font color=blue>" + feedbackEntity.getVersion() + "</font>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userEntity.setUsername(request.getParameter("username"));
        userEntity.setPassword(request.getParameter("pass"));

        request.setAttribute("username",request.getParameter("username"));
        request.setAttribute("pass",request.getParameter("pass"));

        request.getRequestDispatcher("feedback.jsp").forward(request, response);
    }
}
