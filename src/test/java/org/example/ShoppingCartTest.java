package org.example;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


class ShoppingCartTest {

    @Test 
    void calculatePriceForSpider() {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Product arañasimple8patas = new Product(8, null, false, "green", null, "spider", null);
        shoppingCart.addProduct(arañasimple8patas);

        assertEquals(9.60, shoppingCart.getTotalPrice());        
    }

    @Test 
    void calculatePriceForSpiderRed() {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Product arañasimple8patas = new Product(8, null, false, "red", null, "spider", null);
        shoppingCart.addProduct(arañasimple8patas);

        assertEquals(11.60, shoppingCart.getTotalPrice());        
    }

    @Test 
    void calculatePriceForSpiderRedStinky() {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Product arañasimple8patas = new Product(8, null, true, "red", null, "spider", null);
        shoppingCart.addProduct(arañasimple8patas);

        assertEquals(5.80, shoppingCart.getTotalPrice());        
    }

    @Test 
    void calculatePriceForSpiderGold() {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Product arañasimple8patas = new Product(8, null, false, "gold", null, "spider", null);
        shoppingCart.addProduct(arañasimple8patas);

        assertEquals(12.60, shoppingCart.getTotalPrice());        
    }

    @Test 
    void calculatePriceForSpiderGoldStinky() {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Product arañasimple8patas = new Product(8, null, true, "gold", null, "spider", null);
        shoppingCart.addProduct(arañasimple8patas);

        assertEquals(6.30, shoppingCart.getTotalPrice());        
    }
    
    @Test 
    void calculatePriceForSpiderStinky() {
        ShoppingCart shoppingCart = new ShoppingCart();
        
        Product arañasimple8patas = new Product(8, null, true, "green", null, "spider", null);
        shoppingCart.addProduct(arañasimple8patas);

        assertEquals(4.80, shoppingCart.getTotalPrice());        
    }

    @Test
    void calculatePriceForCheese() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 5, true, null, null, "French Camembert", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 50.0);

    }

    @Test
    void calculatePriceForWine() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 5, false, null, null, "el tio juanillo", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 100.0);

    }

    @Test
    void calculatePriceForFish_base() {
        ShoppingCart shoppingCart = new ShoppingCart();

        BigDecimal basePrice = new BigDecimal("1.0");
        Product product = new Product(null, null, false, "red", basePrice, "fish", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 1.0);
    }

    @Test
    void calculatePriceForFish_blue() {
        ShoppingCart shoppingCart = new ShoppingCart();

        BigDecimal basePrice = new BigDecimal("0.0");
        Product product = new Product(null, null, false, "blue", basePrice, "fish", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 0.10);
    }

    @Test
    void calculatePriceForFish_gold() {
        ShoppingCart shoppingCart = new ShoppingCart();

        //BigDecimal basePrice = new BigDecimal("1.0");
        Product product = new Product(null, null, false, "gold", basePrice, "fish", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 100);
    }

    @Test
    void calculatePriceForMagicCards_Magic_BlackLotus() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, null, false, "blue", null, "Magic: The Gathering - Black Lotus", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 40000.0);

    }

    @Test
    void calculatePriceForMagicCards_blue() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 5, false, "blue", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 5.0);

    }
    @Test
    void calculatePriceForMagicCards_blue_MoreTenYears() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 11, false, "blue", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 2.5);

    }

    @Test
    void calculatePriceForMagicCards_red(){
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 5, false, "red", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 3.50);

    }
    @Test
    void calculatePriceForMagicCards_red_MoreTenYears() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 11, false, "red", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 1.75);

    }

    @Test
    void calculatePriceForMagicCards_green() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 7, false, "green", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 4.40);

    }
    @Test
    void calculatePriceForMagicCards_green__MoreTwentyYears() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 21, false, "green", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 5.28);

    }

    @Test
    void calculatePriceForMagicCards_black_(){
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 7, false, "black", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 6.80);

    }
    @Test
    void calculatePriceForMagicCards_black_MoreTwentyYears() {
        ShoppingCart shoppingCart = new ShoppingCart();

        Product product = new Product(null, 21, false, "black", null, "Magic: The Gathering - Maga Eternal", null);
        shoppingCart.addProduct(product);

        assertEquals(shoppingCart.getTotalPrice(), 8.16);

    }

}