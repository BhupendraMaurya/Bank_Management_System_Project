package bank.management.system;

import java.sql.*;

public class Conn {

    // making object of Connection class
    Connection c;

    Statement s;

    public Conn() {
        // doing exception handling to avoid run time error; bcz mysql is an external entity and it can generate errors
        try {

            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "Bhupendra@123");
            // below code is same as above line
            // jdbc:mysql://localhost:3306/bankmanagementsystem
            
            
            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
