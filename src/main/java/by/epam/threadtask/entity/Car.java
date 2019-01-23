package by.epam.threadtask.entity;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable{
    private final static Logger LOGGER= LogManager.getLogger(Car.class);
    private String name;
    private int weight;
    private int area;
    private CountDownLatch latch;

    public Car(){};

    public Car(String name, int weight, int area, CountDownLatch latch){
        this.name=name;
        this.weight=weight;
        this.area=area;
        this.latch=latch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
       return weight==car.weight&&area==car.area&&name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,area,weight);
    }

    @Override
    public String toString(){
        return "Car[name="+name+
                ", weight="+weight+
                ", area="+area;
    }

    @Override
    public void run(){
        try{
            throw new InterruptedException();
        }catch(InterruptedException e){
            LOGGER.error(e);
        }
    }
}
