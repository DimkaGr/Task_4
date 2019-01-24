package by.epam.threadtask.entity;

import by.epam.threadtask.service.exception.TransferExecutionException;
import by.epam.threadtask.util.BoatState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FerryBoat {
    private final static Logger LOGGER = LogManager.getLogger(FerryBoat.class);
    private static FerryBoat INSTANCE = null;
    private int boatArea;
    private int boatStrong;
    private static Lock lock = new ReentrantLock();
    private CountDownLatch arriveLatch;
    private List<Car> cars;

    private FerryBoat() {
    }

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

    public void setListOfCars(List<Car> cars) {
        this.cars = cars;
    }

    public BoatState loadCars(List<Car> cars) throws TransferExecutionException{
        int tempArea = 0;
        int tempStrong = 0;
        Car tempCar=null;
        arriveLatch = new CountDownLatch(1);
        if(cars==null){
            throw new TransferExecutionException();
        }
        try {
            for (int i = 0; i < cars.size(); i++) {
                tempCar = cars.get(i);
                tempArea += tempCar.getArea();
                tempStrong += tempCar.getWeight();
                if (tempArea <= boatArea && tempStrong <= boatStrong) {
                    tempCar.setLatch(arriveLatch);
                    new Thread(tempCar).start();
                    TimeUnit.MILLISECONDS.sleep(100);
                    cars.remove(tempCar);
                    i--;
                } else break;
            }
            LOGGER.info("FerryBoat arrives from the right bank...");
        }catch (InterruptedException e){
            LOGGER.error("Trouble while loading boat "+e);
            throw new TransferExecutionException();
        }
        return BoatState.LOADED;
    }

    public BoatState unloadCars() {
        try {
            LOGGER.info("FerryBoat on the left bank");
            arriveLatch.countDown();
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            LOGGER.error("Thread was interrupted, so boat is broken..." + e);
            return BoatState.CRASHED;
        }
        return BoatState.EMPTY;
    }
}
