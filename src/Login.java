import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileOutputStream;
public class Login extends JFrame implements ActionListener {
    private Container c;
    private JLabel l1,l2,l3;
    private JTextField t1;
    private JPasswordField t2;
    private JButton b1;
    Login()
    {
        setTitle("Login");
        setSize(500,700);
        setLocation(700,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        l1 = new JLabel("Username");
        l1.setBounds(10,10,100,30);
        c.add(l1);
        t1 = new JTextField();
        t1.setBounds(110,10,100,30);
        c.add(t1);
        l2 = new JLabel("Password");
        l2.setBounds(10,50,100,30);
        c.add(l2);
        t2 = new JPasswordField();
        t2.setBounds(110,50,100,30);
        c.add(t2);
        b1 = new JButton("Submit");
        b1.setBounds(110,100,100,30);
        b1.addActionListener(this);
        c.add(b1);
        l3 = new JLabel();
        l3.setBounds(10,150,100,30);
        c.add(l3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String n = t1.getText();
        char[] pass = t2.getPassword();
        try
        {
            FileOutputStream fout = new FileOutputStream("DB.txt");
            String s = "Name: " +n +"\nPassword: " +pass;
            byte b[]= s.getBytes();
            fout.write(b);
            fout.close();
            l3.setText("Success");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        Login l = new Login();
    }
}
