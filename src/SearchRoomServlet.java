import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.awt.SystemColor.text;

/**
 * Created by Nicky on 31/08/2016.
 */
@WebServlet("/searchroomservlet")
public class SearchRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("<html><head><title>Hello World!</title></head>");
//        response.getWriter().println("<body><h1>Hello World!</h1></body></html>");
        RequestDispatcher resqDispatcher = request.getRequestDispatcher("WEB-INF/login.html");
        resqDispatcher.forward(request, response);
    }
}
