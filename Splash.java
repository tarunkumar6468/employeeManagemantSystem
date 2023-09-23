import javax.swing.*;    // to create the panel
import java.awt.*;       // to change the panel color

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;     // use for connect for login page and we use this Interface @ActionListener event
import java.nio.channels.CancelledKeyException;


public class Splash extends JFrame  implements ActionListener {
     Splash(){
          getContentPane().setBackground(Color.white); // Background color change
          setLayout(null);


         JLabel heading = new JLabel(" EMPLOYEE MANAGEMENT SYSTEM");// to insert heading but not show
         heading.setBounds(80,30,1200,60);//heading control
         heading.setFont(new Font("sarif",Font.PLAIN,60));
         heading.setForeground(Color.BLACK);
         add(heading);           // to showing heading above panel


         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/14117805.jpg"));   // to showing the image into panel
         Image i2= i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);   // set the size the of image
         ImageIcon i3= new ImageIcon(i2);  //
         JLabel image = new JLabel(i3);
         image.setBounds(50,100,1050, 500); // set the bounds of the image
         add(image); // show the image


         JButton clickhere = new JButton("CLICK HERE TO CONTINUE"); // to create the button and name showing is click hare to continue
         clickhere.setBounds(400,400,300,70); // size of the button
         clickhere.setBackground(Color.BLACK);
         clickhere.setForeground(Color.WHITE);
         clickhere.addActionListener(this);
         image.add(clickhere);


        setSize(1170, 650); // create a panel
        setLocation(200, 50);  // location set for visibility
        setVisible(true); // boolean type and give the permission for show the panel

        while (true){
            heading.setVisible(false);
            try{
                    Thread.sleep(1000);
            } catch (Exception e){

            }
            heading.setVisible(true);
            try{
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }

     }


     // Class 'Splash' must either be declared abstract or implement abstract method 'actionPerformed(ActionEvent)' in 'ActionListener'
    public  void  actionPerformed (ActionEvent ae){
           setVisible(false);
           new Login();
          }

    public static void main(String[] args) {
         new Splash();
    }
}
