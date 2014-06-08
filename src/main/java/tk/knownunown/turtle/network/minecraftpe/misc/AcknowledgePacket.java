package tk.knownunown.turtle.network.minecraftpe.misc;

import tk.knownunown.turtle.network.BasePacket;

import java.net.DatagramPacket;

/**
 * Created by andrew on 6/7/14.
 */
public class AcknowledgePacket extends BasePacket {

    public short sanity;
    public boolean additionalPacket;
    public boolean packet1;
    public boolean packet2;

    public AcknowledgePacket(DatagramPacket packet){

    }

}
