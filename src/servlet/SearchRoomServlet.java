package servlet;

import model.DataHandler;
import model.TypeUser;
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

    /**
     * Get information form the cookie and use it to display the amount of times the user has been on that page.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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

    /**
     * Check if the user is logged in, check if the user is a tenant.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(DataHandler.loginCheck(request)){
            //Session is initialized, someone is logged in
            if(((User)request.getSession().getAttribute("user")).getType().equals(TypeUser.TENANT)){
                RequestDispatcher resqDispatcher = request.getRequestDispatcher("WEB-INF/tenant.html");
                resqDispatcher.forward(request, response);
            } else{
                response.getWriter().print("You are not a tenant and are not authorized to view this page. ");
            }
        } else {
            response.getWriter().print("You are not logged in. Please log in first.");
        }
    }

    /**
     * Checks if a cookie for a user exists. If so, return that cookie, else return a new cookie
     * @param request contains the username to search for
     * @return a cookie, new or existing
     */
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
