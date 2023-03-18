package presentation;

import javax.swing.*;

public class LoginGui extends JFrame
{
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;

    private ButtonGroup buttonGroup;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;

    private JButton loginButton;
    private JButton registerClientButton;

    public LoginGui()
    {
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setVisible(true);

        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(radioButton1);
        this.buttonGroup.add(radioButton2);
        this.buttonGroup.add(radioButton3);
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

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public JRadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(JRadioButton radioButton1) {
        this.radioButton1 = radioButton1;
    }

    public JRadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(JRadioButton radioButton2) {
        this.radioButton2 = radioButton2;
    }

    public JRadioButton getRadioButton3() {
        return radioButton3;
    }

    public void setRadioButton3(JRadioButton radioButton3) {
        this.radioButton3 = radioButton3;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JButton getRegisterClientButton() {
        return registerClientButton;
    }

    public void setRegisterClientButton(JButton registerClientButton) {
        this.registerClientButton = registerClientButton;
    }
}
