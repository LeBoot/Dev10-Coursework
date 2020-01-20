USE PersonalTrainer;

-- Select all columns from ExerciseCategory and Exercise.
-- The tables should be joined on ExerciseCategoryId.
-- This query returns all Exercises and their associated ExerciseCategory.
-- 64 rows
--------------------
SELECT *
FROM Exercise
INNER JOIN ExerciseCategory
	ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId;
    
    
    
-- Select ExerciseCategory.Name and Exercise.Name
-- where the ExerciseCategory does not have a ParentCategoryId (it is null).
-- Again, join the tables on their shared key (ExerciseCategoryId).
-- 9 rows
--------------------
SELECT
	ExerciseCategory.Name ExerciseCategoryName,
    Exercise.Name ExerciseName
FROM ExerciseCategory
INNER JOIN Exercise
	ON ExerciseCategory.ExerciseCategoryID = Exercise.ExerciseCategoryID
WHERE ExerciseCategory.ParentCategoryID IS NULL;



-- Select FirstName, LastName, and BirthDate from Client
-- and EmailAddress from Login 
-- where Client.BirthDate is in the 1990s.
-- Join the tables by their key relationship. 
-- What is the primary-foreign key relationship?
-- 35 rows
--------------------
SELECT
	c.FirstName,
    c.LastName,
    c.BirthDate,
    l.EmailAddress
FROM `Client` c
INNER JOIN Login l
	ON c.ClientID = l.ClientID
WHERE c.BirthDate BETWEEN '1990-01-01' AND '1999-12-31';



-- Select Workout.Name, Client.FirstName, and Client.LastName
-- for Clients with LastNames starting with 'C'?
-- How are Clients and Workouts related?
-- 25 rows
--------------------
SELECT
	w.Name WorkoutName,
    CONCAT(c.FirstName, ' ', c.LastName) ClientName
FROM `Client` c
INNER JOIN ClientWorkout
	ON ClientWorkout.clientID = c.clientID
INNER JOIN Workout w
	ON ClientWorkout.workoutID = w.workoutID
WHERE c.LastName LIKE 'c%';



-- Select Names from Workouts and their Goals.
-- This is a many-to-many relationship with a bridge table.
-- Use aliases appropriately to avoid ambiguous columns in the result.
--------------------
SELECT
	w.`Name` WorkoutName,
    g.`Name` GoalName
FROM Workout w
INNER JOIN WorkoutGoal wg
	ON w.WorkoutID = wg.WorkoutID
INNER JOIN Goal g
	ON g.GoalID = wg.GoalID;
    



-- Select FirstName and LastName from Client.
-- Select ClientId and EmailAddress from Login.
-- Join the tables, but make Login optional.
-- 500 rows
--------------------
SELECT
	CONCAT(c.FirstName, ' ', c.LastName) ClientName,
    l.ClientID,
    l.EmailAddress
FROM Login l
RIGHT JOIN `Client` c
	ON l.ClientID = c.ClientID;



-- Using the query above as a foundation, select Clients
-- who do _not_ have a Login.
-- 200 rows
--------------------
SELECT
	CONCAT(c.FirstName, ' ', c.LastName) ClientName,
    l.ClientID,
    l.EmailAddress
FROM Login l
RIGHT JOIN `Client` c
	ON l.ClientID = c.ClientID
WHERE l.clientID IS NULL;



-- Does the Client, Romeo Seaward, have a Login?
-- Decide using a single query.
-- nope :(
--------------------
SELECT
	l.ClientID
FROM `Client` c
LEFT OUTER JOIN Login l
	ON c.ClientID = l.ClientID
WHERE c.LastName = 'Seaward' AND c.FirstName = 'Romeo';




-- Select ExerciseCategory.Name and its parent ExerciseCategory's Name.
-- This requires a self-join.
-- 12 rows
--------------------
SELECT
	ecParent.`Name` ParentName,
    ecChild.`Name` Childname
FROM ExerciseCategory ecParent
INNER JOIN ExerciseCategory ecChild
	ON ecParent.ExerciseCategoryID = ecChild.ParentCategoryID;


    
-- Rewrite the query above so that every ExerciseCategory.Name is
-- included, even if it doesn't have a parent.
-- 16 rows
--------------------
SELECT
	ecParent.`Name` ParentName,
    ecChild.`Name` Childname
FROM ExerciseCategory ecParent
RIGHT JOIN ExerciseCategory ecChild
	ON ecParent.ExerciseCategoryID = ecChild.ParentCategoryID;



    
-- Are there Clients who are not signed up for a Workout?
-- 50 rows
--------------------
SELECT *
FROM `Client` c
LEFT JOIN ClientWorkout cw
	ON c.clientID = cw.clientID
WHERE cw.workoutID IS NULL;




-- Which Beginner-Level Workouts satisfy at least one of Shell Creane's Goals?
-- Goals are associated to Clients through ClientGoal.
-- Goals are associated to Workouts through WorkoutGoal.
-- 6 rows, 4 unique rows
--------------------
SELECT *
FROM Level; -- Beginner is level 1

SELECT
	w.`Name` WorkoutName,
    g.`Name` Goal,
    l.`Name` `Level`
FROM Level l
INNER JOIN Workout w
	ON l.levelID = w.levelID
INNER JOIN WorkoutGoal wg
	ON w.workoutID = wg.workoutID
INNER JOIN Goal g
	ON wg.goalID = g.goalID
INNER JOIN ClientGoal cg
	ON g.goalID = cg.goalID
INNER JOIN `Client` c
	ON cg.clientID = c.clientID
WHERE
	c.FirstName = 'Shell'
    AND c.LastName = 'Creane'
    AND l.levelID = 1;



-- Select all Workouts. 
-- Join to the Goal, 'Core Strength', but make it optional.
-- You may have to look up the GoalId before writing the main query.
-- If you filter on Goal.Name in a WHERE clause, Workouts will be excluded.
-- Why?
-- 26 Workouts, 3 Goals
--------------------
SELECT *
FROM Goal; -- Core Strength = 10

SELECT *
FROM Workout
WHERE workout.name LIKE '3%';

SELECT
	w.`Name` WorkoutName,
    g.`Name` GoalName
FROM Workout w
LEFT OUTER JOIN WorkoutGoal wg
	ON w.WorkoutID = wg.WorkoutID AND wg.goalID = 10
LEFT OUTER JOIN Goal g
	ON wg.goalID = g.goalID;




-- The relationship between Workouts and Exercises is... complicated.
-- Workout links to WorkoutDay (one day in a Workout routine)
-- which links to WorkoutDayExerciseInstance 
-- (Exercises can be repeated in a day so a bridge table is required) 
-- which links to ExerciseInstance 
-- (Exercises can be done with different weights, repetions,
-- laps, etc...) 
-- which finally links to Exercise.
-- Select Workout.Name and Exercise.Name for related Workouts and Exercises.
--------------------
SELECT
	w.`Name` WorkoutName,
    e.`Name` ExerciseName
FROM Workout w
INNER JOIN WorkoutDay wd
	ON w.WorkoutID = wd.WorkoutID
INNER JOIN WorkoutDayExerciseInstance wdei
	ON wd.WorkoutDayID = wdei.WorkoutDayID
INNER JOIN ExerciseInstance ei
	ON wdei.exerciseInstanceID = ei.exerciseInstanceID
INNER JOIN Exercise e
	ON ei.exerciseID = e.exerciseID;



   
-- An ExerciseInstance is configured with ExerciseInstanceUnitValue.
-- It contains a Value and UnitId that links to Unit.
-- Example Unit/Value combos include 10 laps, 15 minutes, 200 pounds.
-- Select Exercise.Name, ExerciseInstanceUnitValue.Value, and Unit.Name
-- for the 'Plank' exercise. 
-- How many Planks are configured, which Units apply, and what 
-- are the configured Values?
-- 4 rows, 1 Unit, and 4 distinct Values
--------------------
SELECT *
FROM exercise; -- Plank's exerciseID = 17

SELECT
	e.`Name` ExerciseName,
    eiuv.`Value` eiUnitValue,
    u.`Name` UnitName
FROM Exercise e
INNER JOIN ExerciseInstance ei
	ON e.ExerciseID = ei.ExerciseID AND e.ExerciseID = 17
INNER JOIN ExerciseInstanceUnitValue eiuv
	ON ei.ExerciseInstanceID = eiuv.ExerciseInstanceID
INNER JOIN Unit u
	ON eiuv.UnitID = u.unitID;