package by.epam.threadtask.service.parser;

public enum BoatEnum {
    BOATS("boats"),
    BOAT("boat"),
    BOATSTRONG("boatStrong"),
    BOATAREA("boatArea");

    private String value;

    BoatEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
