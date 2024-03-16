import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Register extends JFrame implements ActionListener
{
    private Container c;
    private JLabel l1,l2,l3,l4,l5,l6,l7;
    private JTextField t1,t2,t3;
    private JComboBox d,m,y;
    private JRadioButton male,female;
    private JCheckBox c1;
    private JTextArea ad,op,res;
    private JButton b1;
    Register()
    {
        setTitle("Register Form");
        setSize(500,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = this.getContentPane();
        c.setLayout(null);
        l1 = new JLabel("Name:");
        l1.setBounds(10,10,100,30);
        c.add(l1);
        t1 = new JTextField();
        t1.setBounds(60,10,100,30);
        c.add(t1);
        l2 = new JLabel("Mobile:");
        l2.setBounds(10,50,100,30);
        c.add(l2);
        t2 = new JTextField();
        t2.setBounds(60,50,100,30);
        c.add(t2);
        l3 = new JLabel("DOB:");
        l3.setBounds(10,100,100,30);
        c.add(l3);
        y = new JComboBox();
        for(int a =0;a<=33;a++)
        {
            y.addItem(1990+a);
        }
        m = new JComboBox();
        for(int b =1;b<=12;b++)
        {
            m.addItem(b);
        }
        d = new JComboBox();
        for( int i =1;i<=30;i++)
        {
            d.addItem(i);
        }
        y.setBounds(60,100,60,30);
        m.setBounds(140,100,60,30);
        d.setBounds(220,100,60,30);
        c.add(y);
        c.add(m);
        c.add(d);
        l4 = new JLabel("Gender");
        l4.setBounds(10,140,100,30);
        c.add(l4);

        male = new JRadioButton("M");
        female = new JRadioButton("F");
        male.setBounds(60,140,40,30);
        female.setBounds(120,140,50,30);
        c.add(male);
        c.add(female);
        l5 = new JLabel("Address:");
        l5.setBounds(10,190,100,30);
        c.add(l5);
        ad = new JTextArea();
        ad.setBounds(70,190,100,30);
        ad.setLineWrap(true);
        c.add(ad);
        l6 = new JLabel("Email:");
        l6.setBounds(10,240,100,30);
        c.add(l6);
        t3 = new JTextField();
        t3.setBounds(60,240,100,30);
        c.add(t3);
        c1 = new JCheckBox();
        c1.setBounds(10,290,30,30);
        c.add(c1);
        l7 = new JLabel("I accept all terms and condition");
        l7.setBounds(50,290,300,30);
        c.add(l7);
        b1 = new JButton("Submit");

        b1.setBounds(60,340,100,30);
        c.add(b1);
        b1.addActionListener(this);
        op = new JTextArea();
        op.setBounds (350,10,400,400);
        c.add(op);
        res = new JTextArea();
        res.setBounds(10,390,150,30);
        res.setLineWrap(true);
        c.add(res);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            if(c1.isSelected())
            {
                l7.setText("Form");
                String gender;
                String input = "Name:"+ t1.getText()+"\n"+"Mobile:"+ t2.getText()+"\n"+"Email:"+t3.getText()+"\n";
                String dob ="DOB:"+y.getSelectedItem()+"-"+ m.getSelectedItem()+"-"+d.getSelectedItem()+"\n";
                if(male.isSelected())
                {
                    gender = "Gender : Male"+"\n";
                }
                else
                {
                    gender = "Gender : Female"+"\n";
                }
                String add = "Address:"+ ad.getText();
                op.setText(input + dob + gender+ add);
                op.setEditable(false);
                res.setText("Successful");
            }
            else
            {
                res.setText("Accept terms and condition");
            }
        }

    }
    public static void main(String[] args) {
        new Register();
    }
}
