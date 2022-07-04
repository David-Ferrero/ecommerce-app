INSERT INTO brands (brand_name) VALUES ('ZARA');
INSERT INTO brands (brand_name) VALUES ('PULL&BEAR');
INSERT INTO brands (brand_name) VALUES ('MASSIMO DUTTI');
INSERT INTO brands (brand_name) VALUES ('BERSHKA');

INSERT INTO PRICES (brand_id, start_date, end_date, product_id, priority, price, curr)
    VALUES (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES (brand_id, start_date, end_date, product_id, priority, price, curr)
    VALUES (1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES (brand_id, start_date, end_date, product_id, priority, price, curr)
    VALUES (1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES (brand_id, start_date, end_date, product_id, priority, price, curr)
    VALUES (1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 35455, 1, 38.95, 'EUR');
