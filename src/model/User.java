package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Kris on 9/1/2016.
 */
public class User {
    private String username;
    private String password;
    private TypeUser type;
    private ArrayList<Room> rooms;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public TypeUser getType() {
        return type;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public User(String username, String password, TypeUser type) {

        this.username = username;
        this.password = password;
        this.type = type;
        this.rooms = new ArrayList<Room>();

    }
}
