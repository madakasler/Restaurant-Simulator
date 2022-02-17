package Presentation;

import BusinessLayer.MenuItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LoginPage {


    private JFrame frameL;

    private JPanel panel;

    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;

    private JPasswordField passwordField;
    private JTextField textField;
    private JTextField textField_1;

    private JButton buttonLog;
    private JButton buttonBack;
   public   ArrayList<MenuItem> baseProducts= new ArrayList<MenuItem>();


    public LoginPage() throws IOException {
        initialize();
        reader();
    }


    private void labels() {
        // labels
        label = new JLabel();
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(129, 45, 185, 60);
        panel.add(label);

        label_1 = new JLabel("Nume:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_1.setBounds(109, 141, 86, 38);
        panel.add(label_1);

        label_2 = new JLabel("Parola:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_2.setBounds(109, 190, 86, 36);
        panel.add(label_2);



    }

    private void textFields() {
        // text/pass fields
        passwordField = new JPasswordField("");
        passwordField.setBounds(228, 196, 86, 27);
        panel.add(passwordField);



        textField_1 = new JTextField("");
        textField_1.setBounds(228, 149, 86, 29);
        textField_1.setColumns(10);
        panel.add(textField_1);
    }

    /**
     *
     * @throws IOException
     */
   public void reader() throws IOException {
       String line = "";
       String splitBy = ",";
       HashSet<String> lines = new HashSet<>();

       int i=0;
       try

       {
//parsing a CSV file into BufferedReader class constructor
           BufferedReader br = new BufferedReader(new FileReader("C:\\UTCN\\AN2_SEM2\\TP\\assignment4\\products.csv"));

           while ((line = br.readLine()) != null)   //returns a Boolean value
           {
               String[] product = line.split(splitBy);
               if (lines.add(product[0]) && i!=0) {
                   Stream.Builder<String> builder = Stream.builder();

                   Stream<String> stream = builder.add(product[0])
                           .add(String.valueOf(Integer.parseInt(product[6])))
                           .add(String.valueOf(Double.parseDouble(product[1])))
                           .add(String.valueOf(Integer.parseInt(product[2])))
                           .add(String.valueOf(Integer.parseInt(product[3]))).add(String.valueOf(Integer.parseInt(product[4])))
                           .add(String.valueOf(Integer.parseInt(product[5])))
                           .build();


                   MenuItem baseProduct = new MenuItem(product[0],Integer.parseInt(product[6]),Double.parseDouble(product[1]),Integer.parseInt(product[2]),Integer.parseInt(product[3]),Integer.parseInt(product[4]),Integer.parseInt(product[5]));
                   baseProducts.add(baseProduct);



                   List<MenuItem> list = Arrays.asList(baseProduct);
                   list.stream().filter(c ->  list.get(0).getName()!=null)
                           .collect(Collectors.toList());
               }
               i++;
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
      File f = new File("products1.csv");
       FileOutputStream fos = new FileOutputStream(f);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       oos.writeObject(baseProducts);
    oos.close();

   }
    private void buttons() {
        // buttons



        buttonLog = new JButton("Login");
        buttonLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                String nume = textField_1.getText();
                String parola = new String(passwordField.getPassword());

                if (nume.equals("") ||  parola.equals("")) {
                    JOptionPane.showMessageDialog(null, "Te rugam sa completezi toate campurile!", "title",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if(nume.equals("Administrator") && parola.equals("1234"))
                {
                    new Administrator(baseProducts);
                    System.out.println("administrator");
                }
                else if(nume.equals("Client") && parola.equals("12345"))
                {
                    new Client(baseProducts);
                    System.out.println("Client");
                }
                else if(nume.equals("Employee") && parola.equals("00000"))
                {
                    ////new AdministratorWindow
                    System.out.println("Employee");
                }
             else
            {
                JOptionPane.showMessageDialog(null, "username or password is incorrect. ensure both user account and password are valid", "WARINIG!", JOptionPane.WARNING_MESSAGE);
            }


            };
              });

        buttonLog.setBounds(385, 427, 89, 23);
        panel.add(buttonLog);

    }
    private void initialize() {
        frameL = new JFrame();
        frameL.setSize(2000, 1000);
        frameL.setBounds(300, 300, 1400, 700);
        frameL.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//panel
        panel = new JPanel();
        frameL.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labels();
        textFields();
        buttons();

        frameL.setVisible(true);
    }




}
