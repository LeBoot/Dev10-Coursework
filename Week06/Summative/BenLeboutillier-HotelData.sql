-- Ensure that the schema is using the correct database.
USE HotelDB;

-- Add data to the table RoomType.
INSERT INTO RoomType (RoomTypeID, RoomTypeName, TypeOccupancy, MaxOccupancy, ExtraPersonFee)
	VALUES (1, 'Single', 2, 2, 0.00),
		(2, 'Double', 2, 4, 10.00),
		(3, 'Suite', 3, 8, 20.00);

-- Add data to table Amenities.
INSERT INTO Amenities (AmenitiesID, AmenityDescription)
	VALUES (1, 'Microwave'),
		(2, 'Refrigerator'),
        (3, 'Microwave and Refrigerator'),
        (4, 'Microwave, Refrigerator, and Oven');
        
-- Add data to table Guest.
INSERT INTO Guest (GuestID, FirstName, LastName, Address, City, StateAbbr, ZipCode, PhoneNum)
	VALUES (1, 'Ben', 'LeBoutillier', '123 Fake Street', 'Charlotte', 'NC', '28270', '1-555-555-0123'),
		(2, 'Mack', 'Simmer', '379 Old Shore Street', 'Council Bluffs', 'IA', '51501', '1-291-553-0508'),
        (3, 'Bettyann', 'Seery', '750 Wintergreen Dr.', 'Wasilla', 'AK', '99654', '1-478-277-9632'),
        (4, 'Duane', 'Cullison', '9662 Foxrun Lane', 'Harlingen', 'TX', '78552', '1-308-494-0198'),
        (5, 'Karie', 'Yang', '9378 W. Augusta Ave.', 'West Deptford', 'NJ', '08096', '1-214-730-0298'),
        (6, 'Aurore', 'Lipton', '762 Wild Rose Street', 'Saginaw', 'MI', '48601', '1-377-507-0974'),
        (7, 'Zachery', 'Luechtefeld', '7 Poplar Dr.', 'Arvada', 'CO', '80003', '1-814-485-2615'),
        (8, 'Jeremiah', 'Pendergrass', '70 Oakwood St.', 'Zion', 'IL', '60099', '1-279-491-0960'),
        (9, 'Walter', 'Holaway', '7556 Arrowhead St.', 'Cumberland', 'RI', '02864', '1-446-396-6785'),
        (10, 'Wilfred', 'Vise', '77 West Surrey Street', 'Oswego', 'NY', '13126', '1-834-727-1001'),
        (11, 'Maritza', 'Tilton', '939 Linda Rd.', 'Burke', 'VA', '22015', '1-446-351-6860'),
        (12, 'Joleen', 'Tison', '87 Queen St.', 'Drexel Hill', 'PA', '19026', '1-231-893-2755');

-- Add data to table Room.
INSERT INTO Room (RoomNum, ADA, Jacuzzi, BasePrice, RoomTypeID, AmenitiesID)
	VALUES ('201', 'n', 'y', 199.99, 2, 1),
		('202', 'y', 'n', 174.99, 2, 2),
        ('203', 'n', 'y', 199.99, 2, 1),
        ('204', 'y', 'n', 174.99, 2, 2),
        ('205', 'n', 'y', 174.99, 1, 3),
        ('206', 'y', 'n', 149.99, 1, 3),
        ('207', 'n', 'y', 174.99, 1, 3),
        ('208', 'y', 'n', 149.99, 1, 3),
        ('301', 'n', 'y', 199.99, 2, 1),
        ('302', 'y', 'n', 174.99, 2, 2),
        ('303', 'n', 'y', 199.99, 2, 1),
        ('304', 'y', 'n', 174.99, 2, 2),
        ('305', 'n', 'y', 174.99, 1, 3),
        ('306', 'y', 'n', 149.99, 1, 3),
        ('307', 'n', 'y', 174.99, 1, 3),
        ('308', 'y', 'n', 149.99, 1, 3),
        ('401', 'y', 'n', 399.99, 3, 4),
        ('402', 'y', 'n', 399.99, 3, 4);

-- Add data into table Reservation.
INSERT INTO Reservation (ReservationID, NumAdults, NumChildren, StartDate, EndDate, GuestID)
	VALUES (1, 1, 0, '2023-02-02', '2023-02-04', 2),
		(2, 2, 1, '2023-01-05', '2023-01-10', 3),
        (3, 2, 0, '2023-02-22', '2023-02-24', 4),
        (4, 2, 2, '2023-03-06', '2023-03-07', 5),
        (5, 1, 1, '2023-03-17', '2023-03-20', 1),
        (6, 3, 0, '2023-03-18', '2023-03-23', 6),
        (7, 2, 2, '2023-03-29', '2023-03-31', 7),
        (8, 2, 0, '2023-03-31', '2023-04-05', 8),
        (9, 1, 0, '2023-04-09', '2023-04-13', 9),
        (10, 1, 1, '2023-04-23', '2023-04-24', 10),
        (11, 2, 4, '2023-05-30', '2023-06-02', 11),
        (12, 2, 0, '2023-06-10', '2023-06-14', 12),
        (13, 1, 0, '2023-06-10', '2023-06-14', 12),
        (14, 3, 0, '2023-06-17', '2023-06-18', 6),
        (15, 2, 0, '2023-06-28', '2023-07-02', 1),
        (16, 3, 1, '2023-07-13', '2023-07-14', 9),
        (17, 4, 2, '2023-07-18', '2023-07-21', 10),
        (18, 2, 1, '2023-07-28', '2023-07-29', 3),
        (19, 1, 0, '2023-08-30', '2023-09-01', 3),
		(20, 2, 0, '2023-09-16', '2023-09-17', 2),
        (21, 2, 2, '2023-09-13', '2023-09-15', 5),
        (22, 2, 2, '2023-11-22', '2023-11-25', 4),
        (23, 2, 0, '2023-11-22', '2023-11-25', 2),
        (24, 2, 2, '2023-11-22', '2023-11-25', 2),
        (25, 2, 0, '2023-12-24', '2023-12-28', 11);
        
-- Add data into table RoomReservationBridge, combining information from tables Reservation and Room.
INSERT INTO RoomReservationBridge (RoomNum, ReservationID)
	VALUES ('308', 1),
		('203', 2),
        ('305', 3),
        ('201', 4),
        ('307', 5),
        ('302', 6),
        ('202', 7),
        ('304', 8),
        ('301', 9),
        ('207', 10),
        ('401', 11),
        ('206', 12),
        ('208', 13),
        ('304', 14),
        ('205', 15),
        ('204', 16),
        ('401', 17),
        ('303', 18),
        ('305', 19),
        ('208', 20),
        ('203', 21),
        ('401', 22),
        ('206', 23),
        ('301', 24),
        ('302', 25);
        
-- ------------------------------------------------------------------------------------
-- ------------------------------------------------------------------------------------        
-- Add script to delete Jeremiah Pendergrass

-- Find his GuestID
SELECT *
FROM Guest
WHERE FirstName LIKE 'JE%'; -- GuestID = 8

-- Find any of his reservations
SELECT *
FROM Reservation
WHERE GuestID = 8; -- There is one reservation, with ReservationID = 8

-- Delete all references with Jeremiah P.
DELETE FROM RoomReservationBridge
WHERE ReservationID = 8;

DELETE FROM Reservation
WHERE ReservationID = 8;

DELETE FROM Guest
WHERE GuestID = 8;