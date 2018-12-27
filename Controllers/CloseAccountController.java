package Controllers;

import Entities.Account;
import Entities.Client;
import Entities.Transaction;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class CloseAccountController {
    JButton btnCloseAccount;
    JDialog dg;
    Client client;
    Account account;
    public CloseAccountController(JDialog dg, JButton btnCloseAccount, Account account) {

        this.btnCloseAccount = btnCloseAccount;
        this.dg = dg;
        this.client = account .getClient();
        this.account = account;

        btnCloseAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (account.getBalance() > 0){
                        JOptionPane.showMessageDialog(dg,"Please Withdraw all your money first");
                        return;
                    }
                    String input = JOptionPane.showInputDialog(dg, "Are You Sure you want to Close your account \n Type Your password");
                    if (!input.equals(client.getPassword())){
                        JOptionPane.showMessageDialog(dg,"Entered Wrong password");
                        return;
                    }

                    File f1 = new File(client.getUsername() + ".txt");
                    File f2 = new File(client.getUsername() + " Transactions.txt");

                    FileOutputStream FOS = new FileOutputStream(f1);
                    ObjectOutputStream OOS = new ObjectOutputStream(FOS);

                    if (f1.exists()) {
                        OOS.write(0);
                        OOS.close();
                        FOS.close();
                    }
                    if (f2.exists()) {
                        FOS = new FileOutputStream(f2);
                        OOS = new ObjectOutputStream(FOS);
                        OOS.write(0);
                        OOS.close();
                        FOS.close();
                    }

                    JOptionPane.showMessageDialog(dg,"You have successfully deleted your account");
                    System.exit(0);
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(dg, "You didn't enter a number");
                }
                 catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
