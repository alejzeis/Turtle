package tk.knownunown.turtle.network.raknet;

import tk.knownunown.turtle.network.Packet;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 5/24/14.
 */
abstract class BasePacket implements Packet {

    protected DatagramPacket packet;
    protected ByteBuffer buffer;
    public InetAddress ip;
    public int port;
    public byte[] magic = new byte[16]; //thankx Intyre <3

}
