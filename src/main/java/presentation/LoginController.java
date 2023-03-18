package presentation;

import business.Client;
import business.DeliveryServiceProcessing;

import javax.swing.*;
import java.util.ArrayList;

public class LoginController
{
    private DeliveryServiceProcessing dsp;
    private LoginGui loginGui;

    private AdminGui adminGui;
    private ClientGui clientGui;
    private EmployeeGui employeeGui;

    public LoginController(DeliveryServiceProcessing dsp, LoginGui loginGui, AdminGui adminGui, ClientGui clientGui, EmployeeGui employeeGui)
    {
        this.dsp = dsp;
        this.loginGui = loginGui;
        this.adminGui = adminGui;
        this.clientGui = clientGui;
        this.employeeGui = employeeGui;
        this.loginGui.setVisible(true);

        addLoginListeners();

    }

    public void loginButtonListener()
    {
        if (loginGui.getRadioButton1().isSelected())
        {
            if (loginGui.getTextField1().getText().equals("admin") && loginGui.getPasswordField1().getText().equals("admin"))
            {
                JOptionPane.showMessageDialog(loginGui, "Valid credentials");
                adminGui.setVisible(true);
                this.loginGui.setVisible(false);
            }

            else
                JOptionPane.showMessageDialog(loginGui, "Invalid credentials");
        }
        else if (loginGui.getRadioButton2().isSelected())
        {
            ArrayList<Client> clients = dsp.getClients();

            for (Client c : clients)
                if (c.getUser().trim().equals(loginGui.getTextField1().getText().trim())
                        && c.getPass().trim().equals(loginGui.getPasswordField1().getText().trim()))
                {
                    JOptionPane.showMessageDialog(loginGui, "Valid credentials");

                    dsp.setCurrentClient(c.getClientId());
                    clientGui.setVisible(true);
                    this.loginGui.setVisible(false);

                    return;
                }
            JOptionPane.showMessageDialog(loginGui, "Invalid credentials");
        }
        else if (loginGui.getRadioButton3().isSelected())
        {
            if (loginGui.getTextField1().getText().equals("emp") && loginGui.getPasswordField1().getText().equals("emp"))
            {
                JOptionPane.showMessageDialog(loginGui, "Valid credentials");
                employeeGui.setVisible(true);
                this.loginGui.setVisible(false);
            }
            else
                JOptionPane.showMessageDialog(loginGui, "Invalid credentials");
        }

        else JOptionPane.showMessageDialog(loginGui, "Invalid credentials");
    }

    public void registerButtonListener()
    {
        String user = loginGui.getTextField1().getText();
        String pass = loginGui.getPasswordField1().getText();

        for (Client c : dsp.getClients())
            if (c.getUser().trim().equals(user.trim()))
            {JOptionPane.showMessageDialog(loginGui, "Invalid credentials"); return; }

        Client client = new Client(user, pass);
        dsp.createClient(client);

        JOptionPane.showMessageDialog(loginGui, "New account created");

    }

    public void addLoginListeners()
    {
        this.loginGui.getLoginButton().addActionListener(e -> loginButtonListener());
        this.loginGui.getRegisterClientButton().addActionListener(e -> registerButtonListener());
    }

    public DeliveryServiceProcessing getDsp() {
        return dsp;
    }

    public void setDsp(DeliveryServiceProcessing dsp) {
        this.dsp = dsp;
    }

    public LoginGui getLoginGui() {
        return loginGui;
    }

    public void setLoginGui(LoginGui loginGui) {
        this.loginGui = loginGui;
    }

    public AdminGui getAdminGui() {
        return adminGui;
    }

    public void setAdminGui(AdminGui adminGui) {
        this.adminGui = adminGui;
    }

    public ClientGui getClientGui() {
        return clientGui;
    }

    public void setClientGui(ClientGui clientGui) {
        this.clientGui = clientGui;
    }

    public EmployeeGui getEmployeeGui() {
        return employeeGui;
    }

    public void setEmployeeGui(EmployeeGui employeeGui) {
        this.employeeGui = employeeGui;
    }
}
