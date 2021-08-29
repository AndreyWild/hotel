-- -----------------------------------------------------
-- Filling Guests
-- -----------------------------------------------------
INSERT INTO hotel.guests (name, age) VALUES
('Eddard Stark',50),
('Catelyn Stark',46),
('Robb Stark',26),
('Sansa Stark',20),
('Arya Stark',17),
('Bran Stark',16),
('Rickon Stark',10),
('Jon Snow',25),
('Benjen Stark',64),
('Lyanna Stark', 52);

-- -----------------------------------------------------
-- Filling Rooms
-- -----------------------------------------------------
INSERT INTO hotel.rooms (number, capacity, price, stars) VALUES
(101, 1, 250.0, 'ONE'),
(102, 2, 200.0, 'FOUR'),
(103, 3, 150.0, 'THREE'),
(104, 4, 100.0, 'TWO'),
(105, 1, 350.0, 'FIVE'),
(106, 2, 300.0, 'FOUR'),
(107, 3, 250.0, 'THREE'),
(108, 4, 200.0, 'TWO'),
(109, 1, 500.0, 'FIVE'),
(110, 2, 450.0, 'FOUR');

-- -----------------------------------------------------
-- Filling Maintenances
-- -----------------------------------------------------
INSERT INTO hotel.maintenances (name, price) VALUES
('Room cleaning',50.0),
('Cleaning clothes',10.0),
('Shoe shine',5.0),
('Food ordering',75.0),
('Call order',3.0),
('Intercity call order',10.0),
('Cable TV order',30.0),
('Pay channel order',3.0),
('Morning Wake Order',2.0),
('Mini bar', 120.0);

-- -----------------------------------------------------
-- Filling Orders
-- -----------------------------------------------------
INSERT INTO hotel.orders (id_guest, id_room, check_in, check_out)VALUES
(1, 1, '2021-01-01', '2021-03-31'),
(2, 2, '2021-01-02', '2021-03-31'),
(3, 3, '2021-01-03', '2021-03-31'),
(4, 4, '2021-01-04', '2021-03-31');

-- -----------------------------------------------------
-- Filling ord_maint
-- -----------------------------------------------------
insert INTO hotel.ord_maint (id_order, id_maintenance) values
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 1);