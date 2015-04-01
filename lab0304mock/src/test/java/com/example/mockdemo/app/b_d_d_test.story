Given a messenger
When set server name to onet.pl
Then test connection should return 0

When set server name to google.com
Then test connection should return 1

When set server name to onet.pl
When set message text to today
Then send message return 0

When set server name to onet.pl
When set message text to t
Then send message return 2

When set server name to o
When set message text to today
Then send message return 2

When set server name to onet.pl
When set message text to tttt
Then send message return 1

When set server name to onet.pl
When set message text to today
Then test connection should return 0
Then send message return 0

When set server name to google.com
When set message text to today
Then test connection should return 1
Then send message return 1
