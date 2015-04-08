Scenario: User searches for a single step 

Given user is on Home page
When user search Wiadomosci
Then Result count is not zero

Given user is on Home page
When user search dobranocka
Then Result count is not zero
