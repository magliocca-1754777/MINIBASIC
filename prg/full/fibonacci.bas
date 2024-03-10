REM Fibonacci da 2 a 10
PRINT "Fibonacci da 2 a 10"
REM fib(0)
$0 = 0
REM fib(1)
$1 = 1
REM counter
$2 = 2
WHILE $2 <> 11 DO $3 = $0 + $1 : $0 = $1 : $1 = $3 : PRINT $3 : $2 = $2 + 1