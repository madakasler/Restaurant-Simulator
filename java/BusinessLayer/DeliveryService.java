package BusinessLayer;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class DeliveryService extends Observable implements IDeliveryServiceProcessing {
    public ArrayList<Order>ordersAll;
    public ArrayList<MenuItem> menuItems;
    public HashMap<Order, ArrayList<MenuItem>> map;
    public ArrayList<MenuItem> report1;
    public ArrayList<MenuItem> report2;
    public ArrayList<MenuItem> report3;
    public ArrayList<MenuItem> report4;
    public JFrame f;



    public DeliveryService() {
        this.ordersAll = new ArrayList<Order>();
        this.menuItems =new ArrayList<MenuItem>();
        this.map = new HashMap<Order, ArrayList<MenuItem>>();
        this.report1= new ArrayList<MenuItem>();
        this.report2= new ArrayList<MenuItem>();
        this.report3= new ArrayList<MenuItem>();
        this.report4= new ArrayList<MenuItem>();

    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    /**
     *
     * @param name
     * @param type
     * @param price
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param rating
     * @param baseProducts
     * @throws IOException
     */
    @Override
    public void addProduct(String name, String type, Double price, int calories, int protein, int fat, int sodium,int rating, String baseProducts) throws IOException {
        assert name!=null;
        FileWriter pw = new FileWriter("products.csv",true);

        StringBuilder sb = new StringBuilder();
        if(type.equals("Base Product"))
        {
            MenuItem baseProduct= new MenuItem(name,price,rating,calories,protein,fat,sodium);
            menuItems.add(baseProduct);
            sb.append(name);
            sb.append(",");
            sb.append(price);
            sb.append(",");
            sb.append(rating);
            sb.append(",");
            sb.append(calories);
            sb.append(",");
            sb.append(protein);
            sb.append(",");
              sb.append(fat);
            sb.append(",");
            sb.append(sodium);
            sb.append("\n");
            pw.write(sb.toString());
            pw.close();


            serialization(baseProduct);
        }
        else
        {
            ArrayList<MenuItem> baseProductsForCompositeProduct = new ArrayList<MenuItem>();
            String[] baseP= baseProducts.split(", ");
            for(String prod : baseP)
            {
                for(MenuItem menuItem :menuItems) {
                    if (menuItem.getName().equals(prod)) {
                        baseProductsForCompositeProduct.add(menuItem);
                    }
                }
            }
            MenuItem compositeProduct = new CompositeProduct(name,price,rating,calories,protein,fat,sodium,baseProductsForCompositeProduct);
            menuItems.add(compositeProduct);
            sb.append(name);
            sb.append(",");
            sb.append(price);
            sb.append(",");
            sb.append(rating);
            sb.append(",");
            sb.append(calories);
            sb.append(",");
            sb.append(protein);
            sb.append(",");
            sb.append(fat);
            sb.append(",");
            sb.append(sodium);
            sb.append("\n");
            pw.write(sb.toString());
            pw.close();
            serialization(compositeProduct);


        }
            assert invariant();
    }

    /**
     *
     * @param name
     * @param type
     */
    @Override
    public void deleteItem(String name, String type) {
        assert !menuItems.isEmpty();
        if(type.equals("Base Product"))
        {
            for(int i=0;i<menuItems.size();i++)
            {
                if(menuItems.get(i).getClass().getName().equals("BusinessLayer.CompositeProduct"))
                {
                    CompositeProduct c = new CompositeProduct("" ,0,0,0,0,0,0,new ArrayList<>());
                    c= (CompositeProduct) menuItems.get(i);

                    for(int j=0;j<c.getBaseProducts().size();j++)
                    {

                        if(c.getBaseProducts().get(j).getName().equals(name)){
                           menuItems.remove(menuItems.get(i));
                            i--;
                        }
                    }
                }
                if(menuItems.get(i).getName().equals(name))
                {
                    menuItems.remove(menuItems.get(i));
                    i--;
                }
            }
        }

    }

    /**
     *
     * @param name
     * @param price
     */
    @Override
    public void editItemByPrice(String name, Double price) {
        assert (price>0);
     for(int i=0;i<menuItems.size();i++)
     {
         if(menuItems.get(i).getName().equals(name))
         {
             menuItems.get(i).setPrice(price);
         }
     }
        assert invariant();
    }

    /**
     *
     * @param name
     * @param rating
     */

    @Override
    public void editItemByRating(String name, int rating) {
        assert (rating>0);
        for(int i=0;i<menuItems.size();i++)
        {
            if(menuItems.get(i).getName().equals(name))
            {
                menuItems.get(i).setPrice(rating);
            }
        }
        assert invariant();
    }

    /**
     *
     * @param orderID
     * @param clientID
     * @return
     */
    @Override
    public double computePrice(int orderID, int clientID) {
        assert (orderID > 0 && clientID > 0); //pre-condition
        double price =0.0;

         for(int count =0; count<ordersAll.size();count++)
         {
             if(ordersAll.get(count).getOrderID()==orderID && ordersAll.get(count).getClientID()==clientID )
             {
                 for(int i=0;i<map.get(ordersAll.get(count)).size();i++)
                 {
                     price=price+map.get(ordersAll.get(count)).get(i).getPrice();
                 }
             }
         }
        assert price > 0.0; //post-condition
        assert invariant();
        return price;
    }

    /**
     *
     * @param orderID
     * @param clientID
     * @throws IOException
     */

    @Override
    public void billGenerate(int orderID, int clientID) throws IOException {
        assert (orderID > 0 && clientID > 0); //pre-condition
        File file = new File(orderID+"_bill.txt");
        FileWriter fw= new FileWriter(file,true);
        String show="";
        double price = computePrice(orderID,clientID);
        Order o = new Order(0,0,"2021-05-05");
        for(int j=0; j<=ordersAll.size(); j++) {
            if(ordersAll.get(j).getOrderID() == orderID) {
                o = ordersAll.get(j);
                ordersAll.remove(ordersAll.get(j));
                j--;
                break;
            }
        }
        ArrayList<MenuItem> menuItems = map.get(o);
        for(int counter=0; counter<menuItems.size();counter++)
            show= show+menuItems.get(counter).getName()+ " - "+menuItems.get(counter).getPrice()+"\n";

        show=show+"TOTAL PRET "+ price;
        System.out.println(show);
        fw.write(show);
        fw.close();
        assert invariant();
    }

    /**
     *
     * @param orderID
     * @param clientID
     * @param products
     */
    @Override
    public void order(int orderID, int clientID, String products) {
        String date = "2020-05-05";
        assert (products!=null);

        Order o = new Order(clientID,orderID,"2021-05-05");
        String[] prod = products.split(", ");
        ArrayList<MenuItem> orders = new ArrayList<MenuItem>();
        for (String str : prod){
            {
                for(int counter=0;counter<menuItems.size();counter++) {
                    if (menuItems.get(counter).getName().equals(str)) {
                        orders.add(menuItems.get(counter));
                        report1.add(menuItems.get(counter));
                    }
                }
            }
        }
        map.put(o,orders);
        ordersAll.add(o);
        assert invariant();

    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void Report1() throws IOException {
        File file = new File("raport1.txt");
        FileWriter fw= new FileWriter(file,true);
        String show="";
        double price1 = 520.0;
        show=show+"Produse comandate in data de 2021-05-13\n";
        int i=0;
        List<MenuItem> list = Arrays.asList(menuItems.get(i));
        list.stream().filter(c ->  list.get(0).getPrice()>price1)
                .collect(Collectors.toList());
        for(int counter=0; counter<menuItems.size();counter++) {
            if (menuItems.get(counter).getRating() == 5 & menuItems.get(counter).getSodium() == 5)
                show = show + menuItems.get(counter).getName() + " - " + menuItems.get(counter).getPrice() + "\n";
            Stream.Builder<String> show1 = Stream.builder();
            Stream<String> stream = show1.add(menuItems.get(counter).getName())
                    .add(String.valueOf(menuItems.get(counter).getPrice()).toString())
                    .build();
        }
        System.out.println(show);
        fw.write(show);
        fw.close();

    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void Report2() throws IOException {
        File file = new File("raport2.txt");
        int i=0;
        FileWriter fw= new FileWriter(file,true);
        AtomicReference<String> show= new AtomicReference<>("");

        List<MenuItem> list = Arrays.asList(menuItems.get(i));
        list.stream().filter(c ->  list.get(0).getRating()>1)
                .collect(Collectors.toList());
        show.set(show + "Produse comandate cel putin odata\n");
        Order o = new Order(0,0,"2021-05-05");
        for(int j=0; j<ordersAll.size(); j++) {

            o = ordersAll.get(j);
            ArrayList<MenuItem> menuItems = map.get(o);
            menuItems.forEach((n) -> {
                show.set(show + n.getName() + " - " + n.getPrice() + "\n");
                Stream.Builder<String> show1 = Stream.builder();
                Stream<String> stream = show1.add(n.getName())
                        .add(String.valueOf(n.getPrice()).toString())
                        .build();

            });

        }


        show.set(show + "TOTAL PRET ");
        System.out.println(show.get());
        fw.write(show.get());
        fw.close();
    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void Report3() throws IOException {
        File file = new File("raport3.txt");
        FileWriter fw= new FileWriter(file,true);
        AtomicReference<String> show= new AtomicReference<>("");
        List<MenuItem> list = Arrays.asList();
        list.stream().filter(c ->  list.get(0).getPrice()>1)
                .collect(Collectors.toList());
        show.set(show + "Clienti care au comandat de mai mult de un numar de ori dat\n");
        Order o = new Order(0,0,"2021-05-05");
        for(int j=0; j<ordersAll.size(); j++) {

            o = ordersAll.get(j);
            ArrayList<MenuItem> menuItems = map.get(o);
            menuItems.forEach( (n) -> {
                show.set(show + n.getName() + " - " + n.getPrice() + "\n");
                Stream.Builder<String> show1 = Stream.builder();
                Stream<String> stream = show1.add(n.getName())
                        .add(String.valueOf(n.getPrice()).toString())
                        .build();


            });



        }




        System.out.println(show.get());
        fw.write(show.get());
        fw.close();

    }

    /**
     *
     * @throws IOException
     */
    @Override
    public void Report4() throws IOException {
        File file = new File("raport4.txt");
        FileWriter fw= new FileWriter(file,true);
        AtomicReference<String> show= new AtomicReference<>("");
        show.set(show + "Produse comandate intr-un interval anume \n");
        Order o = new Order(0,0,"2021-05-05");
        Date date = new Date();
        Date date1 = new Date();

        for(int j=0; j<ordersAll.size(); j++) {

            if(date1.after(date)) {
                o = ordersAll.get(j);
                ArrayList<MenuItem> menuItems = map.get(o);
                menuItems.forEach((n) -> {
                    show.set(show + n.getName() + " - " + n.getPrice() + "\n");
                    Stream.Builder<String> show1 = Stream.builder();
                    Stream<String> stream = show1.add(n.getName())
                            .add(String.valueOf(n.getPrice()).toString())
                            .build();

                });
            }
            List<MenuItem> list = Arrays.asList();
            list.stream().filter(c ->  list.get(0).getPrice()>1)
                    .collect(Collectors.toList());
        }


        System.out.println(show.get());
        fw.write(show.get());
        fw.close();

    }

    /**
     *
     * @param start
     */

    public void setChef(String start) {
        setChanged();
        notifyObservers(start);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean invariant() {
       if(menuItems.size()>0)
           return true;
       return false;
    }

    /**
     *
     * @param o
     * @throws FileNotFoundException
     */
    public void serialization(Object o) throws FileNotFoundException {

        try {
            FileOutputStream fileOut = new FileOutputStream("products1.csv", true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);

            out.close();
            fileOut.close();
        }catch(IOException i) {
            i.printStackTrace();
        }
    }
}
