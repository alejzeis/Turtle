package tk.knownunown.turtle.network.minecraftpe;

import tk.knownunown.turtle.network.minecraftpe.misc.BaseEncapsulatedPacket;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 6/8/14.
 */
public class ReadyPacket extends BaseEncapsulatedPacket{

    public byte status;

    public ReadyPacket(DatagramPacket packet){
        this.buffer = ByteBuffer.wrap(packet.getData());
        this.ip = packet.getAddress();

    }

    public void decode(){
        status =
    }
}
