package sbt.java.terminal;

import java.io.IOException;

public class PinValidator {

    public int inputPin() throws IOException {
        System.out.println("Please, input 4 digit PIN.");
        int powOfTen = 1000;
        int pin = 0;
        for (int i = 0; i < 4; ) {
            char ch = (char) System.in.read();
            if (Character.isWhitespace(ch)) {
                continue;
            }
            if (ch < '0' || ch > '9') {
                throw new IOException("Unexpected input. Supposed to be digits only.");
            } else {
                pin += powOfTen * (ch - '0');
                powOfTen /= 10;
                i++;
            }
        }
        if (powOfTen > 0) {
            throw new IOException("Invalid PIN. PIN too short.");
        }
        return pin;
    }

    public void validate(CrCard card, int truePin, int tries) throws PinInputException {
        try {
            int pin = inputPin();
            if (pin != truePin) {
                String triesMsg;
                switch (tries) {
                    case 2: triesMsg = "Two tries left.";
                        break;
                    case 1: triesMsg = "Only one try left. Be careful!";
                        break;
                    case 0: triesMsg = "No more tries left. Your card is locked for 5 seconds.";
                        break;
                    default: triesMsg = "Wow. Something went really wrong.";
                }
                Exception e = new WrongPinException("Incorrect PIN. " + triesMsg);
                throw new PinInputException(e);
            }
        } catch (IOException e) {
            throw new PinInputException(e);
        }
    }
}
