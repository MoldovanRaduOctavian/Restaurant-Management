package presentation;

import business.DeliveryServiceProcessing;
import business.MenuItem;
import business.Order;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EmployeeController implements ObserverInterface
{

    private DeliveryServiceProcessing dsp;
    private EmployeeGui employeeGui;

    public EmployeeController(DeliveryServiceProcessing dsp, EmployeeGui employeeGui)
    {
        this.dsp = dsp;
        this.employeeGui = employeeGui;
        update();
    }

    @Override
    public void update()
    {
        String[] cname = {"Order ID", "Client ID", "Time", "Contents"};

        Object[][] data = new Object[200][4];
        int i = 0;

        for (Order o : dsp.getOrder().keySet())
        {
            data[i][0] = o.getOrderId();
            data[i][1] = o.getClientId();
            data[i][2] = o.getDate();
            data[i][3] = itemsToString(dsp.getOrder().get(o));

            i++;
        }

        DefaultTableModel model = (DefaultTableModel) this.employeeGui.getTable1().getModel();
        model.setDataVector(data, cname);
        this.employeeGui.getTable1().revalidate();
        this.employeeGui.getTable1().repaint();

    }

    public String itemsToString(ArrayList<MenuItem> items)
    {
        String ret = "";

        for (MenuItem m : items)
            ret += m.getTitle() + "; ";

        return ret;
    }
}
