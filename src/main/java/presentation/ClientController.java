package presentation;

import business.DeliveryServiceProcessing;
import business.MenuItem;
import business.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientController
{
    private DeliveryServiceProcessing dsp;

    private ClientGui clientGui;

    private DeleteProductGui addOrderItemGui;
    private DeleteProductGui removeOrderItemGui;
    private FilterGui filterGui;

    private EmployeeController employeeController;

    public ClientController(DeliveryServiceProcessing dsp, ClientGui clientGui, EmployeeController employeeController)
    {
        this.dsp = dsp;

        this.clientGui = clientGui;
        this.employeeController = employeeController;
        this.addOrderItemGui = new DeleteProductGui("");
        this.removeOrderItemGui = new DeleteProductGui("");
        this.filterGui = new FilterGui("");

        showMenuClient(dsp.getMenu());
        showItemsClient(dsp.getOrderContents());
        addClientListeners();
    }

    public void showMenuClient(ArrayList<MenuItem> items)
    {
        String[] cname = {"Title", "Rating", "Calories", "Protein", "Fat"
                , "Sodium", "Price", "Orders"};

        Object[][] data = new Object[13000][8];
        int i = 0;

        for (MenuItem m : items)
        {
            data[i][0] = m.getTitle();
            data[i][1] = m.getRating();
            data[i][2] = m.getCalories();
            data[i][3] = m.getProtein();
            data[i][4] = m.getFat();
            data[i][5] = m.getSodium();
            data[i][6] = m.getPrice();
            data[i][7] = m.getOrders();

            i++;
        }

        DefaultTableModel model = (DefaultTableModel) this.clientGui.getTable1().getModel();
        model.setDataVector(data, cname);
        this.clientGui.getTable1().revalidate();
        this.clientGui.getTable1().repaint();
    }

    public void showItemsClient(ArrayList<MenuItem> items)
    {
        String[] cname = {"Title", "Rating", "Calories", "Protein", "Fat"
                , "Sodium", "Price", "Orders"};

        Object[][] data = new Object[13000][8];
        int i = 0;

        for (MenuItem m : items)
        {
            data[i][0] = m.getTitle();
            data[i][1] = m.getRating();
            data[i][2] = m.getCalories();
            data[i][3] = m.getProtein();
            data[i][4] = m.getFat();
            data[i][5] = m.getSodium();
            data[i][6] = m.getPrice();
            data[i][7] = m.getOrders();

            i++;
        }

        DefaultTableModel model = (DefaultTableModel) this.clientGui.getTable2().getModel();
        model.setDataVector(data, cname);
        this.clientGui.getTable2().revalidate();
        this.clientGui.getTable2().repaint();
    }

    public void showFilterClientListener() { this.filterGui.setVisible(true);}
    public void filterButtonListener()
    {
        try
        {
            String title;
            float lrating, hrating;
            int lcalories, hcalories, lprotein, hprotein,
                    lfat, hfat, lsodium, hsodium, lprice, hprice;

            title = this.filterGui.getTextField1().getText().trim();
            lrating = Float.parseFloat(this.filterGui.getTextField2().getText());
            hrating = Float.parseFloat(this.filterGui.getTextField3().getText());
            lcalories = Integer.parseInt(this.filterGui.getTextField4().getText());
            hcalories = Integer.parseInt(this.filterGui.getTextField5().getText());
            lprotein = Integer.parseInt(this.filterGui.getTextField6().getText());
            hprotein = Integer.parseInt(this.filterGui.getTextField7().getText());
            lfat = Integer.parseInt(this.filterGui.getTextField8().getText());
            hfat = Integer.parseInt(this.filterGui.getTextField9().getText());
            lsodium = Integer.parseInt(this.filterGui.getTextField10().getText());
            hsodium = Integer.parseInt(this.filterGui.getTextField11().getText());
            lprice = Integer.parseInt(this.filterGui.getTextField12().getText());
            hprice = Integer.parseInt(this.filterGui.getTextField13().getText());

            if (lrating < 0 || hrating < 0 || lcalories < 0 || hcalories < 0
                    || lprotein < 0 || hprotein < 0 || lfat < 0 || hfat < 0 || lsodium < 0 || hsodium < 0
                    || lprice < 0 || hprice < 0)
            {
                JOptionPane.showMessageDialog(this.filterGui, "Invalid input");
                return;
            }

            ArrayList<MenuItem> aux = dsp.filterTest(
                    lrating, hrating,
                    lcalories, hcalories,
                    lprotein, hprotein,
                    lfat, hfat,
                    lsodium, hsodium,
                    lprice, hprice,
                    title
            );

            showMenuClient(aux);
            JOptionPane.showMessageDialog(this.filterGui, "Products filtered");
            this.filterGui.setVisible(false);
        }

        catch (Exception e) { JOptionPane.showMessageDialog(this.filterGui, "Invalid input");}
    }

    public void addItemClientShowListener() {this.addOrderItemGui.setVisible(true);}
    public void addItemClientListener()
    {
        try
        {
            String title = this.addOrderItemGui.getTextField1().getText();
            MenuItem item = dsp.findByTitle(title.trim());

            if (item == null)
            {
                JOptionPane.showMessageDialog(this.addOrderItemGui, "Invalid input");
                return;
            }

            dsp.getOrderContents().add(item);
            showItemsClient(dsp.getOrderContents());
            this.addOrderItemGui.setVisible(false);

        }

        catch (Exception e) { e.printStackTrace();JOptionPane.showMessageDialog(this.addOrderItemGui, "Invalid input");}
    }

    public void removeItemClientShowListener() {this.removeOrderItemGui.setVisible(true);}
    public void removeItemClientListener()
    {
        try
        {
            String title = this.removeOrderItemGui.getTextField1().getText().trim();
            MenuItem aux = null;

            for (MenuItem m : dsp.getOrderContents())
                if (m.getTitle().trim().equals(title))
                {
                    aux = m;
                    break;
                }

            if (aux == null)
            {
                JOptionPane.showMessageDialog(this.removeOrderItemGui, "Invalid input");
                return;
            }

            dsp.getOrderContents().remove(aux);
            showItemsClient(dsp.getOrderContents());
            this.removeOrderItemGui.setVisible(false);

        }

        catch (Exception e) { e.printStackTrace();JOptionPane.showMessageDialog(this.removeOrderItemGui, "Invalid input");}
    }

    public void confirmOrderClientListener()
    {
        if (dsp.getOrderContents().isEmpty())
        {
            JOptionPane.showMessageDialog(this.clientGui, "Empty order");
            return;
        }

        ArrayList<MenuItem> ordered = (ArrayList<MenuItem>) dsp.getOrderContents().clone();
        Order aux = dsp.createOrder(dsp.getCurrentClient(), ordered, employeeController);

        dsp.getOrderContents().clear();
        JOptionPane.showMessageDialog(this.clientGui, "Order confirmed");
        showMenuClient(dsp.getMenu());
        showItemsClient(dsp.getOrderContents());

        try
        {
            File file = new File("bill.txt");
            PrintWriter printWriter = new PrintWriter(file);

            printWriter.println("Order\n");
            printWriter.println(aux.getDate() + "\n");

            ArrayList<MenuItem> items = dsp.getOrder().get(aux);

            for (MenuItem m : items)
            {
                printWriter.println(m.info());
                System.out.println(m.info());
            }

            printWriter.println("Total: " + dsp.orderPrice(items));
            printWriter.close();
        }

        catch (Exception e) {e.printStackTrace();}
    }

    public void addClientListeners()
    {
        this.clientGui.getFilterProductsButton().addActionListener(e -> showFilterClientListener());
        this.filterGui.getFindProductsButton().addActionListener(e -> filterButtonListener());
        this.clientGui.getAddToOrderButton().addActionListener(e -> addItemClientShowListener());
        this.addOrderItemGui.getButton1().addActionListener(e -> addItemClientListener());
        this.clientGui.getRemoveFromOrderButton().addActionListener(e -> removeItemClientShowListener());
        this.removeOrderItemGui.getButton1().addActionListener(e -> removeItemClientListener());
        this.clientGui.getConfirmOrderButton().addActionListener(e -> confirmOrderClientListener());
    }

    public DeliveryServiceProcessing getDsp() {
        return dsp;
    }

    public void setDsp(DeliveryServiceProcessing dsp) {
        this.dsp = dsp;
    }

    public ClientGui getClientGui() {
        return clientGui;
    }

    public void setClientGui(ClientGui clientGui) {
        this.clientGui = clientGui;
    }

    public DeleteProductGui getAddOrderItemGui() {
        return addOrderItemGui;
    }

    public void setAddOrderItemGui(DeleteProductGui addOrderItemGui) {
        this.addOrderItemGui = addOrderItemGui;
    }

    public DeleteProductGui getRemoveOrderItemGui() {
        return removeOrderItemGui;
    }

    public void setRemoveOrderItemGui(DeleteProductGui removeOrderItemGui) {
        this.removeOrderItemGui = removeOrderItemGui;
    }

    public FilterGui getFilterGui() {
        return filterGui;
    }

    public void setFilterGui(FilterGui filterGui) {
        this.filterGui = filterGui;
    }
}
