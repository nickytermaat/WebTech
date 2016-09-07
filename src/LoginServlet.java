import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kris on 9/1/2016.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Checks if posted data is correct
        if(DataHandler.login(request)){
            //login successful, redirect to showUser
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/tenant.html");
            response.sendRedirect("/searchrooms");
        } else {
            //login unsuccessful, redirect to invalidCredentials.html
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/invalidcredentials.html");
            requestDispatcher.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Gets the page to display

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/login.html");
        requestDispatcher.forward(request, response);
    }

}
