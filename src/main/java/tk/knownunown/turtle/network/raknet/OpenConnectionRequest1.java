package tk.knownunown.turtle.network.raknet;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 6/1/14.
 */
public class OpenConnectionRequest1 extends BasePacket{

    public byte structure;
    public short mtu;

    public OpenConnectionRequest1(DatagramPacket packet){
        this.buffer = ByteBuffer.wrap(packet.getData());
        this.ip = packet.getAddress();
        this.port = packet.getPort();
        this.packet = packet;
    }

    @Override
    public void encode(){

    }

    @Override
    public void decode(){
        this.structure = buffer.get(17);
        this.mtu = (short) packet.getLength();
    }

}
