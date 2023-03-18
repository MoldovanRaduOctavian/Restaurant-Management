package business;

import presentation.ObserverInterface;

import java.util.ArrayList;

public interface IDeliveryServiceProcessing
{
    public ArrayList<MenuItem> importMenu(String file);
    public void addProduct(MenuItem product);
    public void updateProduct(String title, MenuItem product);
    public void deleteProduct(String title);

    public void createComposite(String title, ArrayList<MenuItem> items);

    public Order createOrder(int clientId, ArrayList<MenuItem> items, ObserverInterface obs);

    public void createClient(Client client);



}
