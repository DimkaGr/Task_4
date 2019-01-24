package by.epam.threadtask.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {
    private final static Logger LOGGER = LogManager.getLogger(Car.class);
    private String name;
    private int weight;
    private int area;
    private CountDownLatch latch;

    public Car() {
    }

    public Car(String name, int weight, int area) {
        this.name = name;
        this.weight = weight;
        this.area = area;
    }

    public void getMessage(){
        LOGGER.info("Car "+name+" is on the right bank");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return weight == car.weight && area == car.area && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, weight);
    }

    @Override
    public String toString() {
        return "Car[name=" + name +
                ", weight=" + weight +
                ", area=" + area;
    }

    @Override
    public void run() {
        try {
            LOGGER.info("Car "+name+" is on the boat");
            latch.await();
            LOGGER.info("Car "+name+" is on the left bank");
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
    }
}
