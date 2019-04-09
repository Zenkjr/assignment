package controller;

import entity.UserEntity;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserEntity user = new UserEntity();
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        UserModel userModel = new UserModel();

        boolean check = userModel.insert(user);
        if (check){
            response.getWriter().println("Submit thành công.");
            response.sendRedirect("login");
        }else {
            response.getWriter().println("Submit thất bại.");
        }

    }
}
