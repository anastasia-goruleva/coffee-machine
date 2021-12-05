package machine;

public class CoffeeMachineSimulator {
    private int waterAmount;
    private int milkAmount;
    private int coffeeAmount;

    private interface AmountPerCup {
        int MILK = 50;
        int WATER = 200;
        int COFFEE = 15;
    }

    public CoffeeMachineSimulator(int waterAmount, int milkAmount, int coffeeAmount) {
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.coffeeAmount = coffeeAmount;
    }

    public void displayNumberOfServings(int requestedNumber) {
        final var realNumber = computeNumberOfServings();
        String answer;
        if (realNumber < requestedNumber) {
            answer = String.format("No, I can make only %d cup(s) of coffee", realNumber);
        } else if (realNumber > requestedNumber) {
            answer = String.format("Yes, I can make that amount of cofee (and even %d more than that)",
                    realNumber - requestedNumber);
        } else {
            answer = "Yes, I can make that amount of coffee";
        }
        System.out.println(answer);
    }

    private int computeNumberOfServings() {
        return Math.min(waterAmount / AmountPerCup.WATER,
                Math.min(milkAmount / AmountPerCup.MILK, coffeeAmount / AmountPerCup.COFFEE));
    }

    public static void displayIngredients(int cupNumber) {
        System.out.printf("For %d cups of coffee you will need:\n", cupNumber);
        System.out.printf("%d ml of water\n", AmountPerCup.WATER * cupNumber);
        System.out.printf("%d ml of milk\n", AmountPerCup.MILK * cupNumber);
        System.out.printf("%d g of coffee beans\n", AmountPerCup.COFFEE * cupNumber);
    }

    public static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
