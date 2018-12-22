package bmsgui;

import Controllers.*;
import Entities.Account;

import javax.swing.*;
import java.awt.*;

public class ClientPage extends JDialog {

    private JDialog dg = this;
    JPanel pnlTop = new JPanel();
    JPanel pnlMain = new JPanel();
    JPanel pnlBottom = new JPanel();
    JLabel lblWelcome = new JLabel("Welcome");
    JLabel lblName = new JLabel("Name: ");
    JLabel lblAge = new JLabel("Age: ");
    JLabel lblNationalNumber = new JLabel("National Number: ");
    JLabel lblAddress = new JLabel("Address: ");
    JLabel lblEmail = new JLabel("Email: ");
    JLabel lblJob = new JLabel("Job: ");
    private JButton btnDeposit = new JButton("Deposit");
    private JButton btnWithdraw = new JButton("Withdraw");
    private JButton btnInquiry = new JButton("Inquiry");
    private JButton btnMoneyTransfer = new JButton("Money Transfer");
    private JButton btnRequestLoan = new JButton("Request Loan");
    private JButton btnPayLoan = new JButton("Pay Loan");
    private JButton btnViewTransactions = new JButton("View Transactions");

    public ClientPage(Account account) {
        setTitle("My Page");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(d.width / 3, d.height / 4, d.width / 2, d.height / 2);

        Container c = getContentPane();

        pnlMain.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        pnlTop.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        pnlBottom.setPreferredSize(new Dimension(100, 80));
        Dimension d1 = new Dimension(300, 30);
        Dimension d2 = new Dimension(150, 30);

        lblWelcome.setText("Welcome " + account.getClient().getUsername());
        lblName.setText("Name: " + account.getClient().getName());
        lblAge.setText("Age: " + account.getClient().getAge());
        lblNationalNumber.setText("National Number: " + account.getClient().getNationalNumber());
        lblAddress.setText("Address: " + account.getClient().getAddress());
        lblEmail.setText("Email: " + account.getClient().getEmail());
        lblJob.setText("Job: " + account.getClient().getJob());
        lblName.setPreferredSize(d1);
        lblAge.setPreferredSize(d1);
        lblNationalNumber.setPreferredSize(d1);
        lblAddress.setPreferredSize(d1);
        lblEmail.setPreferredSize(d1);
        lblJob.setPreferredSize(d1);
        btnDeposit.setPreferredSize(d2);
        btnWithdraw.setPreferredSize(d2);
        btnInquiry.setPreferredSize(d2);
        btnMoneyTransfer.setPreferredSize(d2);
        btnRequestLoan.setPreferredSize(d2);
        btnPayLoan.setPreferredSize(d2);
        btnViewTransactions.setPreferredSize(d2);
        pnlTop.add(lblWelcome);
        pnlMain.add(lblName);
        pnlMain.add(lblAge);
        pnlMain.add(lblNationalNumber);
        pnlMain.add(lblAddress);
        pnlMain.add(lblEmail);
        pnlMain.add(lblJob);
        pnlBottom.add(btnDeposit);
        pnlBottom.add(btnWithdraw);
        pnlBottom.add(btnInquiry);
        pnlBottom.add(btnMoneyTransfer);
        pnlBottom.add(btnRequestLoan);
        pnlBottom.add(btnPayLoan);
        pnlBottom.add(btnViewTransactions);
        c.add(pnlTop, BorderLayout.NORTH);
        c.add(pnlMain);
        c.add(pnlBottom, BorderLayout.SOUTH);

        DepositController DC = new DepositController(dg, btnDeposit, account);
        WithdrawController WC = new WithdrawController(dg, btnWithdraw, account);
        InquiryController IC = new InquiryController(dg,btnInquiry, account);
        ViewTransactionsController VTC = new ViewTransactionsController(dg,btnViewTransactions, account);
        RequestLoanController RLC = new RequestLoanController(dg,btnRequestLoan, account);
        PayLoanController PLC = new PayLoanController(dg,btnPayLoan, account);
        TransferMoneyController TMC = new TransferMoneyController(dg,btnMoneyTransfer,account);
    }
}
