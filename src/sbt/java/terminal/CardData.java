package sbt.java.terminal;

public class CardData {
    private int pin;
    private int strikes;
    private boolean locked;
    private int cash;
    private long timeout;
    private static final long WAIT_TIME = 5000;

    public CardData(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public int getStrikes() {
        return strikes;
    }

    public void resetStrikes() {strikes = 0;}

    public boolean isLocked() {
        return locked;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void incrementStrikes() {
        strikes++;
        if (strikes == 3) {
            locked = true;
            timeout = System.currentTimeMillis() + WAIT_TIME;
        }
    }

    public long checkTimeOut() {
        long curTime = System.currentTimeMillis();
        if (curTime > timeout) {
            locked = false;
            strikes = 0;
        }
        return timeout - curTime;
    }
}
