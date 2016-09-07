package model;

import com.sun.deploy.net.HttpRequest;
import model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by Kris on 9/7/2016.
 */
public final class DataHandler {
    public static boolean login(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        for (User user : users) {
            if (user.getUsername().toLowerCase().equals(request.getParameter("firstname").toLowerCase()) && user.getPassword().equals(request.getParameter("password"))) {
                return true;
            }
        }
        return false;
    }

    public boolean uniqueUser(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        for (User user : users){
            if(user.getUsername().equals(request.getServletContext().getAttribute("users")))
                return false;
        }
        return true;
    }

    public void addUser(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        users.add(new User (request.getParameter("username"), request.getParameter("password"), TypeUser.valueOf(request.getParameter("type"))));
    }

    public String showRooms(HttpServletRequest request){
        ArrayList<Room> rooms = ((ArrayList<Room>) request.getServletContext().getAttribute("rooms"));

        String room = "";
        for (int i = 0; i < rooms.size() ; i++) {
            room += "<p>Room " + i + ": $" + rooms.get(i).getPrice() + " Sqm " + rooms.get(i).getSurface() + " located in "  + rooms.get(i).getCity() + "</p> \n" ;
        }
        return room;
    }


}
