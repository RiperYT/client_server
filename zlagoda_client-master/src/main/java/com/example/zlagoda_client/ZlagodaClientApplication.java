package com.example.zlagoda_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class ZlagodaClientApplication{

    public static JFrame lander;
    public static JFrame menu;
    public static JFrame adderCat;
    public static JFrame adderPro;
    public static JFrame adderCus;
    public static JFrame adderEmp;
    public static JFrame checker;

    public static void main(String[] args) {

        SpringApplication.run(ZlagodaClientApplication.class, args);


        System.setProperty("java.awt.headless", "false");

        lander = new JFrame();

        lander.setSize(800,600);
        lander.setLocationRelativeTo(null);
        lander.setContentPane(new mainWindow().mainPanel);
        lander.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lander.setVisible(true);

    }

}