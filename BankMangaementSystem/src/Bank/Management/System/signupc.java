package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class signupc extends JFrame implements ActionListener {
    JFrame f=new JFrame();
    String f_n;
    JLabel lfn,lt,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JButton b1,b2;
    JTextField tx1,tx2;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,ctc;

    signupc(String form_no)
    {

        this.f_n=form_no;

        f.setLayout(null);
        f.setSize(800,800);
        f.setTitle("Signup *");
        f.setBounds(250,0,800,800);
        f.getContentPane().setBackground(Color.WHITE);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(30,10,100,100);
        f.add(i4);

        lt=new JLabel("Account Details");
        lt.setBounds(300,30,250,25);
        lt.setFont(new Font("Arial",Font.BOLD,25));
        lt.setForeground(Color.BLACK);
        f.add(lt);

        lfn=new JLabel("Form no. :"+ f_n);
        lfn.setBounds(320,60,250,17);
        lfn.setFont(new Font("Arial",Font.BOLD,17));
        lfn.setForeground(Color.BLACK);
        f.add(lfn);

        l1=new JLabel("Account type:");
        l1.setBounds(160,90,150,20);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        f.add(l1);

        r1=new JRadioButton("Saving Account:");
        r1.setBounds(160,120,150,15);
        r1.setForeground(Color.BLACK);
        r1.setBackground(Color.WHITE);
        r1.setFont(new Font("Arial",Font.PLAIN,15));
        f.add(r1);

        r2=new JRadioButton("Fixed Deposit Account:");
        r2.setBounds(400,120,200,15);
        r2.setForeground(Color.BLACK);
        r2.setBackground(Color.WHITE);
        r2.setFont(new Font("Arial",Font.PLAIN,15));
        f.add(r2);

        r3=new JRadioButton("Current Account:");
        r3.setBounds(160,150,150,15);
        r3.setForeground(Color.BLACK);
        r3.setBackground(Color.WHITE);
        r3.setFont(new Font("Arial",Font.PLAIN,15));
        f.add(r3);

        r4=new JRadioButton("Recurring Deposit Account:");
        r4.setBounds(400,150,200,15);
        r4.setForeground(Color.BLACK);
        r4.setBackground(Color.WHITE);
        r4.setFont(new Font("Arial",Font.PLAIN,15));
        f.add(r4);

        ButtonGroup any1=new ButtonGroup();
        any1.add(r1);
        any1.add(r2);
        any1.add(r3);
        any1.add(r4);

        l2=new JLabel("Card number:");
        l2.setBounds(160,190,200,20);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        f.add(l2);

        l3=new JLabel("(Your 16 digit card number)");
        l3.setBounds(160,210,250,12);
        l3.setFont(new Font("Arial",Font.PLAIN,12));
        f.add(l3);

        l4=new JLabel("XXXX-XXXX-XXXX-4841");
        l4.setBounds(400,190,300,18);
        l4.setFont(new Font("Arial",Font.PLAIN,18));
        l4.setForeground(Color.BLACK);
        f.add(l4);

        l5=new JLabel("(It would appear on atm card/checkbook)");
        l5.setBounds(400,210,250,12);
        l5.setFont(new Font("Arial",Font.PLAIN,12));
        f.add(l5);

        l6=new JLabel("PIN:");
        l6.setBounds(160,250,200,20);
        l6.setFont(new Font("Arial",Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        f.add(l6);

        l7=new JLabel("(4-Digit-Password)");
        l7.setBounds(160,270,250,12);
        l7.setFont(new Font("Arial",Font.PLAIN,12));
        f.add(l7);

        l8=new JLabel("XXXX");
        l8.setBounds(400,250,300,18);
        l8.setFont(new Font("Arial",Font.PLAIN,18));
        l8.setForeground(Color.BLACK);
        f.add(l8);

        l9=new JLabel("Services reequired:");
        l9.setBounds(160,310,200,20);
        l9.setFont(new Font("Arial",Font.BOLD,20));
        l9.setForeground(Color.BLACK);
        f.add(l9);

        c1=new JCheckBox("ATM card");
        c1.setBounds(160,350,200,15);
        c1.setFont(new Font("Arial",Font.PLAIN,15));
        c1.setBackground(Color.WHITE);
        c1.setForeground(Color.BLACK);
        f.add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBounds(400,350,200,15);
        c2.setFont(new Font("Arial",Font.PLAIN,15));
        c2.setBackground(Color.WHITE);
        c2.setForeground(Color.BLACK);
        f.add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBounds(160,380,200,15);
        c3.setFont(new Font("Arial",Font.PLAIN,15));
        c3.setBackground(Color.WHITE);
        c3.setForeground(Color.BLACK);
        f.add(c3);

        c4=new JCheckBox("Cheque book");
        c4.setBounds(400,380,200,15);
        c4.setFont(new Font("Arial",Font.PLAIN,15));
        c4.setBackground(Color.WHITE);
        c4.setForeground(Color.BLACK);
        f.add(c4);

        c5=new JCheckBox("Email Alerts");
        c5.setBounds(160,410,200,15);
        c5.setFont(new Font("Arial",Font.PLAIN,15));
        c5.setBackground(Color.WHITE);
        c5.setForeground(Color.BLACK);
        f.add(c5);

        c6=new JCheckBox("E-statements");
        c6.setBounds(400,410,200,15);
        c6.setFont(new Font("Arial",Font.PLAIN,15));
        c6.setBackground(Color.WHITE);
        c6.setForeground(Color.BLACK);
        f.add(c6);

        ctc=new JCheckBox("I accept all the terms and conditions and proceed with complete understanding.");
        ctc.setBounds(130,470,600,15);
        ctc.setFont(new Font("Times New Roman",Font.BOLD,15));
        ctc.setBackground(Color.WHITE);
        f.add(ctc);

        b1=new JButton("Submit");
        b1.setBounds(170,520,150,50);
        b1.setBackground(Color.BLACK);
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(430,520,150,50);
        b2.setBackground(Color.BLACK);
        b2.setFont(new Font("Arial",Font.BOLD,20));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        f.add(b2);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            String formno=f_n;
           String acc_typ=null;
            if(r1.isSelected())
            {
                acc_typ="Saving Account";
            }
            else if(r2.isSelected())
            {
                acc_typ="Fixed Deposit Account";
            }
            else if(r3.isSelected())
            {
                acc_typ="Current Account";
            }
            else if(r4.isSelected())
            {
                acc_typ="Recurring Deposit Account";
            }

            Random ran = new Random();
            long first7 = (ran.nextLong() % 90000000L) + 1409963000000000L;
            String cardno = "" + Math.abs(first7);

            long first3 = (ran.nextLong() % 9000L)+ 1000L;
            String pin = "" + Math.abs(first3);

            String service="";
            if(c1.isSelected())
            {
                service=service+"ATM card";
            }
            if(c2.isSelected())
            {
                service=service+"Internet Banking";
            }
            else if(c3.isSelected())
            {
                service=service+"Mobile Banking";
            }
            else if(c4.isSelected())
            {
                service=service+"Cheque book";
            }
            else if(c5.isSelected())
            {
                service=service+"Email Alerts";
            }
            else if(c6.isSelected())
            {
                service=service+"E-statement";
            }

            try{
                if(acc_typ.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"please fill all fields");
                }
                else {
                    try{
                        String q3="INSERT INTO ACC_SIGN_UP(form_no,Account_Type,Card_number,PIN,Services)"+
                                "VALUES('"+f_n+"','"+acc_typ+"','"+cardno+"','"+pin+"','"+service+"')";
                        System.out.println("Generated query"+q3);
                        String q4="INSERT INTO LOGIN(form_no,Card_number,PIN)"+
                                "VALUES('"+f_n+"','"+cardno+"','"+pin+"')";
                        System.out.println("Generated query"+q4);
                        Conn c3=new Conn();
                        c3.statement1.executeUpdate(q3);
                        c3.statement1.executeUpdate(q4);
                        JOptionPane.showMessageDialog(null,"Card number:"+cardno+"\nPIN:"+pin);
                        new Deposit(pin);
                        f.setVisible(false);
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
                ex.printStackTrace();
            }


        }
        else if(e.getSource()==b2)
        {
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new signupc("");
    }
}
