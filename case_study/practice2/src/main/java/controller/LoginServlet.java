package controller;

import models.Account;
import repository.Impl.RoomRepositoryImpl;
import repository.RoomRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    RoomRepository roomRepository = new RoomRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        Account account = roomRepository.login(userName, password);
        if (account == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/room?action=list").forward(request, response);
        }
//        response.sendRedirect("login.jsp");
    }
}
