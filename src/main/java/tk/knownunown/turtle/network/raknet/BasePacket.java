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
    public byte[] magic = {(byte)0x00,(byte)0xff,(byte)0xff,(byte)0x00,(byte)0xfe,(byte)0xfe,(byte)0xfe,(byte)0xfe,(byte)0xfd,(byte)0xfd,(byte)0xfd,(byte)0xfd,(byte)0x12,(byte)0x34,(byte)0x56,(byte)0x78};

}
