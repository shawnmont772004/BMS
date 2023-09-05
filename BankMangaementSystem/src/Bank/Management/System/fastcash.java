package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fastcash extends JFrame implements ActionListener {
    String PIN;
    JFrame f=new JFrame();
    JLabel l1;
    JButton b1,b2,b3,b4,b5;

    fastcash(String pin)
    {
        this.PIN =pin;

        f.setLayout(null);
        f.setTitle("Fast cash services");
        f.setBounds(270,20,430,800);
        f.setSize(430,450);
        f.getContentPane().setBackground(Color.BLACK);

        l1=new JLabel("Click on to withdraw cash:");
        l1.setBounds(80,30,300,20);
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setForeground(Color.WHITE);
        f.add(l1);

        b1=new JButton("Rs. 50");
        b1.setBounds(120,80,150,25);
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Ralway",Font.BOLD,20));
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        f.add(b1);

        // Add this code where you create the "b1" and "b5" buttons
        b2 = new JButton("Rs. 100");
        b2.setBounds(120, 140, 150, 25);
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Ralway", Font.BOLD, 20));
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Rs. 200");
        b3.setBounds(120, 200, 150, 25);
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("Ralway", Font.BOLD, 20));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Rs. 500");
        b4.setBounds(120, 260, 150, 25);
        b4.setBackground(Color.WHITE);
        b4.setFont(new Font("Ralway", Font.BOLD, 20));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        f.add(b4);


        b5=new JButton("Back");
        b5.setBounds(120,350,150,25);
        b5.setBackground(Color.WHITE);
        b5.setFont(new Font("Ralway",Font.BOLD,20));
        b5.setForeground(Color.BLACK);
        b5.addActionListener(this);
        f.add(b5);




        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date d=new Date();
        String type="Withdraw";

        if(e.getSource()==b1)
        {
            Conn c=new Conn();
            Integer debited_amt1=50;
            try{
                String q1="SELECT * FROM ACCOUNT WHERE PIN = '" +PIN+"'";
                ResultSet r1=c.statement1.executeQuery(q1);

                if(r1.next())
                {
                    int existing_bal1=r1.getInt("BALANCE");
                   if(existing_bal1!=0 && existing_bal1>debited_amt1)
                    {
                        int new_bal=existing_bal1-debited_amt1;
                        String q2="UPDATE ACCOUNT SET BALANCE = '" + new_bal + "' WHERE PIN = '" +PIN+ "'";
                        c.statement1.executeUpdate(q2);

                        JOptionPane.showMessageDialog(null, "Succesfully debited Rs." + debited_amt1 + "\n Thank you for choosing us");

                        String q3="INSERT INTO BANK_TRANS(pin,transaction_date,transaction_amount,transaction_type)"
                                +"VALUES('" + PIN + "','" + d + "','" + debited_amt1 + "','" + type + "')";
                        c.statement1.executeUpdate(q3);
                    }
                   else
                   {
                       JOptionPane.showMessageDialog(null,"Insufficent balance");
                   }

                }

            }
            catch(SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());
                System.out.println("Message: " + ex.getMessage());
            }
        }
        else if(e.getSource()==b2)
        {

            Integer debited_amt2=100;
            try{
                Conn c=new Conn();
                String q4="SELECT * FROM ACCOUNT WHERE PIN = '" + PIN + "' ";
                ResultSet r2=c.statement1.executeQuery(q4);

                if(r2.next())
                {
                    Integer existing_bal2=r2.getInt("BALANCE");
                    if(existing_bal2!=0 && existing_bal2>debited_amt2)
                    {
                        Integer new_bal=existing_bal2-debited_amt2;
                        String q5="UPDATE ACCOUNT SET BALANCE = '" + new_bal + "' WHERE PIN = '" +PIN+"'";
                        c.statement1.executeUpdate(q5);

                        JOptionPane.showMessageDialog(null, "Succesfully debited Rs." + debited_amt2 + "\n Thank you for choosing us");

                        String q6="INSERT INTO BANK_TRANS(PIN,TRANSACTION_DATE,TRANSACTION_AMOUNT,TRANSACTION_TYPE)"+
                                "VALUES('" + PIN + "','"  + d + "','" + debited_amt2 + "','" + type +"')";
                        c.statement1.executeUpdate(q6);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Insufficent funds");
                    }
                }
            }
            catch(SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());
                System.out.println("Message: " + ex.getMessage());
            }


        }
        else if(e.getSource()==b3)
        {
            Integer debited_amt3=200;
            try{
                Conn c=new Conn();
                String q7="SELECT * FROM ACCOUNT WHERE PIN = '" + PIN + "' ";
                ResultSet r3=c.statement1.executeQuery(q7);

                if(r3.next())
                {
                    Integer existing_bal3=r3.getInt("BALANCE");
                    if(existing_bal3!=0 && existing_bal3>debited_amt3)
                    {
                        Integer new_bal=existing_bal3-debited_amt3;
                        String q8="UPDATE ACCOUNT SET BALANCE = '" + new_bal + "' WHERE PIN = '" +PIN+"'";
                        c.statement1.executeUpdate(q8);

                        JOptionPane.showMessageDialog(null, "Succesfully debited Rs." + debited_amt3 + "\n Thank you for choosing us");

                        String q9="INSERT INTO BANK_TRANS(PIN,TRANSACTION_DATE,TRANSACTION_AMOUNT,TRANSACTION_TYPE)"+
                                "VALUES('" + PIN + "','"  + d + "','" + debited_amt3 + "','" + type +"')";
                        c.statement1.executeUpdate(q9);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Insufficent funds");
                    }
                }
            }
            catch(SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());
                System.out.println("Message: " + ex.getMessage());
            }

        }
        else if(e.getSource()==b4)
        {
            Integer debited_amt4=500;
            try{
                Conn c=new Conn();
                String q10="SELECT * FROM ACCOUNT WHERE PIN = '" + PIN + "' ";
                System.out.println("Generated query is"+q10);
                ResultSet r4=c.statement1.executeQuery(q10);

                if(r4.next())
                {
                    Integer existing_bal4=r4.getInt("BALANCE");
                    if(existing_bal4!=0 && existing_bal4>debited_amt4)
                    {
                        Integer new_bal=existing_bal4-debited_amt4;
                        String q11="UPDATE ACCOUNT SET BALANCE = '" + new_bal + "' WHERE PIN = '" +PIN+"'";
                        System.out.println("Generated query is"+q11);
                        c.statement1.executeUpdate(q11);

                        JOptionPane.showMessageDialog(null, "Succesfully debited Rs." + debited_amt4 + "\n Thank you for choosing us");

                        String q12="INSERT INTO BANK_TRANS(PIN,TRANSACTION_DATE,TRANSACTION_AMOUNT,TRANSACTION_TYPE)"+
                                "VALUES('" + PIN + "','"  + d + "','" + debited_amt4 + "','" + type +"')";
                        System.out.println("Generated query is"+q12);
                        c.statement1.executeUpdate(q12);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Insufficent funds");
                    }
                }
            }
            catch(SQLException ex) {
                ex.printStackTrace();
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Error Code: " + ex.getErrorCode());
                System.out.println("Message: " + ex.getMessage());
            }

        }
        else if(e.getSource()==b5)
        {
            new Main_Class(PIN);
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new fastcash("");
    }
}
