-- Insert Sample Customers
INSERT INTO Customer (name, email, created_at) 
VALUES ('John Doe', 'john.doe@email.com', '2026-02-25');

INSERT INTO Customer (name, email, created_at) 
VALUES ('Jane Smith', 'jane.smith@email.com', '2026-02-25');

INSERT INTO Customer (name, email, created_at) 
VALUES ('Alice Cooper', 'alice.c@email.com', '2026-02-25');

-- Insert Sample Orders linked to Customer #1 (John Doe)
INSERT INTO Orders (order_date, amount, customer_id) 
VALUES ('2026-02-25', 99.99, 1);

INSERT INTO Orders (order_date, amount, customer_id) 
VALUES ('2026-02-26', 150.50, 1);
INSERT INTO Orders (order_date, amount, customer_id) 
VALUES ('2026-02-25', 150.50, 1);

-- Insert Sample Order linked to Customer #2 (Jane Smith)
INSERT INTO Orders (order_date, amount, customer_id) 
VALUES ('2026-02-28', 45.00, 2);