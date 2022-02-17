package BusinessLayer;

import java.io.Serializable;

public class MenuItem implements Serializable {
    private String name;
    private double price;
    private double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;

    /**
     *
     * @param name
     * @param price
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     */
    public MenuItem(String name, double price, double rating, int calories, int protein, int fat, int sodium) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
    }

    public double computePrice()
    {
        return 0.0;
    }

    /**
     *
     * @return
     */
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

