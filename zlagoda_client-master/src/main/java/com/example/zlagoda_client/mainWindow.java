package com.example.zlagoda_client;

import com.example.zlagoda_client.Controllers.EmployeeController;
import com.example.zlagoda_client.Dtos.BaseDto;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import static com.example.zlagoda_client.ZlagodaClientApplication.lander;

public class mainWindow {
    JPanel mainPanel;
    private JButton loginButton;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JLabel loginText;
    private JLabel passwordText;

    mainWindow() {
        initListeners();
    }

    private void createUIComponents() {
    }

    private void initListeners() {
        mainWindow THIS = this;

        ActionListener ButtonPressed = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if(passwordRight()) {

                    lander.dispose();

                    ZlagodaClientApplication.menu = new JFrame();

                    ZlagodaClientApplication.menu.setSize(800, 600);
                    ZlagodaClientApplication.menu.setLocationRelativeTo(null);
                    ZlagodaClientApplication.menu.setContentPane(new mainMenuScreen().mainScreen);
                    ZlagodaClientApplication.menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ZlagodaClientApplication.menu.setVisible(true);

                }

            }
        };

        loginButton.addActionListener(ButtonPressed);
    }

    boolean passwordRight(){
        String login = loginField.getText();
        String password = passwordField.getPassword().toString();

        BaseDto baseDto = new BaseDto();
        baseDto.setLogin(login);
        baseDto.setPassword(password);

        return new EmployeeController().login(baseDto);
    }

}