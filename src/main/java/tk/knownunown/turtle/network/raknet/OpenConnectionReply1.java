package tk.knownunown.turtle.network.raknet;

import tk.knownunown.turtle.network.raknet.misc.BaseRakNetPacket;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 6/1/14.
 */
public class OpenConnectionReply1 extends BaseRakNetPacket {

    public long serverID;
    public byte security;
    public short mtu;

    public OpenConnectionReply1(InetAddress ip, int port){
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void encode(){
        buffer = ByteBuffer.allocate(28);
        buffer.put(RakPacketInfo.OpenConnectionReply1);
        buffer.put(magic);
        buffer.putLong(serverID);
        buffer.put(security);
        buffer.putShort(mtu);
        this.packet = new DatagramPacket(buffer.array(), buffer.capacity(), ip, port);
    }

    @Override
    public void decode(){

    }

    public DatagramPacket getPacket(){
        return this.packet;
    }

}
