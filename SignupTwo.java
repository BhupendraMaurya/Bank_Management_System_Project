
package bank.management.system;



import javax.swing.*;
import java.awt.*;
//import java.util.*;
//import com.toedter.calendar.JDateChooser;// package for dates
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        
        
        JLabel additionalDetails = new JLabel("Page 2: Additional details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        
        JLabel name = new JLabel("Religion");
        name.setFont(new Font("Raleway", Font.BOLD,22));
        name.setBounds(100,140,240,30);
        add(name);  
        
        // for dropdown 
        String valReligion[] = { "Hindu", "Muslim","Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
       
        
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD,22));
        fname.setBounds(100,190,240,30);
        add(fname); 
        
        
        String valCategory[] = {"General","Obc","SC", "ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD,22));
        dob.setBounds(100,240,240,30);
        add(dob); 
        
        
        String incomeCategory[] = {"Null","< 150000","250000", "<50000","upto 1000000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        
        
        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD,22));
        gender.setBounds(100,290,240,30);
        add(gender); 
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD,22));
        email.setBounds(100,315,240,30);
        add(email); 
       
        
        String educationValues[] = {"NonGraduation","Graduation","PostGraduate", "PHD","Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel pincode = new JLabel("Occupation:");
        pincode.setFont(new Font("Raleway", Font.BOLD,22));
        pincode.setBounds(100,390,240,30);
        add(pincode);
        
        
        String occupationValues[] = {"Salaried","Self-Employed","BusinessMan", "Student","Retired","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        JLabel marital = new JLabel("PAN Number:");
        marital.setFont(new Font("Raleway", Font.BOLD,22));
        marital.setBounds(100,450,240,30);
        add(marital);
        
        
        pan = new JTextField();
        pan.setFont(new Font("Raileway",Font.BOLD,14));
        pan.setBounds(300,450,400,30);
        add(pan);
        
        
        JLabel address = new JLabel("Aadhar Number:");
        address.setFont(new Font("Raleway", Font.BOLD,22));
        address.setBounds(100,490,240,30);
        add(address); 
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raileway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        JLabel city = new JLabel("Senior Citizen:");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100,540,240,30);
        add(city);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(430,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
        
        JLabel state = new JLabel("Existing Account:");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100,590,240,30);
        add(state); 
        
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(430,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
        
        
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
    
    public void actionPerformed(ActionEvent e){
        
        String sreligion = (String)religion.getSelectedItem();// to get vlues from dropdwon and returns object so typecasting it
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        } 
        else if(sno.isSelected()){
            seniorcitizen = "No";
        }
      
        String existingAccount  = null;
        if(eyes.isSelected()){
            existingAccount = "Yes";
        }
        else if(eno.isSelected()){
            existingAccount = "No";
        }
        
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        
        
        try{
            
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
                
                
                //signup 3 object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
        }catch(Exception ee){
            System.out.println(ee);
        }
        
    }
    
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}

