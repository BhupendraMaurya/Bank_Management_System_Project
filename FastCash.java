
package bank.management.system;
import javax.swing.*;// for jframe
import java.awt.*; // for image
import java.awt.event.*; // for action listener
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    // creating all buttons globally bcz I want to access them in actionPerformed method
    JButton deposit, withdrawal, ministatement, pinchange, fastcash, balanceenquiry,exit;
    
    String pinnumber;
    FastCash(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210, 300, 700, 35);// upr wali line ke location aur size ke liye
        text.setForeground(Color.WHITE); 
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text); // ye text hmare image ke upr aayega, agr sirf add(text) krenge to frame ke upr aayega aur image pr ni dikhega
        
        
        deposit = new JButton(" Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this); // to perform ssome action by clicking this button
        image.add(deposit);
        
        withdrawal = new JButton("Rs 500");
        withdrawal.setBounds(355,415,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        
        exit = new JButton("BACK");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(900, 900); // to make frame 
        setLocation(300, 0);
        setUndecorated(true); // frame ke upr thoda sa white white h to usko htane ke liye
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+ amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}
