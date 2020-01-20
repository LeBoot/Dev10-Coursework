use PersonalTrainer;

-- Use an aggregate to count the number of Clients.
-- 500 rows
--------------------
SELECT
	COUNT(`client`.clientID)
FROM `client`;



-- Use an aggregate to count Client.BirthDate.
-- The number is different than total Clients. Why?
-- 463 rows
--------------------
SELECT
	COUNT(BirthDate)
FROM `Client`;

SELECT
	COUNT(`Client`.BirthDate)
FROM `Client`;

SELECT
	COUNT(c.BirthDate)
FROM `Client` c;



-- Group Clients by City and count them.
-- Order by the number of Clients desc.
-- 20 rows
--------------------
SELECT
	`Client`.City City,
    COUNT(`Client`.ClientID) NumberOfClients    
FROM `Client`
GROUP BY `Client`.City
ORDER BY NumberOfClients DESC;



-- Calculate a total per invoice using only the InvoiceLineItem table.
-- Group by InvoiceId.
-- You'll need an expression for the line item total: Price * Quantity.
-- Aggregate per group using SUM().
-- 1000 rows
--------------------
SELECT
	ili.invoiceID,
    SUM(ili.Price * ili.Quantity) InventoryTotalPrice
FROM InvoiceLineItem ili
GROUP BY ili.InvoiceID;



-- Calculate a total per invoice using only the InvoiceLineItem table.
-- (See above.)
-- Only include totals greater than $500.00.
-- Order from lowest total to highest.
-- 234 rows
--------------------
SELECT
	invoiceID,
    SUM(Price * Quantity) InventoryTotalPrice
FROM InvoiceLineItem
GROUP BY InvoiceID
HAVING InventoryTotalPrice > 500
ORDER BY InventoryTotalPrice DESC;



-- Calculate the average line item total
-- grouped by InvoiceLineItem.Description.
-- 3 rows
--------------------
SELECT
	AVG(Price * Quantity) AvgTotal
FROM InvoiceLineItem
GROUP BY `Description`;



-- Select ClientId, FirstName, and LastName from Client
-- for clients who have *paid* over $1000 total.
-- Paid is Invoice.InvoiceStatus = 2.
-- Order by LastName, then FirstName.
-- 146 rows
--------------------
SELECT
    c.FirstName FirstName,
    c.LastName LastName,
    SUM(ili.price * ili.quantity) Total,
    c.clientID ClientID
FROM `Client` c
INNER JOIN `Invoice` i
	ON c.clientID = i.clientID
INNER JOIN `InvoiceLineItem` ili
	ON i.invoiceID = ili.invoiceID
WHERE i.invoiceStatus = 2
GROUP BY 
	ClientID,
    FirstName,
    LastName
HAVING Total > 1000
ORDER BY c.LastName, c.FirstName;




-- Count exercises by category.
-- Group by ExerciseCategory.Name.
-- Order by exercise count descending.
-- 13 rows
--------------------
SELECT
	ExerciseCategory.`Name` Category,
    COUNT(*) NumberOfExercises
FROM Exercise
	INNER JOIN ExerciseCategory
		ON Exercise.ExerciseCategoryID = ExerciseCategory.ExerciseCategoryID
GROUP BY ExerciseCategory.`Name`
ORDER BY COUNT(*) DESC;



-- Select Exercise.Name along with the minimum, maximum,
-- and average ExerciseInstance.Sets.
-- Order by Exercise.Name.
-- 64 rows
--------------------
SELECT
	e.`Name` ExerciseName,
    MIN(ei.Sets) MinSets,
    MAX(ei.Sets) MaxSets,
    AVG(ei.Sets) AvgSets
FROM Exercise e
	INNER JOIN ExerciseInstance ei
		ON e.exerciseID = ei.exerciseID
GROUP BY e.exerciseID
ORDER BY ExerciseName;




-- Find the minimum and maximum Client.BirthDate
-- per Workout.
-- 26 rows
-- Sample: 
-- WorkoutName, EarliestBirthDate, LatestBirthDate
-- '3, 2, 1... Yoga!', '1928-04-28', '1993-02-07'
--------------------
SELECT
	w.`Name` WorkoutName,
    MIN(c.birthDate) MinBDay,
    MAX(c.birthDate) MaxBDay
FROM `Client` c
	INNER JOIN ClientWorkout cw
		ON c.clientID = cw.clientID
	INNER JOIN Workout w
		ON cw.workoutID = w.workoutID
GROUP BY w.workoutID, WorkoutName
ORDER BY WorkoutName;



-- Count client goals.
-- Be careful not to exclude rows for clients without goals.
-- 500 rows total
-- 50 rows with no goals
--------------------
SELECT
	CONCAT(c.FirstName, ' ', c.LastName) `Name`,
    COUNT(g.goalID) NumGoals,
    c.clientID ClientID
FROM `Client` c
	LEFT JOIN ClientGoal cg
		ON c.clientID = cg.clientID
	LEFT JOIN Goal g
		ON cg.goalID = g.goalID
GROUP BY c.clientID
ORDER BY NumGoals;




-- Select Exercise.Name, Unit.Name, 
-- and minimum and maximum ExerciseInstanceUnitValue.Value
-- for all exercises with a configured ExerciseInstanceUnitValue.
-- Order by Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	e.`Name` `ExerciseName`,
    u.`Name` `UnitName`,
    MIN(eiuv.`value`) `MinValue`,
    MAX(eiuv.`value`) `MaxValue`
FROM Exercise e
	INNER JOIN ExerciseInstance ei
		ON e.exerciseID = ei.exerciseID
	INNER JOIN ExerciseInstanceUnitValue eiuv
		ON ei.exerciseInstanceID = eiuv.exerciseInstanceID
	INNER JOIN Unit u
		ON eiuv.UnitID = u.unitID
GROUP BY e.exerciseID, `ExerciseName`, u.unitID, `UnitName`
ORDER BY ExerciseName, UnitName;




-- Modify the query above to include ExerciseCategory.Name.
-- Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
-- 82 rows
--------------------
SELECT
	ec.`Name` `CategoryName`,
    e.`Name` `ExerciseName`,
    MIN(eiuv.`value`) `MinValue`,
    MAX(eiuv.`value`) `MaxValue`,
    u.`Name` `UnitName`
FROM Exercise e
	INNER JOIN ExerciseInstance ei
		ON e.exerciseID = ei.exerciseID
	INNER JOIN ExerciseInstanceUnitValue eiuv
		ON ei.exerciseInstanceID = eiuv.exerciseInstanceID
	INNER JOIN Unit u
		ON eiuv.UnitID = u.unitID
	INNER JOIN ExerciseCategory ec
		ON e.exerciseCategoryID = ec.exerciseCategoryID
GROUP BY e.exerciseID, `ExerciseName`, u.unitID, `UnitName`, `CategoryName`
ORDER BY CategoryName, ExerciseName, UnitName;




-- Select the minimum and maximum age in years for
-- each Level.
-- To calculate age in years, use the MySQL function DATEDIFF.
-- 4 rows
--------------------
SELECT
	L.levelID LevelID,
    L.`Name` LevelName,
    MIN(DATEDIFF(CURDATE(),c.BirthDate)/365.25) MinAge,
    MAX(DATEDIFF(CURDATE(),c.BirthDate)/365.25) MaxAge
FROM `Client` c
	INNER JOIN ClientWorkout cw
		ON c.clientID = cw.clientID
	INNER JOIN Workout w
		ON cw.workoutID = w.workoutID
	INNER JOIN `Level` L
		ON w.levelID = L.levelID
GROUP BY LevelID, LevelName
ORDER BY LevelID;



-- Stretch Goal!
-- Count logins by email extension (.com, .net, .org, etc...).
-- Research SQL functions to isolate a very specific part of a string value.
-- 27 rows (27 unique email extensions)
--------------------
SELECT
	SUBSTRING_INDEX(L.EmailAddress, '.', -1) Ending,
    COUNT(L.EmailAddress) Count  
FROM `Login` L
GROUP BY Ending
ORDER BY Count DESC;




-- Stretch Goal!
-- Match client goals to workout goals.
-- Select Client FirstName and LastName and Workout.Name for
-- all workouts that match at least 2 of a client's goals.
-- Order by the client's last name, then first name.
-- 139 rows
--------------------
SELECT
    CONCAT(c.`FirstName`, ' ', c.`LastName`) `Client Name`,
    w.`Name` `Workout Name`,
    COUNT(cg.`goalID`) `NumGoals`
FROM `Client` c
	INNER JOIN `ClientGoal` cg
		ON c.`ClientID` = cg.`ClientID`
	INNER JOIN `WorkoutGoal` wg
		ON cg.`GoalID` = wg.`GoalID`
    INNER JOIN `Workout` w
		ON wg.`WorkoutID` = w.`WorkoutID`
GROUP BY w.`WorkoutID`, c.`clientID`
HAVING `NumGoals` > 1
ORDER BY c.`LastName`;