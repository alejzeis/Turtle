package tk.knownunown.turtle.network.raknet;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 5/31/14.
 */
public class UnconnectedPingOpenConnections extends BasePacket {

    public long pingID;
    public long serverID;
    public String identifier;

    public UnconnectedPingOpenConnections(InetAddress ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void decode(){ //not needed, as it is a packet to be sent S->C, not two way, not C->S

    }

    public void encode(){
        buffer = ByteBuffer.allocate(35 + identifier.length());
        buffer.put((byte) PacketInfo.UnconnectedPingOpenConnections);
        buffer.putLong(pingID);
        buffer.putLong(serverID);
        buffer.put(magic);
        buffer.putShort((short) identifier.length());
        buffer.put(identifier.getBytes());
        this.packet = new DatagramPacket(buffer.array(), buffer.capacity(), ip, port);
    }

    public DatagramPacket getPacket(){

        return this.packet; //so that we don't get denied by protected status
    }

}
