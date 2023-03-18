package business;

import java.util.ArrayList;

public class CompositeProduct implements MenuItem
{

    private String title;
    private ArrayList<MenuItem> products;
    private int orders = 0;
    private static final long serialVersionUID = 6529685098267757690L;

    public CompositeProduct(String title, ArrayList<MenuItem> products)
    {
        this.title = title;
        this.products = products;
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public float getRating() {

        float ret = 0;
        int i = 0;

        for (MenuItem b : products)
        {
            if (b != null)
            {
                ret += b.getRating();
                i++;
            }
        }

        ret /= i;

        return ret;
    }

    @Override
    public void setRating(float rating) {

    }

    @Override
    public int getCalories() {

        int ret = 0;

        for (MenuItem b : products)
            if (b != null)
                ret += b.getCalories();


        return ret;
    }

    @Override
    public void setCalories(int calories) {

    }

    @Override
    public int getProtein() {

        int ret = 0;

        for (MenuItem b : products)
            if (b != null)
                ret += b.getProtein();

        return ret;

    }

    @Override
    public void setProtein(int protein) {

    }

    @Override
    public int getFat() {

        int ret = 0;

        for (MenuItem b : products)
            if (b != null)
                ret += b.getFat();

        return ret;
    }

    @Override
    public void setFat(int fat) {

    }

    @Override
    public int getSodium() {

        int ret = 0;

        for (MenuItem b : products)
            if (b != null)
                ret += b.getSodium();

        return ret;

    }

    @Override
    public void setSodium(int sodium) {

    }

    @Override
    public int getPrice() {

        int ret = 0;

        for (MenuItem b : products)
            if (b != null)
                ret += b.getPrice();

        return ret;

    }

    @Override
    public void setPrice(int price) {

    }

    @Override
    public int getOrders() {
        return orders;
    }

    @Override
    public void setOrders(int orderedTimes) {
        this.orders = orderedTimes;
    }

    @Override
    public String info() {
        String ret =  "Composite product -> Title: " + getTitle()
                + " Price: " + getPrice() + " --> composed of: (\n";

        for (MenuItem m : products)
            if (m != null)
                ret += "\t" + m.info() + "\n";

        ret += ")\n";
        return ret;
    }

}
