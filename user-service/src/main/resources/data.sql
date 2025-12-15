-- Thêm loại thú cưng
INSERT INTO types (name) VALUES ( 'cat');
INSERT INTO types (name) VALUES ('dog');
INSERT INTO types (name) VALUES ('lizard');

-- Thêm chủ nuôi
INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ('George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO owners (first_name, last_name, address, city, telephone) VALUES ( 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');

-- Thêm thú cưng
INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES ( 'Leo', '2010-09-07', 1, 1);
INSERT INTO pets (name, birth_date, type_id, owner_id) VALUES ('Basil', '2012-08-06', 2, 2);