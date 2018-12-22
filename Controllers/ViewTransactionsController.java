package Controllers;

import Entities.Account;
import Entities.Client;
import Entities.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class ViewTransactionsController {
    JButton btnViewTransactions;
    JDialog dg;
    Client client;
    Account account;

    public ViewTransactionsController(JDialog dg, JButton btnViewTransactions, Account account) {

        this.btnViewTransactions = btnViewTransactions;
        this.dg = dg;
        this.client = account .getClient();
        this.account = account;

        btnViewTransactions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try{
                    File file = new File(client.getUsername() + " Transactions.txt");
                    if (!file.exists()){
                        JOptionPane.showMessageDialog(dg,"No Transactions done yet");
                    }
                    FileInputStream FIS = new FileInputStream(file);
                    ObjectInputStream OIS = new ObjectInputStream(FIS);
                    Vector<Transaction> transactions = (Vector<Transaction>)OIS.readObject();
                    String s = "";

                    for (Transaction t: transactions) {
                        s += t.getType() + "\n";
                        if (t.getType().equals("MoneyTransfer")){
                            if (t.isTo())
                                s += "To: "+t.getTransferToUserName()+"\n";
                            else
                                s+="From: "+t.getTransferToUserName()+"\n";
                        }
                        s+= "Amount " + t.getAmount()+"\n";
                        s+="newBalance at that time :" + t.getBalanceAtThatTime() + "\n";
                        s+="---------------------------------------\n";
                    }
                    JOptionPane.showMessageDialog(dg,s);
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(dg, "You didn't enter a number");
                }
                catch (IOException e2) {
                    JOptionPane.showMessageDialog(dg, "IO exception occurred");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
