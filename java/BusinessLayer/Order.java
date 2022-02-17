package BusinessLayer;

public class Order {
    private int clientID;
    private int orderID;
    private String date;

    public Order(int clientID, int orderID, String date) {
        this.clientID = clientID;
        this.orderID = orderID;
        this.date = date;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public int hashCode() {
      return this.getOrderID();
    }
}
