package tk.knownunown.turtle.network.raknet;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 6/1/14.
 */
public class OpenConnectionRequest2 extends BasePacket {

    public short mtu;
    public long clientID;

    public OpenConnectionRequest2(DatagramPacket packet){
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
        this.mtu = buffer.getShort(22);
        this.clientID = buffer.getLong(24);
    }
}
