select tweet_id 
from Tweets 
where LENGTH(content) > 15;

-- SELECT tweet_id
-- FROM Tweets
-- WHERE CHAR_LENGTH(content) > 15;