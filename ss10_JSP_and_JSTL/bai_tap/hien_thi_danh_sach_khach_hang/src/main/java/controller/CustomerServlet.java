package controller;

import model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/customers","/khach-hang"})
public class CustomerServlet extends HttpServlet {
    public static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Trần Thế Huy","2002-11-16","Đà Nẵng","http://static.gamehub.vn/img/files/2017/04/13/Gamehubvn-cac-nhan-vat-trong-one-piece-tuong-ung-voi-qyoc-gia-nao-2.jpg"));
        customerList.add(new Customer("Lê Nhĩ Khang","2002-12-12","Quảng Nam","http://static.gamehub.vn/img/files/2017/04/13/Gamehubvn-cac-nhan-vat-trong-one-piece-tuong-ung-voi-qyoc-gia-nao-9.jpg"));
        customerList.add(new Customer("Nguyễn Thị Bích Giang","2001-02-28","Quảng Ngãi","http://static.gamehub.vn/img/files/2017/04/13/Gamehubvn-cac-nhan-vat-trong-one-piece-tuong-ung-voi-qyoc-gia-nao-1.jpg"));
        customerList.add(new Customer("Nguyễn Thanh Hào","2003-07-19","Hà Tĩnh","http://static.gamehub.vn/img/files/2017/04/13/Gamehubvn-cac-nhan-vat-trong-one-piece-tuong-ung-voi-qyoc-gia-nao-5.jpg"));
        customerList.add(new Customer("Trần Bảo Trân","2000-03-31","Hà Nội","http://static.gamehub.vn/img/files/2017/04/13/Gamehubvn-cac-nhan-vat-trong-one-piece-tuong-ung-voi-qyoc-gia-nao-4.jpg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("customers",customerList);
        request.getRequestDispatcher("listCustomer.jsp").forward(request,response);
    }
}
