package tk.knownunown.turtle.network.minecraftpe.misc;

import tk.knownunown.turtle.network.BasePacket;
import tk.knownunown.turtle.network.minecraftpe.PEPacketInfo;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 6/7/14.
 */
public class AcknowledgePacket extends BasePacket {

    public short sanity;
    public boolean additionalPacket;
    public int packet1;
    public int packet2;

    public AcknowledgePacket(InetAddress ip, int port){
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void encode(){
        if(additionalPacket){
            buffer = ByteBuffer.allocate(7);
        } else buffer = ByteBuffer.allocate(10);
        buffer.put(PEPacketInfo.AcknowledgePacket);
        buffer.putShort(sanity);
        buffer.put((byte) (additionalPacket ? 1 : 0)); //stupid no putBoolean -.-
        buffer.putInt(packet1);
        if(!additionalPacket){
            buffer.putInt(packet2);
        }
    }

    public void decode(){

    }

    public DatagramPacket getPacket(){
        return this.packet;
    }

}
