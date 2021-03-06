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
        if(request.getParameter("username").equals("") || request.getParameter("password").equals("")){
            response.getWriter().print("<html>" +
                    "<head>" +
                    "You didn't fill in the form completely.. <br /><button onclick='window.history.back()'>Please try again</button>" +
                    "</body>" +
                    "</html>");
        } else {
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
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!DataHandler.loginCheck(request)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/register.html");
            requestDispatcher.forward(request, response);
        } else {
            if(((User)request.getSession().getAttribute("user")).getType().equals(TypeUser.TENANT)){
                response.sendRedirect("/searchrooms");
            } else {
                response.sendRedirect("/showrooms");
            }
        }
    }
}
