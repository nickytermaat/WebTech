package servlet;

import model.DataHandler;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nicky on 01/09/2016.
 */
@WebServlet("/showpersonsservlet")
public class ShowPersonsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(DataHandler.loginCheck(request)){
            response.getWriter().print("<html><body>");
            for (User user : (ArrayList<User>)request.getServletContext().getAttribute("users")) {
                response.getWriter().print(user.print());
            }
            response.getWriter().print("</body></html>");
        }
        else{
            response.sendRedirect("/login");
        }
    }
}
