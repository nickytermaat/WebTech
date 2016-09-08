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
            if (user.getUsername().toLowerCase().equals(request.getParameter("username").toLowerCase()) && user.getPassword().equals(request.getParameter("password"))) {
                request.getSession().setAttribute("user", user);
                return true;
            }
        }
        return false;
    }

    public static boolean uniqueUser(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        for (User user : users){
            if(user.getUsername().equals(request.getServletContext().getAttribute("username")))
                return false;
        }
        return true;
    }

    public void addUser(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        users.add(new User (request.getParameter("username"), request.getParameter("password"), TypeUser.valueOf(request.getParameter("type"))));
    }

    public static String showRooms(HttpServletRequest request){
        ArrayList<Room> rooms = ((User) request.getServletContext().getAttribute("user")).getRooms();

        String room = "";
        for (int i = 0; i < rooms.size() ; i++) {
            room += "<p>Room " + i + ": $" + rooms.get(i).getPrice() + " Sqm " + rooms.get(i).getSurface() + " located in "  + rooms.get(i).getCity() + "</p> \n" ;
        }
        return room;
    }

    public static String filterRooms(HttpServletRequest request) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        for (User user :((ArrayList<User>)request.getServletContext().getAttribute("users"))) {
            rooms.addAll(user.getRooms());
        }

        String room = "";

        //String cityRoom = rooms.getCity().toLowerCase().equals(request.getParameter("city").toLowerCase());
        for (int i = 0; i < rooms.size() ; i++) {
            if (rooms.get(i).getCity().equals(request.getParameter("city").toLowerCase())) {
                room += "<p>Room " + i + ": $" + rooms.get(i).getPrice() + " Sqm " + rooms.get(i).getSurface() + " located in "  + rooms.get(i).getCity() + "</p> \n" ;
            }
        }
        if ((room.equals(""))){
            room = "No matches found";
        }

        return room;

    }

    public static void addRoom(HttpServletRequest request){

        System.out.println(request.getParameter("sqm"));
        System.out.println();
        System.out.println(request.getParameter("city"));

        Room room = new Room(Double.valueOf(request.getParameter("price")), Double.valueOf(request.getParameter("sqm")), request.getParameter("city"));
        ((ArrayList<Room>) request.getServletContext().getAttribute("rooms")).add(room);
    }
}
