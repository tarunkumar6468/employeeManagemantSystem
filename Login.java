import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener {

     // create a login page using JFrame
             JTextField  tfusername,tfpassword;
         Login (){ // create a method
             getContentPane().setBackground(Color.WHITE);  // getContentPane using and set color
             setLayout(null);     // layout type  is null


             JLabel lblusername = new JLabel("Username");    // here we use a one variable and new JLabel in  give What is showing in panel upe side
             lblusername.setBounds(40, 20,100,30);   // set a bounds for give four perameter
             add(lblusername);    // add  keyword use and give variable and show

             // texting generating for user name

              tfusername = new JTextField();  // create a second perameter  name is password for entering purpose
             tfusername.setBounds(150, 20,150,30);
             add(tfusername);

             JLabel lblpassword = new JLabel("Password");
             lblpassword.setBounds(40, 70,100,30);
             add(lblpassword);

             // texting generating for password  box
             tfpassword = new JTextField();  // create a second perameter  name is password for entering purpose
             tfpassword.setBounds(150, 70,150,30);
             add(tfpassword);


             // login button create

             JButton loginuser = new JButton("Login"); // to create the button and name showing is click hare to continue
             loginuser.setBounds(150,140,150,30); // size of the button
             loginuser.setBackground(Color.BLACK);
             loginuser.setForeground(Color.WHITE);
             loginuser.addActionListener(this); // ye btaye ki apke buttoin pr click hua h
             add(loginuser);

             //  image create  on the login page
             ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/14117805.jpg"));   // to showing the image into panel
             Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);   // set the size the of image
             ImageIcon i3= new ImageIcon(i2);  //
             JLabel image = new JLabel(i3);
             image.setBounds(350,0,200, 200); // set the bounds of the image
             add(image); // show the image

             setSize(600,300);
             setLocation(450,200);
             setVisible(true);
         }
         public   void actionPerformed(ActionEvent ae){ //  for any panel  data to go and receive
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();


                     Conn c = new Conn();  //  constructor call for Conn class
                // because we have not executeQuery function call so that's why wu use this function over here
                 String query = "select * from login where username = '"+ username+"' and password = '"+password+"'"; //  iska kam h check krna user or password name sahi h ya ni

                ResultSet rs= c.s.executeQuery(query);  // return the value get or not or get than what is that or not it's correct or note and store
                if(rs.next()){
                    setVisible(false);
                    // next class
                         new Home();
                }else{

                    JOptionPane.showMessageDialog(null,"invalid  username or password ");
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
