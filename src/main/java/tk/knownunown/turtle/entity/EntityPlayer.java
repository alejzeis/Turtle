package tk.knownunown.turtle.entity;

import java.net.InetAddress;

/**
 * Created by andrew on 6/8/14.
 */
public class EntityPlayer extends Entity {

    public String username;
    public String mtu;
    public InetAddress ip;
    public int port;
    private long clientID;

    public EntityPlayer(String username, short mtu, InetAddress ip, int port, long clientID){

    }
}
