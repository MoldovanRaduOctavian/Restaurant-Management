package presentation;

import business.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AdminController
{
    private DeliveryServiceProcessing dsp;
    
    private AdminGui adminGui;
    private CreateProductGui createProductGui;
    private CreateProductGui updateProductGui;
    private DeleteProductGui deleteProductGui;
    private CreateCompositeGui createCompositeGui;
    private FilterGui filterGui;

    private ProductNumberReportGui productNumberReportGui;
    private ProductDayReportGui productDayReportGui;
    private HourReportGui hourReportGui;
    private ClientsReportGui clientsReportGui;

    public AdminController(DeliveryServiceProcessing dsp, AdminGui adminGui)
    {
        this.dsp = dsp;
        this.adminGui = adminGui;
        this.createProductGui = new CreateProductGui("");
        this.updateProductGui = new CreateProductGui("");
        this.deleteProductGui = new DeleteProductGui("");
        this.createCompositeGui = new CreateCompositeGui("");
        this.filterGui = new FilterGui("");

        this.productNumberReportGui = new ProductNumberReportGui("");
        this.productDayReportGui = new ProductDayReportGui("");
        this.hourReportGui = new HourReportGui("");
        this.clientsReportGui = new ClientsReportGui();

        showMenuAdmin(dsp.getMenu());
        addAdminListeners();
    }

    public void showMenuAdmin(ArrayList<MenuItem> items)
    {
        if (items == null)
            return;

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

        DefaultTableModel model = (DefaultTableModel) this.adminGui.getTable1().getModel();
        model.setDataVector(data, cname);
        this.adminGui.getTable1().revalidate();
        this.adminGui.getTable1().repaint();

    }

    public void showClientsAdmin(ArrayList<Client> clients)
    {
        String[] cname = {"Client ID", "Username"};

        Object[][] data = new Object[200][2];
        int i = 0;

        for (Client c : clients)
        {
            data[i][0] = c.getClientId();
            data[i][1] = c.getUser();

            i++;
        }

        DefaultTableModel model = (DefaultTableModel) this.adminGui.getTable1().getModel();
        model.setDataVector(data, cname);
        this.adminGui.getTable1().revalidate();
        this.adminGui.getTable1().repaint();
    }

    public void showOrdersAdmin(ArrayList<Order> orders)
    {
        String[] cname = {"Order ID", "Client ID", "Time"};

        Object[][] data = new Object[200][3];
        int i = 0;

        for (Order o : orders)
        {
            data[i][0] = o.getOrderId();
            data[i][1] = o.getClientId();
            data[i][2] = o.getDate();

            i++;
        }

        DefaultTableModel model = (DefaultTableModel) this.adminGui.getTable1().getModel();
        model.setDataVector(data, cname);
        this.adminGui.getTable1().revalidate();
        this.adminGui.getTable1().repaint();

    }

    public void createProductListener() { this.createProductGui.setVisible(true); }
    public void createButtonListener()
    {
        try
        {
            for (MenuItem m : this.dsp.getMenu())
                if (m.getTitle().equals(this.createProductGui.getTitleTextField().getText()))
                {
                    JOptionPane.showMessageDialog(this.createProductGui, "Invalid input");
                    return;
                }

            BaseProduct bp = new BaseProduct(
                    this.createProductGui.getTitleTextField().getText(),
                    Float.parseFloat(this.createProductGui.getRatingTextField().getText()),
                    Integer.parseInt(this.createProductGui.getCaloriesTextField().getText()),
                    Integer.parseInt(this.createProductGui.getProteinTextField().getText()),
                    Integer.parseInt(this.createProductGui.getFatTextField().getText()),
                    Integer.parseInt(this.createProductGui.getSodiumTextField().getText()),
                    Integer.parseInt(this.createProductGui.getPriceTextField().getText())
            );

            this.dsp.addProduct(bp);
            JOptionPane.showMessageDialog(this.createProductGui, "New product added");
            this.createProductGui.setVisible(false);

            showMenuAdmin(dsp.getMenu());

        }
        catch (Exception e) { JOptionPane.showMessageDialog(this.createProductGui, "Invalid input"); }
    }

    public void updateProductListener() { this.updateProductGui.setVisible(true); }
    public void updateButtonListener()
    {
        try
        {
            int ok = 0;
            MenuItem x = null;

            for (MenuItem m : this.dsp.getMenu())
                if (m.getTitle().trim().equals(this.updateProductGui.getTitleTextField().getText().trim()))
                {
                    ok = 1;
                    x = m;
                    break;
                }

            if (ok == 0 || x instanceof CompositeProduct)
            {
                JOptionPane.showMessageDialog(this.updateProductGui, "Invalid input");
                return;
            }

            BaseProduct bp = new BaseProduct(
                    this.updateProductGui.getTitleTextField().getText(),
                    Float.parseFloat(this.updateProductGui.getRatingTextField().getText()),
                    Integer.parseInt(this.updateProductGui.getCaloriesTextField().getText()),
                    Integer.parseInt(this.updateProductGui.getProteinTextField().getText()),
                    Integer.parseInt(this.updateProductGui.getFatTextField().getText()),
                    Integer.parseInt(this.updateProductGui.getSodiumTextField().getText()),
                    Integer.parseInt(this.updateProductGui.getPriceTextField().getText())
            );

            this.dsp.updateProduct(this.updateProductGui.getTitleTextField().getText(), bp);
            JOptionPane.showMessageDialog(this.updateProductGui, "Product updated");
            showMenuAdmin(dsp.getMenu());
            this.updateProductGui.setVisible(false);

        }

        catch (Exception e) {JOptionPane.showMessageDialog(this.updateProductGui, "Invalid input");}
    }

    public void deleteProductListener() {this.deleteProductGui.setVisible(true);}
    public void deleteButtonListener()
    {
        try
        {
            int ok = 0;

            for (MenuItem m : this.dsp.getMenu())
                if (m.getTitle().trim().equals(this.deleteProductGui.getTextField1().getText().trim()))
                {
                    ok = 1;
                    break;
                }

            if (ok == 0)
            {
                JOptionPane.showMessageDialog(this.deleteProductGui, "Invalid input");
                return;
            }

            dsp.deleteProduct(this.deleteProductGui.getTextField1().getText().trim());
            JOptionPane.showMessageDialog(this.deleteProductGui, "Valid input");
            showMenuAdmin(dsp.getMenu());
            this.deleteProductGui.setVisible(false);

        }
        catch (Exception e) {JOptionPane.showMessageDialog(this.deleteProductGui, "Invalid input");}
    }

    public void importButtonListener()
    {
        dsp.setMenu(dsp.importMenu("D:\\PT2022_30224_Moldovan_Radu_Assignment_4\\src\\main\\java\\business\\products.csv"));
        showMenuAdmin(dsp.getMenu());
    }

    public void filterProductListener() {this.filterGui.setVisible(true);}
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

            showMenuAdmin(aux);
            JOptionPane.showMessageDialog(this.filterGui, "Products filtered");
            this.filterGui.setVisible(false);
        }

        catch (Exception e) { JOptionPane.showMessageDialog(this.filterGui, "Invalid input");}
    }

    public void createCompositeProductListener() {this.createCompositeGui.setVisible(true);}
    public void createCompositeButtonListener()
    {

        try
        {
            String title;
            String p1, p2, p3, p4;

            title = this.createCompositeGui.getTextField1().getText().trim();

            if (dsp.findByTitle(title) != null)
            {
                JOptionPane.showMessageDialog(this.createCompositeGui, "Invalid input");
                return;
            }

            p1 = this.createCompositeGui.getTextField2().getText().trim();
            p2 = this.createCompositeGui.getTextField3().getText().trim();
            p3 = this.createCompositeGui.getTextField4().getText().trim();
            p4 = this.createCompositeGui.getTextField5().getText().trim();

            MenuItem aux1, aux2, aux3, aux4;
            aux1 = dsp.findByTitle(p1);
            aux2 = dsp.findByTitle(p2);
            aux3 = dsp.findByTitle(p3);
            aux4 = dsp.findByTitle(p4);

            if ((aux1 == null  && !p1.equals("")) ||
                    (aux2 == null  && !p2.equals("")) ||
                    (aux3 == null  && !p3.equals("")) ||
                    (aux4 == null  && !p4.equals("")))
            {
                JOptionPane.showMessageDialog(this.createCompositeGui, "Invalid input");
                return;
            }

            ArrayList<MenuItem> com = new ArrayList<>();
            com.add(aux1);
            com.add(aux2);
            com.add(aux3);
            com.add(aux4);

            dsp.createComposite(title, com);
            JOptionPane.showMessageDialog(this.createCompositeGui, "Composite created");
            showMenuAdmin(dsp.getMenu());
            this.createCompositeGui.setVisible(false);
        }

        catch (Exception e) { e.printStackTrace();JOptionPane.showMessageDialog(this.createCompositeGui, "Invalid input");}
    }

    public void showProductNumberReport() { this.productNumberReportGui.setVisible(true);}
    public void productNumberReportListener()
    {
        try
        {
            int number = Integer.parseInt(this.productNumberReportGui.getTextField1().getText());
            ArrayList<MenuItem> aux = dsp.numOrdersFilter(number);

            showMenuAdmin(aux);
            JOptionPane.showMessageDialog(this.productNumberReportGui, "Report ready");
            this.productNumberReportGui.setVisible(false);
        }
        catch (Exception e) {JOptionPane.showMessageDialog(this.productNumberReportGui, "Invalid input");}
    }

    public void showClientFilterReport() { this.clientsReportGui.setVisible(true);}
    public void clientFilterReportListener()
    {
        try
        {
            int timesOrdered = Integer.parseInt(this.clientsReportGui.getTextField1().getText());
            int value = Integer.parseInt(this.clientsReportGui.getTextField2().getText());

            ArrayList<Client> aux = dsp.clientFilter(timesOrdered, value);
            showClientsAdmin(aux);
            JOptionPane.showMessageDialog(this.productNumberReportGui, "Report ready");
            this.clientsReportGui.setVisible(false);
        }
        catch (Exception e) {JOptionPane.showMessageDialog(this.productNumberReportGui, "Invalid input");}
    }

    public void showHourReport() { this.hourReportGui.setVisible(true);}
    public void hourReportListener()
    {
        try
        {
            int start = Integer.parseInt(this.hourReportGui.getTextField1().getText());
            int end = Integer.parseInt(this.hourReportGui.getTextField2().getText());

            ArrayList<Order> aux = dsp.hourFilter(start, end);
            showOrdersAdmin(aux);
            JOptionPane.showMessageDialog(this.productNumberReportGui, "Report ready");
            this.hourReportGui.setVisible(false);

        }
        catch (Exception e) {JOptionPane.showMessageDialog(this.productNumberReportGui, "Invalid input");}
    }

    public void showProductDayReport() { this.productDayReportGui.setVisible(true);}
    public void productDayReport()
    {
        try
        {
            int day = Integer.parseInt(this.productDayReportGui.getTextField1().getText());

            ArrayList<MenuItem> aux = dsp.dayProductFilter(day);
            showMenuAdmin(aux);
            JOptionPane.showMessageDialog(this.productNumberReportGui, "Report ready");
            this.productDayReportGui.setVisible(false);
        }

        catch (Exception e) {JOptionPane.showMessageDialog(this.productNumberReportGui, "Invalid input");}
    }

    public void addAdminListeners()
    {
        this.createProductGui.getConfirmButton().addActionListener(e -> createButtonListener());
        this.adminGui.getCreateProductButton().addActionListener(e -> createProductListener());
        this.updateProductGui.getConfirmButton().addActionListener(e -> updateButtonListener());
        this.adminGui.getUpdateProductButton().addActionListener(e -> updateProductListener());
        this.deleteProductGui.getButton1().addActionListener(e -> deleteButtonListener());
        this.adminGui.getDeleteProductButton().addActionListener(e -> deleteProductListener());
        this.adminGui.getImportCSVButton().addActionListener(e -> importButtonListener());
        this.adminGui.getFIlterProductsButton().addActionListener(e -> filterProductListener());
        this.filterGui.getFindProductsButton().addActionListener(e -> filterButtonListener());
        this.adminGui.getCreateCompositeButton().addActionListener(e -> createCompositeProductListener());
        this.createCompositeGui.getButton1().addActionListener(e -> createCompositeButtonListener());
        this.adminGui.getOrderedProductsButton().addActionListener(e -> showProductNumberReport());
        this.productNumberReportGui.getButton1().addActionListener(e -> productNumberReportListener());
        this.adminGui.getClientsButton().addActionListener(e -> showClientFilterReport());
        this.clientsReportGui.getButton1().addActionListener(e -> clientFilterReportListener());
        this.adminGui.getTimeIntervalButton().addActionListener(e -> showHourReport());
        this.hourReportGui.getConfirmButton().addActionListener(e -> hourReportListener());
        this.adminGui.getProductsInADayButton().addActionListener(e -> showProductDayReport());
        this.productDayReportGui.getButton1().addActionListener(e -> productDayReport());
    }

    public DeliveryServiceProcessing getDsp() {
        return dsp;
    }

    public void setDsp(DeliveryServiceProcessing dsp) {
        this.dsp = dsp;
    }


}
