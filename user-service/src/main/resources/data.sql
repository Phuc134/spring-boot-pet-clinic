-- Thêm loại thú cưng
INSERT INTO types (id, name) VALUES (1, 'cat');
INSERT INTO types (id, name) VALUES (2, 'dog');
INSERT INTO types (id, name) VALUES (3, 'lizard');

-- Thêm chủ nuôi
INSERT INTO owners (id, first_name, last_name, address, city, telephone) VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO owners (id, first_name, last_name, address, city, telephone) VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');

-- Thêm thú cưng
INSERT INTO pets (id, name, birth_date, type_id, owner_id) VALUES (1, 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets (id, name, birth_date, type_id, owner_id) VALUES (2, 'Basil', '2012-08-06', 2, 2);