-- CREATE DATABASE IF IT DOES NOT EXISTS aym;
USE aym;

-- Products
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('ANNABELLE', 350, 'noImageForNow', 2, false, 315);
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('MATILDA', 650, 'noImageForNow', 3, false, 585);

-- Colors
INSERT INTO color (color_name) VALUES ('blue');
INSERT INTO color (color_name) VALUES ('red');

-- Product-Color associations
INSERT INTO product_color (product_id, color_id) VALUES (1, 2); -- ANNABELLE is associated with color 'red'
INSERT INTO product_color (product_id, color_id) VALUES (2, 1); -- MATILDA is associated with color 'blue'

-- Materials
INSERT INTO material (name) VALUES ('gold');
INSERT INTO material (name) VALUES ('silver');

-- Sizes
INSERT INTO size (size_name) VALUES ('large');
INSERT INTO size (size_name) VALUES ('small');

-- Categories
INSERT INTO category (name) VALUES ('ring');
INSERT INTO category (name) VALUES ('necklace');

-- Product-Category associations
INSERT INTO product_category (product_id, category_id) VALUES (1, 1); -- ANNABELLE is associated with ring category
INSERT INTO product_category (product_id, category_id) VALUES (2, 2); -- MATILDA is associated with necklace category
INSERT INTO product_category (product_id, category_id) VALUES (1, 2); -- ANNABELLE is associated with necklace category
