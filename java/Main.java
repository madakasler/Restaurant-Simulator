import BusinessLayer.DeliveryService;
import Presentation.LoginPage;

import java.io.*;

public class Main {
    public static DeliveryService deliveryService = new DeliveryService();
    public static void main(String[] args) throws IOException {
	// write your code here
       /* String line = "";
        String splitBy = ",";
        HashSet<String> lines = new HashSet<>();
        ArrayList<MenuItem> baseProducts= new ArrayList<MenuItem>();
        int i=0;
        try

        {
//parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("C:\\UTCN\\AN2_SEM2\\TP\\assignment4\\src\\products.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] product = line.split(splitBy);
                if (lines.add(product[0]) && i!=0) {
                    //System.out.println("Base product [title=" + product[0] + ", rating=" + product[1] + ", Calories=" + product[2] + ", Protein=" + product[3] + ", Fat= " + product[4] + ", Sodium= " + product[5] +", Price= " + product[6] +"]");

                   BaseProduct baseProduct = new BaseProduct(product[0],Double.parseDouble(product[6]),Double.parseDouble(product[1]),Integer.parseInt(product[2]),Integer.parseInt(product[3]),Integer.parseInt(product[4]),Integer.parseInt(product[5]));
                    baseProducts.add(baseProduct);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
//        try
//        {
//            FileInputStream file = new FileInputStream("delivery.ser");
//            ObjectInputStream in = new ObjectInputStream(file);
//            MenuItem menuItem = (MenuItem) in.readObject();
//            in.close();
//            file.close();
//        } catch(IOException ex) {
//            System.out.println("IOException is caught");
//        } catch(ClassNotFoundException ex) {
//            System.out.println("ClassNotFoundException is caught");
//        }
        LoginPage loginPage = new LoginPage();
     /*  BaseProduct baseProduct0 = new BaseProduct("paste",20.0,5.0,4,5,6,7);
        BaseProduct baseProduct1 = new BaseProduct("oua",20.0,5.0,4,5,6,7);
        BaseProduct baseProduct2 = new BaseProduct("sos",20.0,5.0,4,5,6,7);
        ArrayList <MenuItem>produs1= new ArrayList<MenuItem>();
        produs1.add(baseProduct0);
        produs1.add(baseProduct1);
        produs1.add(baseProduct2);
        CompositeProduct compositeProduct = new CompositeProduct("Paste cu sos",20.0,5.0,4,5,6,7,produs1);
        produs1.add(compositeProduct);

        DeliveryService deliveryService = new DeliveryService(produs1);
        deliveryService.addProduct("paste","Base Product",20.0,5,4,6,2,5,"");
        deliveryService.addProduct("oua","Base Product",20.0,5,4,6,2,5,"");
        deliveryService.addProduct("sos","Base Product",20.0,5,4,6,2,5,"");
        deliveryService.addProduct("Paste cu sos","Composite Product",20.0,5,4,6,2,5,"paste, oua, sos");
        System.out.println(deliveryService.getMenuItems().size());

        for(int j=0; j<deliveryService.getMenuItems().size();j++)
        {
            System.out.println(deliveryService.getMenuItems().get(j).getName());
        }
        deliveryService.deleteItem("paste","Base Product");
        System.out.println(deliveryService.getMenuItems().size());

        for(int j=0; j<deliveryService.getMenuItems().size();j++)
        {
            System.out.println(deliveryService.getMenuItems().get(j).getName());
        }
*/

    }


}

