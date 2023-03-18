package presentation;

import javax.swing.*;

public class ProductNumberReportGui extends JFrame
{
    private JTextField textField1;
    private JPanel panel1;
    private JButton button1;

    public ProductNumberReportGui(String s)
    {
        super(s);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }
}
