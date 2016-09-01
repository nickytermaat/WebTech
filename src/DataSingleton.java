import model.Room;
import model.TypeUser;
import model.User;

import java.util.ArrayList;

/**
 * Created by Kris on 9/1/2016.
 */
public class DataSingleton {
    private ArrayList<User> users;
    private ArrayList<Room> rooms;

    private static DataSingleton ourInstance = null;

    public static DataSingleton getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataSingleton();
        }

        return ourInstance;
    }

    private DataSingleton() {
        ArrayList<User> newUsers = new ArrayList<>();
        newUsers.add(new User("Nicky", "nicky", TypeUser.TENANT));
        newUsers.add(new User("Kris", "kris", TypeUser.TENANT));
        newUsers.add(new User("LandLord", "lord", TypeUser.LANDLORD));

        ArrayList<Room> newRooms = new ArrayList<>();
        newRooms.add(new Room(285.00, 18.00, "Amsterdam"));
        newRooms.add(new Room(285.00, 12.00, "Berlijn"));
        newRooms.add(new Room(354.00, 6.00, "New York"));

        users = newUsers;
        rooms = newRooms;
    }

    //TODO: Fix public access to list
    public ArrayList<User> getUsers() {
        return users;
    }

    //TODO: Fix public access to list
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public boolean login(String username, String password){
        for (User user : users) {
            if (user.getUsername().toLowerCase().equals(username.toLowerCase()) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
