USE TrackIt;

-- ----------------------------

SELECT *
FROM Worker;

SELECT DISTINCT WorkerID
FROM ProjectWorker;

SELECT *
FROM WORKER
WHERE WorkerId IN (
    SELECT WorkerId FROM ProjectWorker
);

-- ----------------------------

SELECT
    g.ProjectName,
    g.MinTaskId,
    t.Title MinTaskTitle
FROM Task t
INNER JOIN (
    SELECT
        p.Name ProjectName,
        MIN(t.TaskId) MinTaskId
    FROM Project p
    INNER JOIN Task t ON p.ProjectId = t.ProjectId
    GROUP BY p.ProjectId, p.Name) g ON t.TaskId = g.MinTaskId
ORDER BY MinTaskTitle;

SELECT
        p.Name ProjectName,
        MIN(t.TaskId) MinTaskId
    FROM Project p
    INNER JOIN Task t ON p.ProjectId = t.ProjectId
    GROUP BY p.ProjectId, p.Name;