package tk.knownunown.turtle.network.raknet;

/**
 * Created by andrew on 5/25/14.
 */
public class RakPacketInfo {

    public static final byte ConnectedPing = 0x01;
    public static final byte UnconnectedPing = 0x02;
    public static final byte UnconnectedPingOpenConnections = 0x1c;
    public static final byte AdvertiseSystem = 0x1D;
    public static final byte OpenConnectionRequest1 = 0x05;
    public static final byte OpenConnectionReply1 = 0x06;
    public static final byte OpenConnectionRequest2 = 0x07;
    public static final byte OpenConnectionReply2 = 0x08;
    public static final byte IncompatibleProtocolVersion = 0x1A;

}
