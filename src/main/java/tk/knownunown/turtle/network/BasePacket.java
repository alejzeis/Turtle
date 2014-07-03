package tk.knownunown.turtle.network;

import tk.knownunown.turtle.network.Packet;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 5/24/14.
 */
public abstract class BasePacket implements Packet {

    protected DatagramPacket packet;
    protected ByteBuffer buffer;
    public InetAddress ip;
    public int port;

}
