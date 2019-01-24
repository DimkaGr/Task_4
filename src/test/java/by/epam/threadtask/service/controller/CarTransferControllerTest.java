package by.epam.threadtask.service.controller;

import by.epam.threadtask.entity.Car;
import by.epam.threadtask.entity.FerryBoat;
import by.epam.threadtask.service.parser.BoatParser;
import by.epam.threadtask.service.parser.CarParser;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CarTransferControllerTest {
    @Test
    public void testMakeTransfer() throws Exception {
        BoatParser parser=new BoatParser();
        FerryBoat boat=parser.parse("src/test/resources/FerryBoat.xml");
        CarParser parser2=new CarParser();
        List<Car>cars=parser2.parse("src/test/resources/Cars.xml");
        CarTransferController controller=new CarTransferController();
        assertTrue(controller.makeTransfer(cars,boat));
    }

}