package sbt.java.terminal;

import java.util.HashMap;
import java.util.Map;

public class TerminalServer {
    private final Map<Integer, CardData> data = new HashMap<>();

    public void makeCard(int id, int pin) {
        data.put(id, new CardData(pin));
    }

    public void strike(int id) {
        data.get(id).incrementStrikes();
    }

    public CardData getData(int id) {
        return data.get(id);
    }

    public boolean isLocked(int id) {
        return data.get(id).isLocked();
    }

    public long getTimeout(int id) {
        return data.get(id).checkTimeOut();
    }

    public int getCash(int id) {
        return data.get(id).getCash();
    }

    public void depositOrWithdraw(int id, int value) throws InsufficientFundsException{
        int cash = getCash(id) + value;
        if (cash < 0) {
            throw new InsufficientFundsException("Maximum value you can withdraw is " + getCash(id) + ".");
        } else {
            data.get(id).setCash(cash);
            System.out.println("Success.");
        }
    }

    public int getPin(int id) {
        return data.get(id).getPin();
    }

    public int getTries(int id) {
        return 2 - data.get(id).getStrikes();
    }

    public void resetStrikes(int id) {
        data.get(id).resetStrikes();
    }
}
