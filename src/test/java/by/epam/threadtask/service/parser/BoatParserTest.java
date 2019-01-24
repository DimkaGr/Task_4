package by.epam.threadtask.service.parser;

import by.epam.threadtask.entity.FerryBoat;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BoatParserTest {
    @Test
    public void testParse() throws Exception {
        BoatParser parser=new BoatParser();
        FerryBoat parseBoat=parser.parse("src/test/resources/FerryBoat.xml");
        FerryBoat boat=FerryBoat.getInstance();
        boat.setBoatStrong(4000);
        boat.setBoatArea(15000);
        assertEquals(boat,parseBoat);
    }

}