package servlet;

import model.DataHandler;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import static java.awt.SystemColor.text;

/**
 * Created by Nicky on 31/08/2016.
 */
@WebServlet("/searchrooms")
public class SearchRoomServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();

        Cookie cookie = getCookieForUser(request);

        cookie.setValue(String.valueOf(Integer.valueOf(cookie.getValue()) + 1));
        response.addCookie(cookie);
        String rooms = "kamers";
        rooms = DataHandler.filterRooms(request);
        pw.print("<html>" +
                "<head>" +
                "<title>" +
                "Search rooms" +
                "</title>" +
                "</head>" +
                "<body>" +
                "You have visited this page " + cookie.getValue() + " times <br />" +
                "Rooms found:" +
                rooms +
                "</body>" +
                "</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher resqDispatcher = request.getRequestDispatcher("WEB-INF/tenant.html");
        resqDispatcher.forward(request, response);
    }

    private Cookie getCookieForUser(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        //Check if cookie for this user exists, if not, create it
        //If cookie exists, add +1 to counter of pageVisited
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(((User)request.getSession().getAttribute("user")).getUsername())) {
                return cookie;
            }
        }
        return new Cookie(((User)request.getSession().getAttribute("user")).getUsername(), "0");
    }
}
