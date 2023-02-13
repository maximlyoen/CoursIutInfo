/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.property;

/**
 *
 * @author mlevecq
 */
public class PropertyBid {
    private final Genre genre;
    private final String name;
    private final String address;
    private final String city;
    private final String description;
    private final int maxOccupiers;
    private final int price;
    
    public PropertyBid(Genre genre , String name, String address, String hidden, String city, String description, int maxOccupiers, int price) {
        this.genre = genre;
        this.name = name;
        this.address = address;
        this.city = city;
        this.description = description;
        this.maxOccupiers = maxOccupiers;
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxOccupiers() {
        return maxOccupiers;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PropertyBid{" + "genre=" + genre + ", name=" + name + ", address=" + address + ", city=" + city + ", description=" + description + ", maxOccupiers=" + maxOccupiers + ", price=" + price + '}';
    }
    
}
