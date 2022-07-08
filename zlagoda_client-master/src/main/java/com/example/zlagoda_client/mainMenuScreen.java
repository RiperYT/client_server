package com.example.zlagoda_client;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class mainMenuScreen {

    JPanel mainScreen = new JPanel();

    JPanel panel_1 = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel gapPanel = new JPanel();

    private JButton editButton = new JButton("edit");
    private JButton createNew = new JButton("create new");
    private JButton catButton = new JButton("category");
    private JButton proButton = new JButton("product");
    private JButton cusButton = new JButton("customer");
    private JButton empButton = new JButton("employee");
    private JButton printButton = new JButton("print");



    private JTable dbVisualiser = new JTable();

    private JScrollPane scroller = new JScrollPane(dbVisualiser);

    private String[] columnNamesCat = {"ID number", "name"};
    private String[] columnNamesPro = {"ID number", "name", "creator", "characteristics"};
    private String[] columnNamesCus = {"ID number", "surname", "name", "father's name", "phone", "city", "street", "index", "percent"};
    private String[] columnNamesEmp = {"ID number", "surname", "name", "father's name", "occupation", "salary", "start Date", "birth Date", "phone", "city", "street", "index"};


    mainMenuScreen(){

        buttonPanel.add(catButton);
        buttonPanel.add(proButton);
        buttonPanel.add(cusButton);
        buttonPanel.add(empButton);
        buttonPanel.add(printButton);

        panel_1.add(buttonPanel);
        panel_1.add(gapPanel);

        mainScreen.add(panel_1);

        mainScreen.add(editButton);
        mainScreen.add(createNew);

        scroller.add(dbVisualiser);
        mainScreen.add(scroller);
    }

    /*

    private int state = 1;

    private JButton editButton;
    private JButton createNew;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    JPanel mainScreen;
    private JTable baseTable;
    private JScrollPane scroller;

    private JTable categoryTable;   //  2
    private JTable productsTable;   //  4
    private JTable customerTable;   //  9
    private JTable employeeTable;   //  12

    private String[] columnnamesCat = {"ID number", "name"};
    private String[] columnnamesPro = {"ID number", "name", "creator", "characteristics"};
    private String[] columnnamesCus = {"ID number", "surname", "name", "father's name", "phone", "city", "street", "index", "percent"};
    private String[] columnnamesEmp = {"ID number", "surname", "name", "father's name", "occupation", "salary", "start Date", "birth Date", "phone", "city", "street", "index"};

    mainMenuScreen() {
        this.initListeners();
    }

    public void initListeners() {
        mainMenuScreen THIS = this;

        this.scroller.add(baseTable);

        ActionListener ButtonPressed = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == createNew) {
                    switch (state) {
                        case 1:
                            setActiveCat();
                        case 2:
                            setActiveProd();
                        case 3:
                            setActiveCus();
                        case 4:
                            setActiveEmp();
                    }

                }
                if (e.getSource() == editButton) {

                }
                if (e.getSource() == button1) {
                    System.out.println("1 pressed");
                    setActiveCat();
                    state = 1;
                    System.out.println("1 pressed");
                }
                if (e.getSource() == button2) {
                    System.out.println("2 pressed");
                    setActiveProd();
                    state = 2;
                    System.out.println("2 pressed");
                }
                if (e.getSource() == button3) {
                    System.out.println("3 pressed");
                    setActiveCus();
                    state = 3;
                    System.out.println("3 pressed");
                }
                if (e.getSource() == button4) {
                    System.out.println("4 pressed");
                    setActiveEmp();
                    state = 4;
                    System.out.println("4 pressed");
                }
                if (e.getSource() == button5) {

                }
            }
        };

        editButton.addActionListener(ButtonPressed);
        createNew.addActionListener(ButtonPressed);
        button1.addActionListener(ButtonPressed);
        button2.addActionListener(ButtonPressed);
        button3.addActionListener(ButtonPressed);
        button4.addActionListener(ButtonPressed);
        button5.addActionListener(ButtonPressed);
    }

    private void setActiveCat() {

        Object[][] data = {
                {1, "appliance"}
        };

        categoryTable = new JTable(data, columnnamesCat);
        state = 1;

        DefaultTableModel DTM = new DefaultTableModel(data , columnnamesCat);
        baseTable.setModel(DTM);

        baseTable.revalidate();

    }

    private void setActiveProd() {
        Object[][] data = {
                {1, "light-saber", "Luke", "big"}
        };

        productsTable = new JTable(data, columnnamesPro);
        baseTable = productsTable;
        scroller.add(baseTable);
        baseTable.repaint();
        state = 2;
    }

    private void setActiveCus() {
        Object[][] data = {
                {1, "P", "P", "O", "", "", "", "", ""}
        };

        customerTable = new JTable(data, columnnamesCus);
        baseTable = customerTable;
        baseTable.repaint();
        state = 3;
    }

    private void setActiveEmp() {
        Object[][] data = {
                {1, "P", "P", "O", "", "", "", "", "", "", "", ""}
        };

        employeeTable = new JTable(data, columnnamesEmp);
        baseTable = employeeTable;
        baseTable.repaint();
        state = 4;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    */



}
