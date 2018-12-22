package Controllers;

import Entities.Account;
import Entities.Client;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InquiryController {
    JButton btnInquiry;
    JDialog dg;
    Client client;
    Account account;

    public InquiryController(JDialog dg, JButton btnInquiry, Account account) {

        this.btnInquiry = btnInquiry;
        this.dg = dg;
        this.client = account .getClient();
        this.account = account;

        btnInquiry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String s = "";
                if (account.isOnLoan()){
                    s += "You loan is : "+account.getLoan()+"\n";
                }
                s+="your Balance is: "+account.getBalance();
                JOptionPane.showMessageDialog(dg,s);
            }
        });
    }
}
