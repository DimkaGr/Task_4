package by.epam.threadtask.service.parser;

import by.epam.threadtask.entity.Car;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CarParserTest {

    @Test
    public void testParse() throws Exception {
        CarParser parser=new CarParser();
        List<Car> cars=new ArrayList();
        List parseCars=parser.parse("src/test/resources/Cars.xml");
        Car car1=new Car("truck1",2000,20);
        Car car2=new Car("car1",1000,10);
        Car car3=new Car("truck2",1700,25);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        assertEquals(cars,parseCars);
    }

}