package model;

/**
 * Created by Kris on 9/1/2016.
 */
public class User {
    private String username;
    private String password;
    private TypeUser type;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public TypeUser getType() {
        return type;
    }

    public User(String username, String password, TypeUser type) {

        this.username = username;
        this.password = password;
        this.type = type;
    }
}
