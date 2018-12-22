package Controllers;

import Entities.Account;
import Entities.Client;
import Entities.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class TransferMoneyController  {
    JButton btnMoneyTransfer;
    JDialog dg;
    Client client;
    Account account;

    public TransferMoneyController(JDialog dg, JButton btnMoneyTransfer, Account account) {

        this.btnMoneyTransfer = btnMoneyTransfer;
        this.dg = dg;
        this.client = account .getClient();
        this.account = account;

        btnMoneyTransfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    String inputUsername = JOptionPane.showInputDialog(dg, "Enter the "
                            + "username of the other account to transfer the money ");
                    if (inputUsername == null){
                        JOptionPane.showMessageDialog(dg,"You did't enter a name");
                        return;
                    }

                    File f1 = new File(client.getUsername() + ".txt");
                    File f2 = new File(client.getUsername() + " Transactions.txt");
                    File f3 = new File(inputUsername + ".txt");
                    File f4 = new File(inputUsername + " Transactions.txt");

                    if (!f3.exists()){
                        JOptionPane.showMessageDialog(dg,"Error account doesn't exists");
                        return;
                    }
                    String inputAmount = JOptionPane.showInputDialog(dg, "Enter the desired amount of money");
                    if (inputAmount == null){
                        JOptionPane.showMessageDialog(dg,"You did't enter a number");
                        return;
                    }
                    int amount = Integer.parseInt(inputAmount);
                    if (amount > account.getBalance()){
                        JOptionPane.showMessageDialog(dg,"Error, Trying to transfer more than owned money");
                        return;
                    }

                    FileInputStream FIS = new FileInputStream(f3);
                    ObjectInputStream OIS = new ObjectInputStream(FIS);
                    Account account2 = (Account)OIS.readObject();
                    FIS.close();
                    OIS.close();

                    account.setBalance(account.getBalance() - amount);
                    account2.setBalance(account2.getBalance() + amount);

                    Transaction transaction = new Transaction(account.getClient().getUsername(),account2.getClient().getUsername(),amount,"MoneyTransfer",true,account.getBalance());
                    Transaction transaction2 = new Transaction(account2.getClient().getUsername(),client.getUsername(),amount,"MoneyTransfer",false,account2.getBalance());

                    //Balance editing
                    if (!f1.exists()) {
                        JOptionPane.showMessageDialog(dg, "Error Account Not Found Please reCreate the Account");
                    } else {
                        FileOutputStream FOS = new FileOutputStream(f1);
                        ObjectOutputStream OOS = new ObjectOutputStream(FOS);
                        OOS.writeObject(account);
                        FOS.close();
                        OOS.close();
                        FOS = new FileOutputStream(f3);
                        OOS = new ObjectOutputStream(FOS);
                        OOS.writeObject(account2);
                        FOS.close();
                        OOS.close();

                        /*Transaction for second account*/
                        Vector<Transaction> vector = new Vector<>();
                        if (f2.exists()) {
                            FIS = new FileInputStream(f2);
                            OIS = new ObjectInputStream(FIS);
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

                        /*Transaction for second account*/
                        vector = new Vector<>();
                        if (f4.exists()) {
                            FIS = new FileInputStream(f4);
                            OIS = new ObjectInputStream(FIS);
                            vector = (Vector<Transaction>) OIS.readObject();
                            FIS.close();
                            OIS.close();
                        }
                        else
                            f4.createNewFile();
                        FOS = new FileOutputStream(f4);
                        OOS = new ObjectOutputStream(FOS);
                        vector.add(transaction2);
                        OOS.writeObject(vector);
                        FOS.close();
                        OOS.close();
                    }
                }catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(dg, "You didn't enter a number");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
