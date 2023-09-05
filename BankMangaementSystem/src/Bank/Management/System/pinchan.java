package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class pinchan extends JFrame implements ActionListener{
    String PIN;
    JLabel l1,l2,l3;
    JTextField tx1,tx2;
    JButton b1,b2;
    JFrame f=new JFrame();
    pinchan(String pin)
    {
        this.PIN=pin;

        f.setTitle("Change PIN");
        f.setLayout(null);
        f.setSize(520,300);
        f.setBounds(300,100,520,300);
        f.getContentPane().setBackground(Color.WHITE);

        l1=new JLabel("Please enter your current PIN:");
        l1.setBounds(20,50,300,20);
        l1.setForeground(Color.BLACK);
        l1.setBackground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l1);

       tx1=new JTextField();
       tx1.setBounds(340,50,150,20);
       tx1.setForeground(Color.BLACK);
       tx1.setBackground(Color.WHITE);
       tx1.setFont(new Font("Raleway",Font.PLAIN,18));
       f.add(tx1);

        l2=new JLabel("Please enter the new PIN:");
        l2.setBounds(20,100,300,20);
        l2.setForeground(Color.BLACK);
        l2.setBackground(Color.WHITE);
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l2);

        tx2=new JTextField();
        tx2.setBounds(340,100,150,20);
        tx2.setForeground(Color.BLACK);
        tx2.setBackground(Color.WHITE);
        tx2.setFont(new Font("Raleway",Font.PLAIN,18));
        f.add(tx2);

        JButton b1=new JButton("Submit");
        b1.setBounds(100,170,130,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Raleway",Font.BOLD,20));
        b1.addActionListener(this);
        f.add(b1);

        JButton b2=new JButton("Back");
        b2.setBounds(290,170,130,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("Raleway",Font.BOLD,20));
        b2.addActionListener(this);
        f.add(b2);


        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("shawn");
        if(e.getSource()==b1)
        {

            String pintxtold=tx1.getText();
            String pintxtnew=tx2.getText();
             try{
                 Conn c=new Conn();
                 String qpin1 = "UPDATE LOGIN  SET PIN = '" + pintxtnew + "' WHERE PIN = '" + pintxtold + "'";
                 //String qpin1="UPDATE LOGIN SET PIN = '" + pintxtnew + "' WHERE PIN = '"+pintxtold+"'";

                 System.out.println(qpin1);

                 c.statement1.executeUpdate(qpin1);

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
            new Main_Class(PIN);
        }
    }

    public static void main(String[] args) {
        new pinchan("");
    }


}
