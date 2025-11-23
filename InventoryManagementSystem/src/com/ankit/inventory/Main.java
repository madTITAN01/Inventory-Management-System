package com.ankit.inventory;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService ps = new ProductService();

        while (true) {
            System.out.println("\n=== Inventory Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Quantity");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = Integer.parseInt(sc.nextLine());
                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    ps.addProduct(new Product(name, qty, price));
                }
                case 2 -> ps.viewProducts();
                case 3 -> {
                    System.out.print("Enter Product ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new Quantity: ");
                    int newQty = Integer.parseInt(sc.nextLine());
                    ps.updateQuantity(id, newQty);
                }
                case 4 -> {
                    System.out.print("Enter Product ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    ps.deleteProduct(id);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("❌ Invalid Option");
            }
        }
    }
}