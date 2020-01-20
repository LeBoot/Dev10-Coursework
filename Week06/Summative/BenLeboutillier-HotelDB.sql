-- Destroys existing database, if exists; this way, start from scratch each time.
DROP DATABASE IF EXISTS HotelDB;

-- Create database.
CREATE DATABASE HotelDB;

-- Ensure that the schema is using the correct database.
USE HotelDB;

-- Create table for RoomType.
CREATE TABLE RoomType (
	RoomTypeID INT PRIMARY KEY AUTO_INCREMENT,
    RoomTypeName VARCHAR(6) NOT NULL,
    TypeOccupancy TINYINT NOT NULL,
    MaxOccupancy TINYINT NOT NULL,
    ExtraPersonFee DOUBLE(4,2) NOT NULL
);

-- Crete table for Amenities.
CREATE TABLE Amenities (
	AmenitiesID INT PRIMARY KEY AUTO_INCREMENT,
    AmenityDescription VARCHAR(50) NOT NULL
);

-- Create table for Room, which has foreign keys from tables RoomType and Amenities.
CREATE TABLE Room (
	RoomNum VARCHAR(3) PRIMARY KEY,
    ADA VARCHAR(1) NOT NULL,
    Jacuzzi VARCHAR(1) NOT NULL,
    BasePrice DOUBLE(6, 2) NOT NULL,
    RoomTypeID INT NOT NULL,
    AmenitiesID INT NOT NULL,
    FOREIGN KEY fk_room_roomtype (RoomTypeID)
		REFERENCES RoomType (RoomTypeID),
	FOREIGN KEY fk_room_amenitiesid (AmenitiesID)
		REFERENCES Amenities (AmenitiesID)
);

-- Create table for Guest.
CREATE TABLE Guest (
	GuestID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(20) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    Address VARCHAR(60) NULL,
    City VARCHAR(15) NULL,
    StateAbbr VARCHAR(2) NULL,
    ZipCode VARCHAR(9) NULL,
    PhoneNum VARCHAR(14) NULL
);

-- Create table for Reservation, which has foreign key from table Guest.
CREATE TABLE Reservation (
	ReservationID INT PRIMARY KEY AUTO_INCREMENT,
    NumAdults TINYINT NOT NULL,
    NumChildren TINYINT NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    GuestID INT NOT NULL,
    FOREIGN KEY fk_reservation_guest (GuestID)
		REFERENCES Guest (GuestID)
);

-- Create table for RoomReservationBridge, which bridges tables Room and Reservation.
CREATE TABLE RoomReservationBridge (
	RoomNum VARCHAR(3) NOT NULL,
    ReservationID INT NOT NULL,
    PRIMARY KEY pk_roomreservation (RoomNum, ReservationID),
    FOREIGN KEY fk_roomreservationbridge_room (RoomNum)
		REFERENCES Room (RoomNum),
	FOREIGN KEY fk_roomreservationbridge_reservation (ReservationID)
		REFERENCES Reservation (ReservationID)
);