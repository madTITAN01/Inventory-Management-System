package com.ankit.inventory;
import java.sql.*;
public class ProductService {
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (product_name, quantity, price) VALUES (?, ?, ?)";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setInt(2, product.getQuantity());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
            System.out.println("Product added.");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void viewProducts() {
        String sql = "SELECT * FROM products";
        try (Connection con = DatabaseManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\nID | Name | Quantity | Price");
            while (rs.next()) {
                System.out.printf("%d | %s | %d | %.2f%n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4));
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void updateQuantity(int id, int qty) {
        String sql = "UPDATE products SET quantity=? WHERE product_id=?";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, qty);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Updated.");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE product_id=?";
        try (Connection con = DatabaseManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Deleted.");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}