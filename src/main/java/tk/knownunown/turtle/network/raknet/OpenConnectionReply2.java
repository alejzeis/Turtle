package tk.knownunown.turtle.network.raknet;

import tk.knownunown.turtle.network.BasePacket;
import tk.knownunown.turtle.network.raknet.misc.BaseRakNetPacket;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 6/1/14.
 */
public class OpenConnectionReply2 extends BaseRakNetPacket {

    public InetAddress ip;
    public int port;
    public long serverID;
    public short mtu;
    public byte security;

    public OpenConnectionReply2(InetAddress ip, int port){
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void encode(){
        buffer = ByteBuffer.allocate(30);
        buffer.put(RakPacketInfo.OpenConnectionReply2);
        buffer.put(magic);
        buffer.putLong(serverID);
        buffer.putShort((short) port);
        buffer.putShort(mtu);
        buffer.put(security);
        this.packet = new DatagramPacket(buffer.array(), buffer.capacity(), ip, port);
    }

    @Override
    public void decode(){

    }

    public DatagramPacket getPacket(){
        return this.packet;
    }
}
