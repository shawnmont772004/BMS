package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class signupb extends JFrame implements ActionListener {
    JFrame f=new JFrame();
    String form_no;
    JLabel lfn,lt,l1,l2,l3,l4,l5,l6,l7;
    JComboBox c1,c2,c3;//a combination of input text and options
    JTextField tx1,tx2,tx3,tx4;
    JRadioButton r1,r2,r3,r4;
    JButton b1;
    signupb(String formno)
    {
        this.form_no=formno;


        f.setLayout(null);
        f.setSize(600,600);
        f.setBounds(300,0,600,700);
        f.setTitle("Sign up *");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel i4=new JLabel(i3);
        i4.setBounds(230,20,100,100);
        f.add(i4);

        lt=new JLabel("Additional Details");
        lt.setBounds(170,120,400,40);
        lt.setFont(new Font("Arial",Font.BOLD,30));
        lt.setForeground(Color.BLACK);
        f.add(lt);

        lfn=new JLabel("Form no. :"+form_no);
        lfn.setBounds(400,60,200,20);
        lfn.setForeground(Color.BLACK);
        lfn.setFont(new Font("Arial",Font.BOLD,20));
        f.add(lfn);

        l1=new JLabel("Religion:");
        l1.setBounds(80,170,200,30);
        l1.setFont(new Font("Arial",Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        f.add(l1);

        String religion[]={"Hindu","Muslim","Christian","Sikh","Other"};//array containing strings
        c1=new JComboBox(religion);
        c1.setForeground(Color.BLACK);
        c1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        c1.setBackground(Color.WHITE);
        c1.setBounds(240,170,300,30);
        f.add(c1);

        l2=new JLabel("Category:");
        l2.setBounds(80,220,200,30);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        f.add(l2);

        String Category[]={"General","OBC","SC","ST","Other"};//array containing strings
        c2=new JComboBox(Category);
        c2.setForeground(Color.BLACK);
        c2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        c2.setBackground(Color.WHITE);
        c2.setBounds(240,220,300,30);
        f.add(c2);

        l3=new JLabel("Education:");
        l3.setBounds(80,270,200,30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        f.add(l3);

        String education[]={"None","10th","PUC","Graduate"};//array containing strings
        c3=new JComboBox(education);
        c3.setForeground(Color.BLACK);
        c3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        c3.setBackground(Color.WHITE);
        c3.setBounds(240,270,300,30);
        f.add(c3);

        l4=new JLabel("Income:");
        l4.setBounds(80,320,200,30);
        l4.setFont(new Font("Arial",Font.BOLD,20));
        l4.setForeground(Color.BLACK);
        f.add(l4);

        tx1=new JTextField();
        tx1.setBounds(240,320,300,30);
        tx1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tx1.setForeground(Color.BLACK);
        f.add(tx1);

        l5=new JLabel("Occupation:");
        l5.setBounds(80,370,200,30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        f.add(l5);

        tx2=new JTextField();
        tx2.setBounds(240,370,300,30);
        tx2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tx2.setForeground(Color.BLACK);
        f.add(tx2);

        l5=new JLabel("PAN Number:");
        l5.setBounds(80,420,200,30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        f.add(l5);

        tx3=new JTextField();
        tx3.setBounds(240,420,300,30);
        tx3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tx3.setForeground(Color.BLACK);
        f.add(tx3);

        l5=new JLabel("Aadhar Number:");
        l5.setBounds(80,470,200,30);
        l5.setFont(new Font("Arial",Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        f.add(l5);

        tx4=new JTextField();
        tx4.setBounds(240,470,300,30);
        tx4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        tx4.setForeground(Color.BLACK);
        f.add(tx4);

        l6=new JLabel("Senior Citizen:");
        l6.setBounds(80,520,200,30);
        l6.setFont(new Font("Arial",Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        f.add(l6);

        r1=new JRadioButton("Yes");
        r1.setBounds(240,520,60,30);
        f.add(r1);

        r2=new JRadioButton("No");
        r2.setBounds(340,520,60,30);
        f.add(r2);

        ButtonGroup s1=new ButtonGroup();
        s1.add(r1);
        s1.add(r2);

        l7=new JLabel("Existing acc:");
        l7.setBounds(80,570,200,30);
        l7.setFont(new Font("Arial",Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        f.add(l7);

        r3=new JRadioButton("Yes");
        r3.setBounds(240,570,60,30);
        f.add(r3);

        r4=new JRadioButton("No");
        r4.setBounds(340,570,60,30);
        f.add(r4);

        ButtonGroup s2=new ButtonGroup();
        s2.add(r3);
        s2.add(r4);

        b1=new JButton("Next");
        b1.setBounds(240,600,100,30);
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        f.add(b1);

        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            String f_no=form_no;//retrieve the data of variable form_no

            String religion=(String) c1.getSelectedItem();//retrieve the data that is stored in combobox
            String Category=(String) c2.getSelectedItem();
            String Education=(String) c3.getSelectedItem();


            String tx11=tx1.getText();//conversion of string in jtextfield to double
            Double tx111=Double.parseDouble(tx11);
            Double income=tx111;

            String occupation=tx2.getText();

            String tx31 = tx3.getText();//string to integer
            Integer tx311 = Integer.parseInt(tx31);
            Integer PAN=tx311;

            String tx41=tx4.getText();//shorter method
            Integer tx411= Integer.parseInt(tx41);
            Integer Aadhar=tx411;

            String sen_cz=null;//for integer u could just have int sen_cz
            if(r1.isSelected())
            {
                sen_cz="Yes";
            }
            else if(r2.isSelected())
            {
                sen_cz="No";
            }

            String ex_acc=null;
            if(r3.isSelected())
            {
                ex_acc="Yes";
            }
            else if(r4.isSelected())
            {
                ex_acc="No";
            }

            try {
                if (tx4.getText().equals("") || tx3.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                }
                else {
                    try {
                        Conn con2 = new Conn();
                        String q2 = "insert into add_sign_up(form_no,Religion,Category,Education,Income,Occupation,PAN,Aadhar_no,Senior_citizen,Exist_account) " +
                           "values('"+f_no+"','" + religion + "','" + Category + "','" + Education + "','" + income + "','" + occupation + "','" + PAN + "','" + Aadhar + "','" + sen_cz + "','" + ex_acc + "')";

                        //   String q2 = "INSERT INTO add_sign_up( form_no,Religion, Category, Education, Income, Occupation, PAN, Aadhar_no, Senior_citizen, Exist_account )  VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        //String q2 = "INSERT INTO add_sign_up(form_no, Religion, Category, Education, Income, Occupation, PAN, Aadhar_no, Senior_citizen, Exist_account) " +
                        //         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                          System.out.println("Generated query: " + q2);

                           con2.statement2.executeUpdate(q2);
                           // try  {
                           //     PreparedStatement preparedStatement = con2.connection.prepareStatement(q2);
                           //     preparedStatement.setString(1, f_no);
                           //     preparedStatement.setString(2, religion);
                           //     preparedStatement.setString(3, Category);
                           //     preparedStatement.setString(4, Education);
                           //     preparedStatement.setDouble(5, income);
                           //      preparedStatement.setString(6, occupation);
                           //     preparedStatement.setInt(7, PAN);
                           //     preparedStatement.setInt(8, Aadhar);
                           //     preparedStatement.setString(9, sen_cz);//setBoolean can be used if r1 and r2 were not strings
                           //     preparedStatement.setString(10, ex_acc);
                           //
                           //     int rowsAffected = preparedStatement.executeUpdate();
                           //     System.out.println(rowsAffected + " row(s) inserted.");
                           //
                           //     if (rowsAffected > 0) {
                           //         System.out.println("Data inserted successfully.");
                           //     } else {
                           //         System.out.println("Failed to insert data.");
                           //     }
                           //
                       // }
                   //catch (SQLException exx) {
                   //     exx.printStackTrace();
                   // }
                        new signupc(f_no);
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
    }
    public static void main(String[] args) {
        new signupb("");
    }
}
