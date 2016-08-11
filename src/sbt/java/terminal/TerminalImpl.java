package sbt.java.terminal;

import java.util.Scanner;

/**
 * Created by Alexander on 07.08.2016.
 */
public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;
    public static final Scanner scanner = new Scanner(System.in);

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public void checkout(CrCard card) throws AccountIsLockedException, WrongPinException {
        validate(card);
        System.out.println("Your balance is " + server.getCash(card.getId()) + ".");
    }


    @Override
    public void deposit(CrCard card, int value) throws AccountIsLockedException, IllegalValueException,
            InsufficientFundsException, WrongPinException {
        validate(card);
        if (value % 100 != 0) {
            throw new IllegalValueException("Deposit value must be multiple of 100.");
        } else {
            server.depositOrWithdraw(card.getId(), value);
        }
    }

    public void validate(CrCard card) throws AccountIsLockedException, WrongPinException {
        int id = card.getId();
        while (true) {
            try {
                if (server.isLocked(id)) {
                    long timeout = server.getTimeout(id);
                    if (timeout > 0) {
                        throw new AccountIsLockedException("Wait for " + timeout + " ms.");
                    }
                }
                int pin = server.getPin(id);
                int triesLeft = server.getTries(id);
                pinValidator.validate(card, pin, triesLeft);
                server.resetStrikes(id);
                return;
            } catch (PinInputException e) {
                if (e.getCause() instanceof WrongPinException) {
                    server.strike(id);
                }
                System.out.println(e.getCause().getMessage());
                System.out.println("Wanna try again? Y/N");
                while (true) {
                    String response = scanner.next().toLowerCase().trim();
                    if (response.equals("y")) {
                        break;
                    } else if (response.equals("n")) {
                        throw new WrongPinException();
                    }
                }
            }
        }
    }


    @Override
    public void withdraw(CrCard card, int value) throws
            AccountIsLockedException, IllegalValueException, InsufficientFundsException, WrongPinException {
        validate(card);
        if (value % 100 != 0) {
            throw new IllegalValueException("Deposit value must be multiple of 100.");
        } else {
            server.depositOrWithdraw(card.getId(), -value);
        }
    }
}
