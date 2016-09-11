package model;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Kris on 9/1/2016.
 */

/**
 * Class for the users
 * Users can have a list of rooms, but to do so, they have to be a landlord.
 */
public class User {
    private String username;
    private String password;
    private TypeUser type;
    private ArrayList<Room> rooms;

    /**
     * Returns the username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @returns the user's type
     */
    public TypeUser getType() {
        return type;
    }

    /**
     * Returns the list of rooms, if user is a landlord. Else returns null.
     * @return list of rooms
     */
    public ArrayList<Room> getRooms() {
        if(this.type.equals(TypeUser.LANDLORD))
            return rooms;
        else
            return null;
    }

    /**
     * Adds a room to the rooms list.
     * @param room
     */
    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public User(String username, String password, TypeUser type) {

        this.username = username;
        this.password = password;
        this.type = type;
        if(this.type.equals(TypeUser.LANDLORD))
            this.rooms = new ArrayList<Room>();

    }
}
