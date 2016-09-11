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
    /**
     * Gets a username and a password in the Request, and checks if a user with this username & password exists
     * @param request The request contains POST data, and this will be used to check if the login is successful
     * @return if the request is successful
     */
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

    /**
     * Checks if the username is unique
     * @param request contains username
     * @return if the username is unique
     */
    public static boolean uniqueUser(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        for (User user : users){
            if(user.getUsername().equals(request.getServletContext().getAttribute("username")))
                return false;
        }
        return true;
    }

    /**
     * Adds a user
     * @param request Contains the user's data
     */
    public static void addUser(HttpServletRequest request){
        ArrayList<User> users = ((ArrayList<User>) request.getServletContext().getAttribute("users"));

        users.add(new User (request.getParameter("username"), request.getParameter("password"), TypeUser.valueOf(request.getParameter("type"))));
    }

    /**
     * Displays all rooms
     * @param request contains the ServletContext that contains all rooms
     * @return a HTML string that contains all rooms
     */
    public static String showRooms(HttpServletRequest request){
        ArrayList<Room> rooms = ((User) request.getServletContext().getAttribute("user")).getRooms();

        String room = "";
        for (int i = 0; i < rooms.size() ; i++) {
            room += "<p>Room " + i + ": $" + rooms.get(i).getPrice() + " Sqm " + rooms.get(i).getSurface() + " located in "  + rooms.get(i).getCity() + "</p> \n" ;
        }
        return room;
    }

    /**
     * Displays all rooms that match the search criteria
     * @param request Contains the search criteria
     * @return a HTML string that contains the rooms that match the criteria
     */
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

    /**
     * Gets the room data from the request and makes a new room with it. Then adds it to the r0oms list
     * @param request contains the room data
     */
    public static void addRoom(HttpServletRequest request){
        Room room = new Room(Double.valueOf(request.getParameter("price")), Double.valueOf(request.getParameter("sqm")), request.getParameter("city"));
        ((ArrayList<Room>) request.getServletContext().getAttribute("rooms")).add(room);
    }

    /**
     * TBI
     * Checks if a session with a user exists and if his role matches the given role
     * @param request contains the user
     * @param type checks if the user is the given role
     * @return
     */
    public static boolean typeCheck(HttpServletRequest request, TypeUser type){
        if(request.getSession().getAttribute("user") != null){
            //Check if a cookie exists
            if(((User)request.getSession().getAttribute("user")).getType().equals(type)){
                return true;
            }
        }
        return false;
    }
    /**
     * TBI
     * Checks if a session with a user exists and if his role matches the given role
     * @param request contains the user
     * @return
     */
    public static boolean loginCheck(HttpServletRequest request){
        if(request.getSession().getAttribute("user") != null){
            return true;
        }
        return false;
    }
}
