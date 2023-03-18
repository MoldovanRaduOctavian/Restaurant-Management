package presentation;

import javax.swing.*;

public class FilterGui extends JFrame
{
    private JTextField textField1;
    private JPanel panel1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JButton FindProductsButton;

    public FilterGui(String s)
    {
        super(s);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
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

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public void setTextField5(JTextField textField5) {
        this.textField5 = textField5;
    }

    public JTextField getTextField6() {
        return textField6;
    }

    public void setTextField6(JTextField textField6) {
        this.textField6 = textField6;
    }

    public JTextField getTextField7() {
        return textField7;
    }

    public void setTextField7(JTextField textField7) {
        this.textField7 = textField7;
    }

    public JTextField getTextField8() {
        return textField8;
    }

    public void setTextField8(JTextField textField8) {
        this.textField8 = textField8;
    }

    public JTextField getTextField9() {
        return textField9;
    }

    public void setTextField9(JTextField textField9) {
        this.textField9 = textField9;
    }

    public JTextField getTextField10() {
        return textField10;
    }

    public void setTextField10(JTextField textField10) {
        this.textField10 = textField10;
    }

    public JTextField getTextField11() {
        return textField11;
    }

    public void setTextField11(JTextField textField11) {
        this.textField11 = textField11;
    }

    public JTextField getTextField12() {
        return textField12;
    }

    public void setTextField12(JTextField textField12) {
        this.textField12 = textField12;
    }

    public JTextField getTextField13() {
        return textField13;
    }

    public void setTextField13(JTextField textField13) {
        this.textField13 = textField13;
    }

    public JButton getFindProductsButton() {
        return FindProductsButton;
    }

    public void setFIndProductsButton(JButton FIndProductsButton) {
        this.FindProductsButton = FIndProductsButton;
    }
}
