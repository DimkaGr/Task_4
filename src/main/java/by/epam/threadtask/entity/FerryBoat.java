package by.epam.threadtask.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FerryBoat {
    private final static Logger LOGGER = LogManager.getLogger(FerryBoat.class);
    private static FerryBoat INSTANCE = null;
    private int boatArea;
    private int boatStrong;
    private static Lock lock = new ReentrantLock();

    private FerryBoat() {
    }

    ;

    public static FerryBoat getInstance() {
        if (INSTANCE == null) {
            lock.lock();
            try {
                if (INSTANCE == null) {
                    INSTANCE = new FerryBoat();
                }
            } finally {
                lock.unlock();
            }
        }
        return INSTANCE;
    }

    public void setBoatArea(int boatArea) {
        this.boatArea = boatArea;
    }

    public int getBoatArea() {
        return boatArea;
    }

    public void setBoatStrong(int boatStrong) {
        this.boatStrong = boatStrong;
    }

    public int getBoatStrong() {
        return boatStrong;
    }
}
