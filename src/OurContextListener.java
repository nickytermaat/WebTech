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
        newRooms.add(new Room(285.00, 18.00, "Amsterdam"));
        newRooms.add(new Room(285.00, 12.00, "Berlijn"));
        newRooms.add(new Room(354.00, 6.00, "New York"));

        ctx.setAttribute("users", newUsers);
        ctx.setAttribute("rooms", newRooms);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

//    public boolean login(String username, String password){
//        for (User user : users) {
//            if (user.getUsername().toLowerCase().equals(username.toLowerCase()) && user.getPassword().equals(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean uniqueUser(String username){
//        for (User user : users){
//            if(user.getUsername().equals(username))
//                return false;
//        }
//        return true;
//    }
//
//    public void addUser(User user){
//        users.add(user);
//    }
//
//    public String showRooms(double price, double sqm, String city){
//        String room = "";
//        for (int i = 0; i < rooms.size() ; i++) {
//            room += "<p>Room " + i + ": $" + rooms.get(i).getPrice() + " Sqm " + rooms.get(i).getSurface() + " located in "  + rooms.get(i).getCity() + "</p> \n" ;
//        }
//        return room;
//    }

}
