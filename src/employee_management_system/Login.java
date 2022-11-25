/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField usernametf, passwordtf;
    
    Login(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel usernamelbl = new JLabel("Username");
        usernamelbl.setBounds(40,20,100,30);
        add(usernamelbl);
        
        usernametf = new JTextField();
        usernametf.setBounds(150,20,150,30);
        add(usernametf);
        
        JLabel passwordlbl = new JLabel("Password");
        passwordlbl.setBounds(40,70,100,30);
        add(passwordlbl);
        
        passwordtf = new JTextField();
        passwordtf.setBounds(150,70,150,30);
        add(passwordtf);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            String username = usernametf.getText();
            String password = passwordtf.getText();
            
            String query = "select * from login where username = '"+username+"' and password= '"+password+"'";
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
                
            }else{
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
