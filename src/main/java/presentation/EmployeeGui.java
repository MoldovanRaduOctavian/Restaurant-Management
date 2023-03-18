package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeGui extends JFrame
{
    private JTextArea textArea1;
    private JPanel panel1;
    private JTable table1;

    public EmployeeGui(String s)
    {
        super(s);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        DefaultTableModel dtm = new DefaultTableModel();
        this.table1.setModel(dtm);
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }
}
