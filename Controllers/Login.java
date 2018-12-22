package Controllers;

import Entities.Account;
import bmsgui.ClientPage;

import javax.swing.*;
import java.io.*;

public class Login {

    private String path;

    public Login(String username, String password,JFrame frame) {
        path = username+".txt";
        File file = new File(path);
        FileInputStream FIS;
        ObjectInputStream OIS;
        if (file.exists()){
            try {
                FIS = new FileInputStream(file);
                OIS = new ObjectInputStream(FIS);
                Account account = (Account)OIS.readObject();
                if (account.getClient().getUsername().equals(username) && account.getClient().getPassword().equals(password)){
                      ClientPage clientPage = new ClientPage(account);
                      clientPage.setVisible(true);
                      FIS.close();
                      OIS.close();
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Please check that the Login.txt"
                            + "file isn't in use or deleted");
                    return;
                }
            }
            catch(IOException e2) {
                JOptionPane.showMessageDialog(frame, "Please check that the Login.txt"
                        + "file isn't in use or deleted");
            }
            catch (Exception  e){}
        }
        else{
            JOptionPane.showMessageDialog(frame, "User Name or Password are incorrect");
            return;
        }
    }
}
