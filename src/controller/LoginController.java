package controller;

import entity.UserEntity;
import model.UserModel;
import validate.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.System.out;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(req.getParameter("username"));
        userEntity.setPassword(req.getParameter("password"));
        if (Validate.checkUser(userEntity)) {
            req.setAttribute("pass",userEntity.getPassword());
            req.setAttribute("name", userEntity.getUsername());

            RequestDispatcher rs;
            rs = req.getRequestDispatcher("home.jsp");
            rs.forward(req, resp);
        } else {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = req.getRequestDispatcher("login.jsp");
            rs.include(req, resp);
        }
    }
}
