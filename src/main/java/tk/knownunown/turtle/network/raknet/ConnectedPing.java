package tk.knownunown.turtle.network.raknet;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 5/24/14.
 */
public class ConnectedPing extends BasePacket {

    public long pingID;

    public ConnectedPing(DatagramPacket packet){
        buffer = ByteBuffer.wrap(packet.getData());
        ip = packet.getAddress();
        port = packet.getPort();
        this.packet = packet;
    }

    public void decode(){
        this.pingID = buffer.getLong(1);
        buffer.get(magic); //thanks Intyre :)
    }

    public void encode(){

    }
}
