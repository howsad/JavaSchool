package sbt.java.reflection;

public class Receiver {
    private int anInt;
    private double aDouble;
    private boolean aBoolean;
    private String message;
    private Boolean bigBoolean;
    private Integer bigInt;
    private Number number;
    private Integer intFromNumber;

    public void setInt(int anInt) {
        this.anInt = anInt;
    }

    public void setDouble(double aDouble) {
        this.aDouble = aDouble;
    }

    public void setBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBigBoolean(Boolean bigBoolean) {
        this.bigBoolean = bigBoolean;
    }

    public void setBigInt(Integer bigInt) {
        this.bigInt = bigInt;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public void setIntFromNumber(Integer intFromNumber) {
        this.intFromNumber = intFromNumber;
    }

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
        return number;
    }

    public Integer getIntFromNumber() {
        return intFromNumber;
    }
}
