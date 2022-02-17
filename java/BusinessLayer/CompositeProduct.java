package BusinessLayer;

import java.util.ArrayList;

public class CompositeProduct extends  MenuItem{
    private ArrayList<MenuItem> baseProducts = new ArrayList<MenuItem>();

    /**
     *
     * @param name
     * @param price
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param baseProducts
     */
    public CompositeProduct(String name, double price, double rating, int calories, int protein, int fat, int sodium, ArrayList<MenuItem> baseProducts) {
        super(name, price, rating, calories, protein, fat, sodium);
        this.baseProducts = baseProducts;
       this.setPrice((computePrice()));
    }


    /**
     *
     * @return
     */
    public double computePrice()
    {
        double price =0.0;
        int rating = 0;
        for(MenuItem m : baseProducts)
        {
            price= price+ m.getPrice();

        }

        if(baseProducts.size()>4)
            price=price+10.0;
        else
            price = price+5.0;
        return price;
    }

    public ArrayList<MenuItem> getBaseProducts() {
        return baseProducts;
    }

    @Override
    public String toString() {
        return "CompositeProduct{" +
                "baseProducts=" + baseProducts +
                '}';
    }

    /**
     *
     * @param baseProducts
     */
    public void setBaseProducts(ArrayList<MenuItem> baseProducts) {
        this.baseProducts = baseProducts;
    }
}
