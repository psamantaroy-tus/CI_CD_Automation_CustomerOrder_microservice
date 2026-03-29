-- 1. Drop tables if they exist to ensure a clean start
-- Drop Child table first because of Foreign Key constraints
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customer;

-- 2. Create the Parent Table: CUSTOMER
CREATE TABLE customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    created_at DATE DEFAULT CURRENT_DATE
);

-- 3. Create the Child Table: ORDERS
-- Note: 'ORDER' is a reserved keyword in SQL, so we name the table 'orders'
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE NOT NULL,
    amount DOUBLE NOT NULL,
    customer_id BIGINT NOT NULL,
    
    -- This enforces the One-to-Many relationship at the database level
    CONSTRAINT fk_customer 
        FOREIGN KEY (customer_id) 
        REFERENCES customer(id) 
        ON DELETE CASCADE -- This implements the "Cascading Delete" requirement
);