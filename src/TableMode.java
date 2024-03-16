import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableMode extends JFrame {

    private Container c;
    private JTable tb;
    private JTextField t1, t2, t3;
    private JButton b1, b2, b3;

    TableMode() {
        setTitle("Table");
        setSize(600, 700);
        setVisible(true);
        setLocation(700, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object[][] data = {{1, "Kabina", 21}, {2, "Kritina", 23}, {3, "Kritan", 18}};
        String[] colName = {"Roll No", "Name", "Age"};
        DefaultTableModel model = new DefaultTableModel(data, colName);
        tb = new JTable(model);
        setLayout(new GridLayout(3, 1));
        JPanel panel = new JPanel();
        add(new JScrollPane(tb));
        add(new JPanel());
        add(panel);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        b1 = new JButton("Add");
        b2 = new JButton("Update");
        b3 = new JButton("Delete");
        panel.setLayout(new GridLayout(3, 3));
        panel.add(new JLabel("Roll No"));
        panel.add(t1);
        panel.add(b1);
        panel.add(new JLabel("Name"));
        panel.add(t2);
        panel.add(b2);
        panel.add(new JLabel("Age"));
        panel.add(t3);
        panel.add(b3);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t2.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields are Empty", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    int rollno = Integer.parseInt(t1.getText().toString());
                    String name = t2.getText().toString();
                    int age = Integer.parseInt(t3.getText().toString());
                    Object[] newrow = {rollno, name, age};
                    model.addRow(newrow);
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                }

            }
        });
        tb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int rowindex = tb.getSelectedRow();
                int rollno = (int) model.getValueAt(rowindex, 0);
                String name = (String) model.getValueAt(rowindex, 1);
                int age = (int) model.getValueAt(rowindex, 2);
                t1.setText(String.valueOf(rollno));
                t2.setText(name);
                t3.setText(String.valueOf(age));
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().toString().isEmpty() || t2.getText().toString().isEmpty() || t2.getText().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields are Empty", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int rollno = Integer.parseInt(t1.getText().toString());
                    String name = t2.getText().toString();
                    int age = Integer.parseInt(t3.getText().toString());
                    int row = tb.getSelectedRow();
                    model.setValueAt(rollno, row, 0);
                    model.setValueAt(name, row, 1);
                    model.setValueAt(age, row, 2);
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                }

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tb.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Select a row", "Error", JOptionPane.ERROR_MESSAGE);

                }
                int sel = JOptionPane.showConfirmDialog(null, "Are u sure?");
                if (sel == JOptionPane.YES_NO_OPTION) {
                    model.removeRow(tb.getSelectedRow());
                    t1.setText(null);
                    t2.setText(null);
                    t3.setText(null);
                }
            }
        });
        tb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        validate();
    }

    public static void main(String[] args) {
        new TableMode();
    }

}
