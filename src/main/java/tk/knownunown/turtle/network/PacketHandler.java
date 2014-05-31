package tk.knownunown.turtle.network;

import java.net.DatagramPacket;

import tk.knownunown.turtle.Turtle;
import tk.knownunown.turtle.network.raknet.PacketInfo;
import tk.knownunown.turtle.network.raknet.ConnectedPing;
import tk.knownunown.turtle.network.raknet.UnconnectedPingOpenConnections;
import java.util.Random;
/**
 * Created by andrew on 5/31/14.
 */
public class PacketHandler extends Thread {

    public PacketHandler(){
        this.start();
    }
    @SuppressWarnings("unchecked")
    public void run(){
        while(!NetworkHandler.isStopped){
            if(!NetworkHandler.recvQueue.isEmpty()){
                DatagramPacket packet = ((DatagramPacket) NetworkHandler.recvQueue.get(0));
                switch(packet.getData()[0]){
                   case PacketInfo.UnconnectedPing:
                       ConnectedPing recv = new ConnectedPing(packet);
                       recv.decode();
                       Turtle.log("[PacketHandler] Received packet" + PacketInfo.UnconnectedPing + "from"  + packet.getAddress().toString() + ":" + packet.getPort() + " :)");
                       UnconnectedPingOpenConnections reply = new UnconnectedPingOpenConnections(packet.getAddress(), packet.getPort());
                       reply.pingID = recv.pingID;
                       reply.serverID = (new Random()).nextLong();
                       reply.identifier = Turtle.getIdentifier();
                       reply.encode();
                       Turtle.log("[PacketHandler] Adding packet " + PacketInfo.UnconnectedPingOpenConnections + " to NetworkHandler queue for sending :)");
                       NetworkHandler.sendQueue.add(reply.getPacket());
                       break;
                }
            }
        }
    }
}
