
INSERT INTO freshshop.product_statuses ("name", inserted_at, updated_at) VALUES('test', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO freshshop.products (title, img, price, product_status_id, company, info, incart, count, total, inserted_at, updated_at) VALUES('Tomato', 'img/tomato.jpg', 10, 1, 'FreshShop', 'Yellow', false, 0, 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
