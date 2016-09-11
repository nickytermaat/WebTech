package servlet;

import model.DataHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kris on 9/11/2016.
 */
@WebServlet("/logout")

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataHandler.logout(req);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/login.html");
        requestDispatcher.forward(req, resp);
    }
}
