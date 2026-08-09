package org.example.ShoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    HashMap<String, String> users = new HashMap<>();
    ArrayList<Product> products = new ArrayList<>();
    HashMap<String, Cart> carts = new HashMap<>();

    Scanner sc;

    void main(String[] args) {
        System.out.println("Shopping Cart");
        sc = new Scanner(System.in);

        while(true) {
            System.out.println("1. Add user\n2. Get User\n3. Add Product\n" +
                    "4. Get Product\n5. Add to Cart\n6. Get Cart\n7. Exit");
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
                addToCart();
            } else if (choice == 6) {
                getCart();
            } else if (choice == 7) {
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

    }

    private void getProduct() {

    }

    private void addToCart() {

    }

    private void getCart() {

    }

}
