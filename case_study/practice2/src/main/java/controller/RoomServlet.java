package controller;

import models.Room;
import models.RoomCollapPayment;
import repository.Impl.RoomRepositoryImpl;
import repository.RoomRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/room")
public class RoomServlet extends HttpServlet {
    RoomRepository roomRepository = new RoomRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                insertRoom(request, response);
                break;
            case "delete":
                deleteRoom(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "search":
                searchRoomByNameByName(request, response);
                break;
            default:
                showListRoom(request, response);
                break;
        }
    }

    private void insertRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_customer = request.getParameter("name_customer");
        String phone_number = request.getParameter("phone_number");
        String date_begin = request.getParameter("date_begin");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String error = null;
        try {
            date = format.parse(date_begin);
        } catch (ParseException e) {
            error = "Date Of Birth has wrong format!";
        }

        int id_payment = Integer.parseInt(request.getParameter("id_payment"));
        Room roomNew = new Room(name_customer, phone_number, date,
                id_payment);

        roomRepository.addNewRoom(roomNew);
//        response.sendRedirect("room?action=list");
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_room"));
        try {
            roomRepository.delete(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<RoomCollapPayment> roomList = null;
        roomList = roomRepository.showListRoom();

        request.setAttribute("listRoom", roomList);
//        response.sendRedirect("room?action=list");
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_room"));

        RoomCollapPayment roomCollapPaymentExist = null;
        roomCollapPaymentExist = roomRepository.searchRoomByID(id);

        request.setAttribute("room", roomCollapPaymentExist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showListRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RoomCollapPayment> roomCollapPaymentList = roomRepository.showListRoom();
        request.setAttribute("listRoom", roomCollapPaymentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }

    public void searchRoomByNameByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RoomCollapPayment> roomCollapPaymentList = null;
        String name = request.getParameter("name_customer");
        roomCollapPaymentList = roomRepository.searchRoomByNameCustomer(name);

        RequestDispatcher dispatcher;
        request.setAttribute("listRoom", roomCollapPaymentList);
        dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }


}