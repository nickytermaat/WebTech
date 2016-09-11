package model;

/**
 * Created by Kris on 9/1/2016.
 */
public class Room {
    private double price;
    private double surface;
    private String city;

    public Room(double price, double surface, String city) {
        this.price = price;
        this.surface = surface;
        this.city = city;
    }

    /**
     * Returns the price
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the surface (square meters)
     * @return
     */
    public double getSurface() {
        return surface;
    }

    /**
     * Returns the city
     * @return
     */
    public String getCity() {
        return city;
    }

}
