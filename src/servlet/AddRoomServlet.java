package servlet;

import model.DataHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Nicky on 02/09/2016.
 */
@WebServlet("/addroom")
public class AddRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Is posted to servlet.AddRoomServlet");

        System.out.println(request.getParameter("sqm"));
        System.out.println(request.getParameter("price"));
        System.out.println(request.getParameter("city"));

        DataHandler.addRoom(request);
        //.showRooms(Double.parseDouble(request.getParameter("price")), Double.parseDouble(request.getParameter("sqm")), request.getParameter("city")))
//        {
            //add room successful, redirect to show rooms
//            System.out.println("added room successful");
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/landlord.html");
//            response.sendRedirect("/showrooms");
            // .forward(request, response);

//        }
        response.sendRedirect("/showrooms");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addroomservlet");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/addroom.html");
        requestDispatcher.forward(request, response);
    }
}
