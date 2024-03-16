package unit2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private Container c;
    private JButton b1,b2,b3,b4;
    private JLabel l1,l2,l3;
    private JTextField t1, t2;
    public Calculator()
    {
        setTitle("Calculator");
        setSize(500,700);
        setLocation(700,200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        l1 = new JLabel("First Number");
        l1.setBounds(10,10,100,30);
        c.add(l1);
        t1 = new JTextField();
        t1.setBounds(110,10,100,30);
        c.add(t1);
        l2 = new JLabel("Second Number");
        l2.setBounds(10,50,100,30);
        c.add(l2);
        t2 = new JTextField();
        t2.setBounds(110,50,100,30);
        c.add(t2);
        b1 = new JButton("+");
        b1.setBounds(10,90,100,30);
        c.add(b1);
        b1.addActionListener(this);
        b2 = new JButton("-");
        b2.setBounds(120,90,100,30);
        c.add(b2);
        b2.addActionListener(this);
        b3 = new JButton("*");
        b3.setBounds(230,90,100,30);
        c.add(b3);
        b3.addActionListener(this);
        b4 = new JButton("/");
        b4.setBounds(340,90,100,30);
        c.add(b4);
        b4.addActionListener(this);
        l3 = new JLabel();
        l3.setBounds(10,130,100,30);
        c.add(l3);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        int a = Integer.parseInt(t1.getText());
        int b = Integer.parseInt(t2.getText());
        int c;
        String s = e.getActionCommand();
        if(s.equals("+"))
        {
            c = a+b;
            l3.setText("Sum = " +c);
        }
        else if(s.equals("-"))
        {
            c = a-b;
            l3.setText("Subtraction = " +c);
        }
        else if(s.equals("*"))
        {
            c = a*b;
            l3.setText("Multiply = " +c);
        }
        else
        {
            c = a/b;
            l3.setText("Divide = " +c);
        }


    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
}
