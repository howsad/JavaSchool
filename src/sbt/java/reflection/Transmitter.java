package sbt.java.reflection;

public class Transmitter {
    private final int anInt = 5;
    private final double aDouble = 3.14;
    private final boolean aBoolean = true;
    private final String message = "Radio. Live transmission.";
    private final Boolean bigBoolean = false;
    private final Integer bigInt = 42;

    public int getInt() {
        return anInt;
    }

    public double getDouble() {
        return aDouble;
    }

    public boolean isBoolean() {
        return aBoolean;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getBigBoolean() {
        return bigBoolean;
    }

    public Integer getBigInt() {
        return bigInt;
    }

    public Number getNumber() {
        return bigInt;
    }

    public Number getIntFromNumber() {
        return bigInt;
    }
}
