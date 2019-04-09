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
import java.util.ArrayList;

public class HomeController extends HttpServlet {
    private static UserEntity userEntity = new UserEntity();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackModel feedbackModel = new FeedbackModel();
        userEntity.setUsername((String) req.getAttribute("name"));
        userEntity.setPassword((String) req.getAttribute("pass"));
        ArrayList<FeedbackEntity> fbArray = feedbackModel.getFeedbackById();

        req.setAttribute("arrayList",fbArray);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
        userEntity.setUsername(req.getParameter("username"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

    }
}
