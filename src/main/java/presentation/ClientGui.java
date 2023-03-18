package presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientGui extends JFrame{
    private JButton filterProductsButton;
    private JPanel panel1;
    private JButton addToOrderButton;
    private JButton removeFromOrderButton;
    private JButton confirmOrderButton;
    private JTable table1;
    private JTable table2;

    public ClientGui(String s)
    {
        super(s);
        this.prepareGui();
    }

    public void prepareGui()
    {
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        DefaultTableModel dtm1 = new DefaultTableModel();
        table1.setModel(dtm1);
        DefaultTableModel dtm2 = new DefaultTableModel();
        table2.setModel(dtm2);
    }

    public JButton getFilterProductsButton() {
        return filterProductsButton;
    }

    public void setFilterProductsButton(JButton filterProductsButton) {
        this.filterProductsButton = filterProductsButton;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getAddToOrderButton() {
        return addToOrderButton;
    }

    public void setAddToOrderButton(JButton addToOrderButton) {
        this.addToOrderButton = addToOrderButton;
    }

    public JButton getRemoveFromOrderButton() {
        return removeFromOrderButton;
    }

    public void setRemoveFromOrderButton(JButton removeFromOrderButton) {
        this.removeFromOrderButton = removeFromOrderButton;
    }

    public JButton getConfirmOrderButton() {
        return confirmOrderButton;
    }

    public void setConfirmOrderButton(JButton confirmOrderButton) {
        this.confirmOrderButton = confirmOrderButton;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JTable getTable2() {
        return table2;
    }

    public void setTable2(JTable table2) {
        this.table2 = table2;
    }

}
