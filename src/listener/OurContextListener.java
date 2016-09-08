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
        //TODO: Fix ArrayLists, use serializable file?
        ArrayList<User> newUsers = new ArrayList<>();
        newUsers.add(new User("Nicky", "nicky", TypeUser.TENANT));
        newUsers.add(new User("Kris", "kris", TypeUser.TENANT));
        newUsers.add(new User("LandLord", "lord", TypeUser.LANDLORD));

        ArrayList<Room> newRooms = new ArrayList<>();
        newRooms.add(new Room(285.00, 18.00, "amsterdam"));
        newRooms.add(new Room(285.00, 12.00, "berlin"));
        newRooms.add(new Room(354.00, 6.00, "newyork"));

        ctx.setAttribute("users", newUsers);
        ctx.setAttribute("rooms", newRooms);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
