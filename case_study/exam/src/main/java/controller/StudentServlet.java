package controller;

import models.Student;
import repository.Impl.StudentRepositoryImpl;
import repository.StudentRepository;

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

@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentRepository studentService = new StudentRepositoryImpl();

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
                insertStudent(request, response);
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "search":
                searchStudentByName(request, response);
                break;
            default:
                showListStudent(request, response);
                break;
        }
    }

    public void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameNew = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String dob = request.getParameter("dob");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        String error = null;
        try {
            dateOfBirth = format.parse(dob);
        } catch (ParseException e) {
            error = "Date Of Birth has wrong format!";
        }


        Student studentNew = new Student(nameNew, gender, dateOfBirth);
        studentService.addNewStudent(studentNew);
        response.sendRedirect("student?action=list");
    }

    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            studentService.delete(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<Student> studentList = null;
        studentList = studentService.showListStudent();

        request.setAttribute("listStudent", studentList);
        response.sendRedirect("student?action=list");
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Student studentExist = null;
        studentExist = studentService.searchStudentByID(id);

        request.setAttribute("student", studentExist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-edit.jsp");
        dispatcher.forward(request, response);
    }

    public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String dob = request.getParameter("dob");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth = null;
        String error = null;
        try {
            dateOfBirth = format.parse(dob);
        } catch (ParseException e) {
            error = "Date Of Birth has wrong format!";
        }

        Student student = new Student(id, name, gender, dateOfBirth);
        try {
            studentService.update(student);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("student?action=list");
    }

    private void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentService.showListStudent();
        request.setAttribute("ListStudent", studentList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }

    public void searchStudentByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = null;
        String name = request.getParameter("name");
        studentList = studentService.searchStudentByName(name);

        RequestDispatcher dispatcher;
        request.setAttribute("ListStudent", studentList);
        dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }
}
