package Controllers;

import Entities.Account;
import Entities.Client;
import Entities.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class DepositController {
    JButton btnDeposit;
    JDialog dg;
    Client client;
    Account account;

    public DepositController(JDialog dg, JButton btnDeposit, Account account) {

        this.btnDeposit = btnDeposit;
        this.dg = dg;
        this.client = account .getClient();
        this.account = account;



        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String input = JOptionPane.showInputDialog(dg, "Enter the desired amount"
                            + " of money to put");
                    int amount = Integer.parseInt(input);
                    if (amount < 0){
                        JOptionPane.showMessageDialog(dg, "Error depositing negative money");
                        return;
                    }

                    account.setBalance(account.getBalance() + amount);
                    Transaction transaction = new Transaction(account.getClient().getUsername(),amount,"Deposit",account.getBalance());

                    File f1 = new File(client.getUsername() + ".txt");
                    File f2 = new File(client.getUsername() + " Transactions.txt");

                    //Balance editing
                    if (!f1.exists()) {
                        JOptionPane.showMessageDialog(dg, "Error Account Not Found Please reCreate the Account");
                    } else {
                        FileOutputStream FOS = new FileOutputStream(f1);
                        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
                        OOS.writeObject(account);
                        FOS.close();
                        OOS.close();

                        Vector<Transaction> vector = new Vector<>();
                        if (f2.exists()) {
                            FileInputStream FIS = new FileInputStream(f2);
                            ObjectInputStream OIS = new ObjectInputStream(FIS);
                            vector = (Vector<Transaction>) OIS.readObject();
                            FIS.close();
                            OIS.close();
                        }
                        else
                            f2.createNewFile();
                        FOS = new FileOutputStream(f2);
                        OOS = new ObjectOutputStream(FOS);
                        vector.add(transaction);
                        OOS.writeObject(vector);
                        FOS.close();
                        OOS.close();
                    }
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
