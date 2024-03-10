REM ordinamento bubblesort delle prime 5 variabili
$0 = 5
$1 = 4
$2 = 3
$3 = 2
$4 = 1
IF $1 < $0 THEN $5 = $0 : $0 = $1 : $1 = $5
IF $2 < $1 THEN $5 = $1 : $1 = $2 : $2 = $5
IF $3 < $2 THEN $5 = $2 : $2 = $3 : $3 = $5
IF $4 < $3 THEN $5 = $3 : $3 = $4 : $4 = $5

IF $1 < $0 THEN $5 = $0 : $0 = $1 : $1 = $5
IF $2 < $1 THEN $5 = $1 : $1 = $2 : $2 = $5
IF $3 < $2 THEN $5 = $2 : $2 = $3 : $3 = $5

IF $1 < $0 THEN $5 = $0 : $0 = $1 : $1 = $5
IF $2 < $1 THEN $5 = $1 : $1 = $2 : $2 = $5

IF $1 < $0 THEN $5 = $0 : $0 = $1 : $1 = $5

PRINT $0
PRINT $1
PRINT $2
PRINT $3
PRINT $4