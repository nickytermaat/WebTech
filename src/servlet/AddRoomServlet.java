package servlet;

import model.DataHandler;
import model.TypeUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by Nicky on 02/09/2016.
 */
@WebServlet("/addroom")

public class AddRoomServlet extends HttpServlet {
    /**
     * Add a room
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataHandler.addRoom(request);

        response.sendRedirect("/showrooms");
    }

    /**
     * Retrieve the addroom page if the user is a landlord
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(DataHandler.typeCheck(request, TypeUser.LANDLORD)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/addroom.html");
            requestDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("/login");
        }
    }
}
