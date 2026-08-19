package org.example.ShoppingCart;

import org.example.Utils.CommonUtil;
import org.example.Utils.ScannerUtil;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static HashMap<String, String> users = new HashMap<>();
    public static HashMap<String, Product> products = new HashMap<>();
    public static HashMap<String, Cart> carts = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Shopping Cart");

        while(true) {
            System.out.println("1. Add user\n2. Get User\n3. Add Product\n" +
                    "4. Get Product\n5. Get All Products\n6. Add to Cart\n7. Get Cart\n8. Exit");
            System.out.println("Enter your choice: ");
            int choice = ScannerUtil.readInt();
            ScannerUtil.readString();

            if (choice == 1) {
               addUser();
            } else if (choice == 2) {
                getUser();
            } else if (choice == 3) {
                addProduct();
            } else if (choice == 4) {
                getProduct();
            } else if (choice == 5) {
                getAllProducts();
            } else if (choice == 6) {
                addToCart();
            } else if (choice == 7) {
                getCart();
            } else if (choice == 8) {
                System.exit(0);
            } else {
                System.out.println("Invalid Choice!!");
            }
        }
    }

    private static void addUser() {
        System.out.println("Enter User Name: ");
        String name = ScannerUtil.readString();
        String id = "U" + (users.size() + 1);
        users.put(id, name);
        System.out.format("User added successfully with User Id: %s\n", id);
    }

    private static void getUser() {
        System.out.println("Enter User Id: ");
        String id = ScannerUtil.readString();
        if(!users.containsKey(id)) {
            System.out.println("User Not Found!");
            return;
        }
        System.out.println("User Id: " + id);
        System.out.println("User Name: " + users.get(id));
    }

    private static void addProduct() {
        System.out.println("Enter Product Name: ");
        String name = ScannerUtil.readString();
        String id = "P" + (products.size() + 1);
        System.out.println("Enter Product Rate: ");
        int count = ScannerUtil.readInt();
        products.put(id, new Product(name, count));
        System.out.format("Product added successfully with Product Id: %s\n", id);
    }

    private static void getProduct() {
        System.out.println("Enter Product Id: ");
        String id = ScannerUtil.readString();
        if(!products.containsKey(id)) {
            System.out.println("Product Not Found!");
            return;
        }
        System.out.println("Product Id: " + id);
        System.out.println("Product Name: " + products.get(id).getProductName());
        System.out.println("Product Rate: " + products.get(id).getProductRate());
    }

    private static void getAllProducts() {
        int count = products.size();
        System.out.println("Product Id    Product Name    Product Rate");
        for(int i=0;i<count;i++) {
            String id = "P" + (i+1);
            System.out.format("%s    %s    %d\n", id, products.get(id).getProductName(),
                    products.get(id).getProductRate());
        }
    }

    private static void addToCart() {
        System.out.println("Enter User Id: ");
        String uid = ScannerUtil.readString();
        System.out.println("Enter Product Id: ");
        String id = ScannerUtil.readString();
        if(!users.containsKey(uid)) {
            System.out.println("User Not Found!");
            return;
        }
        if(!products.containsKey(id)) {
            System.out.println("Product Not Found!");
            return;
        }
        Cart cart = carts.computeIfAbsent(uid, _ -> new Cart());
        cart.addProduct(id);
        System.out.println("Product Added Successfully!!");
    }

    private static void getCart() {
        System.out.println("Enter User Id: ");
        String uid = ScannerUtil.readString();
        if(!users.containsKey(uid)) {
            System.out.println("User Not Found!");
            return;
        }
        Cart cart = carts.get(uid);
        if(CommonUtil.checkIsNullOrEmpty(cart)) {
            System.out.println("Cart is Empty!!");
            return;
        }
        Map<String, Integer> prods = cart.getProducts();
        int totalAmount = 0;
        System.out.println("Product Id    Product Quantity    Amount");
        for(int i=0;i<products.size();i++) {
            String id = "P" + (i+1);
            int amount = products.get(id).getProductRate() * prods.get(id);
            System.out.format("%s    %d    %d\n",id, prods.get(id), amount);
            totalAmount += amount;
        }
        System.out.println("Total Amount: " + totalAmount);
    }
}
