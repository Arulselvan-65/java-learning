package org.example.ShoppingCart;

import lombok.Data;
import org.example.Utils.CommonUtil;

import java.util.HashMap;

@Data
public class Cart {

    private HashMap<String, Integer> products;
    private int totalAmount;


    public void addProduct(String productId) {
        if(products.isEmpty()) {
            products = new HashMap<>();
        }
        if(products.containsKey(productId)) {
            int count = products.get(productId);
            products.put(productId, ++count);
        }
    }
}
