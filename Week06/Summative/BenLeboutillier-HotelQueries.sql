-- Ensure that the schema is using the correct database.
USE HotelDB;



-- Query 1: Write a query that returns a list of reservations that end in July 2023, 
	-- including the name of the guest, the room number(s), and the reservation dates.
SELECT
	CONCAT(g.FirstName, ' ', g.LastName) GuestName,
    rm.RoomNum RoomNum,
    res.StartDate StartDate,
    res.EndDate EndDate
FROM Reservation res
	INNER JOIN Guest g
		ON res.guestID = g.guestID
	INNER JOIN RoomReservationBridge rrb
		ON res.ReservationID = rrb.ReservationID
	INNER JOIN Room rm
		ON rrb.RoomNum = rm.RoomNum
WHERE res.EndDate BETWEEN '2023-07-01' AND '2023-07-31';

-- Results: 4 rows (B Leb, 205; W Hol, 204; W Vis, 401; B See, 303)

    

-- Query 2: Write a query that returns a list of all reservations for rooms with a jacuzzi, 
	-- displaying the guest's name, the room number, and the dates of the reservation.
SELECT
	CONCAT(g.FirstName, ' ', g.LastName) GuestName,
    rm.RoomNum RoomNum,
    res.StartDate StartDate,
    res.EndDate EndDate
FROM Reservation res
	INNER JOIN Guest g
		ON res.guestID = g.guestID
	INNER JOIN RoomReservationBridge rrb
		ON res.ReservationID = rrb.ReservationID
	INNER JOIN Room rm
		ON rrb.RoomNum = rm.RoomNum
WHERE rm.Jacuzzi = 'y';

-- Results: 11 rows, all odd-numbered rooms
    

    
-- Query 3: Write a query that returns all the rooms reserved for a specific guest, 
	-- including the guest's name, the room(s) reserved, the starting date of the reservation, 
	-- and how many people were included in the reservation. (Choose a guest's name from the existing data.)    
SELECT
	CONCAT(g.FirstName, ' ', g.LastName) GuestName,
	rm.RoomNum RoomNum,
	res.StartDate StartDate,
    (res.NumAdults + res.NumChildren) TotalPeople
FROM Guest g
	INNER JOIN Reservation res
		ON g.guestID = res.guestID
	INNER JOIN RoomReservationBridge rrb
		ON res.reservationID = rrb.reservationID
	INNER JOIN Room rm
		ON rrb.roomNum = rm.roomNum
WHERE g.guestID = (
		SELECT guestID
        FROM Guest
        WHERE FirstName LIKE 'MARI%'
	);
	
-- Results: 2 Rows (Both M Tilton, roomms 401 [May, 6 ppl] then 302 [December, 2 ppl])
		
        

-- Query 4: Write a query that returns a list of rooms, reservation ID, and per-room cost for each reservation.
	-- The results should include all rooms, whether or not there is a reservation associated with the room.
SELECT
	rm.RoomNum RoomNum,
    res.ReservationID ReservationID,
    rm.BasePrice PerRoomCost
FROM Room rm
	LEFT OUTER JOIN RoomReservationBridge rrb
		ON rm.RoomNum = rrb.RoomNum
	LEFT OUTER JOIN Reservation res
		ON rrb.ReservationID = res.ReservationID;

-- Results: 26 rows (rooms 306 and 402 are null)
    
    
    
    
-- Query 5: Write a query that returns all the rooms accommodating at least three guests and that are
	-- reserved on any date in April 2023.
SELECT
	rm.RoomNum RoomNumber,
    (res.NumAdults + res.NumChildren) TotalGuests
FROM Reservation res
	INNER JOIN RoomReservationBridge rrb
		ON res.ReservationID = rrb.ReservationID
	INNER JOIN Room rm
		ON rrb.RoomNum = rm.RoomNum
WHERE
	(res.NumAdults + res.NumChildren) >= 3
	AND ((res.StartDate BETWEEN '2023-04-01' AND '2023-04-30')
		OR (res.EndDate BETWEEN '2023-04-01' AND '2023-04-30'));

-- Results: 0 rows
    
    
    
-- Query 6: Write a query that returns a list of all guest names and the number of reservations per guest,
	-- sorted starting with the guest with the most reservations and then by the guest's last name.
SELECT
	CONCAT(g.FirstName, ' ', g.LastName) GuestName,
    COUNT(res.ReservationID) NumReservations
FROM Guest g
	LEFT OUTER JOIN Reservation res
		ON g.guestID = res.guestID
	LEFT OUTER JOIN RoomReservationBridge rrb
		ON res.reservationID = rrb.reservationID
	LEFT OUTER JOIN Room rm
		ON rrb.roomNum = rm.roomNum
GROUP BY g.GuestID
ORDER BY NumReservations DESC, g.LastName;

-- Results: 11 rows (M Sim, 4; B See, 3; Z Lue, 1; All othes, 2)



-- Query 7: Write a query that displays the name, address, and phone number of a guest based on their phone number.
	-- (Choose a phone number from the existing data.)
SELECT 
	CONCAT(FirstName, ' ', LastName) GuestName,
    CONCAT(Address, '; ', City, ', ', StateAbbr, ' ', ZipCode) Address,
    PhoneNum
FROM Guest
WHERE PhoneNum = '1-377-507-0974';

-- Results: 1 row (A Lipton)