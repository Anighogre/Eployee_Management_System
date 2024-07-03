package employee.management.system;

import java.awt.*; // bg color
import javax.swing.*; // jframe
import java.awt.event.*; // actionlistener
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JLabel lblempId;
    JButton add, back;
    String empId;
    
    // declare all globally
    JTextField tfeducation, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    
    UpdateEmployee (String empId) {
        this.empId = empId;
        // set bg for frame 3
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // make a heading on frame 4
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);  // position of heading
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        // to get basic information make some labels 5
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        // make  a JLabel uneditable we cannot change name
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150,30);
        add(lblname);
        
        // to get basic information make some labels 7
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        // in front of name make a textfield 8
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150,30);
        add(tffname);
        
        // to get basic information make some labels 9
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        // make  a JLabel uneditable we cannot change dob
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        // to get basic information make some labels 11
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        // in front of name make a textfield 12
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150,30);
        add(tfsalary);
        
        // to get basic information make some labels 13
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        // in front of name make a textfield 14
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150,30);
        add(tfaddress);
        
        // to get basic information make some labels 15
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        // in front of name make a textfield 16
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150,30);
        add(tfphone);
        
        // to get basic information make some labels 17
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        // in front of name make a textfield 18
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150,30);
        add(tfemail);
        
        
        // to get basic information make some labels 19
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        
        // in front of name make a Dropdown 20
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150,30);
        add(tfeducation);
        
         // to get basic information make some labels 22
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        // in front of name make a textfield 23
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150,30);
        add(tfdesignation);
        
        // to get basic information make some labels 24
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        // aadhar no also can not change 
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150,30);
        add(lblaadhar);
        
        // make employee id the id is unique generate random number 26
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // make buttons 28
        add = new JButton("Update Details"); // afor adding employee button 
        add.setBounds(250, 500, 150, 40);  // set the button size 
        add.addActionListener(this); // when click on this button action will be performed 
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);  // button adding on the image 
        
        back = new JButton("Back"); // afor adding employee button
        back.setBounds(450, 500, 150, 40);  // set the button size 
        back.addActionListener(this); // when click on this button action will be performed 
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);  // button adding on the image 
        
        // make a frame 2
        setSize(900, 630);
        setLocation(260, 50);
        setVisible(true);
    }

    UpdateEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    // override the method of actionlistener 29
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
//            String name = tfname.getText();
            String fname = tffname.getText();
//            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
//            String aadhar = tfaadhar.getText();
//            String empId = lblempId.getText();
            
            // after the getting all values store these values in database 30
            try {
                Conn conn = new Conn(); // make Conn class object
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone =  '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'"; // write mysql updatate query
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new UpdateEmployee(""); // create anonymous object 1
    }
    

}
`package employee.management.system;

import java.awt.*; // bg color
import javax.swing.*; // jframe
import java.awt.event.*; // actionlistener
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JLabel lblempId;
    JButton add, back;
    String empId;
    
    // declare all globally
    JTextField tfeducation, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    
    UpdateEmployee (String empId) {
        this.empId = empId;
        // set bg for frame 3
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // make a heading on frame 4
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);  // position of heading
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        // to get basic information make some labels 5
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        // make  a JLabel uneditable we cannot change name
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150,30);
        add(lblname);
        
        // to get basic information make some labels 7
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        // in front of name make a textfield 8
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150,30);
        add(tffname);
        
        // to get basic information make some labels 9
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        // make  a JLabel uneditable we cannot change dob
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        // to get basic information make some labels 11
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        // in front of name make a textfield 12
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150,30);
        add(tfsalary);
        
        // to get basic information make some labels 13
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        // in front of name make a textfield 14
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150,30);
        add(tfaddress);
        
        // to get basic information make some labels 15
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        // in front of name make a textfield 16
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150,30);
        add(tfphone);
        
        // to get basic information make some labels 17
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        // in front of name make a textfield 18
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150,30);
        add(tfemail);
        
        
        // to get basic information make some labels 19
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        
        // in front of name make a Dropdown 20
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150,30);
        add(tfeducation);
        
         // to get basic information make some labels 22
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        // in front of name make a textfield 23
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150,30);
        add(tfdesignation);
        
        // to get basic information make some labels 24
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        // aadhar no also can not change 
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150,30);
        add(lblaadhar);
        
        // make employee id the id is unique generate random number 26
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // make buttons 28
        add = new JButton("Update Details"); // afor adding employee button 
        add.setBounds(250, 500, 150, 40);  // set the button size 
        add.addActionListener(this); // when click on this button action will be performed 
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);  // button adding on the image 
        
        back = new JButton("Back"); // afor adding employee button
        back.setBounds(450, 500, 150, 40);  // set the button size 
        back.addActionListener(this); // when click on this button action will be performed 
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);  // button adding on the image 
        
        // make a frame 2
        setSize(900, 630);
        setLocation(260, 50);
        setVisible(true);
    }

    UpdateEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    // override the method of actionlistener 29
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
//            String name = tfname.getText();
            String fname = tffname.getText();
//            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
//            String aadhar = tfaadhar.getText();
//            String empId = lblempId.getText();
            
            // after the getting all values store these values in database 30
            try {
                Conn conn = new Conn(); // make Conn class object
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone =  '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'"; // write mysql updatate query
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new UpdateEmployee(""); // create anonymous object 1
    }
    

}
package employee.management.system;

import java.awt.*; // bg color
import javax.swing.*; // jframe
import java.awt.event.*; // actionlistener
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JLabel lblempId;
    JButton add, back;
    String empId;
    
    // declare all globally
    JTextField tfeducation, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    
    UpdateEmployee (String empId) {
        this.empId = empId;
        // set bg for frame 3
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // make a heading on frame 4
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);  // position of heading
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        // to get basic information make some labels 5
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        // make  a JLabel uneditable we cannot change name
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150,30);
        add(lblname);
        
        // to get basic information make some labels 7
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        // in front of name make a textfield 8
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150,30);
        add(tffname);
        
        // to get basic information make some labels 9
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        // make  a JLabel uneditable we cannot change dob
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        // to get basic information make some labels 11
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        // in front of name make a textfield 12
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150,30);
        add(tfsalary);
        
        // to get basic information make some labels 13
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        // in front of name make a textfield 14
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150,30);
        add(tfaddress);
        
        // to get basic information make some labels 15
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        // in front of name make a textfield 16
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150,30);
        add(tfphone);
        
        // to get basic information make some labels 17
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        // in front of name make a textfield 18
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150,30);
        add(tfemail);
        
        
        // to get basic information make some labels 19
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        
        // in front of name make a Dropdown 20
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150,30);
        add(tfeducation);
        
         // to get basic information make some labels 22
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        // in front of name make a textfield 23
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150,30);
        add(tfdesignation);
        
        // to get basic information make some labels 24
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        // aadhar no also can not change 
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150,30);
        add(lblaadhar);
        
        // make employee id the id is unique generate random number 26
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // make buttons 28
        add = new JButton("Update Details"); // afor adding employee button 
        add.setBounds(250, 500, 150, 40);  // set the button size 
        add.addActionListener(this); // when click on this button action will be performed 
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);  // button adding on the image 
        
        back = new JButton("Back"); // afor adding employee button
        back.setBounds(450, 500, 150, 40);  // set the button size 
        back.addActionListener(this); // when click on this button action will be performed 
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);  // button adding on the image 
        
        // make a frame 2
        setSize(900, 630);
        setLocation(260, 50);
        setVisible(true);
    }

    UpdateEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    // override the method of actionlistener 29
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
//            String name = tfname.getText();
            String fname = tffname.getText();
//            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
//            String aadhar = tfaadhar.getText();
//            String empId = lblempId.getText();
            
            // after the getting all values store these values in database 30
            try {
                Conn conn = new Conn(); // make Conn class object
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone =  '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'"; // write mysql updatate query
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new UpdateEmployee(""); // create anonymous object 1
    }
    

}
package employee.management.system;

import java.awt.*; // bg color
import javax.swing.*; // jframe
import java.awt.event.*; // actionlistener
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JLabel lblempId;
    JButton add, back;
    String empId;
    
    // declare all globally
    JTextField tfeducation, tffname, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
    
    UpdateEmployee (String empId) {
        this.empId = empId;
        // set bg for frame 3
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // make a heading on frame 4
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);  // position of heading
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        // to get basic information make some labels 5
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        // make  a JLabel uneditable we cannot change name
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150,30);
        add(lblname);
        
        // to get basic information make some labels 7
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);
        
        // in front of name make a textfield 8
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150,30);
        add(tffname);
        
        // to get basic information make some labels 9
        JLabel labeldob = new JLabel("Date Of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);
        
        // make  a JLabel uneditable we cannot change dob
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        // to get basic information make some labels 11
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);
        
        // in front of name make a textfield 12
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150,30);
        add(tfsalary);
        
        // to get basic information make some labels 13
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        // in front of name make a textfield 14
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150,30);
        add(tfaddress);
        
        // to get basic information make some labels 15
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);
        
        // in front of name make a textfield 16
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150,30);
        add(tfphone);
        
        // to get basic information make some labels 17
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);
        
        // in front of name make a textfield 18
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150,30);
        add(tfemail);
        
        
        // to get basic information make some labels 19
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        
        // in front of name make a Dropdown 20
        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150,30);
        add(tfeducation);
        
         // to get basic information make some labels 22
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);
        
        // in front of name make a textfield 23
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150,30);
        add(tfdesignation);
        
        // to get basic information make some labels 24
        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);
        
        // aadhar no also can not change 
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150,30);
        add(lblaadhar);
        
        // make employee id the id is unique generate random number 26
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // make buttons 28
        add = new JButton("Update Details"); // afor adding employee button 
        add.setBounds(250, 500, 150, 40);  // set the button size 
        add.addActionListener(this); // when click on this button action will be performed 
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);  // button adding on the image 
        
        back = new JButton("Back"); // afor adding employee button
        back.setBounds(450, 500, 150, 40);  // set the button size 
        back.addActionListener(this); // when click on this button action will be performed 
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);  // button adding on the image 
        
        // make a frame 2
        setSize(900, 630);
        setLocation(260, 50);
        setVisible(true);
    }

    UpdateEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    // override the method of actionlistener 29
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add) {
//            String name = tfname.getText();
            String fname = tffname.getText();
//            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
//            String aadhar = tfaadhar.getText();
//            String empId = lblempId.getText();
            
            // after the getting all values store these values in database 30
            try {
                Conn conn = new Conn(); // make Conn class object
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone =  '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"'"; // write mysql updatate query
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]) {
        new UpdateEmployee(""); // create anonymous object 1
    }
    

}

