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
        checkResources(coffeeSort);
        makeCoffee(coffeeSort);
    }

    private void checkResources(CoffeeSort coffeeSort) {
        final var failureMessageFormat = "Sorry, not enough %s!";
        String messsage = null;
        var hasEnoughResources = false;
        if (coffeeSort.getWaterAmount() > waterAmount) {
            messsage = String.format(failureMessageFormat, "water");
        } else if (coffeeSort.getMilAmount() > milkAmount) {
            messsage = String.format(failureMessageFormat, "milk");
        } else if (coffeeSort.getCoffeeAmount() > coffeeAmount) {
            messsage = String.format(failureMessageFormat, "coffee beans");
        } else if (cupNumber < 1) {
            messsage = String.format(failureMessageFormat, "disposable cups");
        } else {
            messsage = "I have enough resources, making you a coffee!";
            hasEnoughResources = true;
        }

        if (!hasEnoughResources) {
            throw new NotEnoughResourcesException(messsage);
        }

        System.out.println(messsage);
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
}
