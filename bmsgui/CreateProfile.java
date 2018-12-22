package bmsgui;

import Controllers.RegisterClient;
import Entities.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfile extends JDialog {

    JDialog dg = this;
    JPanel pnlMain = new JPanel();
    JPanel pnlBottom = new JPanel();
    JLabel lblUsername = new JLabel("Username:");
    JLabel lblPassword = new JLabel("Password:");
    JLabel lblName = new JLabel("Name:");
    JLabel lblAge = new JLabel("Age:");
    JLabel lblNationalNumber = new JLabel("National Number:");
    JLabel lblAddress = new JLabel("Address:");
    JLabel lblEmail = new JLabel("Email:");
    JLabel lblJob = new JLabel("Job:");
    JTextField txtUsername = new JTextField();
    JTextField txtPassword = new JTextField();
    JTextField txtName = new JTextField();
    JTextField txtAge = new JTextField();
    JTextField txtNationalNumber = new JTextField();
    JTextField txtAddress = new JTextField();
    JTextField txtEmail = new JTextField();
    JTextField txtJob = new JTextField();
    JButton btnCreate = new JButton("Create");

    public CreateProfile() {
        setTitle("Create New Profile");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width / 3, d.height / 4, d.width / 2, d.height / 2);

        Container c = getContentPane();

        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        Dimension d1 = new Dimension(300, 30);
        Dimension d2 = new Dimension(150, 30);

        lblUsername.setPreferredSize(d1);
        lblPassword.setPreferredSize(d1);
        lblName.setPreferredSize(d1);
        lblAge.setPreferredSize(d1);
        lblNationalNumber.setPreferredSize(d1);
        lblAddress.setPreferredSize(d1);
        lblEmail.setPreferredSize(d1);
        lblJob.setPreferredSize(d1);
        txtUsername.setPreferredSize(d1);
        txtPassword.setPreferredSize(d1);
        txtName.setPreferredSize(d1);
        txtAge.setPreferredSize(d1);
        txtNationalNumber.setPreferredSize(d1);
        txtAddress.setPreferredSize(d1);
        txtEmail.setPreferredSize(d1);
        txtJob.setPreferredSize(d1);
        btnCreate.setPreferredSize(d2);

        pnlMain.add(lblUsername);
        pnlMain.add(txtUsername);
        pnlMain.add(lblPassword);
        pnlMain.add(txtPassword);
        pnlMain.add(lblName);
        pnlMain.add(txtName);
        pnlMain.add(lblAge);
        pnlMain.add(txtAge);
        pnlMain.add(lblNationalNumber);
        pnlMain.add(txtNationalNumber);
        pnlMain.add(lblAddress);
        pnlMain.add(txtAddress);
        pnlMain.add(lblEmail);
        pnlMain.add(txtEmail);
        pnlMain.add(lblJob);
        pnlMain.add(txtJob);
        pnlBottom.add(btnCreate);
        c.add(pnlMain);
        c.add(pnlBottom, BorderLayout.SOUTH);

        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                String name = txtName.getText();
                String nationalNumber = txtNationalNumber.getText();
                String address = txtAddress.getText();
                String email = txtEmail.getText();
                String job = txtJob.getText();
                int age = Integer.parseInt(txtAge.getText());

                Client client = new Client(username, name, password, email, address, job, nationalNumber, age);
                RegisterClient registerClient = new RegisterClient(client,dg);
            }
        });
    }
}
