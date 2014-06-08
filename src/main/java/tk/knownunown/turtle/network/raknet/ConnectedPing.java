package tk.knownunown.turtle.network.raknet;

import tk.knownunown.turtle.network.BasePacket;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 5/24/14.
 */
public class ConnectedPing extends BasePacket {

    public long pingID;

    public ConnectedPing(DatagramPacket packet){
        this.buffer = ByteBuffer.wrap(packet.getData());
        this.ip = packet.getAddress();
        this.port = packet.getPort();
        this.packet = packet;
    }

    @Override
    public void decode(){
        this.pingID = buffer.getLong(1);
    }

    @Override
    public void encode(){

    }
}
