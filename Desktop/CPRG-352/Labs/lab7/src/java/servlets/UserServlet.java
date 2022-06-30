package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataaccess.UserDB;
import models.User;
import services.UserService;

public class UserServlet extends HttpServlet {

    // Service objects
    UserService userService = new UserService();

    // Handles the GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Send list of users to JSP
        try {
            java.util.List<User> userList = userService.getAll();
            request.setAttribute("users", userList);
        } catch (Exception e) {
            System.out.println("Error with viewing users");
        }

        // Render users.jsp
        request.getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    // Handles the POST request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // services
        UserDB foo = new UserDB();

        // Add User
        if (request.getParameter("addBtn") != null) {
            // get data from form
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String role = request.getParameter("role");
            String isActive = request.getParameter("isActive");

            // validate form data
            // create a new user object and save it to the database
            try {
                UserService.insert(new User(email, firstName, lastName, "", Integer.parseInt(role), Boolean.parseBoolean(isActive)));
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.sendRedirect(request.getContextPath() + "/UserServlet");
        }

        // Edit User
        if (request.getParameter("editBtn") != null) {
            try {
                // get data from form
                String email = request.getParameter("email");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                int role = Integer.parseInt(request.getParameter("role"));
                String isActive = request.getParameter("isActive");
                

                // validate form data
                // update user
                User newUser = new User(email, firstName, lastName, "", role, Boolean.parseBoolean(isActive));
                UserService.update(newUser);
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.sendRedirect(request.getContextPath() + "/UserServlet");

        }

        // Delete user
        if (request.getParameter("deleteBtn") != null) {
            try {
                foo.delete(request.getParameter("email"));
            } catch (Exception e) {
                e.printStackTrace();
            }

            response.sendRedirect(request.getContextPath() + "/UserServlet");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
