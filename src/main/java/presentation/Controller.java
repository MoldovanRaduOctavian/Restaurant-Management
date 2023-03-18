package presentation;

import business.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller
{

    private DeliveryServiceProcessing dsp;

    private LoginController loginController;
    private AdminController adminController;
    private ClientController clientController;
    private EmployeeController employeeController;

    private LoginGui loginGui;
    private AdminGui adminGui;
    private ClientGui clientGui;
    private EmployeeGui employeeGui;

    public Controller(DeliveryServiceProcessing dsp)
    {
        this.dsp = dsp;
        this.loginGui = new LoginGui();
        this.adminGui = new AdminGui("");
        this.clientGui = new ClientGui("");
        this.employeeGui = new EmployeeGui("");

        //this.dsp.setMenu(this.dsp.importMenu("D:\\PT2022_30224_Moldovan_Radu_Assignment_4\\src\\main\\java\\business\\products.csv"));
        this.adminController = new AdminController(this.dsp, this.adminGui);
        this.employeeController = new EmployeeController(this.dsp, this.employeeGui);
        this.clientController = new ClientController(this.dsp, this.clientGui, this.employeeController);
        this.loginController = new LoginController(this.dsp, this.loginGui,
                this.adminGui, this.clientGui, this.employeeGui);

    }

}

