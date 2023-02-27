INSERT INTO BRAND (id, name) VALUES (1, 'eCommmerce');

INSERT INTO PRODUCT (id, name) VALUES (35455, 'T-Shirt');

INSERT INTO PRICE_LIST (id, rate) VALUES 
(1, 25.00),
(2, 30.00),
(3, 40.00),
(4, 50.00),
(5, 75.00);

INSERT INTO PRICE (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES 
(1, 1, '2020-06-14T00:00:00', '2020-12-31T23:59:59', 1, 35455, 0, 35.50, 'EUR'),
(2, 1, '2020-06-14T15:00:00', '2020-06-14T18:30:00', 2, 35455, 1, 25.45, 'EUR'),
(3, 1, '2020-06-15T00:00:00', '2020-06-15T11:00:00', 3, 35455, 1, 30.50, 'EUR'),
(4, 1, '2020-06-15T16:00:00', '2020-12-31T23:59:59', 4, 35455, 1, 38.95, 'EUR');
