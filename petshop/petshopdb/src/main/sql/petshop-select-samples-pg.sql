SELECT c.firstname as "Etunimi", c.lastname as "Sukunimi" FROM customer c
JOIN purchase p
ON c.id = p.customerid
JOIN purchaseitem pi
ON p.id = pi.purchaseid
WHERE pi.id = 1;
