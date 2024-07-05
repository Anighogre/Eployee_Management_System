    //JDBC connection take 5 steps
    // 1.Register the driver class
    // 2.Creating the  connection string
    // 3.creating statement
    // 4.executing mysql queries
    // 5.Closing the connectionpackage employee.management.system;
package employee.management.system;

import java.sql.*; // for connection

public class Conn {
    // 2.Creating the  connection string
    Connection c; // 5
    
    // 3.creating statement
    Statement s; // 7

    public Conn () {
        try {  // 1
            // 1.Register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver"); // attach mysql driver 2 
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "Anirudh@#2002");  // make a connection string 6
            s = c.createStatement();
        }catch (Exception e) { // 3
            e.printStackTrace(); // 4
        }
    }
}

