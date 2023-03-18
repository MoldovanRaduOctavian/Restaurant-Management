package business;

import java.io.Serializable;

public interface MenuItem extends Serializable
{
    public String getTitle();

    public void setTitle(String title);

    public float getRating();

    public void setRating(float rating);

    public int getCalories();

    public void setCalories(int calories);

    public int getProtein();

    public void setProtein(int protein);

    public int getFat();

    public void setFat(int fat);

    public int getSodium();

    public void setSodium(int sodium);

    public int getPrice();

    public void setPrice(int price);

    public int getOrders();

    public void setOrders(int orderedTimes);

    public String info();
}
