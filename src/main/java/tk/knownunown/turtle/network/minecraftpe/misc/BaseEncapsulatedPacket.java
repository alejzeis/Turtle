package tk.knownunown.turtle.network.minecraftpe.misc;

import tk.knownunown.turtle.Turtle;
import tk.knownunown.turtle.network.BasePacket;

/**
 * Created by andrew on 6/8/14.
 */
public abstract class BaseEncapsulatedPacket extends BasePacket{ //we are literally on the edge here, Joe..

    public int count;
    public short length;
    public byte encapsulationID;

    public void getAll(){
        getEncapsulationID();
        getLength();
        getCount();
    }

    public void getDataPacket(){
        switch(this.encapsulationID){
            case 0x00: {
                buffer.get(new byte[7]); //hehehe
            }
            break;
            case 0x40: {
                buffer.get(new byte[10]); //tell me I'm not dreaming
            }
            break;
            /*
            case 0x60: {
                buffer.get(new byte[12]); //it just occured to me that I'll need to do this again for encoding
            }
            */ //hehe
            default: {
                Turtle.log("Tis unknown packet Encapsulation ID. Makes Turtle sad :(");
            }
        }
    }

    public void getCount(){
        byte[] cnt = new byte[3];
        buffer.get(cnt, 2, 3);
        this.count = readTriad(cnt);
    }

    public void getLength(){
        this.length = buffer.getShort(6);
    }
    public void getEncapsulationID(){
        this.encapsulationID = buffer.get(5);
    }

    public int readTriad(byte[] bytes){
        return (bytes[2] & 0xFF) | ((bytes[1] & 0xFF) << 8) | ((bytes[0] & 0x0F) << 16); //thanks, http://stackoverflow.com/questions/13154715/convert-3-bytes-to-int-in-java
    }
}
