package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//this performs certain actions like clearing the name when the clear button is hit
import java.sql.ResultSet;
import java.sql.SQLException;

public class login extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField tx1;
    JPasswordField p;
    JFrame f=new JFrame();
    JButton b1,b2,b3;
    login()
    {
        super("Bank Management System");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));//get the image from the given path
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);//scale the image
        ImageIcon i3=new ImageIcon(i2);//to put the scaled image back as an icon
        JLabel image=new JLabel(i3);//any image should be labelled as it could be cutomised in size
        image.setBounds(250,20,100,100);//setting size for the labeled image
        f.add(image);

        //super("title_name"); //if f is not defined
        f.setLayout(null);//cause we want changes or else it would be default as borderline
        f.setTitle("Bank Management system");//title given to the window
        f.setSize(600,500);//size of the window
        f.setLocation(300,150);//at what points the window must lie

        l1=new JLabel("Welcome to Bank");//labels any text
        l1.setBounds(150,110,350,60);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial", Font.BOLD, 40));
        f.add(l1);

        l2=new JLabel("ACC No:");
        l2.setBounds(150,180,200,30);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Futura",Font.BOLD,20));
        f.add(l2);

        tx1=new JTextField(15);//box where an input can be read
        tx1.setBounds(260,180,200,30);
        tx1.setForeground(Color.BLACK);
        tx1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        f.add(tx1);

        l3=new JLabel("PIN:");
        l3.setBounds(150,230,200,30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Futura",Font.BOLD,20));
        f.add(l3);

        p=new JPasswordField(15);//password which gives dots instead of a text
        p.setBounds(260,230,200,30);
        p.setForeground(Color.BLACK);
        p.setFont(new Font("Times New Roman",Font.PLAIN,20));
        f.add(p);

        b1=new JButton("SIGN UP");//button creation
        b1.setBounds(20,320,150,30);
        b1.setBackground(Color.BLACK);//button color
        b1.setForeground(Color.WHITE);//font color
        b1.setFont(new Font("Arial",Font.PLAIN,20));
        b1.addActionListener(this);//so the actions that happen linked to actionPerformed
        f.add(b1);

        b2=new JButton("CLEAR");
        b2.setBounds(220,320,150,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial",Font.PLAIN,20));
        b2.addActionListener(this);
        f.add(b2);

        b3=new JButton("LOG IN");
        b3.setBounds(420,320,150,30);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setFont(new Font("Arial",Font.PLAIN,20));
        b3.addActionListener(this);
        f.add(b3);

        ImageIcon ia=new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image ib=ia.getImage().getScaledInstance(600,500,Image.SCALE_DEFAULT);
        ImageIcon ic=new ImageIcon(ib);
        JLabel imgbg=new JLabel(ic);
        imgbg.setBounds(0,0,600,500);//x & y 0. Also width & height is same as sthe size of the frame indicates it covers the whole background
        f.add(imgbg);//image that is added first overlaps other. Here bg image doesnot overlap bank image

        f.setVisible(true);//by default a frame is invisible so set it to boolean true and must be at last
    }
    public void actionPerformed(ActionEvent e){//actions performed that notices e
        try{
            if (e.getSource()==b1)//if there is a trigger at button 1
            {
                new signup();
            }
            else if (e.getSource()==b2)//if there is a trigger at button 2 for clear
            {
                tx1.setText("");//empties the textfield tx1
                p.setText("");//empties password
            }
            else if(e.getSource()==b3)
            {
                String Carno=tx1.getText();
                String pin=p.getText();

                try{
                    Conn Cont=new Conn();
                    String qm="select * from login where Card_number='"+Carno+"' and PIN='"+pin+"'";
                    ResultSet resultSet = Cont.statement1.executeQuery(qm);
                    if (resultSet.next()){
                        f.setVisible(false);
                        new Main_Class(pin);
                    }else {
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                    }
                }
                catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("SQL State: " + ex.getSQLState());
                    System.out.println("Error Code: " + ex.getErrorCode());
                    System.out.println("Message: " + ex.getMessage());
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();//returns an exception
        }
    }
    public static void main(String[] args)
    {
        new login();
    }
}
//enter + for the entire line
//ctrl+space for entire word