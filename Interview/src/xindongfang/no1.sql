
SELECT name from node WHERE  name not in (SELECT name FROM  node  where id not in (SELECT pid FROM node));