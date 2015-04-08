Given a psikus
When set number to 0
Then cyfrokrad should return null

When set number to 5
Then cyfrokrad should return null

When set number to 9
Then cyfrokrad should return null

When set number to 17
Then cyfrokrad should return 1 or 7
 
When set number to 259
Then cyfrokrad should return 25 or 29 or 59

When set number to 5
Then hultajchochla should throw exception

When set number to 15
Then hultajchochla should return 51

When set number to 135
Then hultajchochla should return 531 or 315 or 153

When set number to 5
Then nieksztaltek should return 5

When set number to 15
Then nieksztaltek should return 15

When set number to 43
Then nieksztaltek should return 48

When set number to 57
Then nieksztaltek should return 51

When set number to 86
Then nieksztaltek should return 89

When set number to 437
Then nieksztaltek should return 487 or 431

When set number to 376
Then nieksztaltek should return 876 or 317 or 379 
