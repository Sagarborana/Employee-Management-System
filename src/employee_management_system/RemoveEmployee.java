/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice empIdc;
    JButton delete, back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel empidlbl = new JLabel("Employee ID");
        empidlbl.setBounds(50,50,100,30);
        add(empidlbl);
        
        empIdc = new Choice();
        empIdc.setBounds(200,50,150,30);
        add(empIdc);
        
        try{
                Conn c= new Conn();
                String query = "select * from employee";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    empIdc.add(rs.getString("empID"));
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        JLabel namelbl = new JLabel("Name");
        namelbl.setBounds(50,100,100,30);
        add(namelbl);
        
        JLabel name = new JLabel();
        name.setBounds(200,100,100,30);
        add(name);
        
        JLabel phonelbl = new JLabel("Phone");
        phonelbl.setBounds(50,150,100,30);
        add(phonelbl);
        
        JLabel phone = new JLabel();
        phone.setBounds(200,150,100,30);
        add(phone);
        
        JLabel emaillbl = new JLabel("Email");
        emaillbl.setBounds(50,200,100,30);
        add(emaillbl);
        
        JLabel email = new JLabel();
        email.setBounds(200,200,100,30);
        add(email);
        
        try{
                Conn c= new Conn();
                String query = "select * from employee where empID = '"+empIdc.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    name.setText(rs.getString("name"));
                    phone.setText(rs.getString("phone"));
                    email.setText(rs.getString("email"));
                    
                }
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        empIdc.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c= new Conn();
                    String query = "select * from employee where empID = '"+empIdc.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        name.setText(rs.getString("name"));
                        phone.setText(rs.getString("phone"));
                        email.setText(rs.getString("email"));

                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600,400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empID ='"+empIdc.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Details Deleted SuccessFully");
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
        new RemoveEmployee();
    }
}
