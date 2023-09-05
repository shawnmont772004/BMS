package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;

public class Deposit extends JFrame implements ActionListener {
    String PIN;
    JFrame f=new JFrame();
    JLabel l1;
    JButton b1,b2;
    JTextField tx1;
    Deposit(String pin)
    {
        this.PIN=pin;

        f.setLayout(null);
        f.setBounds(270,20,800,800);
        f.setSize(800,600);
        f.getContentPane().setBackground(Color.BLACK);
        f.setTitle("Deposit");

        l1=new JLabel("Enter the Amount to be Deposited:");
        l1.setBounds(170,60,400,25);
        l1.setFont(new Font("Arial",Font.PLAIN,25));
        l1.setForeground(Color.WHITE);
        f.add(l1);

        tx1=new JTextField(10);
        setPlaceholder(tx1, " Enter amount here...");
        tx1.setFont(new Font("Raleway",Font.PLAIN,20));
        tx1.setBounds(320,130,200,30);
        tx1.setBackground(Color.WHITE);
        tx1.setForeground(Color.BLACK);
        f.add(tx1);

        b1=new JButton("Submit");
        b1.setBounds(230,230,100,30);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("Back");
        b2.setBounds(230,285,100,30);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("Arial",Font.BOLD,20));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        f.add(b2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image i2=i1.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(150,100,500,500);
        f.add(i4);


        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {


            if(tx1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter the deposit amount:");
            }
            else{
                try{

                    Date date_trans=new Date();
                    String tx2=tx1.getText();
                    Integer tx3=Integer.parseInt(tx2);
                    Integer deposit_amt=tx3;

                    String type="Deposit";

                    Conn c5=new Conn();

                    String checkPINQuery = "SELECT * FROM ACCOUNT WHERE PIN = '" + PIN + "'";
                    ResultSet r = c5.statement1.executeQuery(checkPINQuery);
                    boolean ifpinexists=r.next();

                    if(ifpinexists)//next means if there is any row returned. NULL cannot be used as resultset is not null &contains a query
                    {//first check and then retrieve

                        int conv_bal = r.getInt("BALANCE"); // Get the balance value from the ResultSet
                        int bal = conv_bal + deposit_amt; // Calculate the new balance
                        //String qa="UPDATE ACCOUNT SET Balance=" +bal+ "WHERE PIN ='"+ PIN + "'";
                        
                        String qa = "UPDATE ACCOUNT SET Balance = " + bal + " WHERE PIN = '" + PIN + "'";
                        c5.statement1.executeUpdate(qa);
                    }
                    if(!ifpinexists)
                    {
                        String qpin = "INSERT INTO ACCOUNT(PIN, Balance) VALUES('" + PIN + "', '" + deposit_amt + "')";
                        c5.statement1.executeUpdate(qpin);
                    }
                    String q="INSERT INTO BANK_TRANS(pin,transaction_date,transaction_amount,transaction_type)"+
                            " VALUES('"+PIN+"','"+date_trans+"','"+deposit_amt+"','"+type+"')";
                    c5.statement1.executeUpdate(q);


                    /*else{
                        Integer bal=0;
                        bal=deposit_amt;
                        String qa="UPDATE ACCOUNT SET Balance=" +bal+ "WHERE PIN ='"+ PIN+ "'";
                        c5.statement1.executeUpdate(qa);
                    }*/

                    JOptionPane.showMessageDialog(null,"Succesfully credited Rs." +deposit_amt+"\n Thank you for choosing us");
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        else if(e.getSource()==b2)
        {
            new Main_Class(PIN);
            f.setVisible(false);
        }
    }

    public void setPlaceholder(JTextField textField, String placeholder) {
        textField.setForeground(Color.BLACK);
        textField.setText(placeholder);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }

        });
    }

    public static void main(String[] args) {
            new Deposit("");

    }
}
