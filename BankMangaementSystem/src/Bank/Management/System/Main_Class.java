package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Bank.Management.System.stat;


public class Main_Class extends JFrame implements ActionListener {
    String pinno;
    JFrame f=new JFrame();
    JButton dep,with,fast,bal,stat,p_chan,exit;
    Main_Class(String pin)
    {
        this.pinno=pin;
        f.setLayout(null);
        f.setTitle("SCSG BANK");
        f.setBounds(0,0,1550,850);
        f.setSize(1550,850);


        dep=new JButton("Deposit");
        dep.setBounds(300,180,150,30);
        dep.setBackground(new Color(65,125,128));
        dep.setForeground(Color.WHITE);
        dep.setFont(new Font("Ralway",Font.PLAIN,18));
        dep.addActionListener(this);
        f.add(dep);

        fast=new JButton("Fast Cash");
        fast.setBounds(300,240,150,30);
        fast.setBackground(new Color(65,125,128));
        fast.setForeground(Color.WHITE);
        fast.setFont(new Font("Ralway",Font.PLAIN,18));
        fast.addActionListener(this);
        f.add(fast);

        p_chan=new JButton("PIN Change");
        p_chan.setBounds(300,300,150,30);
        p_chan.setBackground(new Color(65,125,128));
        p_chan.setForeground(Color.WHITE);
        p_chan.setFont(new Font("Ralway",Font.PLAIN,18));
        p_chan.addActionListener(this);
        f.add(p_chan);

        with=new JButton("Withdraw");
        with.setBounds(570,180,150,30);
        with.setBackground(new Color(65,125,128));
        with.setForeground(Color.WHITE);
        with.setFont(new Font("Ralway",Font.PLAIN,18));
        with.addActionListener(this);
        f.add(with);

        stat=new JButton("Statements");
        stat.setBounds(570,240,150,30);
        stat.setBackground(new Color(65,125,128));
        stat.setForeground(Color.WHITE);
        stat.setFont(new Font("Ralway",Font.PLAIN,18));
        stat.addActionListener(this);
        f.add(stat);

        bal=new JButton("Balance");
        bal.setBounds(570,300,150,30);
        bal.setBackground(new Color(65,125,128));
        bal.setForeground(Color.WHITE);
        bal.setFont(new Font("Ralway",Font.PLAIN,18));
        bal.addActionListener(this);
        f.add(bal);

        exit=new JButton("Exit");
        exit.setBounds(435,360,150,30);
        exit.setBackground(new Color(65,125,128));
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Ralway",Font.BOLD,18));
        exit.addActionListener(this);
        f.add(exit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2=i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(-120,0,1550,830);
        f.add(i4);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==dep)
        {
            //Deposit d=new Deposit(pinno);
            //d.setVisible(true);//could be declared this way too
            new Deposit(pinno);
            f.setVisible(false);
        }
        else if(e.getSource()==with)
        {
            new Withdraw(pinno);
            f.setVisible(false);
        }
        else if(e.getSource()==fast)
        {
            new fastcash(pinno);
            f.setVisible(false);
        }
        else if(e.getSource()==stat)
        {
            new stat(pinno);
            f.setVisible(false);
        }
        else if(e.getSource()==bal)
        {
            new BalanceEnq(pinno);
            f.setVisible(false);
        }
        else if(e.getSource()==p_chan)
        {
            new pinchan(pinno);
            f.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Main_Class("");
    }
}
