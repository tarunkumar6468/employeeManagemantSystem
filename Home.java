import javax.swing.*;
import java.awt.*; // image insert  in package
import java.awt.event.*;

public class Home extends JFrame  implements ActionListener { // to create the frame  using frame
      JButton view,add,update,remove;
    Home(){

         setLayout(null);

         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/1669399486857.jpg"));   // to showing the image into panel
         Image i2= i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);   // set the size the of image
         ImageIcon i3= new ImageIcon(i2);  //
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,1120, 630); // set the bounds of the image
         add(image); // show the image

         JLabel heading = new JLabel("Employee Management System");
         heading.setBounds(50,20,400,40);
         heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Railway",Font.BOLD,25));
         image.add(heading);

         add = new JButton("Add Employee");
         add.setBackground(Color.BLACK);
         add.setForeground(Color.WHITE);
         add.setBounds(50,80,150,40);
         add.addActionListener(this);
         image.add(add);

         view = new JButton("View Employees");
         view.setBackground(Color.BLACK);
         view.setForeground(Color.WHITE);
         view.setBounds(300,80,150,40);
         view.addActionListener(this);
         image.add(view);

         update = new JButton("update Employee");
         update.setBackground(Color.BLACK);
         update.setForeground(Color.WHITE);;
         update.setBounds(50,140,150,40);
         update.addActionListener(this);
         image.add(update);

          remove = new JButton("Remove Employee");
          remove.setBackground(Color.BLACK);
          remove.setForeground(Color.WHITE);
          remove.setBounds(300,140,150,40);
          remove.addActionListener(this);
         image.add(remove);


      setSize(1120,630);  // frame create
      setVisible(true); // frame visible
      setLocation(250,100); // location on screen to open
     }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource() == view){
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new ViewEmployee();
        }
        else if (ae.getSource() == remove){
            setVisible(false);
        new RemoveEmployee();


        }
    }

    public static void main(String[] args){
    new Home();

    }
}
