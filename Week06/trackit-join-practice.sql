USE trackit;

SELECT
	Task.TaskID,
    Task.Title,
    TaskStatus.Name
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusID = Task.TaskStatusID
WHERE TaskStatus.IsResolved = 1;

SELECT
	Project.Name,
    Task.Title,
    Worker.FirstName,
    Worker.LastName
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectID = ProjectWorker.ProjectID
INNER JOIN Worker ON ProjectWorker.WorkerID = Worker.WorkerID
INNER JOIN Task ON ProjectWorker.ProjectID = Task.ProjectID
	AND ProjectWorker.WorkerID = Task.WorkerID
WHERE Project.ProjectID = 'game-goodboy' AND Task.Title = 'Build Level 2';

SELECT -- To find projects with no workers
	Project.Name ProjectName -- An alias makes this more clear.
FROM project -- First, find all the projects and include the workers in the search
LEFT OUTER JOIN ProjectWorker ON Project.ProjectID = ProjectWorker.ProjectID
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerID = Worker.WorkerID
WHERE ProjectWorker.WorkerID IS NULL; -- Throws out the projects that have workers

SELECT -- To find workers with no projects (using RIGHT join)
    Worker.FirstName,
    Worker.LastName
FROM project -- First, find all the workers and include the projects in the search
RIGHT OUTER JOIN ProjectWorker ON Project.ProjectID = ProjectWorker.ProjectID
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerID = Worker.WorkerID
WHERE ProjectWorker.ProjectID IS NULL; -- Throws out the workers that have projects

SELECT -- To find workers with no projects (using LEFT join)
    Worker.FirstName,
    Worker.LastName
FROM Worker -- First, find all the workers and include the projects in the search
LEFT OUTER JOIN ProjectWorker ON Worker.WorkerID = ProjectWorker.WorkerID
WHERE ProjectWorker.WorkerID IS NULL; -- Throws out the workers that have projects

SELECT -- To self-join parent/child classes, aliases must be used
	parent.TaskID ParentTaskID,
    child.TaskID ChildTaskID,
    CONCAT(parent.Title, ': ', child.Title) Title
FROM Task parent
INNER JOIN Task child ON parent.TaskID = child.ParentTaskId;

-- To see the worker with ID = 1 combined with every possible non-game
-- (Even if the relationships do not actually exists)
SELECT
	CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    p.Name projectName
FROM Worker w
CROSS JOIN Project p
WHERE w.WorkerID = 1 AND p.ProjectID NOT LIKE 'game-%';

SELECT
	t.title,
    s.Name statusName
FROM Task t
LEFT OUTER JOIN TaskStatus s
	ON t.TaskStatusID = s.TaskStatusID
ORDER BY ISNULL(s.Name), s.Name ASC;

SELECT
    IFNULL(s.Name, '[None]') StatusName,
    IFNULL(s.IsResolved, 0) IsResolved,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.Name, s.IsResolved -- IsResolved is now part of the GROUP.
ORDER BY s.Name;

SELECT
    IFNULL(s.Name, '[None]') StatusName,
    s.IsResolved,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.Name
ORDER BY s.Name;

SELECT
    CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    SUM(t.EstimatedHours) TotalHours
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Task t ON pw.WorkerId = t.WorkerId
    AND pw.ProjectId = t.ProjectId
GROUP BY w.WorkerId-- , w.FirstName, w.LastName
HAVING SUM(t.EstimatedHours) >= 100
ORDER BY SUM(t.EstimatedHours) DESC;

SELECT
    p.Name ProjectName,
    MIN(t.DueDate) MinTaskDueDate
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
WHERE p.ProjectId LIKE 'game-%'
    AND t.ParentTaskId IS NOT NULL
GROUP BY p.ProjectId, p.Name
ORDER BY MinTaskDueDate;

SELECT
    p.Name ProjectName,
    MIN(t.DueDate) MinTaskDueDate,
    MAX(t.DueDate) MaxTaskDueDate,
    SUM(t.EstimatedHours) TotalHours,
    AVG(t.EstimatedHours) AverageTaskHours,
    COUNT(t.TaskId) TaskCount
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
WHERE t.ParentTaskId IS NOT NULL
GROUP BY p.ProjectId, p.Name
HAVING COUNT(t.TaskId) >= 10
ORDER BY COUNT(t.TaskId) DESC, p.Name;