package org.example.ShoppingCart;

import lombok.Data;
import org.example.Utils.CommonUtil;

import java.util.Map;
import java.util.HashMap;

@Data
public class Cart {

    private Map<String, Integer> products;

    public void addProduct(String productId) {
        if(CommonUtil.checkIsNullOrEmpty(products)) {
            products = new HashMap<>();
        }
        products.merge(productId, 1, Integer::sum);
    }
}
