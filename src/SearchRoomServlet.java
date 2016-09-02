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
@WebServlet("/searchrooms")
public class SearchRoomServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("initializing");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.getWriter().println("<html><head><title>Hello World!</title></head>");
//        response.getWriter().println("<body><h1>Hello World!</h1></body></html>");
        //Check if user is logged in, else throw error 401 unauthorized
        RequestDispatcher resqDispatcher = request.getRequestDispatcher("WEB-INF/tenant.html");
        resqDispatcher.forward(request, response);
    }
}
