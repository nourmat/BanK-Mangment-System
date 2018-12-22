import Entities.Transaction;
import bmsgui.Home;
import jdk.nashorn.internal.ir.CatchNode;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        Home home = new Home();
        home.setVisible(true);

//        try {
//            FileInputStream FIS = new FileInputStream("nour Transactions.txt");
//            ObjectInputStream OIS = new ObjectInputStream(FIS);
//            Vector <Transaction> v = (Vector<Transaction>) OIS.readObject();
//            for (Transaction t : v){
//                System.out.println(t.getAmount());
//            }
//        } catch (Exception e){}

    }
}
