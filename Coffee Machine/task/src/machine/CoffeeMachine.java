package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var coffeeMachine = new CoffeeMachineSimulator();
        String action;
        do {
            action = askActionFromUser(scanner);
            System.out.println();

            switch (action) {
                case "fill":
                    addResources(scanner, coffeeMachine);
                    break;

                case "buy":
                    buyCoffee(scanner, coffeeMachine);
                    break;

                case "take":
                    takeMoney(coffeeMachine);
                    break;

                case "remaining":
                    coffeeMachine.displayState();
                    break;
            }

            System.out.println();
        } while (!action.equals("exit"));
    }

    private static void takeMoney(CoffeeMachineSimulator coffeeMachine) {
        System.out.printf("I gave you $%d\n", coffeeMachine.giveMoney());
    }

    private static void buyCoffee(Scanner scanner, CoffeeMachineSimulator coffeeMachine) {
        System.out.println(
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String answer = scanner.next();
        if (!answer.equalsIgnoreCase("back")) {
            try {
                coffeeMachine.buy(CoffeeSort.values()[Integer.parseInt(answer) - 1]);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void addResources(Scanner scanner, CoffeeMachineSimulator coffeeMachine) {
        System.out.println("Write how many ml of water you want to add:");
        final var waterAmount = scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        final var milkAmount = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        final var coffeeAmount = scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        final var cupNumber = scanner.nextInt();

        coffeeMachine.addResources(waterAmount, milkAmount, coffeeAmount, cupNumber);
    }

    private static String askActionFromUser(Scanner scanner) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scanner.next().toLowerCase();
    }
}
