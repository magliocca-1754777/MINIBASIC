REM Fibonacci da 2 a 10
PRINT "Fibonacci da 2 a 10"
REM fib(0)
$0 = 0
REM fib(1)
$1 = 1
REM counter
$2 = 2
ciclo:
$3 = $0 + $1 
$0 = $1
$1 = $3
PRINT $3
IF $2 == 10 THEN END
$2 = $2 + 1   
GOTO ciclo