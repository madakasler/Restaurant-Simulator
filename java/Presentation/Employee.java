package Presentation;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Employee implements Observer {


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

    private JTable table;

    private JButton buttonLog;
    private JButton buttonDel;
    private JButton buttonAdd;
    private JButton buttonMod;
    public ArrayList<MenuItem> menuItems;
    public DeliveryService deliveryService;
    private String note;


    /**
     *
     * @param note
     * @throws InterruptedException
     */

    public Employee(String note) throws InterruptedException {
        initialize(note);
        this.menuItems=menuItems;
        this.deliveryService= new DeliveryService();
        deliveryService.setMenuItems(menuItems);
    }

    /**
     *
     * @param s
     */

    private void labels(String s) {
        // labels
        label = new JLabel();
        label.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(129, 45, 185, 60);
        panel.add(label);



        label_2 = new JLabel(s);
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_2.setBounds(89, 190, 220, 36);
        panel.add(label_2);
//
//        label_3 = new JLabel("Pret:");
//        label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        label_3.setBounds(109, 239, 86, 36);
//        panel.add(label_3);
//
//        label_4 = new JLabel("Calorii:");
//        label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        label_4.setBounds(109, 288, 86, 36);
//        panel.add(label_4);
//
//        label_5 = new JLabel("Proteine:");
//        label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        label_5.setBounds(109, 337, 86, 36);
//        panel.add(label_5);
//
//        label_6 = new JLabel("Grasime:");
//        label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        label_6.setBounds(109, 386, 86, 36);
//        panel.add(label_6);
//
//        label_7 = new JLabel("Sodium:");
//        label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        label_7.setBounds(109, 435, 86, 36);
//        panel.add(label_7);
//
//        label_8 = new JLabel("Rating:");
//        label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        label_8.setBounds(109, 484, 86, 36);
//        panel.add(label_8);
//
//        label_9 = new JLabel("Produse:");
//        label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        label_9.setBounds(109, 533, 86, 36);
//        panel.add(label_9);





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





//        textField_2 = new JTextField("");
//        textField_2.setBounds(228, 243, 86, 29);
//        textField_2.setColumns(10);
//        panel.add(textField_2);
//
//        textField_3 = new JTextField("");
//        textField_3.setBounds(228, 290, 86, 29);
//        textField_3.setColumns(10);
//        panel.add(textField_3);
//
//        textField_4 = new JTextField("");
//        textField_4.setBounds(228, 337, 86, 29);
//        textField_4.setColumns(10);
//        panel.add(textField_4);
//
//        textField_5 = new JTextField("");
//        textField_5.setBounds(228, 384, 86, 29);
//        textField_5.setColumns(10);
//        panel.add(textField_5);
//
//        textField_6 = new JTextField("");
//        textField_6.setBounds(228, 431, 86, 29);
//        textField_6.setColumns(10);
//        panel.add(textField_6);
//
//        textField_7 = new JTextField("");
//        textField_7.setBounds(228, 478, 86, 29);
//        textField_7.setColumns(10);
//        panel.add(textField_7);
//
//        textField_8 = new JTextField("");
//        textField_8.setBounds(228, 525, 86, 29);
//        textField_8.setColumns(10);
//        panel.add(textField_8);
    }

    private void buttons() {
        // buttons






        buttonDel= new JButton("Done");
        buttonDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(panel,"Bonul a fost emis");
            };
        });

        buttonDel.setBounds(250, 285, 140, 23);
        panel.add(buttonDel);

    }
    private void initialize(String note) throws InterruptedException {
        frameL = new JFrame();
        frameL.setSize(2000, 1000);
        frameL.setBounds(300, 300, 500, 500);


//panel
        panel = new JPanel();
        frameL.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labels(note);


        textFields();
        buttons();


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




    @Override
    public void update(Observable o, Object arg) {
        this.setNote((String) arg);
    }
    public void setNote(String s) {
        this.label_2.setText(s);
    }
}
