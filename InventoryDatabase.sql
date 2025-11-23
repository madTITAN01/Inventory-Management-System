CREATE DATABASE inventory_db;
USE inventory_db;

CREATE TABLE products(
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100),
    quantity INT,
    price DOUBLE
);