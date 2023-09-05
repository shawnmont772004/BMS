package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnq extends JFrame implements ActionListener{
    String PIN;
    JLabel l1,l2;
    JFrame f=new JFrame();
    JButton b1;
    BalanceEnq(String pin)
    {
        this.PIN=pin;

        f.setLayout(null);
        f.setTitle("Balance Enquiry");
        f.setBounds(270,20,800,800);
        f.setSize(800,600);
        f.getContentPane().setBackground(Color.BLACK);

        l1=new JLabel("Your Account Balance is:");
        l1.setBounds(270,170,300,25);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Arial",Font.BOLD,23));
        f.add(l1);

        l2=new JLabel();
        l2.setBounds(270,200,300,20);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l2);

        b1=new JButton("Back");
        b1.setBounds(230,280,100,25);
        b1.setBackground(Color.YELLOW);
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Arial",Font.BOLD,18));
        b1.addActionListener(this);
        f.add(b1);

        String strbal="";//intialise it at the first stage

        try{
            Conn c=new Conn();
            String qbal="SELECT BALANCE FROM ACCOUNT WHERE PIN = '" +PIN+ "'";
            ResultSet fetchresult = c.statement1.executeQuery(qbal);
            if (fetchresult.next())
            {
                Integer intbal=fetchresult.getInt("BALANCE");//retrieving balance in integer format
                strbal= intbal.toString();//conversion of intbal to string format as the jlabel only take string values
                //l2.setText("Rs."+strbal);
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("SQL State: " + ex.getSQLState());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Message: " + ex.getMessage());
        }
        l2.setText("Rs."+strbal);

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
            new Main_Class(PIN);
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BalanceEnq("");
    }
}
