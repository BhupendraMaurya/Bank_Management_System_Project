
package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;// package for dates
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female,transgender,married,unmarried,other;
    JDateChooser datechooser;
    
    
    SignupOne(){
        
        
        setLayout(null);
        
        Random ran = new Random();
        random = (Math.abs((ran.nextLong() % 9000L )+ 1000L));
        
        
        JLabel formno = new JLabel("Application Form No: " +random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);
        
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,22));
        name.setBounds(100,140,240,30);
        add(name);   
        
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raileway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
               
        JLabel fname = new JLabel("Fathers Name:");
        fname.setFont(new Font("Raleway", Font.BOLD,22));
        fname.setBounds(100,190,240,30);
        add(fname); 
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raileway",Font.BOLD,14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD,22));
        dob.setBounds(100,240,240,30);
        add(dob); 
        
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300,240,400,30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(100,290,240,30);
        add(gender); 
        
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Femle");
        female.setBounds(430,290,60,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        
        transgender = new JRadioButton("Transgender");
        transgender.setBounds(560,290,100,30);
        transgender.setBackground(Color.WHITE);
        add(transgender);
        
        
        // for single single, if will not use, then we will be able to click on multiple
        // button, but with the help of this, we can click on any single button
        ButtonGroup gendergroup = new ButtonGroup();  
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(transgender);
        
        
        JLabel email = new JLabel("Email Adress:");
        email.setFont(new Font("Raleway", Font.BOLD,22));
        email.setBounds(100,340,240,30);
        add(email); 
        
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raileway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD,22));
        marital.setBounds(100,390,240,30);
        add(marital); 
        
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("UnMarried");
        unmarried.setBounds(430,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        
        other = new JRadioButton("Other");
        other.setBounds(560,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
                
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(100,440,240,30);
        add(address); 
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raileway",Font.BOLD,14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        
        
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100,490,240,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raileway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100,540,240,30);
        add(state); 
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raileway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD,22));
        pincode.setBounds(100,590,240,30);
        add(pincode); 
        
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raileway",Font.BOLD,14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,650,80,30);
        next.addActionListener(this);// validation, iske dwara hum kisi bhi feild ko not null bna skte h, mtlb khali ni chhod skte.
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String formno = String.valueOf(random);// random is long so typecasting it.
        String name = nameTextField.getText();// with the help of getText(), text feilds me se value ko nikal skte h.
        String fname = fnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } 
        else if(female.isSelected()){
            gender = "Female";
        }
        
        
        String email = emailTextField.getText();
        String marital  = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "UnMarried";
        }
        else if(other.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception ee){
            System.out.println(ee);
        }
        
    }
    
    
    public static void main(String args[]){
        new SignupOne();
    }
}
