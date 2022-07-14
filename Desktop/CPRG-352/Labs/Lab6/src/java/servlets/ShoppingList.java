package servlets;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingList extends HttpServlet {

    ArrayList<String> itemList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a session object
        HttpSession session = request.getSession();

        // Get sessions user if exists
        String username = (String) session.getAttribute("usersname");

        // render jsp based on if a user exists in the session or not
        if (username == null) {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
        }

        // invalidate session
        if (request.getQueryString().equals("logout")) {
            session.invalidate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create a session obhect
        HttpSession session = request.getSession();

        // get action from JSP
        String action = (String) request.getParameter("action");

        switch (action) {
            // logic to validate and register a user session
            case "register":
                // Get the username from the form
                String username = request.getParameter("username");

                // validation
                if (username.equals("")) {
                    // send error message to JSP
                    request.setAttribute("errorMsg", "Please enter a username");
                    request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                    return;
                } else {
                    // create a session
                    session.setAttribute("usersname", username);
                    response.sendRedirect("ShoppingList");
                    return;
                }
            // logic to add a item to the shopping list
            case "add":
                // add item to arraylist
                itemList.add(request.getParameter("item"));
                session.setAttribute("items", itemList);
                request.getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);
                break;
            // logic to delete selected items in the shopping list
            case "delete":
                itemList.remove(request.getParameter("item"));
                System.out.println(request.getParameter("item"));
                session.setAttribute("items", itemList);
                request.getRequestDispatcher("/WEB-INF/shoppinglist.jsp").forward(request, response);

                break;
            // logic to invalidate this users session
            case "logout":
                break;
        }

        // adding items
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
