package tk.knownunown.turtle.network.raknet;

/**
 * Created by andrew on 5/25/14.
 */
public class PacketInfo {

    public String placeholder = "derp";
    public static final byte ConnectedPing = 0x01;
    public static final byte UnconnectedPing = 0x02;
    public static final byte UnconnectedPingOpenConnections = 0x1c;
    public static final byte AdvertiseSystem = 0x1d;
}
