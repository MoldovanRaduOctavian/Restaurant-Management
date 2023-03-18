package business;

import presentation.ObserverInterface;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryServiceProcessing extends ObservableClass implements IDeliveryServiceProcessing, Serializable
{
    private ArrayList<MenuItem> menu;
    private Map<Order, ArrayList<MenuItem>> order;
    private ArrayList<Client> clients;
    private transient ArrayList<MenuItem> orderContents;
    private transient int currentClient;
    private static final long serialVersionUID = 6529685098267757690L;
    //public Ma

    public DeliveryServiceProcessing()
    {
        this.menu = new ArrayList<>();
        this.order = new HashMap<>();
        this.clients = new ArrayList<>();
        this.orderContents = new ArrayList<>();
    }

    public boolean WellFormed() { return menu != null && order != null && clients != null;}

    /**
     * @pre line != null
     * @post ret != null
     *
     */
    public static MenuItem mapBase(String line)
    {
        assert line != null;
        String[] aux = line.split(",");
        BaseProduct ret = new BaseProduct(aux[0],
                Float.parseFloat(aux[1]),
                Integer.parseInt(aux[2]),
                Integer.parseInt(aux[3]),
                Integer.parseInt(aux[4]),
                Integer.parseInt(aux[5]),
                Integer.parseInt(aux[6])
                );

        assert ret != null;
        return ret;
    }

    /**
     * @invariant WellFormed()
     * @pre file != null
     *
     */
    public ArrayList<MenuItem> importMenu(String file)
    {
        try
        {
            assert WellFormed();
            assert file != null;

            InputStream in = new FileInputStream(file);
            BufferedReader read = new BufferedReader(new InputStreamReader(in));

            return read.lines().skip(1).map(DeliveryServiceProcessing::mapBase)
                    .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(MenuItem::getTitle))),
                    ArrayList::new));
        }
        catch (Exception e) {e.printStackTrace();}

        return null;
    }

    /**
     * @pre product != null
     *
     */
    @Override
    public void addProduct(MenuItem product) { assert product != null; menu.add(product);}

    /**
     * @pre title != null
     * @pre product != null
     *
     */
    @Override
    public void updateProduct(String title, MenuItem product)
    {
        assert title != null;
        assert product != null;
        for (int i=0; i<menu.size(); i++)
            if (menu.get(i).getTitle().trim().equals(title.trim()))
                menu.set(i, product);

    }

    /**
     * @pre title != null
     *
     */
    @Override
    public void deleteProduct(String title)
    {
        assert title != null;
        for (MenuItem m : menu)
            if (m.getTitle().trim().equals(title.trim()))
            {
                menu.remove(m);
                return;
            }
    }

    /**
     * @pre title != null
     * @pre items != null
     *
     *
     */
    @Override
    public void createComposite(String title, ArrayList<MenuItem> items)
    {
        assert title != null;
        assert items != null;
        MenuItem aux = new CompositeProduct(title, items);
        System.out.println(aux.info());
        addProduct(aux);
    }

    /**
     *
     * @pre obs != null
     *
     *
     * */
    @Override
    public void notifyObserver(ObserverInterface obs) { assert obs != null; obs.update();}

    /**
     * @pre obs != null
     * @pre items != null
     * @post aux != null
     *
     *
     */
    @Override
    public Order createOrder(int clientId, ArrayList<MenuItem> items, ObserverInterface obs)
    {
        assert obs != null;
        assert items != null;
        Order aux = new Order(clientId);
        order.put(aux, items);
        notifyObserver(obs);

        for (MenuItem m : items)
            m.setOrders(m.getOrders() + 1);

        assert aux != null;
        return aux;

    }

    /**
     * @pre client != null
     *
     */
    @Override
    public void createClient(Client client)
    {
        assert client != null;
        for (Client c : clients)
            if (c.equals(client))
                return;

        clients.add(client);

    }


    public ArrayList<MenuItem> filterTest(float lrating, float hrating,
                                          int lcalories, int hcalories,
                                          int lprotein, int hprotein,
                                          int lfat, int hfat,
                                          int lsodium, int hsodium,
                                          int lprice, int hprice,
                                          String title)
    {
        ArrayList<MenuItem> ret = (ArrayList<MenuItem>) menu.stream().filter(s -> s.getPrice() >= lprice
        && s.getPrice() <= hprice && s.getRating() >= lrating && s.getRating() <= hrating
        && s.getProtein() >= lprotein && s.getProtein() <= hprotein
        && s.getFat() >= lfat && s.getFat() <= hfat
        && s.getSodium() >= lsodium && s.getSodium() <= hsodium
        && s.getCalories() >= lcalories && s.getCalories() <= hcalories
        && s.getTitle().trim().contains(title.trim())
        ).collect(Collectors.toList());
        return ret;
    }

    public ArrayList<MenuItem> numOrdersFilter(int n)
    {
        return (ArrayList<MenuItem>) menu.stream().filter(s -> s.getOrders() >= n).collect(Collectors.toList());
    }

    public ArrayList<Client> clientFilter(int n, int price)
    {
        ArrayList<Client> ret = new ArrayList<>();

        for (Client c : clients)
        {
            int si = order.keySet().stream().filter(s -> s.getClientId() == c.getClientId() && orderPrice(order.get(s)) > price).
                    collect(Collectors.toList()).size();

            if (si >= n)
                ret.add(c);

        }

        return ret;
    }

    public ArrayList<Order> hourFilter(int lhour, int hhour)
    {
        return (ArrayList<Order>) order.keySet().stream().filter(s -> s.getDate().getHour() >= lhour && s.getDate().getHour() <= hhour).collect(Collectors.toList());
    }

    public ArrayList<MenuItem> dayProductFilter(int day)
    {
        ArrayList<Order> aux = (ArrayList<Order>) order.keySet().stream().filter(s -> s.getDate().getDayOfMonth() == day).collect(Collectors.toList());
        HashSet<MenuItem> ts = new HashSet<>();

        for (Order o : aux)
            ts.addAll(order.get(o));

        return new ArrayList<>(ts);
    }

    public int orderPrice(ArrayList<MenuItem> items)
    {
        int ret = 0;
        for (MenuItem m : items)
            ret += m.getPrice();

        return ret;
    }

    public MenuItem findByTitle(String title)
    {
        for (MenuItem m : menu)
            if (title.trim().equals(m.getTitle().trim()))
                return m;

        return null;
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<MenuItem> menu) {
        this.menu = menu;
    }

    public Map<Order, ArrayList<MenuItem>> getOrder() {
        return order;
    }

    public void setOrder(Map<Order, ArrayList<MenuItem>> order) {
        this.order = order;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<MenuItem> getOrderContents() {
        return orderContents;
    }

    public void setOrderContents(ArrayList<MenuItem> orderContents) {
        this.orderContents = orderContents;
    }

    public int getCurrentClient() {
        return currentClient;
    }

    public void setCurrentClient(int currentClient) {
        this.currentClient = currentClient;
    }
}
