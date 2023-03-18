package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminGui extends JFrame
{
    private JButton FilterProductsButton;
    private JButton productsInADayButton;
    private JButton timeIntervalButton;
    private JButton clientsButton;
    private JButton orderedProductsButton;
    private JButton createProductButton;
    private JButton updateProductButton;
    private JButton deleteProductButton;
    private JButton importCSVButton;
    private JButton createCompositeButton;
    private JPanel contentPanel;
    private JTable table1;

    public AdminGui(String s)
    {
        super(s);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(contentPanel);
        DefaultTableModel dtm = new DefaultTableModel();
        table1.setModel(dtm);
        //table1.setEnabled(false);

    }

    public JButton getFIlterProductsButton() {
        return FilterProductsButton;
    }

    public void setFIlterProductsButton(JButton FIlterProductsButton) {
        this.FilterProductsButton = FIlterProductsButton;
    }

    public JButton getProductsInADayButton() {
        return productsInADayButton;
    }

    public void setProductsInADayButton(JButton productsInADayButton) {
        this.productsInADayButton = productsInADayButton;
    }

    public JButton getTimeIntervalButton() {
        return timeIntervalButton;
    }

    public void setTimeIntervalButton(JButton timeIntervalButton) {
        this.timeIntervalButton = timeIntervalButton;
    }

    public JButton getClientsButton() {
        return clientsButton;
    }

    public void setClientsButton(JButton clientsButton) {
        this.clientsButton = clientsButton;
    }

    public JButton getOrderedProductsButton() {
        return orderedProductsButton;
    }

    public void setOrderedProductsButton(JButton orderedProductsButton) {
        this.orderedProductsButton = orderedProductsButton;
    }

    public JButton getCreateProductButton() {
        return createProductButton;
    }

    public void setCreateProductButton(JButton createProductButton) {
        this.createProductButton = createProductButton;
    }

    public JButton getUpdateProductButton() {
        return updateProductButton;
    }

    public void setUpdateProductButton(JButton updateProductButton) {
        this.updateProductButton = updateProductButton;
    }

    public JButton getDeleteProductButton() {
        return deleteProductButton;
    }

    public void setDeleteProductButton(JButton deleteProductButton) {
        this.deleteProductButton = deleteProductButton;
    }

    public JButton getImportCSVButton() {
        return importCSVButton;
    }

    public void setImportCSVButton(JButton importCSVButton) {
        this.importCSVButton = importCSVButton;
    }

    public JButton getCreateCompositeButton() {
        return createCompositeButton;
    }

    public void setCreateCompositeButton(JButton createCompositeButton) {
        this.createCompositeButton = createCompositeButton;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }
}
