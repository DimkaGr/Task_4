package by.epam.threadtask.service.controller;

import by.epam.threadtask.entity.Car;
import by.epam.threadtask.entity.FerryBoat;
import by.epam.threadtask.service.exception.TransferExecutionException;
import by.epam.threadtask.util.BoatState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarTransferController {
    private final static Logger LOGGER = LogManager.getLogger(CarTransferController.class);

    public boolean makeTransfer(List<Car> cars, FerryBoat boat) throws  TransferExecutionException{
        try {
            while (!cars.isEmpty()) {
                boat.loadCars(cars);
                TimeUnit.MILLISECONDS.sleep(500);
                if(boat.unloadCars()== BoatState.CRASHED){
                    throw new TransferExecutionException();
                }
                TimeUnit.MILLISECONDS.sleep(500);
                LOGGER.info("FerryBoat is on the right bank");
            }
            LOGGER.info("All cars are transported");
        } catch (InterruptedException e) {
            LOGGER.error("FerryBoat work was interrupted " + e);
        }
        if (cars.isEmpty()) {
            return true;
        } else
            return false;
    }
}
