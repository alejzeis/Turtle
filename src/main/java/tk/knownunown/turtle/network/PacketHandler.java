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

    protected DatagramPacket packet;
    protected NetworkHandler networkHandler;

    public PacketHandler(NetworkHandler networkHandler, DatagramPacket packet){
        Turtle.log("[PacketHandler] new PacketHandler started with packet ID " + packet.getData()[0]);
        this.packet = packet;
        this.networkHandler = networkHandler;
    }
    @SuppressWarnings("unchecked")
    public void run(){
        switch(packet.getData()[0]){
            case PacketInfo.ConnectedPing:
            case PacketInfo.UnconnectedPing:
                ConnectedPing recv = new ConnectedPing(packet);
                recv.decode();
                Turtle.log("[PacketHandler] Received packet " + PacketInfo.ConnectedPing + " from "  + packet.getAddress().toString() + ":" + packet.getPort() + " :)");
                Turtle.log("[PacketHandler] 0x01 Ping ID: " + String.valueOf(recv.pingID));
                UnconnectedPingOpenConnections reply = new UnconnectedPingOpenConnections(packet.getAddress(), packet.getPort());
                reply.pingID = recv.pingID;
                reply.serverID = 925686942; //hehe :)
                reply.identifier = Turtle.getIdentifier();
                reply.encode();
                Turtle.log("[PacketHandler] Adding packet " + PacketInfo.UnconnectedPingOpenConnections + " to NetworkHandler queue for sending :)");
                networkHandler.sendQueue.add(reply.getPacket());
                break;
        }
    }
}
