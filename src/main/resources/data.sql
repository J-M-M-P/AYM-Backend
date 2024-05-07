-- CREATE DATABASE IF IT DOES NOT EXISTS aym;
USE aym;

INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('ANNABELLE', 350, 'noImageForNow', 2, false, 315);
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('MATILDA', 650, 'noImageForNow', 3, false, 585);
INSERT INTO products (name, price, image, qty, on_sale, discount_price) VALUES ('FREJA', 1500, 'noImageForNow', 11, true, 200);

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

-- News
INSERT INTO news (created, headline, content, image) VALUES (NOW(), "Udsalg", "Fra 15/6-2024 - 22/-6-2024 sætter vi priserne ned på alle vores smykker", "Image 1");
INSERT INTO news (created, headline, content, image) VALUES (NOW(), "Lagersalg", "Gør et kup lørdag den 20/7-2024, da vi holder stort lagersalg på Vesterbro i København", "Image 2");