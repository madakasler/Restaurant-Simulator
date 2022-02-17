package BusinessLayer;

import java.io.IOException;

public interface IDeliveryServiceProcessing {

    public void addProduct(String name, String type, Double price, int calories, int protein, int fat, int sodium, int rating, String baseProducts) throws IOException;
    public void deleteItem(String name, String type);
    public void editItemByPrice(String name, Double price);
    public void editItemByRating(String name, int rating);
    public double computePrice(int orderID, int clientID);
    public void billGenerate(int orderID, int clientID) throws IOException;
    public void order(int orderID, int clientID, String products);
    public void Report1() throws IOException;
    public void Report2() throws IOException;
    public void Report3() throws IOException;
    public void Report4() throws IOException;
    public boolean invariant();


}
