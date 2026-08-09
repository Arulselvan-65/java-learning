package org.example.ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String productId;
    private String productName;
    private int productCount;

}
