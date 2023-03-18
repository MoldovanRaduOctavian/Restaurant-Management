package business;

import java.io.Serializable;
import java.util.Random;

import static java.lang.Math.abs;

public class Client implements Serializable
{
    public static int globalClientId;
    private int clientId;
    private String user;
    private static final long serialVersionUID = 6529685098267757690L;

    private String pass;

    public Client(String user, String pass)
    {
        Random rand = new Random();
        this.clientId = abs(rand.nextInt());
        this.user = user;
        this.pass = pass;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
