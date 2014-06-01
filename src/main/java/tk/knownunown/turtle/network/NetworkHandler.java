package tk.knownunown.turtle.network;

import tk.knownunown.turtle.Turtle;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrew on 5/25/14.
 */
public class NetworkHandler extends Thread {

    public Queue<DatagramPacket> sendQueue = new LinkedList<DatagramPacket>();
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
                new PacketHandler(this, packet).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Turtle.log(sendQueue.toString());
                if(sendQueue.peek() == null){
                    Turtle.log("[NetworkHandler] no packet to send.");
                } else {
                    Turtle.log("[NetworkHandler] Heigh-ho, heigh-ho, sending a packet we go!");
                    socket.send(sendQueue.poll());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void close(){
        isStopped = true;
        socket.close();
    }
}
