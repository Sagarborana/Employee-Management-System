/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    
    JTextField educationtf, fnametf, aadhartf, emailtf, phonetf, salarytf, addresstf, designationtf;
    JButton add, back;
    JLabel empID;
    String employeeID;
    
    UpdateEmployee(String employeeID){
        
        this.employeeID = employeeID;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(50,150,150,30);
        namelbl.setFont(new Font("serif",Font.PLAIN,20));
        add(namelbl);
        
        JLabel name = new JLabel();
        name.setBounds(200,150,150,30);
        add(name);
        
        JLabel fnamelbl = new JLabel("Father's Name");
        fnamelbl.setBounds(400,150,150,30);
        fnamelbl.setFont(new Font("serif",Font.PLAIN,20));
        add(fnamelbl);
        
        fnametf = new JTextField();
        fnametf.setBounds(600,150,150,30);
        add(fnametf);
        
        JLabel doblbl = new JLabel("Date of Birth");
        doblbl.setBounds(50,200,150,30);
        doblbl.setFont(new Font("serif",Font.PLAIN,20));
        add(doblbl);
        
        JLabel dob = new JLabel();
        dob.setBounds(200,200,150,30);
        add(dob);
        
        JLabel salarylbl = new JLabel("Salary");
        salarylbl.setBounds(400,200,150,30);
        salarylbl.setFont(new Font("serif",Font.PLAIN,20));
        add(salarylbl);
        
        salarytf = new JTextField();
        salarytf.setBounds(600,200,150,30);
        add(salarytf);
        
        JLabel addresslbl = new JLabel("Address");
        addresslbl.setBounds(50,250,150,30);
        addresslbl.setFont(new Font("serif",Font.PLAIN,20));
        add(addresslbl);
        
        addresstf = new JTextField();
        addresstf.setBounds(200,250,150,30);
        add(addresstf);
        
        JLabel phonelbl = new JLabel("Phone Number");
        phonelbl.setBounds(400,250,150,30);
        phonelbl.setFont(new Font("serif",Font.PLAIN,20));
        add(phonelbl);
        
        phonetf = new JTextField();
        phonetf.setBounds(600,250,150,30);
        add(phonetf);
        
        JLabel emaillbl = new JLabel("Email");
        emaillbl.setBounds(50,300,150,30);
        emaillbl.setFont(new Font("serif",Font.PLAIN,20));
        add(emaillbl);
        
        emailtf = new JTextField();
        emailtf.setBounds(200,300,150,30);
        add(emailtf);
        
      
        JLabel educationlbl = new JLabel("Highest Education");
        educationlbl.setBounds(400,300,150,30);
        educationlbl.setFont(new Font("serif",Font.PLAIN,20));
        add(educationlbl);
        
        educationtf = new JTextField();
        educationtf.setBackground(Color.WHITE);
        educationtf.setBounds(600,300,150,30);
        add(educationtf);
        
        JLabel designationlbl = new JLabel("Designation");
        designationlbl.setBounds(50,350,150,30);
        designationlbl.setFont(new Font("serif",Font.PLAIN,20));
        add(designationlbl);
        
        designationtf = new JTextField();
        designationtf.setBounds(200,350,150,30);
        add(designationtf);
        
        JLabel aadharlbl = new JLabel("Aadhar Number");
        aadharlbl.setBounds(400,350,150,30);
        aadharlbl.setFont(new Font("serif",Font.PLAIN,20));
        add(aadharlbl);
        
        JLabel aadhar = new JLabel();
        aadhar.setBounds(600,350,150,30);
        add(aadhar);
        
        
        JLabel empIDlbl = new JLabel("Employee ID");
        empIDlbl.setBounds(50,400,150,30);
        empIDlbl.setFont(new Font("serif",Font.PLAIN,20));
        add(empIDlbl);
        
        empID = new JLabel();
        empID.setBounds(200,400,150,30);
        empID.setFont(new Font("serif",Font.PLAIN,20));
        add(empID);
        
        try{
            Conn c = new Conn();
            String query = "select * from employee where empID = '"+employeeID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                name.setText(rs.getString("name"));
                fnametf.setText(rs.getString("fname"));
                dob.setText(rs.getString("dob"));
                salarytf.setText(rs.getString("salary"));
                addresstf.setText(rs.getString("address"));
                phonetf.setText(rs.getString("phone"));
                emailtf.setText(rs.getString("email"));
                educationtf.setText(rs.getString("education"));
                designationtf.setText(rs.getString("designation"));
                aadhar.setText(rs.getString("aadhar"));
                empID.setText(rs.getString("empID"));
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
          
            String fname = fnametf.getText();
            String salary = salarytf.getText();
            String address = addresstf.getText();
            String phone = phonetf.getText();
            String email = emailtf.getText();
            String education = educationtf.getText();
            String designation = designationtf.getText();
            
            
            try{
                Conn conn = new Conn();
                String query = "update employee set fname='"+fname+"',salary = '"+salary+"',address ='"+address+"',phone ='"+phone+"',email ='"+email+"',education ='"+education+"',designation ='"+designation+"' where empID='"+employeeID+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated SuccesFully");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new UpdateEmployee("");
    }
}
