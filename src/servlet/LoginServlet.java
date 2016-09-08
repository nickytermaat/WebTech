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
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Kris on 9/1/2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Checks if posted data is correct
        if(DataHandler.login(request)){
            //login successful
            //Create or get session and store username of logged in user
//            HttpSession session = request.getSession();

            //Redirect to user page
            if(((User)request.getSession().getAttribute("user")).getType().equals(TypeUser.TENANT)){
                response.sendRedirect("/searchrooms");
            } else {
                response.sendRedirect("/showrooms");
            }

        } else {
            //login unsuccessful, redirect to invalidCredentials.html
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/invalidcredentials.html");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Gets the page to display

        //Check if there is a session. If so, redirect to searchRoms
        HttpSession session = request.getSession(false);
        if(session != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/tenant.html");
            requestDispatcher.forward(request, response);
        }else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.html");
            requestDispatcher.forward(request, response);
        }
    }

}
