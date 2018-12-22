package bmsgui;

import Controllers.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Home extends JFrame {

    JFrame frame = this;
    JPanel pnlTop = new JPanel();
    JPanel pnlMain = new JPanel();
    JPanel pnlBottom = new JPanel();
    JLabel lblWelcome = new JLabel("Welcome to the AOS bank!");
    JLabel lblUsername = new JLabel("Username:");
    JLabel lblPassword = new JLabel("Password:");
    JLabel lblCreateProfile = new JLabel("Don't have a profile? Sign up ..");
    JTextField txtUsername = new JTextField();
    JTextField txtPassword = new JTextField();
    JButton btnLogin = new JButton("Login");
    JButton btnCreateProfile = new JButton("Create Profile");

    public Home() {
        setTitle("AOS Bank");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);

        Container c = getContentPane();

        pnlMain.setPreferredSize(new Dimension(d.width / 2, d.height / 4));
        pnlTop.setPreferredSize(new Dimension(d.width / 2, d.height / 8));
        pnlBottom.setPreferredSize(new Dimension(d.width / 2, d.height / 8));

        pnlTop.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlTop.add(lblWelcome);

        Dimension d1 = new Dimension(300, 30);
        Dimension d2 = new Dimension(300, 50);
        Dimension d3 = new Dimension(150, 30);

        lblUsername.setPreferredSize(d1);
        lblPassword.setPreferredSize(d1);
        txtUsername.setPreferredSize(d1);
        txtPassword.setPreferredSize(d1);
        btnLogin.setPreferredSize(d3);
        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        JLabel dummy = new JLabel();
        dummy.setPreferredSize(new Dimension(d.width, 0));
        pnlMain.add(dummy);
        pnlMain.add(btnLogin);

        lblCreateProfile.setPreferredSize(d1);
        btnCreateProfile.setPreferredSize(d3);
        pnlBottom.add(lblCreateProfile);
        pnlBottom.add(btnCreateProfile);

        c.add(pnlTop, BorderLayout.NORTH);
        c.add(pnlBottom, BorderLayout.SOUTH);
        c.add(pnlMain, BorderLayout.CENTER);

        //TODO
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                Login login = new Login(username,password,frame);
                txtUsername.setText("");
                txtPassword.setText("");
            }
        });
        //TODO
        btnCreateProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateProfile cp = new CreateProfile();
                cp.setVisible(true);
            }
        });
    }
}
