-- CREATE DATABASE IF IT DOES NOT EXISTS aym;
USE aym;

INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('ANNABELLE', 350, 'noImageForNow', 2, false, 315);
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('MATILDA', 650, 'noImageForNow', 3, false, 585);

-- Colors
INSERT INTO color (color_name) VALUES ('blue');
INSERT INTO color (color_name) VALUES ('red');

-- Materials
INSERT INTO material (name) VALUES ('gold');
INSERT INTO material (name) VALUES ('silver');

-- Sizes
INSERT INTO size (size_name) VALUES ('large');
INSERT INTO size (size_name) VALUES ('small');

-- Categories
INSERT INTO category (name) VALUES ('ring');
INSERT INTO category (name) VALUES ('necklace');
