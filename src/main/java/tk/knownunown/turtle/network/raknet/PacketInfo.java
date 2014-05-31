package tk.knownunown.turtle.network.raknet;

/**
 * Created by andrew on 5/25/14.
 */
public class PacketInfo {

    public String placeholder = "derp";
    public static final int ConnectedPing = 0x01;
    public static final int UnconnectedPing = 0x02;
    public static final int UnconnectedPingOpenConnections = 0x1c;
    public static final int AdvertiseSystem = 0x1d;
}
