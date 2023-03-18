import business.BaseProduct;
import business.DeliveryServiceProcessing;
import business.MenuItem;
import datalayer.Serializator;
import presentation.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainClass
{
    public static void main(String[] args)
    {
        DeliveryServiceProcessing dsp = Serializator.retrieveDsp("dsp.ser");
        //DeliveryServiceProcessing dsp = new DeliveryServiceProcessing();
        dsp.setOrderContents(new ArrayList<>());

        Controller con = new Controller(dsp);

        DeliveryServiceProcessing finalDsp = dsp;
        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> {
                    Serializator.saveDsp(finalDsp, "dsp.ser");
                }
        ));
    }
}
