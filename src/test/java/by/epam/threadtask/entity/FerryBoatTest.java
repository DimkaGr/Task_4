package by.epam.threadtask.entity;

import by.epam.threadtask.service.exception.TransferExecutionException;
import by.epam.threadtask.util.BoatState;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class FerryBoatTest {
    @Test
    public void testLoadCars() throws Exception {
        List<Car> cars = new ArrayList();
        Car car1 = new Car("truck1", 2000, 20);
        Car car2 = new Car("car1", 1000, 10);
        Car car3 = new Car("truck2", 1700, 25);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        FerryBoat boat = FerryBoat.getInstance();
        assertEquals(boat.loadCars(cars), BoatState.LOADED);
    }

    @Test
    public void testUnloadCars() throws Exception {
        FerryBoat boat = FerryBoat.getInstance();
        List<Car> cars = new ArrayList();
        Car car1 = new Car("truck1", 2000, 20);
        Car car2 = new Car("car1", 1000, 10);
        Car car3 = new Car("truck2", 1700, 25);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        boat.loadCars(cars);
        assertEquals(boat.unloadCars(), BoatState.EMPTY);
    }

    @Test
    public void testSingleton() throws Exception {
        FerryBoat f1 = FerryBoat.getInstance();
        FerryBoat f2 = FerryBoat.getInstance();
        System.out.println(f1);
        System.out.println(f2);
        assertEquals(f1, f2);
    }

    @Test(expectedExceptions = TransferExecutionException.class)
    public void testWrongLoadCars() throws Exception {
        FerryBoat boat = FerryBoat.getInstance();
        boat.loadCars(null);
    }
}