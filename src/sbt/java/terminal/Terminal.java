package sbt.java.terminal;

public interface Terminal {
    void checkout(CrCard card) throws AccountIsLockedException, WrongPinException;

    void deposit(CrCard card, int value) throws AccountIsLockedException,
            IllegalValueException, InsufficientFundsException, WrongPinException;

    void withdraw(CrCard card, int value) throws AccountIsLockedException,
            IllegalValueException, InsufficientFundsException, WrongPinException;
}
