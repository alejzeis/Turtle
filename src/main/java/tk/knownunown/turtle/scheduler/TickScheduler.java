package tk.knownunown.turtle.scheduler;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

class TickScheduler extends Thread{

    protected float sleepTime;
    protected float ticksPerSecond;
    protected float tickMeasure;
    public boolean hasTick;

    public TickScheduler(float ticksPerSecond){
        this.ticksPerSecond = (int) ticksPerSecond;
        this.sleepTime = (int) (1000000 / this.ticksPerSecond);
        this.tickMeasure = this.sleepTime;
        this.start();
    }
    public synchronized boolean hasTick(){
        boolean hasTick = this.hasTick;
        this.hasTick = false;
        return hasTick == true;
    }

    public void doTick(){
        this.notify();
    }

    public synchronized float getTPS(){
        return round((sleepTime / tickMeasure) * ticksPerSecond, 2);
    }

    public void run(){
        float tickTime = (float) System.nanoTime();
        hasTick = true;
        while(true){
            synchronized(this){
                hasTick = true;
                try{
                    wait();
                } catch(InterruptedException e){
                    e.printStackTrace();
                    return;
                }
                hasTick = false;
        }

        tickMeasure = (int) ((((float) System.nanoTime()) - tickTime) * 1000000);
        tickTime = (tickMeasure / 1000000) + tickTime;
        try {
            TimeUnit.MICROSECONDS.sleep((long) sleepTime - 100); //Remove a few ms for processing
        } catch(InterruptedException e){
            e.printStackTrace();
            return;
        }
        }
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}


