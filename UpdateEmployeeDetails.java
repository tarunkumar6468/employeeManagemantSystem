import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;

public class UpdateEmployeeDetails extends JFrame  implements ActionListener {


    JTextField tfeducation,tfname,tffname, tfdob,tfsalary,tfPhone,tfaddress, tfemail,tfadhar,tfdesignation ;

    JComboBox cbeductaion;

    JLabel lblempId,dcdob;
    JButton add,back;
    String employeeId;

    UpdateEmployeeDetails(String employeeId){

        this.employeeId = employeeId;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);


        JLabel lebelname = new JLabel("Name");
        lebelname.setBounds(50,150,150,30);
        lebelname.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);


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

       JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);

//         dcdob = new JLabel();
//        dcdob.setBounds(200,200,150,30);
//        add(dcdob);

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


       tfeducation= new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);



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

        JLabel lbladhar = new JLabel();
        lbladhar.setBounds(600,350,150,30);
        add(lbladhar);

        JLabel lebelempID = new JLabel("EmployeeID");
        lebelempID.setBounds(50,400,150,30);
        lebelempID.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lebelempID);
        lblempId = new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        add(lblempId);

        try{
            Conn c = new Conn();
            String query = "select * from employee where employeeId = '"+employeeId+"'";
             ResultSet rs = c.s.executeQuery(query);
             while(rs.next()){
                 lblname.setText(rs.getString("empName"));
                 tffname.setText(rs.getString("fname"));
                 lbldob.setText(rs.getString("dob"));
                 tfsalary.setText(rs.getString("salary"));
                 tfaddress.setText(rs.getString("address"));
                 tfPhone.setText(rs.getString("phone"));
                 tfemail.setText(rs.getString("email"));
                 tfeducation.setText(rs.getString("education"));
                 tfdesignation.setText(rs.getString("designation"));
                 lbladhar.setText(rs.getString("aadhar"));
                 lblempId.setText(rs.getString("employeeId"));


             }
        }
        catch (Exception e){
            e.printStackTrace();
        }



        add = new JButton("Update Detail");
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
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfPhone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();



            try{
                Conn conn = new Conn();
                String quary = "update employee set fname ='"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where employeeId = '"+employeeId+"'";
                conn.s.executeUpdate(quary);
                JOptionPane.showMessageDialog(null,"Details Updated successfully");
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

        new UpdateEmployeeDetails("");
    }
}

