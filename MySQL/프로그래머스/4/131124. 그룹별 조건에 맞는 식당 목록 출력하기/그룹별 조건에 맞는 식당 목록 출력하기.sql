SELECT MP.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM MEMBER_PROFILE AS MP
JOIN REST_REVIEW AS R
ON MP.MEMBER_ID = R.MEMBER_ID
WHERE MP.MEMBER_ID IN (SELECT MEMBER_ID
                    FROM REST_REVIEW AS R
                    GROUP BY MEMBER_ID
                    HAVING
                        COUNT(MEMBER_ID) = 
                        (SELECT COUNT(MEMBER_ID)
                        FROM REST_REVIEW
                        GROUP BY MEMBER_ID
                        ORDER BY COUNT(MEMBER_ID) DESC
                        LIMIT 1)
                      )
ORDER BY REVIEW_DATE ASC, R.REVIEW_TEXT ASC