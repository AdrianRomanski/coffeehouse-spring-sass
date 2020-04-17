package adrianromanski.coffeehouse.domain.drink.enums;


/**
 * We can use this class for custom Coffee Creation later or either load the data from DB
 */
public enum CoffeeSize{
    ESPRESSO("50ml", 1.00),
    REGULAR("180ml", 2.15),
    CAPPUCCINO("220ml", 2.35),
    LATTE("400ml", 4.00),
    BEAST("750ml", 7.00);

    private final String amount;
    private final Double basePrice;

    CoffeeSize(String amount, Double basePrice) {
        this.amount = amount;
        this.basePrice = basePrice;
    }

    public Double getBasePrice() {
        return basePrice;
    }
}
