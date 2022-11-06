package controller;

import models.Product;
import models.ProductCollap;
import service.CategoryService;
import service.Impl.CategoryServiceImpl;
import service.Impl.ProductServiceImpl;
import service.ProductService;
import utils.ProductConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

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
                insertProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "search":
                searchProductByName(request, response);
                break;
            case "sort":
                sortUserByName(request, response);
                break;
            default:
                showListProduct(request, response);
                break;
        }
    }

//    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product-create.jsp");
//        dispatcher.forward(request, response);
//    }

    // insert product
    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("id_category"));
        Product productNew = new Product(name, price, quantity, color, description, id_category);

        productService.addNewProduct(productNew);
//        response.sendRedirect("product?action=list");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-create.jsp");
        dispatcher.forward(request, response);
    }

    // delete product
    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_product"));
        try {
            productService.delete(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        List<ProductCollap> productList = null;
        productList = productService.showListProduct();

        request.setAttribute("listProduct", productList);
//        response.sendRedirect("product?action=list");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }


    // edit
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_product"));

        ProductCollap productCollapExist = null;
        productCollapExist = productService.searchProductByID(id);

        request.setAttribute("product", productCollapExist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-edit.jsp");
        dispatcher.forward(request, response);
    }

    // update
    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id_product"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("id_category"));

        Product product = new Product(id, name, price, quantity, color, description, id_category);
        try {
            productService.update(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("product?action=list");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product-edit.jsp");
//        dispatcher.forward(request, response);
    }

    // default
    private void showListProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCollap> productCollapList = productService.showListProduct();
        request.setAttribute("ListProduct", productCollapList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }

    public void searchProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCollap> productList = null;
        String name = request.getParameter("name");
        productList = productService.searchProductByName(name);

        RequestDispatcher dispatcher;
        request.setAttribute("ListProduct", productList);
        dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }

    public void searchProductByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCollap> productList = null;
        double price = Double.parseDouble(request.getParameter("price"));
        productList = productService.searchProductByPrice(price);

        RequestDispatcher dispatcher;
        request.setAttribute("ListProduct", productList);
        dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }

    public void sortUserByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductCollap> productList = null;
        productList = productService.sortByName();

        RequestDispatcher dispatcher;
        request.setAttribute("ListProduct", productList);
//        response.sendRedirect("product?action=list");
        dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }

}
