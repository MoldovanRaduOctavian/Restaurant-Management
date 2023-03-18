package datalayer;

import business.Client;
import business.DeliveryServiceProcessing;
import business.MenuItem;
import business.Order;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serializator
{
    public static void saveMenu(ArrayList<MenuItem> menu, String file)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream obout = new ObjectOutputStream(fout);

            obout.reset();
            obout.writeObject(menu);
            obout.close();
            fout.close();
        }

        catch (Exception e) {e.printStackTrace();}

    }

    public static ArrayList<MenuItem> retrieveMenu(String file)
    {
        ArrayList<MenuItem> ret = null;

        try
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream obin = new ObjectInputStream(fin);

            ret = (ArrayList<MenuItem>) obin.readObject();

            obin.close();
            fin.close();

        }
        catch (Exception e) { e.printStackTrace();}

        return ret;

    }

    public static void saveOrders(Map<Order, ArrayList<MenuItem>> orders, String file)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream obout = new ObjectOutputStream(fout);

            obout.reset();
            obout.writeObject(orders);
            obout.close();
            fout.close();
        }
        catch (Exception e) { e.printStackTrace();}

    }

    public static Map<Order, ArrayList<MenuItem>> retrieveOrders(String file)
    {
        Map<Order, ArrayList<MenuItem>> ret = null;

        try
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream obin = new ObjectInputStream(fin);

            ret = (Map<Order, ArrayList<MenuItem>>) obin.readObject();

            obin.close();
            fin.close();
        }
        catch (Exception e) { e.printStackTrace();}

        return ret;
    }

    public static void saveDsp(DeliveryServiceProcessing dsp, String file)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream obout = new ObjectOutputStream(fout);

            obout.reset();
            obout.writeObject(dsp);
            obout.flush();

            obout.close();
            fout.close();

        }
        catch (Exception e) { e.printStackTrace();}
    }

    public static DeliveryServiceProcessing retrieveDsp(String file)
    {
        DeliveryServiceProcessing ret = null;

        try
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream obin = new ObjectInputStream(fin);

            ret = (DeliveryServiceProcessing) obin.readObject();

            obin.close();
            fin.close();
        }
        catch (Exception e) { e.printStackTrace();}

        return ret;
    }

    public static void saveClients(ArrayList<Client> clients, String file)
    {
        try
        {
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream obout = new ObjectOutputStream(fout);

            obout.reset();
            obout.writeObject(clients);

            obout.close();
            fout.close();

        }
        catch (Exception e) { e.printStackTrace();}
    }

    public static ArrayList<Client> retrieveClients(String file)
    {
        ArrayList<Client> ret = null;

        try
        {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream obin = new ObjectInputStream(fin);

            ret = (ArrayList<Client>) obin.readObject();

            obin.close();
            fin.close();
        }
        catch (Exception e) { e.printStackTrace();}

        return ret;

    }
}
