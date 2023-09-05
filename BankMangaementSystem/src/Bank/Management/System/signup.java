package Bank.Management.System;

import com.toedter.calendar.JDateChooser;//imported by adding an additional lib i.e JAR file named jcalendar

import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.PreparedStatement; we arent using now
//import java.sql.SQLException;



public class signup extends JFrame implements ActionListener {
    JFrame f=new JFrame();
    JLabel l1,l2,l3,l4,l5,l6,l7,l75,l8,l9,l10,l11;
    Random ran = new Random();
    long first4 =(ran.nextLong() % 9000L) +1000L;
    String first = " " + Math.abs(first4);
    JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7;
    JDateChooser dob;
    JRadioButton r1,r2,r3,m1,m2;
    JButton next;
    signup()
    {


        f.setLayout(null);
        f.setTitle("SIGN UP");
        f.setSize(800,720);
        f.setLocation(240,0);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(350,80,100,100);
        f.add(img);

        l1=new JLabel("APPLICATION FORM" +first);
        l1.setBounds(240,0,400,100);
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        f.add(l1);

        l2=new JLabel("Personal Details");
        l2.setBounds(305,170,250,50);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial",Font.BOLD,25));
        f.add(l2);

        l3=new JLabel("Name:");
        l3.setBounds(200,220,200,25);
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("Raleway",Font.BOLD,20));//height of SB Jlabel must be same as height of JTextfield which puts them at the same level
        f.add(l3);

        tx1=new JTextField(20);
        tx1.setBounds(360,220,300,25);
        tx1.setBackground(Color.WHITE);
        tx1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(tx1);

        l4=new JLabel("Father's Name:");
        l4.setBounds(200,260,200,25);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l4);

        tx2=new JTextField(20);
        tx2.setBounds(360,260,300,25);
        tx2.setBackground(Color.WHITE);
        tx2.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(tx2);

        l5=new JLabel("Date of birth:");
        l5.setBounds(200,300,200,25);
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l5);

        dob=new JDateChooser();//for choosing date
        dob.setForeground(new Color(122,122,122));//no font style
        dob.setBounds(360,300,300,25);
        f.add(dob);

        l6=new JLabel("Gender:");
        l6.setBounds(200,340,200,25);
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l6);

        r1=new JRadioButton("Male");//forms circular buttons which can ticked
        r1.setBounds(360,340,80,25);
        f.add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(450,340,80,25);
        f.add(r2);

        r3=new JRadioButton("Other");
        r3.setBounds(540,340,80,25);
        f.add(r3);

        ButtonGroup onlyone=new ButtonGroup();//the ones added to the button group allows only one to be chosen
        onlyone.add(r1);
        onlyone.add(r2);
        onlyone.add(r3);

        l7=new JLabel("Email:");
        l7.setBounds(200,380,200,25);
        l7.setForeground(Color.BLACK);
        l7.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l7);

        tx3=new JTextField(20);
        tx3.setBounds(360,380,300,25);
        tx3.setBackground(Color.WHITE);
        tx3.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(tx3);

        l75=new JLabel("Marital status:");
        l75.setBounds(200,420,200,25);
        l75.setForeground(Color.BLACK);
        l75.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l75);

        m1=new JRadioButton("Yes");
        m1.setBounds(360,420,80,20);
        f.add(m1);

        m2=new JRadioButton("No");
        m2.setBounds(450,420,80,20);
        f.add(m2);

        ButtonGroup monlyone=new ButtonGroup();
        monlyone.add(m1);
        monlyone.add(m2);

        l8=new JLabel("City:");
        l8.setBounds(200,460,200,25);
        l8.setForeground(Color.BLACK);
        l8.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l8);

        tx4=new JTextField(20);
        tx4.setBounds(360,460,300,25);
        tx4.setBackground(Color.WHITE);
        tx4.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(tx4);

        l9=new JLabel("Address:");
        l9.setBounds(200,500,200,25);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l9);

        tx5=new JTextField(20);
        tx5.setBounds(360,500,300,25);
        tx5.setBackground(Color.WHITE);
        tx5.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(tx5);
        f.setVisible(true);

        l10=new JLabel("PIN Code:");
        l10.setBounds(200,540,200,25);
        l10.setForeground(Color.BLACK);
        l10.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l10);

        tx6=new JTextField(20);
        tx6.setBounds(360,540,300,25);
        tx6.setBackground(Color.WHITE);
        tx6.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(tx6);
        f.setVisible(true);

        l11=new JLabel("State:");
        l11.setBounds(200,580,200,25);
        l11.setForeground(Color.BLACK);
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        f.add(l11);

        tx7=new JTextField(20);
        tx7.setBounds(360,580,300,25);
        tx7.setBackground(Color.WHITE);
        tx7.setFont(new Font("Times New Roman",Font.PLAIN,15));
        f.add(tx7);

        next=new JButton("Next");
        next.setBounds(350,610,100,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial",Font.BOLD,20));
        next.addActionListener(this);
        f.add(next);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==next)
            {
                String form_no=first;//we dont use gettext as it is not an input in a text field
                String Name=tx1.getText();
                String F_name=tx2.getText();
                String DOB=((JTextField) dob.getDateEditor().getUiComponent()).getText();//JDateChooser
                String gender=null;
                if(r1.isSelected())
                {
                    gender="Male";
                }
                else if(r2.isSelected())
                {
                    gender="Female";
                }
                else if(r3.isSelected())
                {
                    gender="Other";
                }
                String E_mail=tx3.getText();
                String Marital=null;
                if(m1.isSelected())
                {
                    Marital="Yes";
                }
                else if(m2.isSelected())
                {
                    Marital="No";
                }
                String City=tx4.getText();
                String Address=tx5.getText();
                String PIN_Code=tx6.getText();
                String State=tx7.getText();

                try{
                    if(tx1.getText().equals(""))//here it is text field name not the variable where the input is stored
                    {
                        JOptionPane.showMessageDialog(null,"Please fill all the fields");

                    }
                    else {
                        Conn con = new Conn();
                        //String q = "insert into sign_up('" + form_no + "','" + Name + "','" + F_name + "','" + DOB + "','" + gender + "','" + E_mail + "','" + Marital + "','" + City + "','" + Address + "','" + PIN_Code + "','" + State + "')";(would work in old IDEAs
                        String q1= "insert into sign_up(form_no, Reg_Name, F_name, DOB, gender, E_mail, Marital_Status, City, Address, PIN_Code, State) " +
                                "values ('" + form_no + "','" + Name + "','" + F_name + "','" + DOB + "','" + gender + "','" +
                                E_mail + "','" + Marital + "','" + City + "','" + Address + "','" + PIN_Code + "','" + State + "')";
                        String q2="insert into account(C_Name)"+"values('"+F_name+"')";
                        con.statement1.executeUpdate(q1);
                        new signupb(form_no);
                        f.setVisible(false);

                        //Note:Also other way of inserting values
                        //String q = "INSERT INTO sign_up(form_no, Reg_Name, F_name, DOB, gender, E_mail, Marital_Status, City, Address, PIN_Code, State) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        //
                        //try {
                        //    PreparedStatement preparedStatement = con.connection.prepareStatement(q);
                        //    preparedStatement.setString(1, form_no);
                        //    preparedStatement.setString(2, Name);
                        //    preparedStatement.setString(3, F_name);
                        //    preparedStatement.setString(4, DOB); this is varchar format cause dateChooser format is dd-monthname(3)-year whereas mysql date format is year/month/date
                        //    preparedStatement.setString(5, gender);
                        //    preparedStatement.setString(6, E_mail);
                        //    preparedStatement.setString(7, Marital);
                        //    preparedStatement.setString(8, City);
                        //    preparedStatement.setString(9, Address);
                        //    preparedStatement.setString(10, PIN_Code);
                        //    preparedStatement.setString(11, State);
                        //
                        //    int rowsAffected = preparedStatement.executeUpdate();
                        //    if (rowsAffected > 0) {
                        //        System.out.println("Data inserted successfully.");
                        //    } else {
                        //        System.out.println("Failed to insert data.");
                        //    }
                        //
                        //    preparedStatement.close();
                        //} catch (SQLException ex) {
                        //    ex.printStackTrace();
                        //}
                    }

                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        }


    public static void main(String[] args) {
        new signup();
    }
}
