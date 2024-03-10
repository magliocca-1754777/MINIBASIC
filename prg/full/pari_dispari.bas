REM Pari o dispari?
$1 = 0 
$2 = 0
ripeti: 
IF $1 == 20 THEN END
IF $2 == 1 THEN PRINT "dispari" : $2 = 0 ELSE PRINT "pari" : $2 = 1
$1 = $1 + 1
GOTO ripeti 