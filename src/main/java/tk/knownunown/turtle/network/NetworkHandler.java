package tk.knownunown.turtle.network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrew on 5/25/14.
 */
public class NetworkHandler extends Thread {

    public static List sendQueue = Collections.synchronizedList(new ArrayList());
    public static List recvQueue = Collections.synchronizedList(new ArrayList());
    public PacketHandler packetHandler = new PacketHandler();
    private DatagramSocket socket;
    public static boolean isStopped;

    public NetworkHandler(){
        isStopped = false;

        this.start();
    }

    public void run(){
        try {
            DatagramSocket socket = new DatagramSocket(19132);
            socket.setBroadcast(true);
            this.socket = socket;
            processLoop();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void processLoop(){
        while(!isStopped){
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(packet);
                recvQueue.add(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!sendQueue.isEmpty()){
                try {
                    socket.send((DatagramPacket) sendQueue.get(0));
                 } catch (IOException e) {
                    e.printStackTrace();
                 }
            }
        }
    }

    public synchronized void close(){
        isStopped = true;
        socket.close();
    }
}
