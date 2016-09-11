package listener;

import model.Room;
import model.TypeUser;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;

/**
 * Created by Kris on 9/7/2016.
 */
@WebListener
public class OurContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //First initialization
        ServletContext ctx = servletContextEvent.getServletContext();

        ArrayList<User> newUsers = new ArrayList<>();
        newUsers.add(new User("Nicky", "nicky", TypeUser.TENANT));
        newUsers.add(new User("Kris", "kris", TypeUser.TENANT));

        User landLord = new User("LandLord", "lord", TypeUser.LANDLORD);
        landLord.addRoom(new Room(285.00, 18.00, "amsterdam"));
        landLord.addRoom(new Room(285.00, 12.00, "berlin"));
        landLord.addRoom(new Room(354.00, 6.00, "newyork"));
        newUsers.add(landLord);

        ctx.setAttribute("users", newUsers);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
