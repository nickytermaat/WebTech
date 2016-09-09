package servlet;

import model.DataHandler;
import model.TypeUser;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Kris on 9/2/2016.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add new user
        System.out.println("Create new user");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        System.out.println(request.getParameter("confirmpassword"));
        System.out.println(request.getParameter("type"));

        // First check if the username already exists
        PrintWriter pw = response.getWriter();

        boolean uniqueUser = DataHandler.uniqueUser(request);

        if (uniqueUser == false) {
            pw.print("<html>" +
                    "<head>" +
                    "<title>" +
                    "Register" +
                    "</title>" +
                    "</head>" +
                    "<body>" +
                    "The name you chose is not unique. Register with an unique name. <br />" +
                    "Not unique username you chose: " + request.getParameter("username") + " <br/> " +
                    "Click <a href=\"/register\"> here </a> to try again.\n" +
                    "</body>" +
                    "</html>");
        } else {
            if (request.getParameter("password").equals(request.getParameter("confirmpassword"))){
                pw.print("<html>" +
                        "<head>" +
                        "<title>" +
                        "Register" +
                        "</title>" +
                        "</head>" +
                        "<body>" +
                        "You registered!  <br />" +
                        "Your username: " + request.getParameter("username") + "<br />" +
                        "Click <a href=\"/login\"> here </a> to go to the login page.\n" +
                        "</body>" +
                        "</html>" );
            } else {
                pw.print("<html>" +
                        "<head>" +
                        "<title>" +
                        "Register" +
                        "</title>" +
                        "</head>" +
                        "<body>" +
                        "Incorrect password!  <br />" +
                        "Your username: " + request.getParameter("username") + "<br />" +
                        "Your password and password confirmation are not the same" +
                        "Click <a href=\"/register\"> here </a> to try again.\n"+
                        "</body>" +
                        "</html>" );
            }
        }

        DataHandler.addUser(request);

        /*if(((listener.OurContextListener)getServletContext()).uniqueUser(request.getParameter("firstname")) && request.getParameter("password").equals(request.getParameter("confirmpassword"))){
            //Name is unique, passwords match
            User user = new User(request.getParameter("firstname"), request.getParameter("password"), TypeUser.valueOf(request.getParameter("usertype")));
            ((listener.OurContextListener)getServletContext()).addUser(user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/register.html");
            requestDispatcher.forward(request, response);
        } else {
            //TODO: Show user friendly message, something went wrong.
            PrintWriter out = response.getWriter();
            out.println("<!doctype html\">\n"
                    + "<html>\n"
                    + "<head><title>Invalid registration</title></head>\n"
                    + "<body>\n"
                    + "<p>Something went wrong! That username may already be taken, or your passwords didn't match...</p>\n"
                    + "Click <a href=\"/register\"> here </a> to try again.\n"
                    + "</body></html>");
        }*/
//        System.out.println(TypeUser.;request.getParameter("usertype"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/register.html");
        requestDispatcher.forward(request, response);
    }
}
