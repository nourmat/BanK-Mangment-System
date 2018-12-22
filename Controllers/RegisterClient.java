package Controllers;

import Entities.Account;
import Entities.Client;
import javax.swing.*;
import java.io.*;

public class RegisterClient {
    public static int ID = 0;
    private String path;

    public RegisterClient(Client client, JDialog dialog){
        try {
            path = client.getUsername()+".txt";
            File file = new File(path);
            FileOutputStream FOS;
            ObjectOutputStream OOS;

            if (!file.exists()){
                file.createNewFile();
                client.setID(ID);
                Account account = new Account(client);
                FOS = new FileOutputStream(file);
                OOS = new ObjectOutputStream(FOS);
                OOS.writeObject(account);
                FOS.close();
                OOS.close();
                ID++;
            }
            else{
                JOptionPane.showMessageDialog(dialog, "Username already reserved. Please"
                            + " make another username.");
                return;
            }
            JOptionPane.showMessageDialog(dialog, "Done. Account created");
        }catch (IOException e1){
            JOptionPane.showMessageDialog(dialog, "IOException encountered. Please check"
                    + "the Login.txt file if in use or deleted.");
        }catch (Exception e2){
            JOptionPane.showMessageDialog(dialog, "Please check that you filled all the"
                    + "fields with the right data types.");
        }
    }
}
