package tk.knownunown.turtle.network.raknet;

import tk.knownunown.turtle.network.Packet;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * Created by andrew on 5/24/14.
 */
abstract class BasePacket implements Packet {

    protected DatagramPacket packet;
    protected ByteBuffer buffer;
    public InetAddress ip;
    public int port;
    public byte[] magic = hexStringToByteArray("00ffff00fefefefefdfdfdfd12345678");

    public static byte[] hexStringToByteArray(String s) { //thank you, StackOverflow!
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
