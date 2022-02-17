package Presentation;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;


import java.util.ArrayList;

public class Administrator {


    private JFrame frameL;

    private JPanel panel;

    private JLabel label;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JLabel label_4;
    private JLabel label_5;
    private JLabel label_6;
    private JLabel label_7;
    private JLabel label_8;
    private JLabel label_9;
    private DefaultTableModel model;

    private JPasswordField passwordField;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;

    private JTable table;

    private JButton buttonLog;
    private JButton buttonDel;
    private JButton buttonAdd;
    private JButton buttonMod;
    private JButton raport1;
    private JButton raport2;
    private JButton raport3;
    private JButton raport4;
   public ArrayList<MenuItem> menuItems;
   public DeliveryService deliveryService;


    /**
     *
     * @param menuItems
     */
    public Administrator(ArrayList<MenuItem> menuItems) {
        initialize();
        this.menuItems=menuItems;
        this.deliveryService= new DeliveryService();
        deliveryService.setMenuItems(menuItems);
    }


    private void labels() {
        // labels
        label = new JLabel();
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(129, 45, 185, 60);
        panel.add(label);

        label_1 = new JLabel("Nume Produs:");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_1.setBounds(109, 141, 86, 38);
        panel.add(label_1);

        label_2 = new JLabel("Tip:");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_2.setBounds(109, 190, 86, 36);
        panel.add(label_2);

        label_3 = new JLabel("Pret:");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_3.setBounds(109, 239, 86, 36);
        panel.add(label_3);

        label_4 = new JLabel("Calorii:");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_4.setBounds(109, 288, 86, 36);
        panel.add(label_4);

        label_5 = new JLabel("Proteine:");
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_5.setBounds(109, 337, 86, 36);
        panel.add(label_5);

        label_6 = new JLabel("Grasime:");
        label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_6.setBounds(109, 386, 86, 36);
        panel.add(label_6);

        label_7 = new JLabel("Sodium:");
        label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_7.setBounds(109, 435, 86, 36);
        panel.add(label_7);

        label_8 = new JLabel("Rating:");
        label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_8.setBounds(109, 484, 86, 36);
        panel.add(label_8);

        label_9 = new JLabel("Produse:");
        label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_9.setBounds(109, 533, 86, 36);
        panel.add(label_9);





    }
    private void tabel() {

        String[] coloane = { "Id", "Name" };


        table = new JTable(0,0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setBounds(400, 100, 445, 412);
        JScrollPane js = new JScrollPane(table);
        js.setBounds(600, 150, 600, 405);
        panel.add(js);

    }

    private void textFields() {
        // text/pass fields
        textField = new JTextField("");
        textField.setBounds(228, 149, 86, 29);
        textField.setColumns(10);
        panel.add(textField);


        textField_1 = new JTextField("");
        textField_1.setBounds(228, 196, 86, 29);
        textField_1.setColumns(10);
        panel.add(textField_1);

        textField_2 = new JTextField("");
        textField_2.setBounds(228, 243, 86, 29);
        textField_2.setColumns(10);
        panel.add(textField_2);

        textField_3 = new JTextField("");
        textField_3.setBounds(228, 290, 86, 29);
        textField_3.setColumns(10);
        panel.add(textField_3);

        textField_4 = new JTextField("");
        textField_4.setBounds(228, 337, 86, 29);
        textField_4.setColumns(10);
        panel.add(textField_4);

        textField_5 = new JTextField("");
        textField_5.setBounds(228, 384, 86, 29);
        textField_5.setColumns(10);
        panel.add(textField_5);

        textField_6 = new JTextField("");
        textField_6.setBounds(228, 431, 86, 29);
        textField_6.setColumns(10);
        panel.add(textField_6);

        textField_7 = new JTextField("");
        textField_7.setBounds(228, 478, 86, 29);
        textField_7.setColumns(10);
        panel.add(textField_7);

        textField_8 = new JTextField("");
        textField_8.setBounds(228, 525, 86, 29);
        textField_8.setColumns(10);
        panel.add(textField_8);

        textField_9 = new JTextField("");
        textField_9.setBounds(228, 570, 86, 29);
        textField_9.setColumns(10);
        panel.add(textField_9);
    }

    private void buttons() {
        // buttons



        buttonLog = new JButton("Vezi produse");
        buttonLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

             // create jtable for all of them
            // deliveryService.viewAll();

                model = new DefaultTableModel();

                model.addColumn("Name");
                model.addColumn("Rating");
                model.addColumn("Price");
                model.addColumn("Calories");
                model.addColumn("Protein");
                model.addColumn("Fat");
                model.addColumn("Sodium");


                for(int i=0; i<deliveryService.getMenuItems().size(); i++) {
                    String a = deliveryService.getMenuItems().get(i).getName();
                    Double b = deliveryService.getMenuItems().get(i).getPrice();
                  Double c = deliveryService.getMenuItems().get(i).getRating();
                  int d = deliveryService.getMenuItems().get(i).getCalories();
                   int o = deliveryService.getMenuItems().get(i).getProtein();
                  int h = deliveryService.getMenuItems().get(i).getFat();
                  int f = deliveryService.getMenuItems().get(i).getSodium();

                    model.addRow(new Object[]{a,b,c,d,o,h,f});
                }
                 table.setModel(model);

                table.setPreferredScrollableViewportSize(new Dimension(450,63));
                table.setFillsViewportHeight(true);

//                JScrollPane js=new JScrollPane(table);
//                js.setVisible(true);
//                panel.add(js);

            };
        });

        buttonLog.setBounds(385, 420, 140, 23);
        panel.add(buttonLog);
        buttonMod = new JButton("Modifica produs");
        buttonMod.setBounds(385, 445, 140, 23);
        panel.add(buttonMod);

        buttonAdd= new JButton("Adauga produs");
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    deliveryService.addProduct(textField.getText(),textField_1.getText(),Double.parseDouble(textField_2.getText()),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText()),Integer.parseInt(textField_5.getText()),Integer.parseInt(textField_6.getText()),Integer.parseInt(textField_7.getText()),textField_8.getText());
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            };
        });
        buttonAdd.setBounds(385, 390, 140, 23);
        panel.add(buttonAdd);
        buttonDel= new JButton("Sterge produs");
        buttonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                deliveryService.deleteItem(textField.getText(),textField_1.getText());
            };
        });

        buttonDel.setBounds(385, 365, 140, 23);
        panel.add(buttonDel);

        raport1= new JButton("Raport1");
        raport1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    deliveryService.Report1();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            };
        });

        raport1.setBounds(385, 470, 140, 23);
        panel.add(raport1);


        raport2= new JButton("Raport2");
        raport2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    deliveryService.Report2();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            };
        });

        raport3= new JButton("Raport3");
        raport3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    deliveryService.Report3();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            };
        });

        raport4= new JButton("Raport4");
        raport4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    deliveryService.Report1();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            };
        });

        raport2.setBounds(385, 500, 140, 23);
        panel.add(raport2);
        raport3.setBounds(385, 530, 140, 23);
        panel.add(raport3);
        raport4.setBounds(385, 560, 140, 23);
        panel.add(raport4);

    }
    private void initialize() {
        frameL = new JFrame();
        frameL.setSize(2000, 1000);
        frameL.setBounds(300, 300, 1400, 700);


//panel
        panel = new JPanel();
        frameL.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labels();
        textFields();
        buttons();
        tabel();

        frameL.setVisible(true);
    }

    public String getText()
    {
        return textField.getText();
    }

    public String getText1()
    {
        return textField_1.getText();
    }

    public String getText2()
    {
        return textField_2.getText();
    }

    public String getText3()
    {
        return textField_3.getText();
    }

    public String getText4()
    {
        return textField_4.getText();
    }

    public String getText5()
    {
        return textField_5.getText();
    }

    public String getText6()
    {
        return textField_6.getText();
    }

    public String getText7()
    {
        return textField_7.getText();
    }

    public String getText_8()
    {
        return textField_8.getText();
    }





}
