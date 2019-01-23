package by.epam.threadtask.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FerryBoat {
    private final static Logger LOGGER=LogManager.getLogger(FerryBoat.class);
    private static FerryBoat INSTANCE=null;
    private int boatArea;
    private int boatStrong;

    private FerryBoat(){};

    public static FerryBoat getInstance(){
        if(INSTANCE==null){
            synchronized (FerryBoat.class){
                if(INSTANCE==null){
                    INSTANCE=new FerryBoat();
                }
            }
        }
        return INSTANCE;
    }
    public void setBoatArea(int boatArea){
        this.boatArea=boatArea;
    }

    public int getBoatArea(){return boatArea;}

    public void setBoatStrong(int boatStrong){
        this.boatStrong=boatStrong;
    }

    public int getBoatStrong(){return boatStrong;}
}
