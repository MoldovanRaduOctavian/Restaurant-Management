package presentation;

import javax.swing.*;

public class CreateProductGui extends JFrame
{
    private JPanel panel1;
    private JTextField titleTextField;
    private JButton confirmButton;
    private JTextField ratingTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField fatTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;

    public CreateProductGui(String s)
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

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getTitleTextField() {
        return titleTextField;
    }

    public void setTitleTextField(JTextField titleTextField) {
        this.titleTextField = titleTextField;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public void setConfirmButton(JButton confirmButton) {
        this.confirmButton = confirmButton;
    }

    public JTextField getRatingTextField() {
        return ratingTextField;
    }

    public void setRatingTextField(JTextField ratingTextField) {
        this.ratingTextField = ratingTextField;
    }

    public JTextField getCaloriesTextField() {
        return caloriesTextField;
    }

    public void setCaloriesTextField(JTextField caloriesTextField) {
        this.caloriesTextField = caloriesTextField;
    }

    public JTextField getProteinTextField() {
        return proteinTextField;
    }

    public void setProteinTextField(JTextField proteinTextField) {
        this.proteinTextField = proteinTextField;
    }

    public JTextField getFatTextField() {
        return fatTextField;
    }

    public void setFatTextField(JTextField fatTextField) {
        this.fatTextField = fatTextField;
    }

    public JTextField getSodiumTextField() {
        return sodiumTextField;
    }

    public void setSodiumTextField(JTextField sodiumTextField) {
        this.sodiumTextField = sodiumTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public void setPriceTextField(JTextField priceTextField) {
        this.priceTextField = priceTextField;
    }
}
