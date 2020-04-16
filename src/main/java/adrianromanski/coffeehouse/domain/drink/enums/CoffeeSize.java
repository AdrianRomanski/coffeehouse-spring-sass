package adrianromanski.coffeehouse.domain.drink.enums;

import java.util.HashMap;
import java.util.Map;

public enum CoffeeSize{
    ESPRESSO("50ml", 1.00),
    REGULAR("180ml", 2.15),
    CAPPUCCINO("220ml", 2.35),
    LATTE("400ml", 4.00),
    BEAST("750ml", 7.00);

    private final String amount;
    private final Double basePrice;

    private static final Map<String, CoffeeSize> sizes = new HashMap<>();

    CoffeeSize(String amount, Double basePrice) {
        this.amount = amount;
        this.basePrice = basePrice;
    }

    static {
        for(CoffeeSize c : CoffeeSize.values()) {
            sizes.put(c.name(), c);
        }
    }

    public static Map<String, CoffeeSize> getSizes() {
        return sizes;
    }


}
