package servlet;

import model.DataHandler;
import model.TypeUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Nicky on 01/09/2016.
 */
@WebServlet("/showrooms")
public class ShowRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Check if user is landlord
        PrintWriter pw = response.getWriter();
        if(DataHandler.typeCheck(request, TypeUser.LANDLORD)){


            pw.print("<html>" +
                    "<head>" +
                    "<title>" +
                    "Search rooms" +
                    "</title>" +
                    "</head>" +
                    "<body>" +
                    "Rooms found:" +
                    DataHandler.showRooms(request) +
                    "    <a href=\"/addroom\"> Add a room</a>\n"+
                    "</body>" +
                    "</html>");

        }
        else{
            pw.print("You are not authorized to view this page. Please log in as a landlord");
        }
    }
}
