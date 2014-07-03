package tk.knownunown.turtle.entity;

import java.net.InetAddress;

/**
 * Created by andrew on 6/8/14.
 */
public class EntityPlayer extends Entity {

    public String username;
    public short mtu;
    public InetAddress ip;
    public int port;
    //private long clientID; -MCPE provided CID - not reliable?
    private String clientID;
    public float pitch;
    public float yaw;

    public EntityPlayer(String username, short mtu, InetAddress ip, int port, String clientID){
        this.username = username;
        this.mtu = mtu;
        this.ip = ip;
        this.port = port;
        this.clientID = clientID;
    }
}
