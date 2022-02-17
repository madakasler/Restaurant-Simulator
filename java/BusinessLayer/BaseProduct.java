package BusinessLayer;

public class BaseProduct extends MenuItem{
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
    public BaseProduct(String name, double price, double rating, int calories, int protein, int fat, int sodium) {
        super(name, price, rating, calories, protein, fat, sodium);
    }


    /**
     *
     * @return
     */
    public double computePrice()
    {
        double price = 0.0;
        return price;

    }
    /**
     *
     * @return
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     *
     * @return
     */
    public double getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */

    public void setRating(double rating) {
        this.rating = rating;
    }
    /**
     *
     * @return
     */
    public int getCalories() {
        return calories;
    }

    /**
     *
     * @param calories
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }
    /**
     *
     * @return
     */
    public int getProtein() {
        return protein;
    }

    /**
     *
     * @param protein
     */
    public void setProtein(int protein) {
        this.protein = protein;
    }
    /**
     *
     * @return
     */
    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }
    /**
     *
     * @return
     */
    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    @Override
    public String toString() {
        return "BaseProduct{" +

                "price=" + price +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                '}';
    }
}
