package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        displayIngredients(askCupNumber(new Scanner(System.in)));
    }

    public interface AmountPerCup {
        int MILK = 50;
        int WATER = 200;
        int COFFEE = 15;
    }

    private static void displayIngredients(int cupNumber) {
        System.out.printf("For %d cups of coffee you will need:\n", cupNumber);
        System.out.printf("%d ml of water\n", AmountPerCup.WATER * cupNumber);
        System.out.printf("%d ml of milk\n", AmountPerCup.MILK * cupNumber);
        System.out.printf("%d g of coffee beans\n", AmountPerCup.COFFEE * cupNumber);
    }

    private static int askCupNumber(Scanner scanner) {
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }

    private static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
