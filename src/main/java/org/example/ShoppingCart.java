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
        return  products.stream()
                .map(this::calculatePrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .doubleValue();
    }

    private BigDecimal calculatePrice(Product product) {
        if (product.getNumberOfLegs() != null) {
        
            if (product.getName().equalsIgnoreCase("spider")) {
                
                if (product.getColor().equalsIgnoreCase("red")) {
                    if (product.isStinky())
                        return ((BigDecimal.valueOf(1.2).multiply(BigDecimal.valueOf(product.getNumberOfLegs())).add(BigDecimal.valueOf(2.0)))).divide(BigDecimal.valueOf(2));
                    else{
                        return (BigDecimal.valueOf(1.2).multiply(BigDecimal.valueOf(product.getNumberOfLegs())).add(BigDecimal.valueOf(2.0)));
                    }

                }else if (product.getColor().equalsIgnoreCase("gold")) {
                    if (product.isStinky())
                        return ((BigDecimal.valueOf(1.2).multiply(BigDecimal.valueOf(product.getNumberOfLegs())).add(BigDecimal.valueOf(3.0)))).divide(BigDecimal.valueOf(2));
                    else{
                        return (BigDecimal.valueOf(1.2).multiply(BigDecimal.valueOf(product.getNumberOfLegs())).add(BigDecimal.valueOf(3.0)));
                    } 
                }else if (product.isStinky()){ 
                    return (BigDecimal.valueOf(1.2).multiply(BigDecimal.valueOf(product.getNumberOfLegs()))).divide(BigDecimal.valueOf(2.0));
                }else{        
                
                return BigDecimal.valueOf(1.2).multiply(BigDecimal.valueOf(product.getNumberOfLegs()));
                }


            }else {
                return BigDecimal.valueOf(4.2).multiply(BigDecimal.valueOf(product.getNumberOfLegs()));
            }

        }else if (product.getColor() != null && product.getBasePrice() != null) {
                return switch (product.getColor()) {
                    case "blue" -> product.getBasePrice().add(BigDecimal.valueOf(0.1));
                    case "gold" -> product.getBasePrice().multiply(BigDecimal.valueOf(100.0));
                    default -> product.getBasePrice();
                };
        }else if (product.getName().equals("Magic: The Gathering - Black Lotus")) {
                return BigDecimal.valueOf(40000.0);
           
        }else if (product.getName().startsWith("Magic: The Gathering")) {
            switch (product.getColor()) {
                case "blue" -> {
                    if (product.getAge() != null && product.getAge() > 10) {
                        return BigDecimal.valueOf(2.5);
                    } else {
                        return BigDecimal.valueOf(5.0);
                    }
                }
                case "red" -> {
                    if (product.getAge() != null && product.getAge() > 10) {
                        return BigDecimal.valueOf(1.75);
                    } else {
                        return BigDecimal.valueOf(3.5);
                    }
                }
                case "green" -> {
                    if (product.getAge() != null && product.getAge() > 20) {
                        return BigDecimal.valueOf(4.4).multiply(BigDecimal.valueOf(1.2));
                    } else {
                        return BigDecimal.valueOf(4.4);
                    }
                }
                case "black" -> {
                    if (product.getAge() != null && product.getAge() > 20) {
                        return BigDecimal.valueOf(6.8).multiply(BigDecimal.valueOf(1.2));
                    } else {
                        return BigDecimal.valueOf(6.8);
                    }
                }
                default -> {
                    return BigDecimal.valueOf(2.0);
                }
            
            }
        }else if (product.getAge() != null) {
            if (product.isStinky()) {
                return BigDecimal.valueOf(10.0* product.getAge());
            } else {
                return BigDecimal.valueOf(20.0 * product.getAge());
            } 
        }return product.getSellPrice();
            
    }
}
    

