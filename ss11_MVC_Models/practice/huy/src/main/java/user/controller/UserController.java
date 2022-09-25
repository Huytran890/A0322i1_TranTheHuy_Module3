package user.controller;

import user.models.UserModels;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang chu","/user-home"})
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserModels userModels = new UserModels();
        userModels.setId(1);
        userModels.setFullName("Tran The Huy");
        request.setAttribute("models",userModels);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/home.jsp");
        requestDispatcher.forward(request,response);
    }
}
