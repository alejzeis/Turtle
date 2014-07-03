package tk.knownunown.turtle.network.raknet.misc;

import tk.knownunown.turtle.network.BasePacket;

/**
 * Created by andrew on 6/8/14.
 */
public abstract class BaseRakNetPacket extends BasePacket{

    public byte[] magic = {(byte)0x00,(byte)0xff,(byte)0xff,(byte)0x00,(byte)0xfe,(byte)0xfe,(byte)0xfe,(byte)0xfe,(byte)0xfd,(byte)0xfd,(byte)0xfd,(byte)0xfd,(byte)0x12,(byte)0x34,(byte)0x56,(byte)0x78};
}
