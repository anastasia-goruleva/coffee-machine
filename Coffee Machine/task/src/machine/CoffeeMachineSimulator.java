package machine;

public class CoffeeMachineSimulator {
    private int waterAmount;
    private int milkAmount;
    private int coffeeAmount;
    private int cupNumber;
    private int money;

    public CoffeeMachineSimulator() {
        this(400, 540, 120, 9, 550);
    }

    public void displayState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", waterAmount);
        System.out.printf("%d ml of milk\n", milkAmount);
        System.out.printf("%d g of coffee beans\n", coffeeAmount);
        System.out.printf("%d disposable cups\n", cupNumber);
        System.out.printf("$%d of money\n", money);
    }

    public void addResources(int waterAmount, int milkAmount, int coffeeAmount, int cupNumber) {
        this.waterAmount += waterAmount;
        this.milkAmount += milkAmount;
        this.coffeeAmount += coffeeAmount;
        this.cupNumber += cupNumber;
    }

    public void buy(CoffeeSort coffeeSort) {
        final var failureMessageFormat = "Sorry, not enough %s!";
        String failureMessage = null;
        if (coffeeSort.getWaterAmount() > waterAmount) {
            failureMessage = String.format(failureMessageFormat, "water");
        } else if (coffeeSort.getMilAmount() > milkAmount) {
            failureMessage = String.format(failureMessageFormat, "milk");
        } else if (coffeeSort.getCoffeeAmount() > coffeeAmount) {
            failureMessage = String.format(failureMessageFormat, "coffee beans");
        } else if (cupNumber < 1) {
            failureMessage = String.format(failureMessageFormat, "disposable cups");
        }

        if (failureMessage != null) {
            throw new RuntimeException(failureMessage);
        }

        System.out.println("I have enough resources, making you a coffee!");
        makeCoffee(coffeeSort);
    }

    private void makeCoffee(CoffeeSort coffeeSort) {
        waterAmount -= coffeeSort.getWaterAmount();
        milkAmount -= coffeeSort.getMilAmount();
        coffeeAmount -= coffeeSort.getCoffeeAmount();
        --cupNumber;
        money += coffeeSort.getCost();
    }

    public int giveMoney() {
        final var currentMoney = money;
        money = 0;
        return currentMoney;
    }

    private CoffeeMachineSimulator(int waterAmount, int milkAmount, int coffeeAmount, int cupNumber, int money) {
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.coffeeAmount = coffeeAmount;
        this.cupNumber = cupNumber;
        this.money = money;
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
