package org.example.ShoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    HashMap<String, String> users = new HashMap<>();
    HashMap<String, Product> products = new HashMap<>();
    HashMap<String, Cart> carts = new HashMap<>();

    Scanner sc;

    void main(String[] args) {
        System.out.println("Shopping Cart");
        sc = new Scanner(System.in);

        while(true) {
            System.out.println("1. Add user\n2. Get User\n3. Add Product\n" +
                    "4. Get Product\n5. Get All Products\n6. Add to Cart\n7. Get Cart\n8. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                this.addUser();
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

    private void addUser() {
        System.out.println("Enter User Name: ");
        String name = sc.nextLine();
        String id = "U" + (users.size() + 1);
        users.put(id, name);
        System.out.format("User added successfully with User Id: %s\n", id);
    }

    private void getUser() {
        System.out.println("Enter User Id: ");
        String id = sc.nextLine();
        if(!users.containsKey(id)) {
            System.out.println("User Not Found!");
            return;
        }
        System.out.println("User Id: " + id);
        System.out.println("User Name: " + users.get(id));
    }

    private void addProduct() {
        System.out.println("Enter Product Name: ");
        String name = sc.nextLine();
        String id = "P" + (products.size() + 1);
        System.out.println("Enter Product Rate: ");
        int count = sc.nextInt();
        products.put(id, new Product(name, count));
        System.out.format("Product added successfully with Product Id: %s\n", id);
    }

    private void getProduct() {
        System.out.println("Enter Product Id: ");
        String id = sc.nextLine();
        if(!products.containsKey(id)) {
            System.out.println("Product Not Found!");
            return;
        }
        System.out.println("Product Id: " + id);
        System.out.println("Product Name: " + products.get(id).getProductName());
        System.out.println("Product Rate: " + products.get(id).getProductRate());
    }

    private void getAllProducts() {
        int count = products.size();
        System.out.println("Product Id    Product Name    Product Rate");
        for(int i=0;i<count;i++) {
            String id = "P" + (i+1);
            System.out.format("%s    %s    %d\n", id, products.get(id).getProductName(),
                    products.get(id).getProductRate());
        }
    }

    private void addToCart() {
        System.out.println("Enter User Id: ");
        String uid = sc.nextLine();
        System.out.println("Enter Product Id: ");
        String id = sc.nextLine();
        if(!users.containsKey(uid)) {
            System.out.println("User Not Found!");
            return;
        }
        if(!products.containsKey(id)) {
            System.out.println("Product Not Found!");
            return;
        }
        if(carts.containsKey(uid)) {
            Cart cart = carts.get(uid);
            cart.addProduct(id, products.get(id).getProductRate());
        } else {
            Cart cart = new Cart();
            cart.addProduct(id, products.get(id).getProductRate());
            carts.put(uid, cart);
        }
        System.out.println("Product Added Successfully!!");
    }

    private void getCart() {
        System.out.println("Enter User Id: ");
        String uid = sc.nextLine();
        if(!users.containsKey(uid)) {
            System.out.println("User Not Found!");
            return;
        }
        Cart cart = carts.get(uid);
        HashMap<String, Integer> prods = cart.getProducts();
        System.out.println("Product Id    Product Quantity");
        for(int i=0;i<products.size();i++) {
            String id = "P" + (i+1);
            System.out.format("%s    %d\n",id, prods.get(id));
        }
        System.out.println("Total Amount: " + cart.getTotalAmount());

    }

}
