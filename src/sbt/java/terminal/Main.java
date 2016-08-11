package sbt.java.terminal;

import java.util.Scanner;

public class Main {
    private static TerminalServer server;

    public static void setServer(TerminalServer server) {
        Main.server = server;
    }

    public static CrCard makeCard(int id, int pin) {
        server.makeCard(id, pin);
        return new CrCard(id);
    }

    public static void main(String[] args) {
        TerminalServer server = new TerminalServer();
        setServer(server);
        CrCard card1 = makeCard(1, 1234);
        Terminal t = new TerminalImpl(server, new PinValidator());
        System.out.println("Please, input command. Commands include check, deposit, withdraw and exit.");
        try (Scanner scanner = TerminalImpl.scanner) {
            while (scanner.hasNext()) {
                String command = scanner.next().toLowerCase().trim();
                try {
                    switch (command) {
                        case "check":
                            t.checkout(card1);
                            break;
                        case "deposit": {
                            System.out.println("Please insert money. (Input value).");
                            int value = scanner.nextInt();
                            t.deposit(card1, value);
                            break;
                        }
                        case "withdraw": {
                            System.out.println("Input amount of money you want to withdraw.");
                            int value = scanner.nextInt();
                            t.withdraw(card1, value);
                            break;
                        }
                        case "exit":
                            return;
                        default:
                            System.out.println("Unknown operation.");
                            break;
                    }
                } catch (Exception e) {
                    String msg = e.getMessage();
                    if (msg != null) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
