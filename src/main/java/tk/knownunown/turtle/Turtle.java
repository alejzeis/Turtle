package tk.knownunown.turtle;

import com.google.gson.JsonArray;
import tk.knownunown.turtle.network.NetworkHandler;

import java.util.Scanner;

/**
 * Created by andrew on 5/23/14.
 */
public class Turtle extends Thread {

    protected Scanner console = new Scanner(System.in);
    protected NetworkHandler networkHandler;
    protected static String serverName = "MineTurtle Test Server";

    public Turtle(){

    }

    public static void main(String[] args){
        (new Turtle()).start();
    }

    public static String getIdentifier(){
        return "MCCPP;Demo;" + serverName;
    }

    public void run(){
       System.out.println("Turtle 1.0.0-SNAPSHOT starting.");
       networkHandler = new NetworkHandler();
       while(true){
           if(console.nextLine().equals("stop")){
               System.out.println("Turtle is stopping...");
               networkHandler.close();
               System.exit(0);
           }
       }
    }

    public static void log(String text){
        System.out.println(text);
    }

}
