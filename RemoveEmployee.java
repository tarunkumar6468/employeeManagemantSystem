import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cEmpId;

    JButton Back , Delete;
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelEmpId = new JLabel("Employee Id");
        labelEmpId.setBounds(50,50,100,40);
        add(labelEmpId);

        cEmpId = new Choice();
        cEmpId.setBounds(200,50,150,30);
        add(cEmpId);

         try{
             Conn c = new Conn();
             String query ="select * from employee";
             ResultSet rs = c.s.executeQuery(query);
             while (rs.next()){
                 cEmpId.add(rs.getString("employeeId"));
             }
         }catch (Exception e){
             e.printStackTrace();
         }

        JLabel labelname = new JLabel("Name");
       labelname.setBounds(50,100,100,40);
        add(labelname);

        JLabel lblname= new JLabel();
        lblname.setBounds(200,100,100,40);
        add(lblname);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,40);
        add(labelphone);

        JLabel lblphone= new JLabel();
        lblphone.setBounds(200,150,100,40);
        add(lblphone);


        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,40);
        add(labelemail);

        JLabel lblemail= new JLabel();
        lblemail.setBounds(200,200,100,40);
        add(lblemail);


        try{
            Conn c = new Conn();
            String query ="select * from employee where employeeId = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
              lblname.setText(rs.getString("empName"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        cEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c = new Conn();
                    String query ="select * from employee where employeeId = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        lblname.setText(rs.getString("empName"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        Delete = new JButton("Delete");
        Delete.setBounds(80,300,100,30);
        Delete.setBackground(Color.BLACK);
        Delete.setForeground(Color.WHITE);
        Delete.addActionListener(this);
        add(Delete);


        Back = new JButton("Back");
        Back.setBounds(220,300,100,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        add(Back);


        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/remove.png"));   // to showing the image into panel
        Image i2= i1.getImage().getScaledInstance(400,200,Image.SCALE_DEFAULT);   // set the size the of image
        ImageIcon i3= new ImageIcon(i2);  //
        JLabel image = new JLabel(i3);
        image.setBounds(350,100,400, 200); // set the bounds of the image
        add(image);

        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
             if(ae.getSource() == Delete){
                 try{
                    Conn c = new Conn();
                    String query = "delete from employee where employeeId = '"+cEmpId.getSelectedItem()+"'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Information Delete Successfully");
                    setVisible(false);
                 }catch(Exception e){
                     e.printStackTrace();
                 }

             } else {
                 setVisible(false);
                 new Home();
             }

    }

    public static void main(String[] args){
        new RemoveEmployee();
    }
}
