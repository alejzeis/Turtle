package tk.knownunown.turtle.network.raknet;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 6/1/14.
 */
public class IncompatibleProtocolVersion extends BasePacket{

    public InetAddress ip;
    public int port;
    public byte structure;
    public long serverID;

    public IncompatibleProtocolVersion(InetAddress ip, int port){
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void encode() {
        buffer = ByteBuffer.allocate(26);
        buffer.put(PacketInfo.IncompatibleProtocolVersion);
        buffer.put(structure);
        buffer.putLong(serverID);
        this.packet = new DatagramPacket(buffer.array(), buffer.capacity(), ip, port);
    }

    @Override
    public void decode() {

    }

    public DatagramPacket getPacket(){
        return this.packet;
    }
}
