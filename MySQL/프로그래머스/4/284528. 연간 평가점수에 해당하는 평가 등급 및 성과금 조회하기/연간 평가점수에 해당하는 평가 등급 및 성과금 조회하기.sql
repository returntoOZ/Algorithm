WITH GR AS(
    SELECT EMP_NO AS E,
        CASE
            WHEN AVG(SCORE) >= 96 THEN 'S'
            WHEN AVG(SCORE) >= 90 THEN 'A'
            WHEN AVG(SCORE) >= 80 THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_GRADE
    GROUP BY EMP_NO
), CTE AS(
    SELECT E.EMP_NO, E.EMP_NAME, G.GRADE,
        CASE
            WHEN G.GRADE = 'S' THEN E.SAL * 0.2
            WHEN G.GRADE = 'A' THEN E.SAL * 0.15
            WHEN G.GRADE = 'B' THEN E.SAL * 0.1
            ELSE 0
        END AS BONUS
    FROM HR_EMPLOYEES E
    JOIN GR G
    ON E.EMP_NO = G.E
    ORDER BY E.EMP_NO ASC
)

SELECT *
FROM CTE