import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame  implements ActionListener {
     Random ran =  new Random();
     int number = ran.nextInt(999999);

     JTextField tfname,tffname, tfdob,tfsalary,tfPhone,tfaddress, tfemail,tfadhar,tfdesignation ;

    JComboBox cbeductaion;
    JDateChooser dcdob;
    JLabel lblempId;
     JButton add,back;

    AddEmployee(){

         getContentPane().setBackground(Color.WHITE);
         setLayout(null);

         JLabel heading = new JLabel("Add Employee Detail");
         heading.setBounds(320,30,500,50);
         heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
         add(heading);


         JLabel lebelname = new JLabel("Name");
         lebelname.setBounds(50,150,150,30);
         lebelname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
         add(lebelname);

          tfname = new JTextField();
         tfname.setBounds(200,150,150,30);
         add(tfname);


        JLabel lebelfname = new JLabel("Father's Name");
        lebelfname.setBounds(400,150,150,30);
        lebelfname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebelfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);


        JLabel lebeldob = new JLabel("Date Of Birth");
        lebeldob.setBounds(50,200,150,30);
        lebeldob.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebeldob);

         tfdob = new JTextField();
        tfdob.setBounds(200,150,150,30);
        add(tfdob);

        // date of in calender selection
         dcdob = new JDateChooser();
         dcdob.setBounds(200,200,150,30);
         add(dcdob);

        JLabel lebelsalay = new JLabel("Salary");
        lebelsalay.setBounds(400,200,150,30);
        lebelsalay.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebelsalay);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel lebeladdress = new JLabel("Address");
        lebeladdress.setBounds(50,250,150,30);
        lebeladdress.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lebelphone = new JLabel("Phone");
        lebelphone.setBounds(400,250,150,30);
        lebelphone.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebelphone);

        tfPhone = new JTextField();
        tfPhone.setBounds(600,250,150,30);
        add(tfPhone);

        JLabel lebelemail = new JLabel("Email");
        lebelemail.setBounds(50,300,150,30);
        lebelemail.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebelemail);

       tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lebeledu = new JLabel("Highest Education");
        lebeledu.setBounds(400,300,150,30);
        lebeledu.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebeledu);

        String course[] = {"select","BBA","BCA","BA","BSC","B.COM","B-TECH","MCA","MBA","MA","M-TECH","MSC","PhD"};

        cbeductaion = new JComboBox(course);
        cbeductaion.setBackground(Color.WHITE);
        cbeductaion.setBounds(600,300,150,30);
        add(cbeductaion);



        JLabel lebeldesignation = new JLabel("Designation");
        lebeldesignation.setBounds(50,350,150,30);
        lebeldesignation.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel lebeladhar = new JLabel("Aadhaar NO");
        lebeladhar.setBounds(400,350,150,30);
        lebeladhar.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebeladhar);

        tfadhar = new JTextField();
        tfadhar.setBounds(600,350,150,30);
        add(tfadhar);

          JLabel lebelempID = new JLabel("EmployeeID");
        lebelempID.setBounds(50,400,150,30);
        lebelempID.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebelempID);

         lblempId = new JLabel(" "+number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lblempId);




         add = new JButton("Add Detail");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);



        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,50);
        setVisible(true);

    }
     public void actionPerformed(ActionEvent ae){
         if( ae.getSource() == add){
             String empName = tfname.getText();
             String fname = tffname.getText();
             String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
             String salary = tfsalary.getText();
             String address = tfaddress.getText();
             String phone = tfPhone.getText();
             String email = tfemail.getText();
             String education = (String) cbeductaion.getSelectedItem();
             String designation = tfdesignation.getText();
             String aadhar = tfadhar.getText();
             String employeeId = lblempId.getText();

             try{
                 Conn conn = new Conn();
                 String quary = "insert into employee values('"+empName+"', '"+fname+"', '"+dob+"' ,'"+salary+"' ,'"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+employeeId+"')";
                 conn.s.executeUpdate(quary);
                 JOptionPane.showMessageDialog(null,"Details added successfully");
                  setVisible(false);
                  new Home();
             }catch (Exception e){
                 e.printStackTrace();
             }


         } else{
             setVisible(false);
             new Home();
         }
     }
    public static void main(String[] args){
         new AddEmployee();
    }
}
