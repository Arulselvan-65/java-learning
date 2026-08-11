package org.example.ShoppingCart;

import lombok.Data;
import org.example.Utils.CommonUtil;

import java.util.HashMap;

@Data
public class Cart {

    private HashMap<String, Integer> products;
    private int totalAmount;

    public void addProduct(String productId, int amount) {
        if(CommonUtil.checkIsNullOrEmpty(products)) {
            products = new HashMap<>();
        }
        if(products.containsKey(productId)) {
            int count = products.get(productId);
            products.put(productId, ++count);
            totalAmount += amount;
        } else {
            products.put(productId, 1);
            totalAmount += amount;
        }
    }
}
