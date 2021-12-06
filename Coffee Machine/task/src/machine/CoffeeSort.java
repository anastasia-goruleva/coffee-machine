package machine;

public enum CoffeeSort {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int waterAmount;
    private final int milAmount;
    private final int coffeeAmount;
    private final int cost;

    CoffeeSort(int waterAmount, int milAmount, int coffeeAmount, int cost) {
        this.waterAmount = waterAmount;
        this.milAmount = milAmount;
        this.coffeeAmount = coffeeAmount;
        this.cost = cost;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getMilAmount() {
        return milAmount;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public int getCost() {
        return cost;
    }
}
