import com.sun.deploy.net.HttpRequest;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Kris on 9/7/2016.
 */
final class DataHandler {
    static boolean login(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        for (User user : users) {
            if (user.getUsername().toLowerCase().equals(request.getParameter("firstname").toLowerCase()) && user.getPassword().equals(request.getParameter("password"))) {
                return true;
            }
        }
        return false;
    }

}
