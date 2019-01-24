package by.epam.threadtask.service.parser;

public enum CarEnum {
    CARS("cars"),
    CAR("car"),
    NAME("name"),
    WEIGHT("weight"),
    AREA("area");

    private String value;

    CarEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
