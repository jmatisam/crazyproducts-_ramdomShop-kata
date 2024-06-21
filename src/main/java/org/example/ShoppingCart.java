package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Double getTotalPrice() {
        return products.stream()
                .map(this::calculatePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .doubleValue();
    }

    private BigDecimal calculatePrice(Product product) {
        if (isSpider(product)) {
            return calculateSpiderPrice(product);
        } else if (hasBasePriceAndColor(product)) {
            return calculatePriceFishBasedOnColor(product);
        } else if (isBlackLotus(product)) {
            return BigDecimal.valueOf(40000.0);
        } else if (isMagicCard(product)) {
            return calculateMagicCardPrice(product);
        } else if (hasAge(product)) {
            return calculatePriceGourmet(product);
        }
        return product.getSellPrice();
    }

    private boolean isSpider(Product product) {
        return product.getNumberOfLegs() != null && product.getName().equalsIgnoreCase("spider");
    }

    private boolean hasBasePriceAndColor(Product product) {
        return product.getBasePrice() != null && product.getColor() != null;
    }

    private boolean isBlackLotus(Product product) {
        return product.getName().equals("Magic: The Gathering - Black Lotus");
    }

    private boolean isMagicCard(Product product) {
        return product.getName().startsWith("Magic: The Gathering");
    }

    private boolean hasAge(Product product) {
        return product.getAge() != null;
    }

   
    private BigDecimal calculateSpiderPrice(Product product) {
        BigDecimal pricePerLeg = BigDecimal.valueOf(1.2);
        BigDecimal basePrice = BigDecimal.valueOf(product.getNumberOfLegs()).multiply(pricePerLeg);

        switch (product.getColor().toLowerCase()) {
            case "red" -> basePrice = basePrice.add(BigDecimal.valueOf(2.0));
            case "gold" -> basePrice = basePrice.add(BigDecimal.valueOf(3.0));
        }

        if (product.isStinky()) {
            basePrice = basePrice.divide(BigDecimal.valueOf(2));
        }

        return basePrice;
    }

    private BigDecimal calculatePriceFishBasedOnColor(Product product) {
        return switch (product.getColor().toLowerCase()) {
            case "blue" -> product.getBasePrice().add(BigDecimal.valueOf(0.1));
            case "gold" -> product.getBasePrice().multiply(BigDecimal.valueOf(100.0));
            default -> product.getBasePrice();
        };
    }

    private BigDecimal calculateMagicCardPrice(Product product) {
        return switch (product.getColor().toLowerCase()) {
            case "blue" -> product.getAge() != null && product.getAge() > 10
                ? BigDecimal.valueOf(2.5)
                : BigDecimal.valueOf(5.0);
            case "red" -> product.getAge() != null && product.getAge() > 10
                ? BigDecimal.valueOf(1.75)
                : BigDecimal.valueOf(3.5);
            case "green" -> product.getAge() != null && product.getAge() > 20
                ? BigDecimal.valueOf(4.4).multiply(BigDecimal.valueOf(1.2))
                : BigDecimal.valueOf(4.4);
            case "black" -> product.getAge() != null && product.getAge() > 20
                ? BigDecimal.valueOf(6.8).multiply(BigDecimal.valueOf(1.2))
                : BigDecimal.valueOf(6.8);
            default -> BigDecimal.valueOf(2.0);
        };
    }

    private BigDecimal calculatePriceGourmet(Product product) {
        return product.isStinky()
                ? BigDecimal.valueOf(10.0 * product.getAge())
                : BigDecimal.valueOf(20.0 * product.getAge());
    }
}
