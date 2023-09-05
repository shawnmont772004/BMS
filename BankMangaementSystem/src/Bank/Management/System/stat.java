package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.*;
// ... other imports ...

public class stat extends JFrame implements ActionListener{
    JFrame f=new JFrame();
    JLabel l;
    JButton b;
    private JTable table;
    String PIN;
    public stat(String pin) {

        this.PIN=pin;
        f.setLayout(null);
        f.setBounds(350,50,600,600);
        f.setTitle("Transaction history");


        l=new JLabel("YOUR TRANSACTION HISTORY");
        l.setBounds(120,20,400,20);
        l.setFont(new Font("Raleway",Font.BOLD,18));
        l.setForeground(Color.BLACK);
        f.add(l);

        String[] columnNames = {"Transaction Date", "Transaction Amount", "Transaction Type"};
        Object[][] data = fetchTransactionData(PIN); // Extract data fetching logic

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        scrollPane.setBounds(40, 50, 500, 450);

        f.add(scrollPane, BorderLayout.CENTER);
        // ... rest of your frame setup ...

        b=new JButton("Back");
        b.setBounds(230,520,100,25);
        b.setFont(new Font("Raleway",Font.BOLD,18));
        b.setForeground(Color.WHITE);
        b.setBackground(Color.BLACK);
        b.addActionListener(this);
        f.add(b);

        f.setVisible(true);
    }

    // ... other methods ...

    private Object[][] fetchTransactionData(String PIN) {
        Conn c = new Conn();
        // Fetch data from the database and return it as a 2D array
        // Make sure to properly handle data types and SQL queries
        // For example:
        Object[][] data = new Object[100][3];
        int rowCount = 0;
        try {
            String q = "SELECT * FROM BANK_TRANS WHERE PIN='" + PIN + "'";
            ResultSet r = c.statement1.executeQuery(q);
            while (r.next()) {
                data[rowCount][0] = r.getString("transaction_date");
                data[rowCount][1] = r.getInt("transaction_amount");
                data[rowCount][2] = r.getString("transaction_type");
                rowCount++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // Resize the data array to match the actual number of rows fetched
        return Arrays.copyOf(data, rowCount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            new Main_Class(PIN);
            f.setVisible(false);
        }
    }

    public static void main(String[] args) {
        //SwingUtilities.invokeLater(() -> {
           new stat(""); // Pass a valid PIN
        //});

    }
}
