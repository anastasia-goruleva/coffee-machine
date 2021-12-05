package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var coffeeMachine = createCoffeeMachineSimulator(scanner);
        coffeeMachine.displayNumberOfServings(askCupNumber(scanner));
    }

    private static CoffeeMachineSimulator createCoffeeMachineSimulator(Scanner scanner) {
        System.out.println("Write how many ml of water the coffee machine has:");
        final var waterAmount = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        final var milkAmount = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        final var coffeeAmount = scanner.nextInt();

        return new CoffeeMachineSimulator(waterAmount, milkAmount, coffeeAmount);
    }

    private static int askCupNumber(Scanner scanner) {
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }
}
