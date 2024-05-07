-- CREATE DATABASE IF IT DOES NOT EXISTS aym;
USE aym;

-- Products
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('ANABELLE', 350, 'noImageForNow', 2, false, 315);
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('MATILDA', 650, 'noImageForNow', 3, false, 585);
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('MARTHA', 250, 'noImageForNow', 5, false, 225);
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('FREJA', 1500, 'noImageForNow', 11, true, 200);

-- Colors
INSERT INTO color (color_name) VALUES ('HAVANA BROWN');
INSERT INTO color (color_name) VALUES ('OSAKA MINT');

-- Product-Color associations
INSERT INTO product_color (product_id, color_id) VALUES (1, 1); -- ANNABELLE is associated with color 'red'
INSERT INTO product_color (product_id, color_id) VALUES (3, 2); -- MARTHA is associated with color 'blue'

-- Materials
INSERT INTO material (name) VALUES ('celluloseacetat');
INSERT INTO material (name) VALUES ('stainless steel');
INSERT INTO material (name) VALUES ('freshwater pearls');
INSERT INTO material (name) VALUES ('celluloseacetat pearls');

-- Product-Material associations
INSERT INTO product_material (product_id, material_id) VALUES (1, 1); -- ANNABELLE is associated with color 'red'
INSERT INTO product_material (product_id, material_id) VALUES (2, 3); -- MATILDA is associated with color 'blue'
INSERT INTO product_material (product_id, material_id) VALUES (3, 2); -- MARTHA is associated with color 'blue'
INSERT INTO product_material (product_id, material_id) VALUES (3, 4); -- MARTHA is associated with color 'blue'

-- Sizes
INSERT INTO size (size_name) VALUES ('one size');
INSERT INTO size (size_name) VALUES ('small');
INSERT INTO size (size_name) VALUES ('medium');

-- Product-Size associations
INSERT INTO product_size (product_id, size_id) VALUES (1, 2); -- ANABELLE is associated with size 'one size'
INSERT INTO product_size (product_id, size_id) VALUES (1, 3); -- ANABELLE is associated with size 'small'
INSERT INTO product_size (product_id, size_id) VALUES (2, 1); -- MATILDA is associated with size 'one size'
INSERT INTO product_size (product_id, size_id) VALUES (3, 1); -- MARTHA is associated with size 'one size'

-- Categories
INSERT INTO category (name) VALUES ('bracelet');
INSERT INTO category (name) VALUES ('necklace');
INSERT INTO category (name) VALUES ('earring');

-- Product-Category associations
INSERT INTO product_category (product_id, category_id) VALUES (1, 1); -- ANNABELLE is associated with ring category
INSERT INTO product_category (product_id, category_id) VALUES (2, 2); -- MATILDA is associated with necklace category
INSERT INTO product_category (product_id, category_id) VALUES (3, 3); -- MARTHA is associated with necklace category

-- News
INSERT INTO news (created, headline, content, image) VALUES (NOW(), "Udsalg", "Fra 15/6-2024 - 22/-6-2024 sætter vi priserne ned på alle vores smykker", "Image 1");
INSERT INTO news (created, headline, content, image) VALUES (NOW(), "Lagersalg", "Gør et kup lørdag den 20/7-2024, da vi holder stort lagersalg på Vesterbro i København", "Image 2");